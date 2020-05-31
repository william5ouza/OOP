/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.managers;

import dal.Connection_Module;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class StaffRegistration extends javax.swing.JInternalFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form StaffRegistration
     */
    public StaffRegistration() {
        initComponents();
        conn = Connection_Module.connector();
    }
    
    //added to make room on my screen
    private void SearchID(){
        
        
                String sql = "select * from users where StaffID=?";
        

         try {
           
            
            pst = conn.prepareStatement(sql);
           
            pst.setString(1, txtStfID.getText());
            //pst.setString(2, txtStdID.getText());
                       
            rs = pst.executeQuery();
          
            
            
             if (rs.next()) {
                 
              txtStfNm.setText(rs.getString(2));
              //txtStfEmail.setText(rs.getString(3)); //here is where the second item of the table is 
              //txtStfFunct1.setText(rs.getString(4)); //here is where the fourth item of the table is
              //.setText(rs.getString(3)); //here is where the third item of the table is 
              //txtCourseDel.setText(rs.getString(6)); //here is where the third item of the table is 
             
               
            } 
        } catch (Exception e) {
            
             JOptionPane.showMessageDialog(null, e);
            
        }
            
    }
  
    
    private void StaffSearch(){
        
        
                String sql = "select * from staff where StaffID=?";
                         
       
                
                

         try {
           
            
            pst = conn.prepareStatement(sql);
           
            pst.setString(1, txtStfID.getText());
            //pst.setString(2, txtStdID.getText());
                       
            rs = pst.executeQuery();
          
            
            
             if (rs.next()) {
                //txtStfID.setText(rs.getString(1));
                txtStfNm.setText(rs.getString(2));
                txtStfEmail.setText(rs.getString(3)); //here is where the second item of the table is 
                txtStfPhn.setText(rs.getString(4)); //here is where the fourth item of the table is
                txtStfFunct.setText(rs.getString(5)); //here is where the third item of the table is 
                cboBranch.setSelectedItem(rs.getString(6));//here is where the third item of the table is  
             }
             
             
             else {
                
                 
                
                JOptionPane.showMessageDialog(null, "User is not found");
                //If the user is not found the system cleans the form in case there was another search
               txtStfNm.setText(null);
              txtStfEmail.setText(null);
               txtStfPhn.setText(null);
               txtStfFunct.setText(null);
              cboBranch.setSelectedItem(null);
               
            }
             
        } catch (Exception e) {
            
             JOptionPane.showMessageDialog(null, e);
            
        }
    }
         
    
         private void UpdatingStaff(){
              try {                   
                        
                        
                pst= conn.prepareStatement("update staff  set  Staff_Email=?, Staff_Phone=?, Staff_Function=?, Branch=? where StaffID=?");
                        
                //txtStfID.setText(rs.getString(1));
                //txtStfNm.setText(rs.getString(2));
                pst.setString(1,txtStfEmail.getText());
                pst.setString(2,txtStfPhn.getText());
                pst.setString(3,txtStfFunct.getText());
                pst.setString(4,cboBranch.getSelectedItem().toString());
                   
                        if (txtStfID.getText().isEmpty()||txtStfNm.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Please fill all mandatory fields");
                        } else {
                                                
                        int added = pst.executeUpdate();
                       
                       
                        if(added >0){
                            JOptionPane.showMessageDialog(null, "User updated successfully");
                            txtStfNm.setText(null);
                             txtStfEmail.setText(null);
                             txtStfPhn.setText(null);
                             txtStfFunct.setText(null);
                             cboBranch.setSelectedItem(null);
               
                        } 
                        }    
                        
                    }  catch (Exception e) {
                        
                        JOptionPane.showMessageDialog(null, e);
                    }
                    //Java code
                    
             
        
            
       //Here the student data is updated into "student" table as the ID has been already set by the SuperUser "ADMIN"
                 
       //Here by searching the student data by user is possible to add additional info such as email, phone, course and module.
          
             
                    
                    
                    //Java code
                    
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
        jLabel8 = new javax.swing.JLabel();
        txtStfID = new javax.swing.JTextField();
        txtStfPhn = new javax.swing.JTextField();
        txtStfNm = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtStfEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtStfFunct = new javax.swing.JTextField();
        SearchStaffID = new javax.swing.JButton();
        cboBranch = new javax.swing.JComboBox<>();
        btnStaffUpd = new javax.swing.JButton();
        StaffSerch = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(480, 420));

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Staff ID");
        jLabel8.setPreferredSize(new java.awt.Dimension(7, 20));

        txtStfID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStfID.setToolTipText("");
        txtStfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStfIDActionPerformed(evt);
            }
        });

        txtStfPhn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStfPhn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStfPhnActionPerformed(evt);
            }
        });

        txtStfNm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStfNm.setToolTipText("SudentID");
        txtStfNm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStfNmActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Email");
        jLabel9.setPreferredSize(new java.awt.Dimension(7, 20));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Staff Full Name");
        jLabel10.setPreferredSize(new java.awt.Dimension(7, 20));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Staff Phone");
        jLabel11.setPreferredSize(new java.awt.Dimension(7, 20));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Branch");
        jLabel13.setPreferredSize(new java.awt.Dimension(7, 20));

        txtStfEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStfEmailActionPerformed(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Funciton");
        jLabel12.setPreferredSize(new java.awt.Dimension(7, 20));

        txtStfFunct.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStfFunct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStfFunctActionPerformed(evt);
            }
        });

        SearchStaffID.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        SearchStaffID.setText("Check");
        SearchStaffID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchStaffIDActionPerformed(evt);
            }
        });

        cboBranch.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        cboBranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dublin", "Cork", "Galway" }));
        cboBranch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboBranch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cboBranch.setOpaque(false);
        cboBranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBranchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtStfID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtStfPhn)
                    .addComponent(txtStfFunct)
                    .addComponent(txtStfEmail)
                    .addComponent(txtStfNm)
                    .addComponent(cboBranch, 0, 199, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtStfID)
                        .addComponent(SearchStaffID)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStfNm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStfFunct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStfPhn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {SearchStaffID, cboBranch, jLabel10, jLabel11, jLabel12, jLabel13, jLabel8, jLabel9, txtStfEmail, txtStfFunct, txtStfID, txtStfNm, txtStfPhn});

        btnStaffUpd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.jpg"))); // NOI18N
        btnStaffUpd.setToolTipText("Update Info");
        btnStaffUpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffUpdActionPerformed(evt);
            }
        });

        StaffSerch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/StaffSearch.png"))); // NOI18N
        StaffSerch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StaffSerchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addComponent(StaffSerch, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStaffUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StaffSerch, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStaffUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtStfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStfIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStfIDActionPerformed

    private void txtStfPhnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStfPhnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStfPhnActionPerformed

    private void txtStfNmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStfNmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStfNmActionPerformed

    private void txtStfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStfEmailActionPerformed

    private void btnStaffUpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffUpdActionPerformed
        // TODO add your handling code here:
        UpdatingStaff();

    }//GEN-LAST:event_btnStaffUpdActionPerformed

    private void txtStfFunctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStfFunctActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStfFunctActionPerformed

    private void StaffSerchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StaffSerchActionPerformed
        // TODO add your handling code here:
        StaffSearch();
     
    }//GEN-LAST:event_StaffSerchActionPerformed

    private void SearchStaffIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchStaffIDActionPerformed
        // TODO add your handling code here:
         StaffSearch();
    }//GEN-LAST:event_SearchStaffIDActionPerformed

    private void cboBranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBranchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboBranchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SearchStaffID;
    private javax.swing.JButton StaffSerch;
    private javax.swing.JButton btnStaffUpd;
    private javax.swing.JComboBox<String> cboBranch;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtStfEmail;
    private javax.swing.JTextField txtStfFunct;
    private javax.swing.JTextField txtStfID;
    private javax.swing.JTextField txtStfNm;
    private javax.swing.JTextField txtStfPhn;
    // End of variables declaration//GEN-END:variables
}
