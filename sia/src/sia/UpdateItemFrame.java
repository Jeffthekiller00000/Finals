/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateItemFrame extends JFrame {
    public UpdateItemFrame() {
        setTitle("Update Item");
        setSize(400, 300);
        setLayout(null);

        JLabel lblId = new JLabel("Item ID:");
        lblId.setBounds(50, 50, 100, 30);
        JTextField txtId = new JTextField();
        txtId.setBounds(150, 50, 200, 30);

        JLabel lblName = new JLabel("New Name:");
        lblName.setBounds(50, 100, 100, 30);
        JTextField txtName = new JTextField();
        txtName.setBounds(150, 100, 200, 30);

        JLabel lblQuantity = new JLabel("New Quantity:");
        lblQuantity.setBounds(50, 150, 100, 30);
        JTextField txtQuantity = new JTextField();
        txtQuantity.setBounds(150, 150, 200, 30);

        JLabel lblPrice = new JLabel("New Price:");
        lblPrice.setBounds(50, 200, 100, 30);
        JTextField txtPrice = new JTextField();
        txtPrice.setBounds(150, 200, 200, 30);

        JButton btnUpdate = new JButton("Update Item");
        btnUpdate.setBounds(150, 250, 150, 30);
        btnUpdate.addActionListener(e -> {
            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();
            int quantity = Integer.parseInt(txtQuantity.getText());
            double price = Double.parseDouble(txtPrice.getText());

            try (Connection conn = DatabaseConnection.getConnection()) {
                String sql = "UPDATE inventory SET name = ?, quantity = ?, price = ? WHERE id = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, name);
                pstmt.setInt(2, quantity);
                pstmt.setDouble(3, price);
                pstmt.setInt(4, id);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Item updated successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        add(lblId);
        add(txtId);
        add(lblName);
        add(txtName);
        add(lblQuantity);
        add(txtQuantity);
        add(lblPrice);
        add(txtPrice);
        add(btnUpdate);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}