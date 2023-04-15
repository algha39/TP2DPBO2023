/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tp2dpbo_grup;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
/**
 *
 * @author naufal
 */
public class Grup extends javax.swing.JPanel {
    private Menu Menu;
    private int id;
    private dbConnection db;
    /**
     * Creates new form Grup
     */
    public Grup(Menu Menu, int id) {
        initComponents();
        this.db = new dbConnection();
        this.id = id;
        ImageIcon foto = null;
        ResultSet res = db.selectQuery("SELECT * FROM grup WHERE id_grup=" + this.id);
        try {
            if (res.next()) {
                labelNama.setText(res.getString("nama_grup"));
                foto = new ImageIcon("src\\assets\\"+res.getString("foto_grup"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddGrup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Image image = foto.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
 
        LabelImage.setIcon(new ImageIcon(image));
        LabelImage.setVerticalAlignment(SwingConstants.CENTER);
        
        this.Menu = Menu;
    }
    
    private void notifikasiUpdated() {
        Menu.onDataUpdated();
    }
    
    public void deleteData(){
            String sql = "DELETE FROM grup WHERE id_grup=" + this.id;
            int affectedRow = db.updateQuery(sql);

            if (affectedRow > 0) {
                notifikasiUpdated();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            } else {
                JOptionPane.showMessageDialog(null, "Data gagal dihapus!");
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelNama = new javax.swing.JLabel();
        ButtonDelete = new javax.swing.JButton();
        ButtonUpdate = new javax.swing.JButton();
        LabelImage = new javax.swing.JLabel();
        ButtonDetail = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        labelNama.setBackground(new java.awt.Color(255, 255, 255));
        labelNama.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        labelNama.setForeground(new java.awt.Color(204, 0, 0));
        labelNama.setText("jLabel3");
        labelNama.setOpaque(true);

        ButtonDelete.setBackground(new java.awt.Color(255, 0, 0));
        ButtonDelete.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        ButtonDelete.setForeground(new java.awt.Color(0, 0, 0));
        ButtonDelete.setText("Delete");
        ButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteActionPerformed(evt);
            }
        });

        ButtonUpdate.setBackground(new java.awt.Color(51, 255, 51));
        ButtonUpdate.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        ButtonUpdate.setForeground(new java.awt.Color(0, 0, 0));
        ButtonUpdate.setText("Update");
        ButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonUpdateActionPerformed(evt);
            }
        });

        LabelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ButtonDetail.setBackground(new java.awt.Color(204, 153, 255));
        ButtonDetail.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        ButtonDetail.setForeground(new java.awt.Color(0, 0, 0));
        ButtonDetail.setText("Detail");
        ButtonDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDetailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(labelNama)
                        .addGap(70, 70, 70)))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonUpdate)
                    .addComponent(ButtonDetail)
                    .addComponent(ButtonDelete))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(labelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(ButtonDetail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonDelete)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null,
            "Are you sure you want to delete this data?",
            "Confirmation",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            deleteData();
            ButtonDelete.setVisible(false);
        }

    }//GEN-LAST:event_ButtonDeleteActionPerformed

    private void ButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonUpdateActionPerformed
        // TODO add your handling code here:
        this.Menu.setIsUpdated(true);
        AddGrup frame = new AddGrup(this.Menu, this.id);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(AddGrup.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }//GEN-LAST:event_ButtonUpdateActionPerformed

    private void ButtonDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDetailActionPerformed
        // TODO add your handling code here:
        String sql = "SELECT * FROM grup WHERE id_grup=" + this.id;
        ResultSet res = db.selectQuery(sql);
        
        try {
            if(res.next()){
            DetailGrup detail = new DetailGrup(this.id);
            detail.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddGrup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_ButtonDetailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonDelete;
    private javax.swing.JButton ButtonDetail;
    private javax.swing.JButton ButtonUpdate;
    private javax.swing.JLabel LabelImage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelNama;
    // End of variables declaration//GEN-END:variables
}