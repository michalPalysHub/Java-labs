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
    private JMenuBar menuBar;
    private GridBagConstraints c;

    private Form() {

        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        this.setBounds((int) width / 4, (int) height / 4, (int) width / 2, (int) height / 2);

        initiateComponents();

        add(mainPanel);
        this.setTitle("SciCalculator");
        this.setResizable(true);
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initiateComponents(){
        mainPanel = new JPanel();
        c = new GridBagConstraints();
        mainPanel.setLayout(new GridBagLayout());

        Dimension size = getPreferredSize();
        size.width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2;
        size.height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2;
        setPreferredSize(size);

        // adding components to mainPanel

        functionsList = new JList();
        setConstraints(c, 1, 1,0, 0);
        mainPanel.add(functionsList,c);

        evalButton = new JButton("Evaluate!");
        setConstraints(c, 1, 2, 0, 0);
        mainPanel.add(evalButton, c);

        historyTextArea = new JTextArea();
        historyTextArea.setEditable(false);

        menuBar = new JMenuBar();
        setConstraints(c, 0, 0, 0, 0);
        c.gridwidth = 2;
        c.fill = GridBagConstraints.VERTICAL;
        c.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(menuBar, c);

        formulaInput = new JTextField();
        setConstraints(c, 0, 2, 10, 0);
        mainPanel.add(formulaInput, c);

        scrollContainerPane = new JScrollPane();
        scrollContainerPane.add(historyTextArea);
        setConstraints(c, 0, 1, 10, 10);
        //c.ipady = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2;
        mainPanel.add(scrollContainerPane, c);
    }

    private void setConstraints(GridBagConstraints c, int column, int row, double weightX, double weightY){
        c.insets = new Insets(10,10,10,10);
        c.gridx = column;
        c.gridy = row;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = weightX;
        c.weighty = weightY;
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
