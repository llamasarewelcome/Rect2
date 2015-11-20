/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raphaellevy.rect2;

import java.awt.Rectangle;

/**
 *
 * @author raffa
 */
public class RectSprite extends Rectangle{
    double dx = 0;
    double dy = 0;
    double vx = .5;
    double vy = 1;
    RectSprite(int i, int i0, int i1, int i2) {
        super(i,i0,i1,i2);
        dx=i;
        dy=i0;
    }
    void move() {
        dx=dx+vx;
        dy=dy+vy;
        if (touchingBottom()) {
            vy = -vy;
        }
        if (touchingTop()) {
            vy = -vy;
        }
        if (touchingRight()) {
            vx = -vx;
        }
        if (touchingLeft()) {
            vx = -vx;
        }
        setLocation((int) (dx),(int) (dy));
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
