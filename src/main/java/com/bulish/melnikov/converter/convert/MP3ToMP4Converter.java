package com.bulish.melnikov.converter.convert;

import com.bulish.melnikov.converter.service.FFmpegService;
import com.bulish.melnikov.converter.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MP3ToMP4Converter extends Mp3Converter {

    private final FileService fileService;

    private final FFmpegService fFmpegService;

    public MP3ToMP4Converter(FileService fileService, FFmpegService fFmpegService) {
        super("mp4");
        this.fileService = fileService;
        this.fFmpegService = fFmpegService;
    }

    @Override
    public byte[] convert(byte[] file) {
        return fFmpegService.convert(file, "mp3", "mp4");
    }
}
