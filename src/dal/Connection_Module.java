/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.*;

/**
 *
 * @author William
 */
public class Connection_Module {
    
    public static Connection connector() {
    
     java.sql.Connection conn = null;
     final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
     final String DB_URL = "jdbc:mysql://localhost/virtualglobalcollege?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    //  Database credentials
     final String USER = "root";
     final String PASS = "Will157@";
     
        try {
             //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

//STEP 3: Open a connection
           
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            return conn;
        } catch (Exception e) {
            
            return null;
        }

}
        }
