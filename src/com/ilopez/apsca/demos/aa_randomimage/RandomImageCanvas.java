package com.ilopez.apsca.demos.aa_randomimage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class RandomImageCanvas extends Canvas {

    private final int width ;
    private final int height;
    private final BufferedImage image;
    private final int scale_factor;
    private final Random random;

    public RandomImageCanvas(){
        random = new Random();
        width = 10;
        height = 10;
        scale_factor = 100;
        image = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public void paint(Graphics graphics) {
        // For loop for the horizontal pixels
        for(int x = 0; x < width; x++ ){
            // for loop for the vertical pixels
            for(int y = 0; y < height; y++){


                int r = (int)(Math.random()*155)+200;
                int g = (int)(Math.random()*155)+200;
                int b = (int)(Math.random()*155)+200;

                // to prevent RGB overflow when modifying rgb values
                if(r > 255)
                    r = 255;

                if(g > 255)
                    g = 255;

                if(b > 255)
                    b = 255;

                Color color = new Color(r,g,b); // Probably do not need to do this, but it works

                int rgb = color.getRGB();

                image.setRGB(x,y,rgb);
                graphics.drawImage(image.getScaledInstance(height*scale_factor,width*scale_factor, Image.SCALE_FAST),0,0, this);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }

    }
}
