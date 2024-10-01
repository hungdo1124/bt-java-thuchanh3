package com.mycompany.thuchanhngay3;

import javax.swing.*;
import java.awt.event.*;

public class bai2 extends JFrame {
    private JTextField txtFirstNumber, txtSecondNumber, txtSum;
    private JButton btnSum, btnExit;
    public bai2() {
        setTitle("My Addition Operator");
        setLayout(null); // Dùng layout tự do
        JLabel lblFirstNumber = new JLabel("Enter first number:");
        lblFirstNumber.setBounds(20, 20, 150, 30);
        add(lblFirstNumber);
        JLabel lblSecondNumber = new JLabel("Enter second number:");
        lblSecondNumber.setBounds(20, 60, 150, 30);
        add(lblSecondNumber);
        JLabel lblSum = new JLabel("The sum is:");
        lblSum.setBounds(20, 100, 150, 30);
        add(lblSum);
        txtFirstNumber = new JTextField();
        txtFirstNumber.setBounds(170, 20, 100, 30);
        add(txtFirstNumber);
        txtSecondNumber = new JTextField();
        txtSecondNumber.setBounds(170, 60, 100, 30);
        add(txtSecondNumber);
        txtSum = new JTextField();
        txtSum.setBounds(170, 100, 100, 30);
        txtSum.setEditable(false);
        add(txtSum);
        btnSum = new JButton("Sum");
        btnSum.setBounds(50, 150, 80, 30);
        add(btnSum);
        btnExit = new JButton("Exit");
        btnExit.setBounds(150, 150, 80, 30);
        add(btnExit);
        btnSum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int number1 = Integer.parseInt(txtFirstNumber.getText());
                    int number2 = Integer.parseInt(txtSecondNumber.getText());
                    int sum = number1 + number2;
                    txtSum.setText(String.valueOf(sum));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers!");
                }
            }
        });
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setSize(300, 250); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new bai2();
    }
}
