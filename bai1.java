package com.mycompany.thuchanhngay3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bai1 extends JFrame { 
    private JLabel sampleTextLabel; 
    private JCheckBox boldCheckBox; 
    private JCheckBox italicCheckBox; 

    public bai1() { 
        setTitle("Text Styler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        sampleTextLabel = new JLabel("Sample Text");
        add(sampleTextLabel);
        boldCheckBox = new JCheckBox("Bold");
        boldCheckBox.addActionListener(new StyleListener());
        add(boldCheckBox);
        italicCheckBox = new JCheckBox("Italic");
        italicCheckBox.addActionListener(new StyleListener());
        add(italicCheckBox);
        setSize(300, 150);
        setVisible(true);
    }

    private class StyleListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int style = Font.PLAIN; 
            if (boldCheckBox.isSelected()) {
                style |= Font.BOLD; 
            }
            if (italicCheckBox.isSelected()) {
                style |= Font.ITALIC;
            }

            sampleTextLabel.setFont(new Font("Serif", style, 16));
        }
    }

    public static void main(String[] args) {
        new bai1(); // Khởi tạo giao diện
    }
}
