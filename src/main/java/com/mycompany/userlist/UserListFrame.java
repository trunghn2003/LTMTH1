/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.userlist;

/**
 *
 * @author wetech
 */
// UserListFrame.java
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class UserListFrame extends JFrame {
    private JTable userTable;

    public UserListFrame() {
        setTitle("User List");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        userTable = new JTable();
        loadUserData();

        add(new JScrollPane(userTable));
    }

    private void loadUserData() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Username", "IP Address"}, 0);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/th1", "root", "your_password")) {
            String query = "SELECT id, username, ip_address FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String ipAddress = rs.getString("ip_address");
                model.addRow(new Object[]{id, username, ipAddress});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        userTable.setModel(model);
    }
}

