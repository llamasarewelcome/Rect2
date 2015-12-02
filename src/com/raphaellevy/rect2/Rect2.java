/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raphaellevy.rect2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.Toolkit;
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
    static int[] SIZE;
    static {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        Rect2.SIZE = new int[] {(int)width,(int)height};
        
    }
    
    static Rect2 r;
    /** Main Window */
    JFrame f;
    /** Main panel */
    RPanel p;
    
    /** Main method */
    public static void main(String[] args) throws InterruptedException {
        r = new Rect2();
//        double[] d = new double[] {3.0,4.0};
//        double[] e = RPanel.cartToPolar(d[0],d[1]);
//        double[] f = RPanel.polarToCart(e[0], e[1]);
//        System.out.println(f[0]);
//        System.out.println(f[1]);
        r.setup();
        r.loop();
        
    }
    
    /** Set up app */
    public void setup() {
        
        f = new JFrame(TITLE);
        f.setUndecorated(true);
        f.setBackground(new Color(0, 0, 0, 0));
        f.setSize(SIZE[0], SIZE[1]);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p = new RPanel();
        p.setBackground(new Color(0, 0, 0, 0));
        p.setSize(SIZE[0], SIZE[1]);
        f.add(p);
        GraphicsDevice g = f.getGraphicsConfiguration().getDevice();
        
        //g.setFullScreenWindow(f);
        
        
    }
    
    /** Main loop */
    public void loop() throws InterruptedException {
        while (true) {  
            Rect2.SIZE[0] = f.getSize().width;
            Rect2.SIZE[1] = f.getSize().height;
            if (!p.getSize().equals(f.getSize())) {
                p.setSize(f.getSize());
            }
            p.move();
            p.repaint();
            
            
            Thread.sleep(3);
            
        }
    }
    
}
