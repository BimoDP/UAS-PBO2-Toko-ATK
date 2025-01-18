/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.b1modp.noerskuy.p1p1ng.uaspbo2.frame;

import com.b1modp.noerskuy.p1p1ng.uaspbo2.db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author User
 */
public class BarangAddFrame extends javax.swing.JFrame {

    /**
     * Creates new form BarangAddFrame
     */
    public BarangAddFrame() {
        initComponents();
        loadEnumSatuanToComboBox();
        setLocationRelativeTo(null);
    }

    public BarangAddFrame(int id) {
        initComponents();
        loadEnumSatuanToComboBox();
        try {
            Connection koneksi = Database.getConnection();
            String findSQL = "SELECT * FROM barang WHERE id_barang=" + id;
            Statement statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(findSQL);
            while (resultSet.next()) {
                satuanComboBox1.setSelectedItem(resultSet.getString("satuan"));
                idTextField.setText(resultSet.getString("id_barang"));
                namaBarangTextField.setText(resultSet.getString("nama_barang"));
                stokTextField.setText(resultSet.getString("stok"));
            }
            koneksi.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    private void loadEnumSatuanToComboBox() {
    try {
        Connection koneksi = Database.getConnection();
        String sql = "SHOW COLUMNS FROM barang WHERE Field = 'satuan'";
        Statement statement = koneksi.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            // Ambil definisi ENUM dari kolom 'Type'
            String type = resultSet.getString("Type"); // Akan berupa "enum('A','B','C','D')"
            
            // Ekstrak nilai dari string ENUM
            String[] enumValues = type.substring(type.indexOf("(") + 1, type.indexOf(")"))
                                   .replace("'", "")
                                   .split(",");

            // Tambahkan nilai ENUM ke ComboBox
            satuanComboBox1.removeAllItems();
            for (String value : enumValues) {
                satuanComboBox1.addItem(value);
            }
        }

        koneksi.close();
    } catch (SQLException ex) {
        System.err.println("Error: " + ex.getMessage());
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        simpanButton = new javax.swing.JButton();
        batalButton = new javax.swing.JButton();
        judulLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        stokTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        satuanComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        namaBarangTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        simpanButton.setBackground(new java.awt.Color(153, 255, 153));
        simpanButton.setText("Save");
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });

        batalButton.setBackground(new java.awt.Color(204, 204, 204));
        batalButton.setText("Cancel");
        batalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalButtonActionPerformed(evt);
            }
        });

        judulLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        judulLabel.setText("Tambah Data Barang");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(simpanButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(batalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(judulLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(judulLabel)
                .addGap(45, 45, 45)
                .addComponent(simpanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(batalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Id");

        idTextField.setEditable(false);
        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Satuan");

        stokTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Stok");

        satuanComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        satuanComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satuanComboBox1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Nama Barang");

        namaBarangTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaBarangTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(idTextField)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(satuanComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addComponent(namaBarangTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(stokTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaBarangTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stokTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(satuanComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextFieldActionPerformed

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
       if(idTextField.getText().equals("")){
        try {
            Connection koneksi = Database.getConnection();
            
            String insertSQL = "INSERT INTO barang SET "
                + "nama_barang = '" + namaBarangTextField.getText() + "',"
                + "stok = '" + stokTextField.getText() + "',"
                + "satuan = '" + satuanComboBox1.getSelectedItem().toString() + "'";
            Statement statement = koneksi.createStatement();
            statement.executeUpdate(insertSQL);
            koneksi.close();
            dispose();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    } else {
        try {
            Connection koneksi = Database.getConnection();
            
            String updateSQL = "UPDATE barang SET "
                + "nama_barang = '" + namaBarangTextField.getText() + "',"
                + "stok = '" + stokTextField.getText() + "',"
                + "satuan = '" + satuanComboBox1.getSelectedItem().toString() + "'"
                + " WHERE id_barang=" + idTextField.getText();

            Statement statement = koneksi.createStatement();
            statement.executeUpdate(updateSQL);
            koneksi.close();
            dispose();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    }//GEN-LAST:event_simpanButtonActionPerformed

    private void batalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtonActionPerformed
        dispose();
    }//GEN-LAST:event_batalButtonActionPerformed

    private void stokTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokTextFieldActionPerformed

    private void satuanComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satuanComboBox1ActionPerformed
        
    }//GEN-LAST:event_satuanComboBox1ActionPerformed

    private void namaBarangTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaBarangTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaBarangTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(BarangAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarangAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarangAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarangAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarangAddFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalButton;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel judulLabel;
    private javax.swing.JTextField namaBarangTextField;
    private javax.swing.JComboBox<String> satuanComboBox1;
    private javax.swing.JButton simpanButton;
    private javax.swing.JTextField stokTextField;
    // End of variables declaration//GEN-END:variables
}
