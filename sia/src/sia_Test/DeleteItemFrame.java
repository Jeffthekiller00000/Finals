/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia_Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteItemFrame extends JFrame {
    private JTextField txtItemId;
    private JButton btnDeleteItem;

    public DeleteItemFrame() {
        setTitle("Delete Item");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblItemId = new JLabel("Item ID:");
        lblItemId.setBounds(10, 20, 80, 25);
        add(lblItemId);

        txtItemId = new JTextField();
        txtItemId.setBounds(100, 20, 160, 25);
        add(txtItemId);

        btnDeleteItem = new JButton("Delete");
        btnDeleteItem.setBounds(100, 60, 80, 25);
        add(btnDeleteItem);

        btnDeleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemId = txtItemId.getText();

                if (itemId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter an item ID.");
                    return;
                }

                try {
                    ApiClient.delete("/inventory/delete/" + itemId);
                    JOptionPane.showMessageDialog(null, "Item deleted successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
    }
}
