/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddItemFrame extends JFrame {
    public AddItemFrame() {
        setTitle("Add Item");
        setSize(400, 300);
        setLayout(null);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 50, 100, 30);
        JTextField txtName = new JTextField();
        txtName.setBounds(150, 50, 200, 30);

        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(50, 100, 100, 30);
        JTextField txtQuantity = new JTextField();
        txtQuantity.setBounds(150, 100, 200, 30);

        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setBounds(50, 150, 100, 30);
        JTextField txtPrice = new JTextField();
        txtPrice.setBounds(150, 150, 200, 30);

        JButton btnAdd = new JButton("Add Item");
        btnAdd.setBounds(150, 200, 100, 30);
        btnAdd.addActionListener(e -> {
            String name = txtName.getText();
            int quantity = Integer.parseInt(txtQuantity.getText());
            double price = Double.parseDouble(txtPrice.getText());

            try (Connection conn = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO inventory (name, quantity, price) VALUES (?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, name);
                pstmt.setInt(2, quantity);
                pstmt.setDouble(3, price);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Item added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        add(lblName);
        add(txtName);
        add(lblQuantity);
        add(txtQuantity);
        add(lblPrice);
        add(txtPrice);
        add(btnAdd);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
