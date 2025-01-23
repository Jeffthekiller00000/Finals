/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteItemFrame extends JFrame {
    public DeleteItemFrame() {
        setTitle("Delete Item");
        setSize(400, 200);
        setLayout(null);

        JLabel lblId = new JLabel("Item ID:");
        lblId.setBounds(50, 50, 100, 30);
        JTextField txtId = new JTextField();
        txtId.setBounds(150, 50, 200, 30);

        JButton btnDelete = new JButton("Delete Item");
        btnDelete.setBounds(150, 100, 150, 30);
        btnDelete.addActionListener(e -> {
            int id = Integer.parseInt(txtId.getText());

            try (Connection conn = DatabaseConnection.getConnection()) {
                String sql = "DELETE FROM inventory WHERE id = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Item deleted successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        add(lblId);
        add(txtId);
        add(btnDelete);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
