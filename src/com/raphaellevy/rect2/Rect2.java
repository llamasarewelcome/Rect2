/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raphaellevy.rect2;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * Main class
 * @author raffa
 */
public class Rect2 {
    // Here be constants
    static final String TITLE = "Hello World";
    static final int[] SIZE = {500,500};
    
    /** Main Window */
    JFrame f;
    /** Main panel */
    RPanel p;
    
    /** Main method */
    public static void main(String[] args) throws InterruptedException {
        Rect2 r = new Rect2();
        r.setup();
        r.loop();
        
    }
    
    /** Set up app */
    public void setup() {
        f = new JFrame(TITLE);
        f.setSize(SIZE[0], SIZE[1]);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p = new RPanel();
        p.setSize(SIZE[0], SIZE[1]);
        f.add(p);
        
        
    }
    
    /** Main loop */
    public void loop() throws InterruptedException {
        while (true) {            
            p.move();
            p.repaint();
            System.out.print("a");
            
            Thread.sleep(10);
            
        }
    }
    
}
