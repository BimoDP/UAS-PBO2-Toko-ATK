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

/**
 *
 * @author User
 */
public class GajiAddFrame extends javax.swing.JFrame {

    /**
     * Creates new form GajiAddFrame
     */
    public GajiAddFrame() {
        initComponents();
        loadKaryawanData();
        
        jamKerjaTextField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                hitungGajiPerbulan();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                hitungGajiPerbulan();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                hitungGajiPerbulan();
            }
        });
    }
    
    public GajiAddFrame(int id) {
    initComponents();
    loadKaryawanData();
    setLocationRelativeTo(null);
    
    // Tambahkan DocumentListener untuk perhitungan otomatis
    jamKerjaTextField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
        @Override
        public void insertUpdate(javax.swing.event.DocumentEvent e) {
            hitungGajiPerbulan();
        }

        @Override
        public void removeUpdate(javax.swing.event.DocumentEvent e) {
            hitungGajiPerbulan();
        }

        @Override
        public void changedUpdate(javax.swing.event.DocumentEvent e) {
            hitungGajiPerbulan();
        }
    });
    
    try {
        Connection koneksi = Database.getConnection();
        String findSQL = "SELECT g.*, k.nama_karyawan, k.posisi " +
                        "FROM gaji_karyawan g " +
                        "JOIN karyawan k ON g.id_karyawan = k.id_karyawan " +
                        "WHERE g.id_gaji = ?";
        
        PreparedStatement pstmt = koneksi.prepareStatement(findSQL);
        pstmt.setInt(1, id);
        ResultSet resultSet = pstmt.executeQuery();
        
        if (resultSet.next()) {
            idTextField.setText(String.valueOf(id));
            String namaKaryawan = resultSet.getString("nama_karyawan");
            String posisi = resultSet.getString("posisi");
            String kombinasi = namaKaryawan + " - " + posisi;
            
            karyawanPosisiComboBox1.setSelectedItem(kombinasi);
            
            gajiPerjamTextField.setText(String.format("%.2f", resultSet.getDouble("gaji_perjam")));
            jamKerjaTextField.setText(String.valueOf(resultSet.getInt("jam_kerja")));
            
            // Hitung ulang gaji perbulan setelah data dimuat
            hitungGajiPerbulan();
        }
        
        koneksi.close();
    } catch (SQLException ex) {
        System.err.println("Error loading data: " + ex.getMessage());
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Error loading data: " + ex.getMessage(),
            "Error",
            javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }

    private void hitungGajiPerbulan() {
        try {
        if (!jamKerjaTextField.getText().trim().isEmpty() && 
            !gajiPerjamTextField.getText().trim().isEmpty()) {
            
            double jamKerja = Double.parseDouble(jamKerjaTextField.getText().trim());
            double gajiPerjam = Double.parseDouble(gajiPerjamTextField.getText().trim());
            double gajiPerbulan = gajiPerjam * jamKerja;
            
            gajiPerbulanTextField.setText(String.format("%.2f", gajiPerbulan));
        } else {
            gajiPerbulanTextField.setText("");
        }
    } catch (NumberFormatException ex) {
        gajiPerbulanTextField.setText("");
    }
    }
    
    private void loadKaryawanData() {
        try {
            Connection koneksi = Database.getConnection();
            String query = "SELECT nama_karyawan, posisi FROM karyawan";
            Statement statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            karyawanPosisiComboBox1.removeAllItems(); // Bersihkan item sebelumnya
            while (resultSet.next()) {
                karyawanPosisiComboBox1.addItem(resultSet.getString("nama_karyawan") + " - " + resultSet.getString("posisi"));
            }
            koneksi.close();
        } catch (SQLException ex) {
            System.err.println("Error loading karyawan data: " + ex.getMessage());
        }
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jamKerjaTextField = new javax.swing.JTextField();
        gajiPerbulanTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        karyawanPosisiComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        gajiPerjamTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        simpanButton = new javax.swing.JButton();
        batalButton = new javax.swing.JButton();
        judulLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setText("Id");

        idTextField.setEditable(false);
        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Karyawan Dan Posisi");

        jamKerjaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jamKerjaTextFieldActionPerformed(evt);
            }
        });

        gajiPerbulanTextField.setEditable(false);

        jLabel5.setText("Jam Kerja Perbulan");

        jLabel6.setText("Gaji Perbulan");

        karyawanPosisiComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        karyawanPosisiComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                karyawanPosisiComboBox1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Gaji Perjam");

        gajiPerjamTextField.setEditable(false);
        gajiPerjamTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gajiPerjamTextFieldActionPerformed(evt);
            }
        });

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

        judulLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        judulLabel.setText("Tambah Data Gaji Karyawan");

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
                .addGap(20, 20, 20)
                .addComponent(judulLabel)
                .addGap(42, 42, 42)
                .addComponent(simpanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(batalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(idTextField)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(karyawanPosisiComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addComponent(gajiPerjamTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(gajiPerbulanTextField)
                        .addComponent(jamKerjaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(karyawanPosisiComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gajiPerjamTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jamKerjaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gajiPerbulanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextFieldActionPerformed

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        if (jamKerjaTextField.getText().trim().isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Semua data harus diisi!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Parse dan validasi input numerik terlebih dahulu
        int jamKerja = Integer.parseInt(jamKerjaTextField.getText().trim());
        double gajiPerjam = Double.parseDouble(gajiPerjamTextField.getText().trim());
        double gajiPerbulan = Double.parseDouble(gajiPerbulanTextField.getText().trim().replace(",", ""));
        
        String[] karyawanPosisi = karyawanPosisiComboBox1.getSelectedItem().toString().split(" - ");
        String namaKaryawan = karyawanPosisi[0];
        String posisi = karyawanPosisi[1];

        Connection koneksi = Database.getConnection();
        
        // Ambil id_karyawan dan posisi dari tabel karyawan
        String findKaryawanSQL = "SELECT id_karyawan FROM karyawan WHERE nama_karyawan = ? AND posisi = ?";
        java.sql.PreparedStatement pstmt = koneksi.prepareStatement(findKaryawanSQL);
        pstmt.setString(1, namaKaryawan);
        pstmt.setString(2, posisi);
        ResultSet resultSet = pstmt.executeQuery();
        
        if (resultSet.next()) {
            int idKaryawan = resultSet.getInt("id_karyawan");
            
            // Tentukan id_posisi berdasarkan posisi
            int idPosisi;
            switch (posisi.toLowerCase()) {
                case "kasir":
                    idPosisi = 1;
                    break;
                case "staff barang":
                    idPosisi = 2;
                    break;
                case "admin":
                    idPosisi = 3;
                    break;
                default:
                    throw new IllegalArgumentException("Posisi tidak valid");
            }
            
            if (idTextField.getText().trim().isEmpty()) {
                // Insert baru
                String insertSQL = "INSERT INTO gaji_karyawan (id_karyawan, id_posisi, gaji_perjam, jam_kerja, gaji_perbulan) VALUES (?, ?, ?, ?, ?)";
                pstmt = koneksi.prepareStatement(insertSQL);
                pstmt.setInt(1, idKaryawan);
                pstmt.setInt(2, idPosisi);
                pstmt.setDouble(3, gajiPerjam);
                pstmt.setInt(4, jamKerja);
                pstmt.setDouble(5, gajiPerbulan);
            } else {
                // Update data yang ada
                String updateSQL = "UPDATE gaji_karyawan SET id_karyawan=?, id_posisi=?, gaji_perjam=?, jam_kerja=?, gaji_perbulan=? WHERE id_gaji=?";
                pstmt = koneksi.prepareStatement(updateSQL);
                pstmt.setInt(1, idKaryawan);
                pstmt.setInt(2, idPosisi);
                pstmt.setDouble(3, gajiPerjam);
                pstmt.setInt(4, jamKerja);
                pstmt.setDouble(5, gajiPerbulan);
                pstmt.setInt(6, Integer.parseInt(idTextField.getText().trim()));
            }
            
            pstmt.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(this, "Data berhasil disimpan!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
        
        koneksi.close();
        
    } catch (NumberFormatException ex) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Format angka tidak valid! Pastikan semua input angka sudah benar.", 
            "Error", 
            javax.swing.JOptionPane.ERROR_MESSAGE);
        System.err.println("Error parsing number: " + ex.getMessage());
    } catch (SQLException ex) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Error database: " + ex.getMessage(), 
            "Error", 
            javax.swing.JOptionPane.ERROR_MESSAGE);
        System.err.println("Database error: " + ex.getMessage());
    }
    }//GEN-LAST:event_simpanButtonActionPerformed

    private void batalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtonActionPerformed
        dispose();
    }//GEN-LAST:event_batalButtonActionPerformed

    private void karyawanPosisiComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_karyawanPosisiComboBox1ActionPerformed
        if (karyawanPosisiComboBox1.getSelectedItem() != null) {
            String posisi = karyawanPosisiComboBox1.getSelectedItem().toString().split(" - ")[1].trim();
            int gajiPerJam;
            switch (posisi.toLowerCase()) {
                case "kasir":
                    gajiPerJam = 100000;
                    break;
                case "staff barang":
                    gajiPerJam = 125000;
                    break;
                case "admin":
                    gajiPerJam = 150000;
                    break;
                default:
                    javax.swing.JOptionPane.showMessageDialog(this, "Posisi tidak dikenal!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
            }
            gajiPerjamTextField.setText(String.valueOf(gajiPerJam));
        }    }//GEN-LAST:event_karyawanPosisiComboBox1ActionPerformed

    private void gajiPerjamTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gajiPerjamTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gajiPerjamTextFieldActionPerformed

    private void jamKerjaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jamKerjaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jamKerjaTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(GajiAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GajiAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GajiAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GajiAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GajiAddFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalButton;
    private javax.swing.JTextField gajiPerbulanTextField;
    private javax.swing.JTextField gajiPerjamTextField;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jamKerjaTextField;
    private javax.swing.JLabel judulLabel;
    private javax.swing.JComboBox<String> karyawanPosisiComboBox1;
    private javax.swing.JButton simpanButton;
    // End of variables declaration//GEN-END:variables
}
