/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class StudentScreen extends javax.swing.JFrame {
    
     Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    private void StaffSearch(){
        
        
                String sql = "select * from student where StudentID=?";
                         
       
                
                

         try {
           
            
            pst = conn.prepareStatement(sql);
           
            pst.setString(1, txtStfID.getText());
            //pst.setString(2, txtStdID.getText());
                       
            rs = pst.executeQuery();
          
            String info = rs.getString(6);;
            
             if (rs.next()) {
                 
                 if(info.equals("Dublin"))
                //txtStfID.setText(rs.getString(1));
                txtStfNm.setText(rs.getString(2));
                txtStfEmail.setText(rs.getString(3)); //here is where the second item of the table is 
                txtStfPhn.setText(rs.getString(4)); //here is where the fourth item of the table is
                txtStfFunct.setText(rs.getString(5)); //here is where the third item of the table is 
                cboBranch.setSelectedItem(rs.getString(6));//here is where the third item of the table is  
             }
             
             if(info.equals("Cork")){
                 
                 pst = conn.prepareStatement("select * from student where StudentID=?");
                 
                txtStfNm.setText(rs.getString(2));
                txtStfEmail.setText(rs.getString(3)); //here is where the second item of the table is 
                txtStfPhn.setText(rs.getString(4)); //here is where the fourth item of the table is
                txtStfFunct.setText(rs.getString(5)); //here is where the third item of the table is 
                cboBranch.setSelectedItem(rs.getString(6));//here is where the third item of the table is 
                 
             }
             
              if(info.equals("Galway")){
                 
                 pst = conn.prepareStatement("select * from student where StudentID=?");
                 
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
                    
         }

    /**
     * Creates new form StudentScreen
     */
    public StudentScreen() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtStfID = new javax.swing.JTextField();
        txtStfPhn = new javax.swing.JTextField();
        txtStfNm = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtStfEmail = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtStfFunct = new javax.swing.JTextField();
        SearchStaffID = new javax.swing.JButton();
        cboBranch = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Student ID");
        jLabel13.setPreferredSize(new java.awt.Dimension(7, 20));

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

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Email");
        jLabel14.setPreferredSize(new java.awt.Dimension(7, 20));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Full Name");
        jLabel15.setPreferredSize(new java.awt.Dimension(7, 20));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Attendance");
        jLabel16.setPreferredSize(new java.awt.Dimension(7, 20));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Branch");
        jLabel17.setPreferredSize(new java.awt.Dimension(7, 20));

        txtStfEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStfEmailActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Phone");
        jLabel18.setPreferredSize(new java.awt.Dimension(7, 20));

        txtStfFunct.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStfFunct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStfFunctActionPerformed(evt);
            }
        });

        SearchStaffID.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(txtStfNm))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStfPhn)
                            .addComponent(txtStfFunct)
                            .addComponent(txtStfEmail)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStfID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboBranch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addComponent(SearchStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStfNm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStfFunct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStfPhn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(SearchStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboBranch, jLabel13, jLabel14, jLabel15, jLabel16, jLabel17, jLabel18, txtStfEmail, txtStfFunct, txtStfID, txtStfNm, txtStfPhn});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
   
    }//GEN-LAST:event_formWindowActivated

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

    private void txtStfFunctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStfFunctActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStfFunctActionPerformed

    private void SearchStaffIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchStaffIDActionPerformed
        // TODO add your handling code here:
        //StudentSearch();
    }//GEN-LAST:event_SearchStaffIDActionPerformed

    private void cboBranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBranchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboBranchActionPerformed

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
            java.util.logging.Logger.getLogger(StudentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SearchStaffID;
    private javax.swing.JComboBox<String> cboBranch;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtStfEmail;
    private javax.swing.JTextField txtStfFunct;
    private javax.swing.JTextField txtStfID;
    private javax.swing.JTextField txtStfNm;
    private javax.swing.JTextField txtStfPhn;
    // End of variables declaration//GEN-END:variables
}
