/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raphaellevy.rect2;

import java.awt.Color;
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
    static int[] SIZE = {200,500};
    static Rect2 r;
    /** Main Window */
    JFrame f;
    /** Main panel */
    RPanel p;
    
    RInfoWindow w;
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
    private volatile boolean paused;
    
    /** Set up app */
    public void setup() {
        f = new JFrame(TITLE);
        f.setSize(SIZE[0], SIZE[1]);
        f.setUndecorated(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p = new RPanel(this);
        p.setSize(SIZE[0], SIZE[1]);
        p.setBackground(new Color(0,0,0,0));
        f.add(p);
        w = RInfoWindow.openWindow("hihi");
        w.getFrame().setLocation(500, 0);
        f.toFront();
        
        
    }
    public void pause() {
        paused = true;
    }
    public void play() throws InterruptedException {
        if (!paused) {
            paused = false;
            
        }
    }
    public void toggle() throws InterruptedException {
        if (paused) {
            
            paused = false;
            
            
        } else {
            paused = true;
        }
    }
    public boolean isPaused() {
        return paused;
    }
    public boolean isPlaying() {
        return !paused;
    }
    /** Main loop */
    public void loop() {
        while (true) {
            while (!paused) {
                
                Rect2.SIZE[0] = f.getSize().width;
                Rect2.SIZE[1] = f.getSize().height;
                if (!p.getSize().equals(f.getSize())) {
                    p.setSize(f.getSize());
                }
                p.move();
                p.repaint();
                
                try {
                    Thread.sleep(3);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Rect2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }
    
}
