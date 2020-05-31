/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.managers.StaffRegistration;
import view.lectuer.*;
import view.managers.StudentEnrol;
import java.sql.*;
import dal.Connection_Module;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class LoginScreen extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @SuppressWarnings("deprecation")
    public void loginUser() {

        String sql = null;
        //"select * from users where StaffID =? or StudentID=? and Password =?";

        try {
            /*
             Testing Combobox for login option worked fine
             pst = conn.prepareStatement("select * from users where profile=? and Password =?");
             pst.setString(2, txtPass.getText());
             pst.setString(1, cboteste.getSelectedItem().toString());
             */
            
           
            pst = conn.prepareStatement("select * from users where userlogin=? or StaffID =? or StudentID=?  and Password =?");

            pst.setString(1, txtLogin.getText());
            pst.setString(2, txtLogin.getText());
            pst.setString(3, txtLogin.getText());
            pst.setString(4, txtPass.getText());

            rs = pst.executeQuery();

            if (rs.next()) {

                String profile = rs.getString(6);
                String Branch = rs.getString(7);
                //System.out.println(profile);

                if (profile.equals("admin")) {

                    MainScreen mainScr = new MainScreen();
                    mainScr.setVisible(true);
                    MainScreen.RegMenu.setEnabled(true);
                    MainScreen.StaffReg.setEnabled(true);
                    MainScreen.BranchMenu.setEnabled(true);
                    MainScreen.DublinMenu.setEnabled(true);
                    MainScreen.CorkMenu.setEnabled(true);
                    MainScreen.GalwayMenu.setEnabled(true);
                    
                    

                    this.dispose();

                }
                if (profile.equals("staff") && Branch.equals("Dublin")) {
                    MainScreen mainScr = new MainScreen();
                    mainScr.setVisible(true);
                    MainScreen.DublinMenu.setEnabled(true);
                    MainScreen.StaffReg.setEnabled(true);
                    MainScreen.BranchMenu.setEnabled(true);MainScreen.StaffReg.setEnabled(true);
                    StudentEnrol stdEnrol = new StudentEnrol();
                    stdEnrol.setVisible(true);

                    StaffRegistration staffReg = new StaffRegistration();
                    staffReg.setVisible(true);
                    this.dispose();

                }
                if (profile.equals("staff") && Branch.equals("Cork")) {
                    MainScreen mainScr = new MainScreen();
                    mainScr.setVisible(true);
                    MainScreen.StaffReg.setEnabled(true);
                    MainScreen.BranchMenu.setEnabled(true);
                    MainScreen.CorkMenu.setEnabled(true);
                    //GalwayScreen galwayscr =  new GalwayScreen();
                    // galwayscr.setVisible(true);
                    StudentEnrol stdEnrol = new StudentEnrol();
                    stdEnrol.setVisible(true);

                    StaffRegistration staffReg = new StaffRegistration();
                    staffReg.setVisible(true);
                    this.dispose();

                }
                if (profile.equals("staff") && Branch.equals("Galway")) {
                    MainScreen mainScr = new MainScreen();
                    mainScr.setVisible(true);//CorkScreen corkscr =  new CorkScreen
                    //corkscr.setVisible(true)
                    MainScreen.StaffReg.setEnabled(true);
                    MainScreen.BranchMenu.setEnabled(true);
                    MainScreen.GalwayMenu.setEnabled(true);
                    StudentEnrol stdEnrol = new StudentEnrol();
                    stdEnrol.setVisible(true);

                    StaffRegistration staffReg = new StaffRegistration();
                    staffReg.setVisible(true);
                    this.dispose();

                }

                if (profile.equals("lecturer")) {
                    MainScreen mainScr = new MainScreen();
                    mainScr.setVisible(true);
                    Test_ExamsScreen staffScr = new Test_ExamsScreen();
                    staffScr.setVisible(true);
                    this.dispose();

                }
                

            } else {

                JOptionPane.showMessageDialog(null, "User or password is incorrect");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Creates new form LoginScreen
     */
    public LoginScreen() {
        initComponents();
        conn = Connection_Module.connector();
        //System.out.println(conn);

        if (conn != null) {
            lblStatus.setText("Connected");

        } else {

            lblStatus.setText("Not connected");
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

        jInternalFrame2 = new javax.swing.JInternalFrame();
        btnAccess = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        lblPass = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 0, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.black);
        setResizable(false);

        jInternalFrame2.setVisible(true);

        btnAccess.setText("Access");
        btnAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccessActionPerformed(evt);
            }
        });

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        lblPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPass.setText("Password");
        lblPass.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setText("Login");
        lblLogin.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("Status");

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAccess, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPass, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(45, 45, 45))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAccess))
                .addGap(45, 45, 45))
        );

        jInternalFrame2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAccess, lblLogin, lblPass, lblStatus, txtLogin, txtPass});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void btnAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccessActionPerformed
        // TODO add your handling code here:
        loginUser();
    }//GEN-LAST:event_btnAccessActionPerformed

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
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccess;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
