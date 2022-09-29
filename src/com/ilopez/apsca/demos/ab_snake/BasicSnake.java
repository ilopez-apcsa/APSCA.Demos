package com.ilopez.apsca.demos.ab_snake;

import com.ilopez.apsca.demos.aa_randomimage.RandomImageCanvas;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BasicSnake {
    public static void main(String[] args) {

        SnakeCanvas canvas = new SnakeCanvas();
        canvas.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP)
                    canvas.direction = SnakeDirection.UP;

                if(e.getKeyCode() == KeyEvent.VK_DOWN)
                    canvas.direction = SnakeDirection.DOWN;

                if(e.getKeyCode() == KeyEvent.VK_LEFT)
                    canvas.direction = SnakeDirection.LEFT;

                if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                    canvas.direction = SnakeDirection.RIGHT;

                if(e.getKeyCode() == KeyEvent.VK_SPACE)
                    canvas.start_stop = !canvas.start_stop;
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        JFrame window = new JFrame();
        window.setTitle("BasicSnake");
        window.add(canvas);
        window.setSize(1024,1060);
        window.setVisible(true);

        // 60 FPS
        Timer timer = new Timer(1000/2, event -> canvas.repaint());
        timer.start();
    }
}
