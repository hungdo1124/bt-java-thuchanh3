/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thuchanhngay3;

/**
 *
 * @author dohun
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bai5 extends JFrame implements ActionListener {

    JTextField real1, imag1, real2, imag2, resultReal, resultImag;
    JRadioButton add, subtract, multiply, divide;
    JButton execute, clear, exit;
    
    public bai5() {
        setTitle("Complex Number Calculator");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 4, 10, 10));
        add(new JLabel("Phần thực"));
        add(new JLabel("Phần ảo"));
        real1 = new JTextField();
        imag1 = new JTextField();
        real2 = new JTextField();
        imag2 = new JTextField();
        add(real1);
        add(imag1);
        add(real2);
        add(imag2);
        resultReal = new JTextField();
        resultImag = new JTextField();
        resultReal.setEditable(false);
        resultImag.setEditable(false);
        add(new JLabel("Kết quả: "));
        add(new JLabel());
        add(resultReal);
        add(resultImag);
        ButtonGroup group = new ButtonGroup();
        add = new JRadioButton("Cộng");
        subtract = new JRadioButton("Trừ");
        multiply = new JRadioButton("Nhân");
        divide = new JRadioButton("Chia");
        group.add(add);
        group.add(subtract);
        group.add(multiply);
        group.add(divide);
        add(add);
        add(subtract);
        add(multiply);
        add(divide);
        execute = new JButton("Thực hiện");
        clear = new JButton("Xóa");
        exit = new JButton("Thoát");
        add(execute);
        add(clear);
        add(exit);
        execute.addActionListener(this);
        clear.addActionListener(this);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == execute) {
            try {
                double r1 = Double.parseDouble(real1.getText());
                double i1 = Double.parseDouble(imag1.getText());
                double r2 = Double.parseDouble(real2.getText());
                double i2 = Double.parseDouble(imag2.getText());
                double resReal = 0, resImag = 0;
                if (add.isSelected()) {
                    resReal = r1 + r2;
                    resImag = i1 + i2;
                } else if (subtract.isSelected()) {
                    resReal = r1 - r2;
                    resImag = i1 - i2;
                } else if (multiply.isSelected()) {
                    resReal = r1 * r2 - i1 * i2;
                    resImag = r1 * i2 + i1 * r2;
                } else if (divide.isSelected()) {
                    double denominator = r2 * r2 + i2 * i2;
                    resReal = (r1 * r2 + i1 * i2) / denominator;
                    resImag = (i1 * r2 - r1 * i2) / denominator;
                }
                resultReal.setText(String.valueOf(resReal));
                resultImag.setText(String.valueOf(resImag));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ.");
            }
        } else if (e.getSource() == clear) {
            real1.setText("");
            imag1.setText("");
            real2.setText("");
            imag2.setText("");
            resultReal.setText("");
            resultImag.setText("");
        } else if (e.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        bai5 calculator = new bai5();
        calculator.setVisible(true);
    }
}

