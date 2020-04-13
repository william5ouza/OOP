import java.sql.Connection;
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
    static final String DB_URL = "jdbc:mysql://localhost/myfirstdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
        //  Database credentials
    static final String USER = "root";
    static final String PASS = "Will157@";
    
    public static void main (String []args){
        
     Connection conn = null;
     Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);



//STEP 4: Execute a query
System.out.println("Creating statement...");
stmt = conn.createStatement();
String sql;
sql = "SELECT * FROM employees";
ResultSet rs = stmt.executeQuery(sql);

System.out.println("Creating statement...");
stmt = conn.createStatement();
String sql1;
sql1 = "SELECT * FROM staff";
ResultSet rs1 = stmt.executeQuery(sql1);
//STEP 5: Extract data from result set
while (rs.next()) {
System.out.println("reading result.... ");

int personid = rs.getInt("Sno");
String  = rs.getString("age");
String firstname = rs.getString("first");
String LName = rs.getString("last");
//String c= rs.getString("City");

//Display values
System.out.print("id: " + personid);
System.out.println(", age: " + age);
System.out.println(", First Name: " + firstname);
System.out.println(", Last Name: " + LName);
//System.out.println(", City: " + city);

}

} catch (Exception e) {
//Handle errors for Class.forName
e.printStackTrace();
} finally {

}

}

}
