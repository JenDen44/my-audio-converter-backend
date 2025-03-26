package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class MP3ToMP4Converter extends Mp3Converter {
    public MP3ToMP4Converter() {
        super("mp4");
    }

    @Override
    public byte[] convert(File file) {
       return null;
    }
}
