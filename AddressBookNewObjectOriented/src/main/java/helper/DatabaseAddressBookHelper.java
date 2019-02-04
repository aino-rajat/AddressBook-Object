package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import addressbook.Address;
import backend.Backend;
import backendmanager.BackendMenuManager;

public class DatabaseAddressBookHelper implements BackendHelper{

	Scanner input=new Scanner(System.in);
	Connection connect;
	Statement statement = null;
	PreparedStatement preparedStatement;
	ResultSet resultSet =null;
	BackendMenuManager manage;
	Backend current;
	
	public DatabaseAddressBookHelper(BackendMenuManager manage) {
		this.manage=manage; 
		current = manage.getCurrentBackend();
        connection();
	}

	public void connection() {
		try {
			String url=current.toString();
			String spl[]=url.split(" ");
			String url1=spl[0];
			String user=spl[1];
			String pass=spl[2];
			System.out.println(url1);
			Class.forName("com.mysql.jdbc.Driver");
			connect =DriverManager.getConnection(url1,user,pass);
			statement=connect.createStatement();
			System.out.println("Connected");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void createAddressbook() {
	connection();
	Address add=new Address();
	System.out.println("Enter Your Name");
	add.setName(input.next());
	System.out.println("Enter Your Emailid");
	add.setEmailId(input.next());
	System.out.println("Enter Your Phone No");
	add.setPhoneNo(input.nextInt());
	String query = " insert into Address VALUES ('"+add.getName()+"','"+add.getEmailId()+"','"+add.getPhoneNo()+"')";
	try {
	 statement.executeUpdate(query);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	}

	public void readAddressbook() {
		connection();
		Address add=new Address();
		System.out.println("Enter Your Name");
		add.setName(input.next());
		String name=add.getName();
		System.out.println(name);
		String query="Select * from Address where name='"+name+"'";
		try {
			resultSet=statement.executeQuery(query);
			while(resultSet.next())
			{
			  resultSet.getString("EMAILID");
			 resultSet.getString("PHONENUMBER");
			System.out.println("Email id is :"+resultSet.getString(2)+"Phone Number is :"+resultSet.getString(3) );
			 }
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

	public void updateAddressbook() {
		connection();
		Address add=new Address();
		System.out.println("Enter the name you want to update");
		add.setName(input.next());
		System.out.println("Enter Your Emailid");
		add.setEmailId(input.next());
		System.out.println("Enter Your Phone No");
		add.setPhoneNo(input.nextInt());
		String query = "UPDATE Address SET EMAILID='"+add.getEmailId()+"' , PHONENUMBER='"+add.getPhoneNo()+"'where name='"+add.getName()+"'  ";
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	public void deleteAddressbook() {
		connection();
		Address add=new Address();
		System.out.println("Enter the name you want to delete");
		add.setName(input.next());
		String query="Delete from Address where name='"+add.getName()+"'";
		try {
		statement.executeUpdate(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}
}
	
		

