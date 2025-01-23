/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia_Test;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Inventory Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblTitle = new JLabel("Inventory Management System", SwingConstants.CENTER);
        lblTitle.setBounds(50, 20, 500, 50);
        lblTitle.setFont(lblTitle.getFont().deriveFont(24.0f));
        add(lblTitle);

        JButton btnAdd = new JButton("Add Item");
        btnAdd.setBounds(200, 100, 200, 30);
        add(btnAdd);

        JButton btnUpdate = new JButton("Update Item");
        btnUpdate.setBounds(200, 150, 200, 30);
        add(btnUpdate);

        JButton btnDelete = new JButton("Delete Item");
        btnDelete.setBounds(200, 200, 200, 30);
        add(btnDelete);

        JButton btnView = new JButton("View Inventory");
        btnView.setBounds(200, 250, 200, 30);
        add(btnView);

        // Add action listeners to open respective frames
        btnAdd.addActionListener((ActionEvent e) -> {
            AddItemFrame addFrame = new AddItemFrame();
            addFrame.setVisible(true);
        });

        btnUpdate.addActionListener((ActionEvent e) -> {
            UpdateItemFrame updateFrame = new UpdateItemFrame();
            updateFrame.setVisible(true);
        });

        btnDelete.addActionListener((ActionEvent e) -> {
            DeleteItemFrame deleteFrame = new DeleteItemFrame();
            deleteFrame.setVisible(true);
        });

        btnView.addActionListener((ActionEvent e) -> {
            ViewInventoryFrame viewFrame = new ViewInventoryFrame();
            viewFrame.setVisible(true);
        });
    }
}
