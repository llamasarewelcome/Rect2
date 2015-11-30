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
    double vx = 0;
    double vy = 0;
    static final double GRAVITY = .005;
    static final double SLOW = .9999;
    RectSprite(int i, int i0, int i1, int i2) {
        super(i,i0,i1,i2);
        dx=i;
        dy=i0;
    }
    void gravity() {
        vy += GRAVITY;
    }
    void move() {
        dx=dx+vx;
        dy=dy+vy;
        
        if (touchingBottom()) {
            
            vy = -vy;
            randomize();
            //dy=Rect2.SIZE[1]-this.height;
            
            //dy--;
            dy = Rect2.SIZE[1] - 1 - this.height;
            if (vy > -.15 && vy < 0) {
                vy = 0;
            }
        }
        RectSprite rect = colliding();
        if (rect != null) {
            
            vy = -vy;
            vx = -vx;
            dy = dy + 2*vy;
            dx = dx + 2*vx;
            randomize();
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
        gravity();
        setLocation((int) (dx),(int) (dy));
    }
    void loseVelocity() {
        double[] coords = RPanel.cartToPolar(vx, vy);
        coords[0] = coords[0] * .8;
        vx = RPanel.polarToCart(coords[0], coords[1])[1];
        vy = RPanel.polarToCart(coords[0], coords[1])[0];
        
    }
    void randomize() {
        double[] coords = RPanel.cartToPolar(vx, vy);
        Random r = new Random();
        coords[1] = coords[1] + Math.toRadians((r.nextInt(10)-5));
        
        vx = RPanel.polarToCart(coords[0], coords[1])[1];
        vy = RPanel.polarToCart(coords[0], coords[1])[0];
        loseVelocity();
    }
    boolean collidingBottom() {
        return false;
    }
    boolean touchingLeft() {
        boolean a = dx < 1 && vx < 0;
        
        return a;
        
    }
    boolean touchingTop() {
        boolean b = (dy < 1 && vy < 0);
        return b;
    }
    boolean touchingRight() {
        boolean c = dx + this.width >= Rect2.SIZE[0];
        return c;
    }
    boolean touchingBottom() {
        boolean d = dy + this.width >= Rect2.SIZE[1];
        
        
        boolean e = d;
        return e;
    }

    private RectSprite colliding() {
        for (RectSprite rect : Rect2.r.p.list) {
            if (!this.equals(rect)) {
                if (this.intersects(rect)) {
                    System.out.println("da");
                    return rect;
                }
            }
        }
        return null;
    }
}
//boolean b = dy < 1;
//boolean c = dx + this.width >= Rect2.SIZE[0];
//boolean d = dy + this.width >= Rect2.SIZE[1];
