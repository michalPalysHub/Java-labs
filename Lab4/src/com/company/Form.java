package com.company;

import org.mariuszgromada.math.mxparser.Expression;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;

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
    private String lastExpression, lastResult;


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

        evalButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                evaluate();
            }
        });

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
                lastExpression = null;
                lastResult = null;
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
        listModel.addElement(new listItem("Euler's number", "e", false));
        listModel.addElement(new listItem("Plastic constant", "[PN]", false));
        listModel.addElement(new listItem("add", "+", false));
        listModel.addElement(new listItem("substract", "-", false));
        listModel.addElement(new listItem("multiplicate", "*", false));
        listModel.addElement(new listItem("Last result", "Last result", false));

        functionsList.setModel(listModel);
        functionsList.addListSelectionListener(new FunctionsListListener());
    }

    private void evaluate(){
        String formulaInputText = formulaInput.getText();
        lastExpression = formulaInput.getText();
        Expression expression = new Expression(formulaInputText);

        if (expression.checkSyntax()){
            double result = expression.calculate();
            historyTextArea.append(MessageFormat.format("{0} = {1, number} \n _______ \n", formulaInputText, result));
            formulaInput.setText("");
            lastResult = Double.toString(result);
        } else {
            String errorMessage = expression.getErrorMessage();
            JOptionPane.showMessageDialog(null, "Couldn't evaluate:\n" +  errorMessage, "Errror", JOptionPane.ERROR_MESSAGE);
            formulaInput.setText(" ");
        }
    }

    private class FunctionsListListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e){
            if (e.getValueIsAdjusting()){
                listItem item = functionsList.getSelectedValue();
                if (item.getName() == "Last result"){
                    formulaInput.setText(formulaInput.getText() + lastResult);
                }
                else {
                    formulaInput.setText(formulaInput.getText() + item.getKeyWord());
                    setFocus(item.hasBraces());
                }
                functionsList.clearSelection();
            }
        }
    }

    private void setFocus(boolean hasBraces){
        formulaInput.requestFocus();

        if (hasBraces) {
            formulaInput.setCaretPosition(formulaInput.getText().length() - 1);
        } else {
            formulaInput.setCaretPosition(formulaInput.getText().length());
        }
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