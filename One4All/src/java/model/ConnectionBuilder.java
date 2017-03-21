
package model;
    import java.sql.*;

    
public class ConnectionBuilder {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
        con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
        
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(SQLException e) {
            System.out.println(e);
            
        }

        return con;
    }
    public static void main(String[]arg){
        Connection con=getConnection();
        System.out.println("Connection Complete");
    }
}
