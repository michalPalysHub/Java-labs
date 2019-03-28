package com.company;

import org.mariuszgromada.math.mxparser.Expression;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame {
    private JPanel mainPanel;
    private JScrollPane scrollContainerPane;
    private JTextArea historyTextArea;
    private JTextField formulaInput;
    private JList<listItem> functionsList;
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
        createFunctionsList();

        this.setJMenuBar(menuBar);
        this.setContentPane(mainPanel);
        historyTextArea.setEditable(false);
    }

    private void createMenu(){

        menuBar = new JMenuBar();
        options = new JMenu("Options");
        reset = new JMenuItem("Reset");
        exit = new JMenuItem("Exit");
        options.add(reset);
        options.add(exit);
        menuBar.add(options);

        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                historyTextArea.setText(" ");
                formulaInput.setText(" ");
            }
        });
    }

    private void createFunctionsList(){
        DefaultListModel<listItem> listModel = new DefaultListModel<>();

        listModel.addElement(new listItem("sine", "sin()", true));
        listModel.addElement(new listItem("cosine", "cos()", true));
        listModel.addElement(new listItem("tangent", "tan()", true));
        listModel.addElement(new listItem("cotangent", "ctan()", true));
        listModel.addElement(new listItem("inverse sine", "arcsin()", true));
        listModel.addElement(new listItem("Pi", "pi", false));
        listModel.addElement(new listItem("Euler's nuber", "e", false));
        listModel.addElement(new listItem("Plastic constant", "[PN]", false));
        listModel.addElement(new listItem("add", "+", false));
        listModel.addElement(new listItem("substract", "-", false));
        listModel.addElement(new listItem("multiplicate", "*", false));
        listModel.addElement(new listItem("Last result", "Last result", false));

        functionsList.setModel(listModel);
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