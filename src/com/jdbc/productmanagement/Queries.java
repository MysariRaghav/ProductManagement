package com.jdbc.productmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.jdbc.DBConnection.DBConnection;
import com.jdbc.model.ProductDetails;

public class Queries {
	
	
	private DBConnection db= new DBConnection();
	private Connection connection= db.getConnection();
	private PreparedStatement st;
	private ResultSet result;
	private ProductDetails productDetails= new ProductDetails();
	
	public void addCategory(String sqlStatement, String category) throws SQLException {
		// TODO Auto-generated method stub
		
		st = createStatement(sqlStatement, category);
				
		int result= executeUpdate();
		
		if(result>0)
			System.out.println("Success");
		else
			System.out.println("cannot insert");
		
	}

	private int executeUpdate() throws SQLException {
		try{
			return st.executeUpdate();
		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			System.out.println("Element already exists, Please check and re-enter");
			return 0;
		}
		
	}
	
	public void categoryListing(String sqlStatement) throws SQLException
	{
		st = createStatement(sqlStatement);
		
		result= st.executeQuery();
		ResultSetMetaData resultSetMetaData= result.getMetaData();		 
		 
		int numberOfColumns= resultSetMetaData.getColumnCount();
		
		displayResults(numberOfColumns);
	}

	public void showProductDetails(String sqlStatement, String productName) throws SQLException {
		// TODO Auto-generated method stub
		
		st = createStatement(sqlStatement, productName);
		
		result= st.executeQuery();
		ResultSetMetaData resultSetMetaData= result.getMetaData();		 
		 	
		
		while(result.next())
		{
			productDetails.setDiscription(result.getString(5));
			productDetails.setPid(result.getInt(1));
			productDetails.setPrice(result.getInt(4));
			productDetails.setProduct_code(result.getString(2));
			productDetails.setProduct_name(result.getString(3));
			productDetails.setQuantity(result.getInt(6));
			productDetails.setRating(result.getDouble(7));
			
			System.out.println(productDetails);
			
		}
		
	}
	
	public void addProduct(String sqlStatement, String[] productDetails) throws SQLException {
		// TODO Auto-generated method stub
		
		st = createStatement(sqlStatement, productDetails);		
		int result= executeUpdate();
		
		if(result>0)
			System.out.println("Success");
		else
			System.out.println("cannot insert");
		
		
	}
	
	public void productsOfCategoryListing(String sqlStatement, String category) throws SQLException {
		// TODO Auto-generated method stub
		
		st = createStatement(sqlStatement, category);
		
		result= st.executeQuery();
		ResultSetMetaData resultSetMetaData= result.getMetaData();		 
		 
		int numberOfColumns= resultSetMetaData.getColumnCount();
		
		displayResults(numberOfColumns);		
	}
	
	
	public void deleteCategory(String sqlStatement, String category) throws SQLException {
		// TODO Auto-generated method stub
		st = createStatement(sqlStatement, category);		
		int result= executeUpdate();
		
		if(result>0)
			System.out.println("Successfully Deleted Rowa");
		else
			System.out.println("Nothing gets deleted");
		
	}
	
	
	public void deleteProducts(String sqlStatement, String productDetails) throws SQLException {
		// TODO Auto-generated method stub
		st = createStatement(sqlStatement, productDetails);		
		int result= executeUpdate();
		
		if(result>0)
			System.out.println("Successfully Deleted Rowa");
		else
			System.out.println("Nothing gets deleted");
	}
	
	public void averageProductInCategory(String sqlStatement) throws SQLException {
		// TODO Auto-generated method stub
		
		st = createStatement(sqlStatement);		
		result= st.executeQuery();
		
		ResultSetMetaData resultSetMetaData= result.getMetaData();;
		int numberOfColumns= resultSetMetaData.getColumnCount();
		
		displayResults(numberOfColumns);		
		
		
	}
	
	
	public void goodDescriotion(String sqlStatement) throws SQLException {
		// TODO Auto-generated method stub
		
		st = createStatement(sqlStatement);		
		result= st.executeQuery();
		
		ResultSetMetaData resultSetMetaData= result.getMetaData();;
		int numberOfColumns= resultSetMetaData.getColumnCount();
		
		displayResults(numberOfColumns);				
		
	}

	private void displayResults(int numberOfColumns) throws SQLException {
		while(result.next())
			for(int i=1; i<=numberOfColumns; i++)
				System.out.print(result.getString(i)+"\t");
	}
	
	private PreparedStatement createStatement(String sqlStatement, String... args) throws SQLException {
		PreparedStatement st= (PreparedStatement) connection.prepareStatement(sqlStatement);
		
		if(args!= null)
			for(int i=0; i<args.length; i++)
			{
				String arg=args[i];
				if(isDouble(arg))
					st.setDouble(i, Double.parseDouble(arg));
				else if(isInteger(arg))
					st.setInt(i, Integer.parseInt(arg));
				else
					st.setString(i+1, args[i]);
			}
			
		return st;

	}

	private boolean isInteger(String arg) {
		// TODO Auto-generated method stub		
		try{
			Integer.parseInt(arg);
			return true;
		}
		catch(NumberFormatException e)
		{
			
			//System.out.println("Please enter valid detaits, cannot parse to Integer");			
			return false;
		}
	}

	private boolean isDouble(String arg) {
		// TODO Auto-generated method stub
		
		try{
			Double.parseDouble(arg);
			return true;
		}
		catch(NumberFormatException e)
		{
			//System.out.println("Please enter valid detaits, cannot parse to Double");
			return false;
		}
	}

	

	

	
}
