/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raphaellevy.rect2;

import java.awt.Rectangle;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raffa
 */
public class RectSprite extends Rectangle{
    double dx = 0;
    double dy = 0;
    double vx = .5;
    double vy = 1;
    static final double SLOW = .9999;
    RectSprite(int i, int i0, int i1, int i2) {
        super(i,i0,i1,i2);
        dx=i;
        dy=i0;
    }
    void move() {
        dx=dx+vx;
        dy=dy+vy;
        if (touchingBottom()) {
            System.out.println("b");
            vy = -vy;
            randomize();
            //dy=Rect2.SIZE[1]-this.height;
            
            //dy--;
        }
        if (touchingTop()) {
            vy = -vy;
            randomize();
            dy = 1;
            
        }
        if (touchingRight()) {
            vx = -vx;
            randomize();
            dx = Rect2.SIZE[0] - 1 - this.width;
        }
        if (touchingLeft()) {
            vx = -vx;
            randomize();
            
        }
        vx=vx*SLOW;
        vy=vy*SLOW;
        setLocation((int) (dx),(int) (dy));
    }
    void randomize() {
        double[] coords = RPanel.cartToPolar(vx, vy);
        Random r = new Random();
        coords[1] = coords[1] + Math.toRadians((r.nextInt(10)-5));
        vx = RPanel.polarToCart(coords[0], coords[1])[1];
        vy = RPanel.polarToCart(coords[0], coords[1])[0];
    }
    boolean touchingLeft() {
        boolean a = dx < 1 && vx < 0;
        
        return a;
        
    }
    boolean touchingTop() {
        boolean b = dy < 1 && vy < 0;
        return b;
    }
    boolean touchingRight() {
        boolean c = dx + this.width >= Rect2.SIZE[0];
        return c;
    }
    boolean touchingBottom() {
        boolean d = dy + this.width >= Rect2.SIZE[1];
        return d;
    }
}
//boolean b = dy < 1;
//boolean c = dx + this.width >= Rect2.SIZE[0];
//boolean d = dy + this.width >= Rect2.SIZE[1];
