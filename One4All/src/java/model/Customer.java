package model;

import java.sql.*;
import java.util.*;


public class Customer {

    private int customerId;
    private String name;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Customer findById(int customerId) {
        Customer c = null;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "Select * from customer where customer_id = ?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, customerId);
            ResultSet rs=ps.executeQuery();
            
          if(rs.next()){
              if(c==null){
                  c=new Customer();
                  c.setCustomerId(rs.getInt("customer_Id"));
                  c.setName(rs.getString("name"));
              }
          }  
            
            
        } catch (SQLException e) {
            System.out.println(e);
        }
            return c;
    }
    public static void main(String[]args){
        Customer c=Customer.findById(1);
        System.out.println(c.getName());
    }
}
