/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia_Test;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ViewInventoryFrame extends JFrame {
        public ViewInventoryFrame() {
        setTitle("View Inventory");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JTextArea txtArea = new JTextArea();
        txtArea.setBounds(20, 20, 550, 300);
        txtArea.setEditable(false);
        add(txtArea);

        JButton btnLoad = new JButton("Load Items");
        btnLoad.setBounds(230, 330, 120, 30);
        add(btnLoad);

        btnLoad.addActionListener((ActionEvent e) -> {
            try {
                String response = ApiClient.get("/inventory");
                txtArea.setText(response);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}