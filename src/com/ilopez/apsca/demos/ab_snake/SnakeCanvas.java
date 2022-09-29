package com.ilopez.apsca.demos.ab_snake;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SnakeCanvas extends Canvas {

    private final BufferedImage playfield;
    private final int height;
    private final int width;
    private final int tick_rate;
    private final int scale_factor;
    public SnakeDirection direction;

    private final Color snake_color = Color.WHITE;
    public boolean start_stop = true;

    int frame_count;
    int current_x;
    int current_y;

    public SnakeCanvas(){
        direction = SnakeDirection.DOWN; // Set the default direction to down
        // Play Field Height Width
        height = 100;
        width = 100;

        scale_factor = 10; // Number we use to embiggen the image for humans


        current_x = width/2;
        current_y = height/2;

        // Update every N frames
        tick_rate = 1;

        playfield = new BufferedImage(100,100, BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public void paint(Graphics graphics) {
        if(!start_stop){
            // Keep drawing the image while stopped
            graphics.drawImage(playfield.getScaledInstance(height*scale_factor,width*scale_factor, Image.SCALE_FAST),0,0, this);
            return;
        }

        frame_count++; // Increase the frame counter
        if(frame_count >= tick_rate){ // Once it reaches at/over 30 frames
            frame_count = 0; // Reset it to zero

            // then change the X/Y cords based on the current direction set
            switch(direction)
            {
                case UP:
                    current_y--; // I know its weird because graphics Y is upside down
                    break;
                case DOWN:
                    current_y++; // I know its weird because graphics Y is upside down
                    break;
                case LEFT:
                    current_x--;
                    break;
                case RIGHT:
                    current_x++;
                    break;
            }

            // Logic to prevent it from running outside of the max/min of /height/width
            if(current_x >= width)
                current_x = width-1; // Clamp it to width

            if(current_y >= height)
                current_y = height-1; // Clamp it to height

            if(current_x < 0)
                current_x = 0; // Clamp it above zero

            if(current_y < 0)
                current_y = 0; // Clamp it to above zero

            // Set a pixel color
            System.out.println("X " + current_x + " Y " + current_y);
            playfield.setRGB(current_x, current_y, snake_color.getRGB());
        }

        graphics.drawImage(playfield.getScaledInstance(height*scale_factor,width*scale_factor, Image.SCALE_FAST),0,0, this);
    }
}
