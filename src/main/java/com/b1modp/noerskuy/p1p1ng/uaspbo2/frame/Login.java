/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.b1modp.noerskuy.p1p1ng.uaspbo2.frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author User
 */
public class Login extends javax.swing.JFrame {

    private Connection conn;
private PreparedStatement stmt;
private ResultSet rs;

    public Login() {
        initComponents();
        
        usernameTextField.setForeground(Color.GRAY);
    passwordTextField.setForeground(Color.GRAY);
    
    usernameTextField.setText("Masukkan username");
    passwordTextField.setText("Masukkan password");
    
    // Add focus listeners
    usernameTextField.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if (usernameTextField.getText().equals("Masukkan username")) {
                usernameTextField.setText("");
                usernameTextField.setForeground(Color.BLACK);
            }
        }
        
        @Override
        public void focusLost(FocusEvent e) {
            if (usernameTextField.getText().isEmpty()) {
                usernameTextField.setForeground(Color.GRAY);
                usernameTextField.setText("Masukkan username");
            }
        }
    });
    
    passwordTextField.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if (passwordTextField.getText().equals("Masukkan password")) {
                passwordTextField.setText("");
                passwordTextField.setForeground(Color.BLACK);
            }
        }
        
        @Override
        public void focusLost(FocusEvent e) {
            if (passwordTextField.getText().isEmpty()) {
                passwordTextField.setForeground(Color.GRAY);
                passwordTextField.setText("Masukkan password");
            }
        }
    });
    
    loginButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            loginButtonActionPerformed(evt);
        }
    });
    
        loginButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            loginButtonActionPerformed(evt);
        }
    });
    }
    
    private void connectDB() {
    try {
        String url = "jdbc:mysql://localhost:3306/toko_atk";
        String user = "root";
        String password = "";
        conn = DriverManager.getConnection(url, user, password);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Koneksi database gagal: " + e.getMessage());
    }
}
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        buatAkunButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Login Akun");

        loginButton.setBackground(new java.awt.Color(102, 153, 255));
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        buatAkunButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        buatAkunButton.setText("Buat Akun");
        buatAkunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buatAkunButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Belum Punya Akun?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buatAkunButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jLabel3)
                            .addGap(30, 30, 30))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buatAkunButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String username = usernameTextField.getText();
    String password = passwordTextField.getText();
    
    if (username.equals("Masukkan username") || password.equals("Masukkan password")) {
        JOptionPane.showMessageDialog(this, "Username dan password harus diisi!");
        return;
    }
    
    try {
        connectDB();
        String query = "SELECT * FROM akun WHERE username = ? AND password = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);
        rs = stmt.executeQuery();
        
        if (rs.next()) {
            String posisi = rs.getString("id_posisi");
            
            // Close login window
            this.dispose();
            
            // Open appropriate window based on position
            switch (posisi) {
                case "1":  // Kasir
                    Kasir kasir = new Kasir();
                    kasir.setVisible(true);
                    break;
                    
                case "3":  // Staff Barang
                    BarangViewFrame staff = new BarangViewFrame();
                    staff.setVisible(true);
                    break;
                    
                case "2":  // Admin
                    KaryawanViewFrame admin = new KaryawanViewFrame();
                    admin.setVisible(true);
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(this, "Posisi tidak valid!");
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Username atau password salah!");
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    } finally {
        try {
            // Close all database resources
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error closing database: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void buatAkunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buatAkunButtonActionPerformed
        BuatAkun f = new BuatAkun();
        f.setVisible(true);
    }//GEN-LAST:event_buatAkunButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buatAkunButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loginButton;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
