/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia_Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateItemFrame extends JFrame {

    private JTextField idField;
    private JTextField nameField;
    private JTextField quantityField;
    private JTextField priceField;
    private JButton updateButton;

    public UpdateItemFrame() {
        setTitle("Update Item");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel idLabel = new JLabel("Item ID:");
        idLabel.setBounds(20, 20, 100, 30);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(130, 20, 200, 30);
        add(idField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 70, 100, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(130, 70, 200, 30);
        add(nameField);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(20, 120, 100, 30);
        add(quantityLabel);

        quantityField = new JTextField();
        quantityField.setBounds(130, 120, 200, 30);
        add(quantityField);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(20, 170, 100, 30);
        add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(130, 170, 200, 30);
        add(priceField);

        updateButton = new JButton("Update Item");
        updateButton.setBounds(130, 220, 200, 30);
        add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String name = nameField.getText();
                    int quantity = Integer.parseInt(quantityField.getText());
                    double price = Double.parseDouble(priceField.getText());

                    // Validate payload format
                    if (name.isEmpty() || quantity < 0 || price < 0) {
                        JOptionPane.showMessageDialog(null, "Invalid input: Ensure name is not empty, and quantity/price are non-negative.");
                        return;
                    }

                    String payload = String.format(
                        "{\"name\": \"%s\", \"quantity\": %d, \"price\": %.2f}",
                        name, quantity, price
                    );

                    String endpoint = "http://127.0.0.1:5000/inventory/update/" + id;
                    // Ensure URL is correctly pointing to API
                    if (!endpoint.startsWith("http://")) {
                        JOptionPane.showMessageDialog(null, "Error: Invalid URL");
                        return;
                    }

                    String response = ApiClient.put(endpoint, payload);

                    // Validate API response structure
                    if (response != null && response.contains("\"success\": true")) {
                        JOptionPane.showMessageDialog(null, "Item updated successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update item: " + response);
                    }
                } catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(null, "Please enter valid numeric values. Ensure Item ID, Quantity, and Price are numeric.");
    return;
} catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
    }
}