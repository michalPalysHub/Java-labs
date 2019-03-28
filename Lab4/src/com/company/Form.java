package com.company;

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
    private JMenu menu;
    private JMenuItem reset, exit;
    private GridBagConstraints a, b, c, d;

    private Form() {

        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        this.setBounds((int) width / 4, (int) height / 4, (int) width / 2, (int) height / 2);

        initiateComponents();

        getContentPane().add(mainPanel);
        this.setTitle("SciCalculator");
        this.setResizable(true);
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initiateComponents(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        Dimension size = getPreferredSize();
        size.width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2;
        size.height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2;
        this.setPreferredSize(size);

        // adding components to mainPanel ////////////////

        // setting menuBar
        menuBar = new JMenuBar();
        menu = new JMenu("Options");
        reset = new JMenuItem("Reset");
        exit = new JMenu("Exit");
        menu.add(reset);
        menu.add(exit);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        evalButton = new JButton("Evaluate!");
        a = new GridBagConstraints(1,1,1,1,0,0,GridBagConstraints.SOUTHEAST,0,new Insets(10,10,10,10),0,0);
        mainPanel.add(evalButton, a);

        formulaInput = new JTextField();
        b = new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.SOUTHWEST,0,new Insets(10,10,10,10), 0, 0);
        mainPanel.add(formulaInput, b);

        historyTextArea = new JTextArea();
        historyTextArea.setEditable(false);
        scrollContainerPane = new JScrollPane();
        scrollContainerPane.add(historyTextArea);
        c = new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.NORTHWEST,0,new Insets(10,10,10,10),0,0);
        mainPanel.add(scrollContainerPane, c);

        functionsList = new JList();
        d = new GridBagConstraints(1,0,1,1,0,0,GridBagConstraints.NORTHEAST,0,new Insets(10,10,10,10), 0, 0);
        mainPanel.add(functionsList,d);
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
