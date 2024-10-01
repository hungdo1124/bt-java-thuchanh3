/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thuchanhngay3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

class bai4 extends JFrame implements ActionListener {
    private JTextField txtNumber;
    private JButton btnCheck;
    private JLabel lblResult;

    public bai4() {
        setTitle("Kiểm tra số nguyên tố");
        setLayout(new FlowLayout());
        txtNumber = new JTextField(10);
        btnCheck = new JButton("Kiểm tra SNT");
        lblResult = new JLabel("");
        btnCheck.addActionListener(this);
        add(new JLabel("Nhập số nguyên n:"));
        add(txtNumber);
        add(btnCheck);
        add(lblResult);
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCheck) {
            try {
                int n = Integer.parseInt(txtNumber.getText());
                if (isPrime(n)) {
                    lblResult.setText(n + " là số nguyên tố.");
                } else {
                    lblResult.setText(n + " không phải là số nguyên tố.");
                }
            } catch (NumberFormatException ex) {
                lblResult.setText("Vui lòng nhập số nguyên hợp lệ!");
            }
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new bai4(); // Khởi tạo giao diện
    }
}

