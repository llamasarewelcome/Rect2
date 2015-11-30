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
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author raffa
 */
public class RPanel extends JPanel{
    RVector rsize = new RVector(40,40);
    ArrayList<RectSprite> list = new ArrayList<>();
    
    public RPanel () {
        super();
        this.r = new RectSprite(0,0,(int)rsize.x,(int)rsize.y);
        r.vx = 1;
        r.vy=1;
        list.add(r);
        this.r2 = new RectSprite(450,0 ,(int)rsize.x,(int)rsize.y);
        r2.vx = -1;
        r2.vy=1;
        list.add(r2);
        //r2.vx = -.4;
        //r2.vy = -.4;
        
    }
    @Override
    public void paint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Rect2.SIZE[0], Rect2.SIZE[1]);
        g.setColor(Color.RED);
        g.fillOval(r.x, r.y, r.width, r.height);
        g.setColor(Color.BLUE);
        g.fillOval(r2.x, r2.y, r2.width, r2.height);
    }
    
    public void move() {
        r.move();
        r2.move();
    }
    
    RectSprite r;
    RectSprite r2;
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
