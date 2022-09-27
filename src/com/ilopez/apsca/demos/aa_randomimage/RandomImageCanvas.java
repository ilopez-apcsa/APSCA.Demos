package com.ilopez.apsca.demos.aa_randomimage;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RandomImageCanvas extends Canvas {

    private final int width ;
    private final int height;
    private final BufferedImage image;
    private final int scale_factor;

    public RandomImageCanvas(){
        width = 10;
        height = 10;
        scale_factor = 100;
        image = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);

    }

    @Override
    public void paint(Graphics graphics) {
        for(int x = 0; x < width; x++ ){
            for(int y = 0; y < height; y++){
                int r = (int)(Math.random()*255);
                int g = (int)(Math.random()*255);
                int b = (int)(Math.random()*255);

                Color color = new Color(r,g,b);

                int rgb = color.getRGB();

                image.setRGB(x,y,rgb);
            }
        }
        graphics.drawImage(image.getScaledInstance(height*scale_factor,width*scale_factor, Image.SCALE_FAST),0,0, this);
    }
}
