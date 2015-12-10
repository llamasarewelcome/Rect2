/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raphaellevy.rect2;

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
        
        w.repaint();
        return w;
    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }
}
