/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("Inventory Management System");
        setSize(400, 300);
        setLayout(null);

        JButton btnAddItem = new JButton("Add Item");
        btnAddItem.setBounds(50, 50, 150, 30);
        btnAddItem.addActionListener(e -> {
            new AddItemFrame().setVisible(true);
            
        });

        JButton btnUpdateItem = new JButton("Update Item");
        btnUpdateItem.setBounds(50, 100, 150, 30);
        btnUpdateItem.addActionListener(e -> {
            new UpdateItemFrame().setVisible(true);
            
        });

        JButton btnDeleteItem = new JButton("Delete Item");
        btnDeleteItem.setBounds(50, 150, 150, 30);
        btnDeleteItem.addActionListener(e -> {
            new DeleteItemFrame().setVisible(true);
            
        });

        JButton btnViewItems = new JButton("View Items");
        btnViewItems.setBounds(50, 200, 150, 30);
        btnViewItems.addActionListener(e -> {
            new ViewInventoryFrame().setVisible(true);
            
        });

        add(btnAddItem);
        add(btnUpdateItem);
        add(btnDeleteItem);
        add(btnViewItems);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
