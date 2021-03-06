package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Branch {
	//A common method to connect to the DB
		private Connection connect()
		{
		Connection con = null;
		try
		{
		Class.forName("com.mysql.jdbc.Driver");

		//Provide the correct details: DBServer/DBName, username, password
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/electro_grid", "root", "");
		}
		catch (Exception e)
		{e.printStackTrace();}
		return con;
		}

		
//		public String readBranches()
//		{
//		String output = "";
//		try
//		{
//		Connection con = connect();
//		if (con == null)
//		{return "Error while connecting to the database for reading."; }
//		// Prepare the html table to be displayed
//		output = "<table border='1'><tr><th>Branch Name</th><th>Branch Address</th>" +
//				"<th>Branch ContactNo</th>" +
//				"<th>Branch Email</th>" +
//				"<th>Update</th><th>Remove</th></tr>";
//
//		String query = "select * from branches";
//		Statement stmt = con.createStatement();
//		ResultSet rs = stmt.executeQuery(query);
//		// iterate through the rows in the result set
//		while (rs.next())
//		{
//		String branchID = rs.getString("branchID");
//		String branchName = rs.getString("branchName");
//		String branchAddress = rs.getString("branchAddress");
//		String branchContact = Integer.toString(rs.getInt("branchContact"));
//		String branchEmail = rs.getString("branchEmail");
//		// Add into the html table
//		output += "<tr><td>" + branchName + "</td>";
//		output += "<td>" + branchAddress + "</td>";
//		output += "<td>" + branchContact + "</td>";
//		output += "<td>" + branchEmail + "</td>";
//		// buttons
//		output += "<td><input type='button' value='Update' class='btn btn-secondary'></td>"
//		+ "<td><form method='post' action='branches.jsp'>"+"<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
//		+ "<input name='branchID' type='hidden' value='" + branchID
//		+ "'>" + "</form></td></tr>";
//		}
//		con.close();
//		// Complete the html table
//		output += "</table>";
//		}
//		catch (Exception e)
//		{
//		output = "Error while reading the branches.";
//		System.err.println(e.getMessage());
//		}
//		return output;
//		}
//		
		
		public String readBranches()
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {
		 return "Error while connecting to the database for reading.";
		 }
		 // Prepare the html table to be displayed
		 output = "<table border='1'><tr><th>Branch ID</th> <th>Branch Name</th><th>Branch Address</th>" +
		 		"<th>Branch ContactNo</th>" +
		 		"<th>Branch Email</th>" +
		 		"<th>Update</th><th>Remove</th></tr>";
		 
		 String query = "select * from branches";
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
		 // iterate through the rows in the result set
		 while (rs.next())
		 {
		 String branchID = rs.getString("branchID");
		 String branchName = rs.getString("branchName");
		 String branchAddress = rs.getString("branchAddress");
		 String branchContact = Integer.toString(rs.getInt("branchContact"));
		 String branchEmail = rs.getString("branchEmail");
		 
		 // Add into the html table
		 output += "<tr><td><input id='hiddbrIDUpdate' name='hiddbrIDUpdate' type='hidden' value='" + branchID + "'>" + branchID + "</td>";
		 output += "<td>" + branchName + "</td>";
		 output += "<td>" + branchAddress + "</td>";
		 output += "<td>" + branchContact + "</td>";
		 output += "<td>" + branchEmail + "</td>";
		 
		 // buttons
		output += "<td><input name='btnUpdate' type='button' value='Update'class='btnUpdate btn btn-secondary'></td>"+ "<td><input name='btnRemove'type='button' value='Remove' class='btnRemove btn btn-danger'data-branchID='"+ branchID + "'>" + "</td></tr>";
		 }
		 con.close();
		 // Complete the html table
		 output += "</table>";
		 }
		 catch (Exception e)
		 {
		 output = "Error while reading the branches.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 } 
		
		public String insertBranch(String branchID, String branchName, String branchAddress, String branchContact, String branchEmail)
		{
		String output = "";
		try
		{
		Connection con = connect();
		if (con == null)
		{return "Error while connecting to the database for inserting."; }
		// create a prepared statement
		String query = " insert into branches(`branchID`,`branchName`,`branchAddress`,`branchContact`,`branchEmail`)" + " values (?, ?, ?, ?, ?)";
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
		// binding values
		preparedStmt.setString(1, branchID);
		preparedStmt.setString(2, branchName);
		preparedStmt.setString(3, branchAddress);
		preparedStmt.setInt(4, Integer.parseInt(branchContact));
		preparedStmt.setString(5,branchEmail);
		// execute the statement

		preparedStmt.execute();
		con.close();
		
		String newBranches = readBranches();
		 output = "{\"status\":\"success\", \"data\": \"" +
		 newBranches + "\"}";
		 }
		 catch (Exception e)
		 {
		 output = "{\"status\":\"error\", \"data\":\"Error while inserting the branch.\"}";
		 System.err.println(e.getMessage());
		 } 

		return output;
		}
		
		public String updateBranch(String branchID, String branchName, String branchAddress, String branchContact, String branchEmail)
		{
		String output = "";
		try
		{
		Connection con = connect();
		if (con == null)
		{return "Error while connecting to the database for updating."; }
		// create a prepared statement
		String query = "UPDATE branches SET branchID=?, branchName=?,branchAddress=?,branchContact=?,branchEmail=?WHERE branchID=?";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		// binding values
		
		preparedStmt.setString(1, branchName);
		preparedStmt.setString(2, branchAddress);
		preparedStmt.setInt(3, Integer.parseInt(branchContact));
		preparedStmt.setString(4, branchEmail);
		preparedStmt.setString(5, branchID);
		// execute the statement
		preparedStmt.execute();
		con.close();
		
		String newBranches = readBranches();
		 output = "{\"status\":\"success\", \"data\": \"" +
		 newBranches + "\"}";
		 }
		 catch (Exception e)
		 {
		 output = "{\"status\":\"error\", \"data\":\"Error while inserting the branch.\"}";
		 System.err.println(e.getMessage());
		 } 
		return output;
		}
		
		public String deleteBranch(String branchID)
		{
		String output = "";
		try
		{
		Connection con = connect();
		if (con == null)
		{return "Error while connecting to the database for deleting."; }
		// create a prepared statement
		String query = "delete from branches where branchID=?";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		// binding values
		preparedStmt.setString(1, branchID);
		// execute the statement
		preparedStmt.execute();
		con.close();
		String newBranches = readBranches();
		 output = "{\"status\":\"success\", \"data\": \"" +
		 newBranches + "\"}";
		 }
		 catch (Exception e)
		 {
		 output = "{\"status\":\"error\", \"data\":\"Error while inserting the branch.\"}";
		 System.err.println(e.getMessage());
		 } 
		return output;
		}
}