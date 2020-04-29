package com.bilal.restapijersey;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;

public class CustomerRepository {
	
	Connection con = null;
	

	
	//List<Customer> customerList;
	
	
	public CustomerRepository()
	{
		String url = "jdbc:mysql://localhost:3306/restapidb?autoReconnect=true&useSSL=false";
		String username = "root";
		String password = "bilal123";
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
//		customerList = new ArrayList<>();
//		
//		Customer c1 = new Customer();
//		c1.setId(101);
//		c1.setCname("Bilal");
//		c1.setCscore(80);
//		
//		Customer c2 = new Customer();
//		c2.setId(102);
//		c2.setCname("Ahmad");
//		c2.setCscore(70);
//		
//		customerList.add(c1);
//		customerList.add(c2);
	}
	
	public List<Customer> getCustomers(){
		
		List<Customer> customers = new ArrayList<>();
		String sql = "select * from customer";
		try 
		{	
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Customer c = new Customer();
				c.setId(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setCscore(rs.getInt(3));
				
				customers.add(c);
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		return customers;
	}
	
	public Customer getCustomer(int id)
	{
		
		
		String sql = "select * from customer where id = " +id;
		Customer c = new Customer();
		
		try 
		{	
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				c.setId(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setCscore(rs.getInt(3));
			}
			else
			{
				c = null;
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}

	public void createCustomer(Customer c) {
		// TODO Auto-generated method stub
		String sql = "insert into customer values(?,?,?)";
		try 
		{	
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, c.getId());
			st.setString(2, c.getCname());
			st.setInt(3, c.getCscore());
			st.executeUpdate();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		String sql = "update customer set name =?, score= ? where id=?";
		try 
		{	
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, c.getCname());
			st.setInt(2, c.getCscore());
			st.setInt(3, c.getId());
			
			st.executeUpdate();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from customer where id=?";
		try 
		{	
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
}
