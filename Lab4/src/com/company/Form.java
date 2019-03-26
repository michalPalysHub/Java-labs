package com.company;

import javax.swing.*;
import java.awt.*;


public class Form extends JFrame{

    private Form(){
        setTitle("SciCalculator");
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        setBounds( (int)width/4,(int)height/4, (int)width/2, (int)height/2);
        initComponents();
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents(){

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Form();
            }
        });
    }
}
