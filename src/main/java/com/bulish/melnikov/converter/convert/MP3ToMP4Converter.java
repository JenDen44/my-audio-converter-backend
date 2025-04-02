package com.bulish.melnikov.converter.convert;

import com.bulish.melnikov.converter.service.FileService;
import it.sauronsoftware.jave.*;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;

@Component
public class MP3ToMP4Converter extends Mp3Converter {

    private final FileService fileService;
    public MP3ToMP4Converter(FileService fileService) {
        super("mp4");
        this.fileService = fileService;
    }

    @Override
    public byte[] convert(File file) {
        try {
            String fileNameWithoutExtension = fileService.getFileNameWithoutExtension(file.getName());
            String tempFileName = fileService.getNewPathForFile(fileNameWithoutExtension).toString();
            File target = File.createTempFile(tempFileName, ".mp4");
            target.deleteOnExit();

            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("aac");

            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setFormat("mp4");
            attrs.setAudioAttributes(audio);

            Encoder encoder = new Encoder();
            encoder.encode(file, target, attrs);

            return Files.readAllBytes(target.toPath());

        } catch (Exception e) {
            throw new RuntimeException("Error while audio converting " + e.getMessage());
        }
    }
}
