/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.b1modp.noerskuy.p1p1ng.uaspbo2.frame;

import com.b1modp.noerskuy.p1p1ng.uaspbo2.db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class BuatAkun extends javax.swing.JFrame {

    /**
     * Creates new form BuatAkun
     */
    public BuatAkun() {
        initComponents();
        setLocationRelativeTo(null);
        usernameTextField.requestFocus();
        loadPosisiComboBox();
        generateAutoId();
    }
    
    public BuatAkun(int id) {
        initComponents();
        try {
            Connection koneksi = Database.getConnection();
            String findSQL = "SELECT * FROM akun WHERE id=" + id;
            Statement statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(findSQL);
            while (resultSet.next()) {
                posisiComboBox1.setSelectedItem(resultSet.getString("id_posisi"));
                idTextField.setText(resultSet.getString("id_akun"));
                usernameTextField.setText(resultSet.getString("username"));
                passwordTextField.setText(resultSet.getString("password"));
            }
            koneksi.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    private void loadPosisiComboBox() {
        try {
            Connection koneksi = Database.getConnection();
            String query = "SELECT DISTINCT posisi FROM karyawan ORDER BY posisi";
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            Vector<String> posisiList = new Vector<>();
            while (rs.next()) {
                posisiList.add(rs.getString("posisi"));
            }
            
            posisiComboBox1.setModel(new DefaultComboBoxModel<>(posisiList));
            
            rs.close();
            stmt.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error loading positions: " + ex.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean validateInput() {
        if (usernameTextField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Username tidak boleh kosong!",
                "Validasi Error",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (passwordTextField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Password tidak boleh kosong!",
                "Validasi Error",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (posisiComboBox1.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this,
                "Posisi harus dipilih!",
                "Validasi Error",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
private void generateAutoId() {
        try {
            Connection koneksi = Database.getConnection();
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(id_akun) as max_id FROM akun");
            
            if (rs.next()) {
                int nextId = rs.getInt("max_id") + 1;
                idTextField.setText(String.valueOf(nextId));
            } else {
                idTextField.setText("1");
            }
            
            rs.close();
            stmt.close();
            koneksi.close();
        } catch (SQLException ex) {
            System.err.println("Error generating ID: " + ex.getMessage());
            idTextField.setText("1"); // Default if error
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        posisiComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        simpanButton = new javax.swing.JButton();
        batalButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jLabel3.setText("Posisi");

        posisiComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Id");

        idTextField.setEditable(false);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        simpanButton.setBackground(new java.awt.Color(153, 255, 153));
        simpanButton.setText("Save");
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });

        batalButton.setBackground(java.awt.Color.lightGray);
        batalButton.setText("Cancel");
        batalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Buat Akun");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(simpanButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(batalButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 28, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addGap(33, 33, 33)
                .addComponent(simpanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(batalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(posisiComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordTextField)
                    .addComponent(usernameTextField)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(posisiComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        if (validateInput()) {
            try {
                Connection koneksi = Database.getConnection();
                
                // Get position ID based on selected position name
                String posisiQuery = "SELECT id_karyawan FROM karyawan WHERE posisi = ? LIMIT 1";
                PreparedStatement posisiStmt = koneksi.prepareStatement(posisiQuery);
                posisiStmt.setString(1, posisiComboBox1.getSelectedItem().toString());
                ResultSet posisiRs = posisiStmt.executeQuery();
                
                int idPosisi = 0;
                if (posisiRs.next()) {
                    idPosisi = posisiRs.getInt("id_karyawan");
                }
                
                // Insert new account
                String query = "INSERT INTO akun (id_akun, username, password, id_posisi) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = koneksi.prepareStatement(query);
                
                // Make sure ID is not empty
                String id = idTextField.getText().trim();
                if (id.isEmpty()) {
                    generateAutoId();
                    id = idTextField.getText();
                }
                
                pstmt.setInt(1, Integer.parseInt(id));
                pstmt.setString(2, usernameTextField.getText().trim());
                pstmt.setString(3, passwordTextField.getText().trim());
                pstmt.setInt(4, idPosisi);
                
                int result = pstmt.executeUpdate();
                
                if (result > 0) {
                    JOptionPane.showMessageDialog(this,
                        "Akun berhasil dibuat!",
                        "Sukses",
                        JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
                
                posisiRs.close();
                posisiStmt.close();
                pstmt.close();
                koneksi.close();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,
                    "Error menyimpan akun: " + ex.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
    }//GEN-LAST:event_simpanButtonActionPerformed

    private void batalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtonActionPerformed
        dispose();       
    }//GEN-LAST:event_batalButtonActionPerformed

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
            java.util.logging.Logger.getLogger(BuatAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuatAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuatAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuatAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuatAkun().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalButton;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JComboBox<String> posisiComboBox1;
    private javax.swing.JButton simpanButton;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
