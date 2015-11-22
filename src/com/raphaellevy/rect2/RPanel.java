/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raphaellevy.rect2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author raffa
 */
public class RPanel extends JPanel{
    RVector rsize = new RVector(40,40);
    
    
    public RPanel () {
        super();
        
    }
    @Override
    public void paint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Rect2.SIZE[0], Rect2.SIZE[1]);
        g.setColor(Color.RED);
        g.fillOval(r.x, r.y, r.width, r.height);
    }
    
    public void move() {
        r.move();
    }
    
    RectSprite r = new RectSprite(0,0,(int)rsize.x,(int)rsize.y);
    
    public static double[] cartToPolar(double x, double y) {
        double magnitude = Math.hypot(x, y);
        double theta = Math.atan2(x, y);
        return new double[] {magnitude, theta};
    }
    public static double[] polarToCart(double magnitude, double theta) {
        double x = magnitude * Math.cos(theta);
        double y = magnitude * Math.sin(theta);
        return new double[] {x,y};
    }
}
