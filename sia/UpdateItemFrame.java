/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateItemFrame extends JFrame {
    private JTextField txtItemId;
    private JTextField txtItemName;
    private JTextField txtItemQuantity;
    private JButton btnUpdateItem;

    public UpdateItemFrame() {
        setTitle("Update Item");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblItemId = new JLabel("Item ID:");
        lblItemId.setBounds(10, 20, 80, 25);
        add(lblItemId);

        txtItemId = new JTextField();
        txtItemId.setBounds(100, 20, 200, 25);
        add(txtItemId);

        JLabel lblItemName = new JLabel("Item Name:");
        lblItemName.setBounds(10, 60, 80, 25);
        add(lblItemName);

        txtItemName = new JTextField();
        txtItemName.setBounds(100, 60, 200, 25);
        add(txtItemName);

        JLabel lblItemQuantity = new JLabel("Quantity:");
        lblItemQuantity.setBounds(10, 100, 80, 25);
        add(lblItemQuantity);

        txtItemQuantity = new JTextField();
        txtItemQuantity.setBounds(100, 100, 200, 25);
        add(txtItemQuantity);

        btnUpdateItem = new JButton("Update");
        btnUpdateItem.setBounds(120, 150, 100, 25);
        add(btnUpdateItem);

        btnUpdateItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemId = txtItemId.getText().trim();
                String itemName = txtItemName.getText().trim();
                String itemQuantity = txtItemQuantity.getText().trim();

                // Validate input fields
                if (itemId.isEmpty() || itemName.isEmpty() || itemQuantity.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields are required.");
                    return;
                }

                try {
                    int quantity = Integer.parseInt(itemQuantity); // Ensure quantity is an integer

                    // Construct payload
                    String payload = String.format("{\"name\": \"%s\", \"quantity\": %d}", itemName, quantity);

                    // Construct endpoint with base URL
                    String endpoint = "http://127.0.0.1:5000/inventory/update/" + itemId;

                    // Send PUT request
                    String response = ApiClient.put(endpoint, payload);

                    // Check response
                    if (response.contains("success")) {
                        JOptionPane.showMessageDialog(null, "Item updated successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update item: " + response);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Quantity must be a valid number.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
    }
}