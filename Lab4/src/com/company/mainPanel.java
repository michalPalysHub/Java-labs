package com.company;

import javax.swing.*;
import java.awt.*;

public class mainPanel extends JPanel {
    public mainPanel(){
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        setBounds( (int)width/4,(int)height/4, (int)width/2, (int)height/2);

        setLayout(new GridBagLayout());
    }
}
