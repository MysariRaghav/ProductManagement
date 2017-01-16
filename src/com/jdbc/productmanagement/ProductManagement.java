package com.jdbc.productmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.DBConnection.DBConnection;


public class ProductManagement {
	
	public static void main(String[] args) throws SQLException {
	
	int option=0;
	Scanner scanner= new Scanner(System.in);
	
	Queries queries= new Queries();
		
	EXIT: do
	{
	System.out.println(" Please enter the option\n");
	
	System.out.println("1) Add new product category\n" +
					   "2) Add new product under a category\n"+
					   "3) View specific product's description and other details\n"+
					   "4) Listing of categories\n"+
					   "5) Listing of all the products of a category\n"+
					   "6) Display Average number of products among all categories\n"+
					   "7) Display the product which has largest description\n"+
					   "8) Delete Category\n"+
					   "9) Delete Product\n"+
					   "10) Remove Product from a category\n"+
					   "11) Display most recent 5 products\n"+
					   "12) EXIT\n");
	
	option= Integer.parseInt(scanner.nextLine());
	
	switch(option)
	{
	
	case 1:
		System.out.println("Please enter the category");
		String category= scanner.nextLine();
		queries.addCategory("insert into categories values (?)", category);
		break;
	case 2:
		
		System.out.println("Please enter the Product,Category");
		String productDetails= scanner.nextLine();
		System.out.println(productDetails);
		System.out.println(productDetails.split(",")[1]);
		
		queries.addProduct("insert into productcategories values (?,?)", productDetails.split(","));
		break;
	case 3:
		
		System.out.println("Please enter the Product Name");
		String productName= scanner.nextLine();
		queries.showProductDetails("SELECT * FROM productddetails where product_name= ?", productName);
		break;
	case 4:		
		queries.categoryListing("select * from categories");
		break;
	case 5:
		System.out.println("Please enter the category");
		category= scanner.nextLine();
		queries.productsOfCategoryListing("SELECT product_code FROM productcategories where product_category= ?", category);
		break;
	case 6:
		queries.averageProductInCategory("select Avg(no_of_product) "
				+ "from "
				+ "( select product_code, count(*) as no_of_product "
				+ "from productcategories"
				+ " group by product_category) As t");	
		break;
	case 7:
		queries.goodDescriotion("select product_description, length(product_description) as desc_len "
				+ "from productddetails "
				+ "order by desc_len desc "
				+ "limit 1");
		break;
	case 8:
		System.out.println("Please enter the category");
		category= scanner.nextLine();
		queries.deleteCategory("delete from categories where product_category= ?", category);
		break;
	case 9:
		System.out.println("Please enter the product");
		productDetails= scanner.nextLine();
		queries.deleteProducts("delete from productcategories where product_code= ?", productDetails);
		break;
	case 10:
		break;
	case 11:
		break;
	case 12:
		break EXIT;
	default:
		System.out.println("Please enter correct option");	
	}
	
	
	System.out.println("\n\n\n\nWould you like to continue(Y/N)..!!");
	
	if(scanner.nextLine().equals("N"))
		break;
	}while(true);
	
	
	System.out.println("Exited the Program");
	

	}

}
