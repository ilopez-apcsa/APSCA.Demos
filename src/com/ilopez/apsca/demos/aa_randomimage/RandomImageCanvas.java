package com.ilopez.apsca.demos.aa_randomimage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Random;

public class RandomImageCanvas extends Canvas {

    private final int width ;
    private final int height;
    private final BufferedImage image;

    public RandomImageCanvas(){
        width = 800;
        height = 800;
        image = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public void paint(Graphics graphics) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();


        Color white = Color.white;

        HashMap<Color,Boolean> dictionary = new HashMap<>();

        for(int x = 0; x < width; x++ ){
            for(int y = 0; y < height; y++){
                int r = (int)(Math.random()*240);
                int g = (int)(Math.random()*240);
                int b = (int)(Math.random()*240);

                Color color = new Color(r,g,b);

                /*
                int rgb = white.getRGB();

                if(!dictionary.containsKey(color)) {

                    dictionary.put(color,true);
                }
                */
                int rgb = color.getRGB();

                image.setRGB(x,y,rgb);
            }
        }

        graphics.drawImage(image,0,0, this);
    }
}
