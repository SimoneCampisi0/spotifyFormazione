package com.simonecampisi.spotifyFormazione.utils;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
@NoArgsConstructor
public class ImageManager {
    public byte [] base64ToImg(String base64) {
        byte [] img = null;
        try {
            img = Base64.getDecoder().decode(base64);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return img;
    }
}
