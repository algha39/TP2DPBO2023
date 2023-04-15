/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tp2dpbo_grup;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author naufal
 */
public class Idol extends javax.swing.JPanel {
private final int id_idol;
    private final int id_grup;
    private final dbConnection db;
    private DetailGrup Detail;
    /**
     * Creates new form Idol
     */
    public Idol(int id, String nama, String foto, int id_grup, DetailGrup Detail) {
        initComponents();
        db = new dbConnection();
        this.id_idol = id;
        this.id_grup = id_grup;
        this.Detail = Detail;
        
        String tempId = Integer.toString(id);
        namaMember.setText(nama);
        
        BufferedImage fileImg = null;
        File img = new File("src/assets/" + foto);
        try {
            fileImg = ImageIO.read(img);
            int width = fotoMember.getWidth(), height = fotoMember.getHeight();
            if(width == 0){
                width = 115;
            }
            if(height == 0){
                height = 139;
            }
            Image image = fileImg.getScaledInstance(width, height,Image.SCALE_SMOOTH);
            ImageIcon ic = new ImageIcon(image);
            fotoMember.setIcon(ic);
        } catch (IOException ex) {
            Logger.getLogger(DetailGrup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteData(){
        int response = JOptionPane.showConfirmDialog(this, "Data akan di delete!", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
          if(response == JOptionPane.YES_OPTION){
              String sql = "DELETE FROM idol WHERE id_idol ='"+id_idol+"'";
              db.updateQuery(sql);
              this.Detail.setPanel();
              System.out.println("Delete Success!");
              JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
          }
    }
    
    public void updateData(){
        ResultSet res = db.selectQuery("SELECT * FROM idol WHERE id_idol ='"+id_idol+"'");
        try{
            if(res.next()){
                String nama, foto;
                int id, idGrup;
                id = res.getInt(1);
                nama = res.getString(3);
                foto = res.getString(4);
                AddIdol mem = new AddIdol(id, nama, foto, this.Detail);
                mem.setVisible(true);
            }
        }catch (SQLException ex) {
              System.out.println(ex.getMessage());
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

        MainCard = new javax.swing.JPanel();
        member = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        namaMember = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        fotoMember = new javax.swing.JLabel();

        MainCard.setBackground(new java.awt.Color(0, 102, 102));
        MainCard.setForeground(new java.awt.Color(0, 0, 0));

        member.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        member.setForeground(new java.awt.Color(255, 255, 255));
        member.setText("Member");

        jLabel2.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama :");

        editButton.setBackground(new java.awt.Color(0, 51, 255));
        editButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 0, 51));
        deleteButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        namaMember.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        namaMember.setForeground(new java.awt.Color(255, 255, 255));
        namaMember.setText("nama member");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fotoMember, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fotoMember, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout MainCardLayout = new javax.swing.GroupLayout(MainCard);
        MainCard.setLayout(MainCardLayout);
        MainCardLayout.setHorizontalGroup(
            MainCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(MainCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainCardLayout.createSequentialGroup()
                        .addGap(0, 126, Short.MAX_VALUE)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainCardLayout.createSequentialGroup()
                        .addGroup(MainCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainCardLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(namaMember))
                            .addComponent(member))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        MainCardLayout.setVerticalGroup(
            MainCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainCardLayout.createSequentialGroup()
                .addGroup(MainCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainCardLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(member)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(namaMember))
                        .addGap(54, 54, 54)
                        .addGroup(MainCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(MainCardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("update data");
        updateData();
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("delete data " + id_idol);
        deleteData();
    }//GEN-LAST:event_deleteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainCard;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel fotoMember;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel member;
    private javax.swing.JLabel namaMember;
    // End of variables declaration//GEN-END:variables
}