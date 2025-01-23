/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia_Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemFrame extends JFrame {
    private JTextField txtItemName;
    private JTextField txtItemQuantity;
    private JButton btnAddItem;

    public AddItemFrame() {
        setTitle("Add Item");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblItemName = new JLabel("Item Name:");
        lblItemName.setBounds(10, 20, 80, 25);
        add(lblItemName);

        txtItemName = new JTextField();
        txtItemName.setBounds(100, 20, 160, 25);
        add(txtItemName);

        JLabel lblItemQuantity = new JLabel("Quantity:");
        lblItemQuantity.setBounds(10, 60, 80, 25);
        add(lblItemQuantity);

        txtItemQuantity = new JTextField();
        txtItemQuantity.setBounds(100, 60, 160, 25);
        add(txtItemQuantity);

        btnAddItem = new JButton("Add");
        btnAddItem.setBounds(100, 100, 80, 25);
        add(btnAddItem);

        btnAddItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = txtItemName.getText();
                String itemQuantity = txtItemQuantity.getText();

                if (itemName.isEmpty() || itemQuantity.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields.");
                    return;
                }

                try {
                    String payload = String.format("{\"name\": \"%s\", \"quantity\": %s}", itemName, itemQuantity);
                    ApiClient.post("/inventory/add", payload);
                    JOptionPane.showMessageDialog(null, "Item added successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
    }
}