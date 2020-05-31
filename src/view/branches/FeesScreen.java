/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.branches;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import view.MainScreen;

/**
 *
 * @author William
 */
public class FeesScreen extends javax.swing.JInternalFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void CheckFeeStatus() {
        
         String sql = null;
        //"select * from users where StaffID =? or StudentID=? and Password =?";

        try {
            
            pst = conn.prepareStatement("select * from student where StudentID=?");

            pst.setString(1, StdID.getText());
           

            rs = pst.executeQuery();

            if (rs.next()) {

                String branch = rs.getString(6);
                
                //System.out.println(profile);

                if (branch.equals("Dublin")) {
                    pst = conn.prepareStatement("select Fee_paid,fee_balance,fee_total from dublin where StudentID=?");
                    
                    //txtStfID.setText(rs.getString(1));
                txtFee.setText(rs.getString(2));
                txtBalance.setText(rs.getString(3)); //here is where the second item of the table is 
                txtFeetotal.setText(rs.getString(4)); //here is where the fourth item of the table is
                txtFeetotal.setText(rs.getString(5)); //here is where the third item of the table is 
               

                    

                }
                 if (branch.equals("Cork")) {
                     
                     pst = conn.prepareStatement("select Fee_paid,fee_balance,fee_total from cork where StudentID=?");
                
                txtFee.setText(rs.getString(2));
                txtBalance.setText(rs.getString(3)); //here is where the second item of the table is 
                txtFeetotal.setText(rs.getString(4)); //here is where the fourth item of the table is
                txtFeetotal.setText(rs.getString(5)); //here is where the third item of the table is 
               

                }
                 if (branch.equals("Galway")) {
                     
                     pst = conn.prepareStatement("select Fee_paid,fee_balance,fee_total from galway where StudentID=?");
                
                txtFee.setText(rs.getString(2));
                txtBalance.setText(rs.getString(3)); //here is where the second item of the table is 
                txtFeetotal.setText(rs.getString(4)); //here is where the fourth item of the table is
                txtFeetotal.setText(rs.getString(5)); //here is where the third item of the table is 
               

                }
                
                

            } 

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void MakePayment(){
        
           String sql = null;
        //"select * from users where StaffID =? or StudentID=? and Password =?";

        try {
            
            pst = conn.prepareStatement("select * from student where StudentID=?");

            pst.setString(1, StdID.getText());
           

            rs = pst.executeQuery();

            if (rs.next()) {

                String branch = rs.getString(6);
                
                 if (branch.equals("Dublin")) {
                    pst = conn.prepareStatement("update dublin  set  Fee_paid=?,fee_balance=?,fee_total=? where StudentID=?");
                    
                pst.setString(1,txtFee.getText());
                pst.setString(2,txtBalance.getText());
                pst.setString(3,txtFeetotal.getText());
                
                 }
                 
                                                
                        int added = pst.executeUpdate();
                       
                       
                        if(added >0){
                            JOptionPane.showMessageDialog(null, "Payment made successfully");
                            txtFee.setText(null);
                             txtBalance.setText(null);
                             txtFeetotal.setText(null);
                             StdID.setText(null);
                             
               
                        } 
                 if (branch.equals("Cork")) {
                    pst = conn.prepareStatement("update cork  set  Fee_paid=?,fee_balance=?,fee_total=? where StudentID=?");
                    
                pst.setString(1,txtFee.getText());
                pst.setString(2,txtBalance.getText());
                pst.setString(3,txtFeetotal.getText());
                
                 }
                  if(added >0){
                            JOptionPane.showMessageDialog(null, "Payment made successfully");
                            txtFee.setText(null);
                             txtBalance.setText(null);
                             txtFeetotal.setText(null);
                             StdID.setText(null);
                             
               
                        } 
                 if (branch.equals("Galway")) {
                    pst = conn.prepareStatement("update galway  set  Fee_paid=?,fee_balance=?,fee_total=? where StudentID=?");
                    
                pst.setString(1,txtFee.getText());
                pst.setString(2,txtBalance.getText());
                pst.setString(3,txtFeetotal.getText());
                
                 }
                  if(added >0){
                            JOptionPane.showMessageDialog(null, "Payment made successfully");
                            txtFee.setText(null);
                             txtBalance.setText(null);
                             txtFeetotal.setText(null);
                             StdID.setText(null);
                             
               
                        } 
            }
                
        } catch (Exception e) {
        }
        
        
    
    
    }
    
    /**
     * Creates new form FessScreen
     */
    public FeesScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        StdID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        SearchStaffID = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtFee = new javax.swing.JTextField();
        SearchStaffID1 = new javax.swing.JButton();
        txtBalance = new javax.swing.JTextField();
        txtFeetotal = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jInternalFrame1.setVisible(true);

        StdID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        StdID.setToolTipText("");
        StdID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StdIDActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Student ID");
        jLabel13.setPreferredSize(new java.awt.Dimension(7, 20));

        SearchStaffID.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        SearchStaffID.setText("Make payment");
        SearchStaffID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchStaffIDActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Balance");
        jLabel15.setPreferredSize(new java.awt.Dimension(7, 20));

        txtFee.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFee.setToolTipText("");
        txtFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFeeActionPerformed(evt);
            }
        });

        SearchStaffID1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        SearchStaffID1.setText("Check");
        SearchStaffID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchStaffID1ActionPerformed(evt);
            }
        });

        txtBalance.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBalance.setToolTipText("SudentID");
        txtBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBalanceActionPerformed(evt);
            }
        });

        txtFeetotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFeetotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFeetotalActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Amount paid");
        jLabel17.setPreferredSize(new java.awt.Dimension(7, 20));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Total cost");
        jLabel14.setPreferredSize(new java.awt.Dimension(7, 20));

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchStaffID1))
                .addGap(124, 124, 124)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SearchStaffID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBalance)
                    .addComponent(txtFee)
                    .addComponent(StdID)
                    .addComponent(txtFeetotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StdID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFeetotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchStaffID)
                    .addComponent(SearchStaffID1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFeetotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFeetotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFeetotalActionPerformed

    private void txtBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBalanceActionPerformed

    private void txtFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFeeActionPerformed

    private void SearchStaffIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchStaffIDActionPerformed
        MakePayment();        // TODO add your handling code here:
        
    }//GEN-LAST:event_SearchStaffIDActionPerformed

    private void StdIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StdIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StdIDActionPerformed

    private void SearchStaffID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchStaffID1ActionPerformed
        CheckFeeStatus();        // TODO add your handling code here:
    }//GEN-LAST:event_SearchStaffID1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SearchStaffID;
    private javax.swing.JButton SearchStaffID1;
    private javax.swing.JTextField StdID;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtFee;
    private javax.swing.JTextField txtFeetotal;
    // End of variables declaration//GEN-END:variables
}
