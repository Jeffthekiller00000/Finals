/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia_Test;

import javax.swing.*;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}