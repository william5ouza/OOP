/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.managers;
import java.sql.*;
import dal.Connection_Module;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class Registration extends javax.swing.JInternalFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    //This method calls the funcion search
    
    
    /**
     * Creates new form Registration
     */
    public Registration() {
        initComponents();
        
       conn = Connection_Module.connector();
    }
    
    private void Searching(){
                String sql = "select * from users where StaffID =? or StudentID=?";

         try {
            //System.out.println("Connecting"); 
            
            pst = conn.prepareStatement(sql);
           
            pst.setString(1, txtID.getText());
            
            pst.setString(2, txtID.getText());
            
          
            
            rs = pst.executeQuery();
          
            
            
             if (rs.next()) {
                 
               
               txtNme.setText(rs.getString(3)); //here is where the second item of the table is 
               txtLogin.setText(rs.getString(4)); //here is where the third item of the table is 
               txtPass.setText(rs.getString(5)); //here is where the fourth item of the table is
               cboProfile.setSelectedItem(rs.getString(6));
               cboBranch.setSelectedItem(rs.getString(7)); //here is where the sixth item of the table is (combo box)
               
               
            } else {
                JOptionPane.showMessageDialog(null, "User is not registered");
                //If the user is not found the system cleans the form in case there was another search
               txtNme.setText(null);
               txtLogin.setText(null);
               txtPass.setText(null);
               cboProfile.setSelectedItem(null);
               cboBranch.setSelectedItem(null);
            }
            
        } catch (Exception e) {
            
             JOptionPane.showMessageDialog(null, e);
            
        }
            
    }
    
            private void Adding() {
                
                 
        try {
            pst = conn.prepareStatement("select * from users where profile=?");
            pst.setString(1,cboProfile.getSelectedItem().toString());
            rs = pst.executeQuery();
            
            
            
            String profile = cboProfile.getSelectedItem().toString();
            System.out.println(profile);
            switch (profile)
            {
                case "staff":
                    
                    //String sql = "insert into users (profile, Name, Phone, Password, StudentID) values (?, ?, ?, ?, ?, ?)";
                    
                    try {                   
                        
                        
    pst= conn.prepareStatement("insert into users (StaffID, Name, userlogin, Password, profile, Branch) values (?, ?, ?, ?, ?, ?)");
                        
                        pst.setString(1, txtID.getText());
                        pst.setString(2,txtNme.getText());
                        pst.setString(3,txtLogin.getText());
                        pst.setString(4,txtPass.getText());
                        pst.setString(5,cboProfile.getSelectedItem().toString());
                        pst.setString(6,cboBranch.getSelectedItem().toString());
                       
                        //pst.setString (6, txtStdID.getText());
                        //confirming the  addition of a data in the table
                        
                        if (txtID.getText().isEmpty()||txtNme.getText().isEmpty()||txtPass.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Please fill all mandatory fields");
                        } else {
                        
                        int added = pst.executeUpdate();
                       
                       
                        if(added >0){
                            JOptionPane.showMessageDialog(null, "User added successfully");
                            txtID.setText(null);
                            txtNme.setText(null);
                            txtLogin.setText(null);
                            txtPass.setText(null);
                            cboProfile.setSelectedItem(null);
                            cboBranch.setSelectedItem(null);
                        } 
                        }   
                        
                    }  catch (Exception e) {
                        
                        JOptionPane.showMessageDialog(null, e);
                        
                        break;
                    }
                
                case "lecturer":
                    
                    //String sql = "insert into users (profile, Name, Phone, Password, StudentID) values (?, ?, ?, ?, ?, ?)";
                    
                    try {                   
                        
                        
    pst= conn.prepareStatement("insert into users (StaffID, Name, userlogin, Password, profile, Branch) values (?, ?, ?, ?, ?, ?)");
                        
                        pst.setString(1, txtID.getText());
                        pst.setString(2,txtNme.getText());
                        pst.setString(3,txtLogin.getText());
                        pst.setString(4,txtPass.getText());
                        pst.setString(5,cboProfile.getSelectedItem().toString());
                        pst.setString(6,cboBranch.getSelectedItem().toString());
                       
                        //pst.setString (6, txtStdID.getText());
                        //confirming the  addition of a data in the table
                        
                        if (txtID.getText().isEmpty()||txtNme.getText().isEmpty()||txtPass.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Please fill all mandatory fields");
                        } else {
                        
                        int added = pst.executeUpdate();
                       
                       
                        if(added >0){
                            JOptionPane.showMessageDialog(null, "User added successfully");
                            txtID.setText(null);
                            txtNme.setText(null);
                            txtLogin.setText(null);
                            txtPass.setText(null);
                            cboProfile.setSelectedItem(null);
                            cboBranch.setSelectedItem(null);
                        } 
                        }   
                        
                    }  catch (Exception e) {
                        
                        JOptionPane.showMessageDialog(null, e);
                    }
                    //Java code
               
                   break;
                case "student":
                    //Java code
                    try {
                        
                        
    pst= conn.prepareStatement("insert into users (StudentID, Name, userlogin, Password, profile, Branch ) values (?, ?, ?, ?, ?, ?)");
                        
                        
                        pst.setString(2,txtNme.getText());
                        pst.setString(3,txtLogin.getText());
                        pst.setString(4,txtPass.getText());
                        pst.setString(1, txtID.getText());
                        pst.setString(5,cboProfile.getSelectedItem().toString());
                        pst.setString(6,cboBranch.getSelectedItem().toString());
                        
                        
                        //pst.setString (6, txtStdID.getText());
                        //confirming the  addition of a data in the table
                         if (txtID.getText().isEmpty()||txtNme.getText().isEmpty()||txtPass.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Please fill all mandatory fields");
                        } else {
                        int added = pst.executeUpdate();
                        if(added >0){
                            JOptionPane.showMessageDialog(null, "User added successfully");
                            txtID.setText(null);
                            txtNme.setText(null);
                            txtLogin.setText(null);
                            txtPass.setText(null);
                            cboProfile.setSelectedItem(null);
                            cboBranch.setSelectedItem(null);
                        }
                         }
                        
                    }  catch (Exception e) {
                        
                        JOptionPane.showMessageDialog(null, e);
                    }
                 
                default:
                    
                    
                    //Java code
                    ;
             
            }
            
          
        } catch (SQLException ex) {
           // Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
            }
            
            
        private void Updating(){
           String sql = null; 
         
         
            try {
                pst= conn.prepareStatement("update users  set  Name=?, userlogin=?, Password=?, Branch=?  where StudentID=? or StaffID=?");
                //pst.setString(1,cboProfile.getSelectedItem().toString());
            
            
            
            
           
            
            //rs = pst.executeQuery();
            
            if (rs.next()) {             
                 String profile = cboProfile.getSelectedItem().toString();
             

                if (profile.equals("staff")||(profile.equals("lecturer"))) {

                        pst.setString(1,txtID.getText());
                        pst.setString(1,txtNme.getText());
                        pst.setString(2,txtLogin.getText());
                        pst.setString(3,txtPass.getText());
                        //pst.setString(4,cboProfile.getSelectedItem().toString());
                        pst.setString(5,cboBranch.getSelectedItem().toString());
                        //confirming the  addition of a data in the table
                }
                        if (txtID.getText().isEmpty()||txtNme.getText().isEmpty()||txtPass.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Please fill all mandatory fields");
                        } else {
                                                
                        int added = pst.executeUpdate();
                        
                        if(added >0){
                            JOptionPane.showMessageDialog(null, "User updated successfully");
                            txtID.setText(null);
                            txtNme.setText(null);
                            txtLogin.setText(null);
                            txtPass.setText(null);
                            cboProfile.setSelectedItem(null);
                        }
                        }

            
            
            if (profile.equals("student")) {

                        pst.setString(1,txtID.getText());
                        pst.setString(1,txtNme.getText());
                        pst.setString(2,txtLogin.getText());
                        pst.setString(3,txtPass.getText());
                        //pst.setString(4,cboProfile.getSelectedItem().toString());
                        pst.setString(5,cboBranch.getSelectedItem().toString());
                        //confirming the  addition of a data in the table
                }
                        if (txtID.getText().isEmpty()||txtNme.getText().isEmpty()||txtPass.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Please fill all mandatory fields");
                        } else {
                                                
                        int added = pst.executeUpdate();
                        
                        if(added >0){
                            JOptionPane.showMessageDialog(null, "User updated successfully");
                            txtID.setText(null);
                            txtNme.setText(null);
                            txtLogin.setText(null);
                            txtPass.setText(null);
                            cboProfile.setSelectedItem(null);
                        }
                        }

            }else {

                JOptionPane.showMessageDialog(null, "Erro");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }
                 
              
           
         {  /*rs = pst.executeQuery();
           
           if (rs.next()) {
               String profile = cboProfile.getSelectedItem().toString();     
           
                if (profile.equals("staff") || profile.equals("lecturer") ) {
                        
                        pst.setString(1,txtID.getText());
                        pst.setString(1,txtNme.getText());
                        pst.setString(2,txtLogin.getText());
                        pst.setString(3,txtPass.getText());
                        pst.setString(4,cboProfile.getSelectedItem().toString());
                        pst.setString(5,cboBranch.getSelectedItem().toString());
                        //confirming the  addition of a data in the table
                }
                        if (txtID.getText().isEmpty()||txtNme.getText().isEmpty()||txtPass.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Please fill all mandatory fields");
                        } else {
                                                
                        int added = pst.executeUpdate();
                       
                        
                        if(added >0){
                            JOptionPane.showMessageDialog(null, "User updated successfully");
                            txtID.setText(null);
                            txtNme.setText(null);
                            txtLogin.setText(null);
                            txtPass.setText(null);
                            cboProfile.setSelectedItem(null);
                        } 
                         
                
                        
          
           
                    
               if (profile.equals("student") ) {
                    
                    //String sql = "insert into users (profile, Name, Phone, Password, StudentID) values (?, ?, ?, ?, ?, ?)";
                    
                    try {                   
                  
                        
                        
                        pst= conn.prepareStatement("update users  set  Name=?, userlogin=?, Password=?, Branch=?  where StudentID=?");
                        
                        
                        pst.setString(1,txtNme.getText());
                        pst.setString(2,txtLogin.getText());
                        pst.setString(3,txtPass.getText());
                        pst.setString(4,cboBranch.getSelectedItem().toString());
                        //pst.setString (6, txtStdID.getText());
                        //confirming the  addition of a data in the table
                        if (txtID.getText().isEmpty()||txtNme.getText().isEmpty()||txtPass.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Please fill all mandatory fields");
                        } else {
                        
                        int added = pst.executeUpdate();
                        if(added >0){
                            JOptionPane.showMessageDialog(null, "User updated successfully");
                            txtID.setText(null);
                            txtNme.setText(null);
                            txtLogin.setText(null);
                            txtPass.setText(null);
                            cboProfile.setSelectedItem(null);
                            cboBranch.setSelectedItem(null);
                        }
                        }
                        
                    }  catch (Exception e) {
                        
                        JOptionPane.showMessageDialog(null, e);
                    }
                    ;
               
               
                    
                    
                    //Java code
                    ;
            
        } catch (SQLException e) {
            //Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
           }
        
        }
         }
        }


  */} 

         private void Deleting(){
            
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "Atention", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                try {
                    pst = conn.prepareStatement("delete from users where StaffID=? or StudentID=?");
                            
                    pst.setString(1, txtID.getText());
                    pst.setString(2, txtID.getText());
                    
                    int deleted = pst.executeUpdate(); 
                    
                    if(deleted >0){
                        JOptionPane.showMessageDialog(null, "User deleted succefully");
                         txtID.setText(null);
                            txtNme.setText(null);
                            txtLogin.setText(null);
                            txtPass.setText(null);
                            cboProfile.setSelectedItem(null);
                             cboBranch.setSelectedItem(null);
                            
                        
                    }
                } catch (Exception e) {
                    
                     JOptionPane.showMessageDialog(null, "User deleted succefully");
                }
                
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

        jColorChooser1 = new javax.swing.JColorChooser();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel8 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNme = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        cboProfile = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        btnDrop = new javax.swing.JButton();
        btnADD = new javax.swing.JButton();
        btnUpda = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        cboBranch = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setClosable(true);
        setForeground(new java.awt.Color(255, 255, 255));
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Register");
        setFrameIcon(null);
        setMaximumSize(new java.awt.Dimension(480, 420));
        setMinimumSize(new java.awt.Dimension(48, 42));
        setPreferredSize(new java.awt.Dimension(480, 420));
        setVisible(true);

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("jLabel1");
        jLabel8.setAlignmentX(0.5F);
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jInternalFrame1.setVisible(true);

        jLabel7.setBackground(new java.awt.Color(153, 153, 255));
        jLabel7.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("* Password");
        jLabel7.setAlignmentX(0.5F);
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel7.setMaximumSize(new java.awt.Dimension(90, 25));
        jLabel7.setPreferredSize(new java.awt.Dimension(90, 20));

        txtID.setBackground(new java.awt.Color(153, 153, 255));
        txtID.setForeground(new java.awt.Color(255, 255, 255));
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtID.setCaretColor(new java.awt.Color(204, 204, 255));
        txtID.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtID.setOpaque(false);
        txtID.setPreferredSize(new java.awt.Dimension(90, 25));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtNme.setBackground(new java.awt.Color(153, 153, 255));
        txtNme.setForeground(new java.awt.Color(255, 255, 255));
        txtNme.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNme.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNme.setCaretColor(new java.awt.Color(204, 204, 255));
        txtNme.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtNme.setOpaque(false);
        txtNme.setPreferredSize(new java.awt.Dimension(90, 25));
        txtNme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNmeActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(153, 153, 255));
        jLabel9.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("* User ID");
        jLabel9.setAlignmentX(0.5F);
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel9.setMaximumSize(new java.awt.Dimension(90, 25));
        jLabel9.setPreferredSize(new java.awt.Dimension(90, 20));

        jLabel10.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("* Profile");
        jLabel10.setAlignmentX(0.5F);
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel10.setMaximumSize(new java.awt.Dimension(90, 25));
        jLabel10.setPreferredSize(new java.awt.Dimension(90, 25));

        txtLogin.setBackground(new java.awt.Color(153, 153, 255));
        txtLogin.setForeground(new java.awt.Color(255, 255, 255));
        txtLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtLogin.setCaretColor(new java.awt.Color(204, 204, 255));
        txtLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtLogin.setOpaque(false);
        txtLogin.setPreferredSize(new java.awt.Dimension(90, 25));
        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(153, 153, 255));
        jLabel11.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("* Full  Name");
        jLabel11.setAlignmentX(0.5F);
        jLabel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel11.setMaximumSize(new java.awt.Dimension(90, 25));
        jLabel11.setPreferredSize(new java.awt.Dimension(90, 20));

        jLabel6.setBackground(new java.awt.Color(153, 153, 255));
        jLabel6.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("User login");
        jLabel6.setAlignmentX(0.5F);
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel6.setMaximumSize(new java.awt.Dimension(90, 25));
        jLabel6.setPreferredSize(new java.awt.Dimension(90, 20));

        txtPass.setBackground(new java.awt.Color(153, 153, 255));
        txtPass.setForeground(new java.awt.Color(255, 255, 255));
        txtPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtPass.setCaretColor(new java.awt.Color(204, 204, 255));
        txtPass.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtPass.setOpaque(false);
        txtPass.setPreferredSize(new java.awt.Dimension(90, 25));
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        cboProfile.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        cboProfile.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "staff", "student", "lecturer" }));
        cboProfile.setToolTipText("");
        cboProfile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cboProfile.setOpaque(false);
        cboProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProfileActionPerformed(evt);
            }
        });

        jLabel1.setText("*Mandatory field");

        jDesktopPane2.setBackground(new java.awt.Color(51, 0, 255));

        btnDrop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delDB.jpg"))); // NOI18N
        btnDrop.setToolTipText("Drop DB");
        btnDrop.setAlignmentX(0.5F);
        btnDrop.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDrop.setOpaque(false);
        btnDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDropActionPerformed(evt);
            }
        });

        btnADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addDB.jpg"))); // NOI18N
        btnADD.setAlignmentX(0.5F);
        btnADD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnADD.setOpaque(false);
        btnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDActionPerformed(evt);
            }
        });

        btnUpda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/updateDB.png"))); // NOI18N
        btnUpda.setAlignmentX(0.5F);
        btnUpda.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpda.setOpaque(false);
        btnUpda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdaActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/searchDB.jpg"))); // NOI18N
        btnSearch.setAlignmentX(0.5F);
        btnSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSearch.setOpaque(false);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jDesktopPane2.setLayer(btnDrop, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btnADD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btnUpda, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btnSearch, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnADD)
                .addGap(49, 49, 49)
                .addComponent(btnSearch)
                .addGap(49, 49, 49)
                .addComponent(btnUpda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDrop)
                .addContainerGap())
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnADD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDrop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch))
                    .addComponent(btnUpda))
                .addContainerGap())
        );

        jLabel12.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("* Branch");
        jLabel12.setAlignmentX(0.5F);
        jLabel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel12.setMaximumSize(new java.awt.Dimension(90, 25));
        jLabel12.setPreferredSize(new java.awt.Dimension(90, 25));

        cboBranch.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        cboBranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dublin", "Cork", "Galway" }));
        cboBranch.setToolTipText("");
        cboBranch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboBranch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cboBranch.setOpaque(false);
        cboBranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBranchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(46, 46, 46))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDesktopPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNme, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jInternalFrame1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboProfile, jLabel10, jLabel11, jLabel6, jLabel7, jLabel9, txtID, txtLogin, txtNme, txtPass});

        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jInternalFrame1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboProfile, jLabel10, jLabel11, jLabel6, jLabel7, jLabel9, txtID, txtLogin, txtNme, txtPass});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        setBounds(0, 0, 440, 420);
    }// </editor-fold>//GEN-END:initComponents

    private void cboProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboProfileActionPerformed

    private void btnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDActionPerformed
        // TODO add your handling code here:
        Adding();
    }//GEN-LAST:event_btnADDActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        Searching();

    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtNmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNmeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNmeActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnUpdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdaActionPerformed
        // TODO add your handling code here:
        Updating();
    }//GEN-LAST:event_btnUpdaActionPerformed

    private void btnDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDropActionPerformed
        // TODO add your handling code here:
        Deleting();
    }//GEN-LAST:event_btnDropActionPerformed

    private void cboBranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBranchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboBranchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnADD;
    private javax.swing.JButton btnDrop;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpda;
    private javax.swing.JComboBox<String> cboBranch;
    private javax.swing.JComboBox<String> cboProfile;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLogin;
    public javax.swing.JTextField txtNme;
    private javax.swing.JTextField txtPass;
    // End of variables declaration//GEN-END:variables
}
