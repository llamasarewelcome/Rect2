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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author raffa
 */
public class RPanel extends JPanel{
    RVector rsize = new RVector(40,40);
    ArrayList<RectSprite> list = new ArrayList<>();
    Rect2 rec;
    Rectangle close = new Rectangle(5,5,30,30);
    public RPanel (final Rect2 rec) {
        super();
        this.rec = rec;
        this.setFocusable(true);
        requestFocus();
        addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("adfd");
                if (e.getKeyChar() == ' ') {
                    System.out.println("adf");
                    try {
                        rec.toggle();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(RPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }  
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        this.r = new RectSprite(0,0,(int)rsize.x,(int)rsize.y);
        r.vx = 1;
        r.vy=1;
        list.add(r);
        addMouseListener(r);
        this.r2 = new RectSprite(450,0 ,(int)rsize.x,(int)rsize.y);
        r2.vx = -2;
        r2.vy=1;
        list.add(r2);
        addMouseListener(r2);
        //r2.vx = -.4;
        //r2.vy = -.4;
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (close.contains(e.getPoint())) {
                    System.exit(0);
                };
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        });
        
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
        g.setColor(Color.red);
        g.fill(close);
    }
    
    public void move() {
        r.move();
        r2.move();
        rec.w.l1.setText(Double.toString((double)Math.round(r.vx*100)/100)+","+Double.toString((double)Math.round(r.vy*100)/100));
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
