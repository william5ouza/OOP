
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William
 *
 */
public class OOP_Project {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/MyFirstDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "Will157@";

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

//STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

//STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM staff";
            ResultSet rs = stmt.executeQuery(sql);

//STEP 5: Extract data from result set
            while (rs.next()) {
                System.out.println("reading result.... ");
                
                String personid = rs.getString("Sno");
                String lastname = rs.getString("LName");
                String firstname = rs.getString("FName");
                String address = rs.getString("Address");
                Date DOB = rs.getDate("DOB");
                //String city = rs.getString("Address");

//Display values
                
                System.out.print("PersonID: " + personid);
                System.out.println(", Last Name: " + lastname);
                System.out.println(", First Name: " + firstname);
                System.out.println(", Address: " + address);
                System.out.println("DOB: " + DOB);
                //System.out.println(", City: " + city);

            }

        } catch (Exception e) {
//Handle errors for Class.forName
            e.printStackTrace();
        } finally {

        }

    }

}
