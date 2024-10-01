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
import java.util.Arrays;

public class bai6 extends JFrame implements ActionListener {

    JTextField arraySizeField, elementField, inputArrayField, sumField, sortedArrayField;
    JButton inputButton, executeButton, clearButton, exitButton;
    int[] array;
    int currentIndex = 0;

    public bai6() {
        setTitle("Array Operations");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout()); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(new JLabel("Nhập số phần tử mảng:"), gbc);
        arraySizeField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(arraySizeField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Nhập phần tử:"), gbc);
        elementField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(elementField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Mảng đã nhập:"), gbc);
        inputArrayField = new JTextField(10);
        inputArrayField.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(inputArrayField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Tính tổng:"), gbc);
        sumField = new JTextField(10);
        sumField.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(sumField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Sắp xếp:"), gbc);
        sortedArrayField = new JTextField(10);
        sortedArrayField.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(sortedArrayField, gbc);
        gbc.gridx = 2; 
        gbc.gridy = 0;
        gbc.gridheight = 1; 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputButton = new JButton("Nhập");
        add(inputButton, gbc);
        gbc.gridy = 1;
        executeButton = new JButton("Thực hiện");
        add(executeButton, gbc);
        gbc.gridy = 2;
        clearButton = new JButton("Xóa");
        add(clearButton, gbc);
        gbc.gridy = 3;
        exitButton = new JButton("Thoát");
        add(exitButton, gbc);
        inputButton.addActionListener(this);
        executeButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inputButton) {
            try {
                int size = Integer.parseInt(arraySizeField.getText());
                if (array == null) {
                    array = new int[size];
                }
                if (currentIndex < size) {
                    int element = Integer.parseInt(elementField.getText());
                    array[currentIndex++] = element;
                    inputArrayField.setText(Arrays.toString(array));
                    elementField.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Mảng đã đầy!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ.");
            }
        } else if (e.getSource() == executeButton) {
            // Perform sum and sort
            if (array != null) {
                int sum = Arrays.stream(array).sum();
                sumField.setText(String.valueOf(sum));

                int[] sortedArray = array.clone();
                Arrays.sort(sortedArray);
                sortedArrayField.setText(Arrays.toString(sortedArray));
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mảng trước.");
            }
        } else if (e.getSource() == clearButton) {
            // Clear input and output fields
            arraySizeField.setText("");
            elementField.setText("");
            inputArrayField.setText("");
            sumField.setText("");
            sortedArrayField.setText("");
            array = null;
            currentIndex = 0;
        } else if (e.getSource() == exitButton) {
            // Exit the application
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        bai6 app = new bai6();
        app.setVisible(true);
    }
}

