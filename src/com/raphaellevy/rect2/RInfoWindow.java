/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raphaellevy.rect2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author student
 */
public class RInfoWindow extends JPanel{
    static final int X_WIDTH = 200;
    static final int Y_HEIGHT = 300;
    
    private JFrame frame;
    
    JLabel l1;
    JButton b1;
    JButton b2;
    
    private RInfoWindow() {
        super();
    }
    
    public static RInfoWindow openWindow(String title) {
        JFrame f = new JFrame(title);
        
        f.setSize(X_WIDTH, Y_HEIGHT);
        f.setVisible(true);
        f.setResizable(false);
        
        RInfoWindow w = new RInfoWindow();
        
        w.frame = f;
        f.add(w);
        
        w.l1 = new JLabel();
        w.l1.setText("0,0");
        w.add(w.l1);
        
        w.b1 = new JButton("Reset Velocity!!!!");
        w.b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rect2.r.p.r.vx = 0;
                Rect2.r.p.r.vy = 0;
            }
        });
        w.add(w.b1);
        
        w.b2 = new JButton("Reset All Velocities!");
        w.b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rect2.r.p.r.vx = 0;
                Rect2.r.p.r.vy = 0;
                Rect2.r.p.r2.vx = 0;
                Rect2.r.p.r2.vy = 0;
            }
        });
        w.add(w.b2);
        w.revalidate();
        //w.repaint();
        return w;
    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }
}
