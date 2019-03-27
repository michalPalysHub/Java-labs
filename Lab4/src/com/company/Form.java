package com.company;

import javax.swing.*;
import java.awt.*;
import org.mariuszgromada.math.mxparser.*;

public class Form extends JFrame {
    private JPanel mainPanel;
    private JScrollPane scrollContainerPane;
    private JTextArea historyTextArea;
    private JTextField formulaInput;
    private JList functionsList;
    private JButton evalButton;

    private Form() {
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        this.setBounds((int) width / 4, (int) height / 4, (int) width / 2, (int) height / 2);

        initiateComponents();

        this.setTitle("SciCalculator");
        this.setResizable(true);
        this.setVisible(true);
        //pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initiateComponents(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
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
