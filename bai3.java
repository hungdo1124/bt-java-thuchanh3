/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thuchanhngay3;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

class bai3 extends JFrame implements ActionListener { 
    private JTextField txtCanhA, txtCanhB, txtChuVi, txtDienTich;
    private JButton btnThucHien, btnTiepTuc, btnThoat;

    public bai3() {
        setTitle("Tính chu vi và diện tích hình chữ nhật");
        setLayout(new FlowLayout());
        txtCanhA = new JTextField(10);
        txtCanhB = new JTextField(10);
        txtChuVi = new JTextField(10);
        txtDienTich = new JTextField(10);
        txtChuVi.setEditable(false);
        txtDienTich.setEditable(false);
        btnThucHien = new JButton("Thực hiện");
        btnTiepTuc = new JButton("Tiếp tục");
        btnThoat = new JButton("Thoát");
        btnThucHien.addActionListener(this);
        btnTiepTuc.addActionListener(this);
        btnThoat.addActionListener(this);
        add(new JLabel("Canh A:"));
        add(txtCanhA);
        add(new JLabel("Canh B:"));
        add(txtCanhB);
        add(new JLabel("Chu vi:"));
        add(txtChuVi);
        add(new JLabel("Dien tich:"));
        add(txtDienTich);
        add(btnThucHien);
        add(btnTiepTuc);
        add(btnThoat);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnThucHien) {
            try {
                double canhA = Double.parseDouble(txtCanhA.getText());
                double canhB = Double.parseDouble(txtCanhB.getText());
                double chuVi = 2 * (canhA + canhB);
                double dienTich = canhA * canhB;
                txtChuVi.setText(String.valueOf(chuVi));
                txtDienTich.setText(String.valueOf(dienTich));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnTiepTuc) {
            txtCanhA.setText("");
            txtCanhB.setText("");
            txtChuVi.setText("");
            txtDienTich.setText("");
        } else if (e.getSource() == btnThoat) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new bai3();
    }
}

