package com.company;

import org.mariuszgromada.math.mxparser.Expression;

import javax.swing.*;
import java.awt.*;

public class Form extends JFrame {
    private JPanel mainPanel;
    private JScrollPane scrollContainerPane;
    private JTextArea historyTextArea;
    private JTextField formulaInput;
    private JList functionsList;
    private JButton evalButton;
    private JMenuBar menuBar;
    private JMenu options;
    private JMenuItem reset, exit;

    private Form() {
        this.setTitle("SciCalculator");
        Dimension size = getPreferredSize();
        size.width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2;
        size.height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2;
        this.setPreferredSize(size);
        this.setMinimumSize(new Dimension(500,300));
        this.setResizable(true);
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createMenu();

        this.setJMenuBar(menuBar);
        this.setContentPane(mainPanel);
        historyTextArea.setEditable(false);
    }

    private void createMenu(){
        menuBar = new JMenuBar();
        options = new JMenu("Options");
        reset = new JMenuItem("Reset");
        exit = new JMenu("Exit");
        options.add(reset);
        options.add(exit);
        menuBar.add(options);
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
