package com.bulish.melnikov.converter.fabric;

import com.bulish.melnikov.converter.convert.Mp3Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MP3Fabric extends Fabric {

    @Autowired
    public MP3Fabric(List<Mp3Converter> converters) {
        super("mp3");

        for (Mp3Converter converter : converters) {
            this.converters.put(converter.getFormat(), converter);
        }
    }
}
