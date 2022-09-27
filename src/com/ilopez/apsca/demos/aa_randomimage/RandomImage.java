package com.ilopez.apsca.demos.aa_randomimage;

import javax.swing.*;

public class RandomImage {
    public static void main(String[] args) {

        RandomImageCanvas ric = new RandomImageCanvas();


        JFrame window = new JFrame();
        window.add(ric);
        window.setSize(1024,1024);
        window.setVisible(true);

        Timer timer = new Timer(1000/2, event -> ric.repaint());
        timer.start();

    }
}
