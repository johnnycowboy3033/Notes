package gov.irs.protype.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class CustomerDOA {
	 // Database credentials
    String url = "jdbc:mysql://localhost:3306/protype";
    String username = "root";
    String password = "root";
    
  	String first_name =  "";
	String last_name = "";
    
   
    public CustomerDOA() {
		super();
	}

	public String getCustomerById(int customer_id) {
        // Establish a connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");

            // Create a statement object
            Statement statement = connection.createStatement();

            // Execute a SELECT query
            String query = "SELECT first_name, last_name FROM protype.customer where customer_id = 1;";
            ResultSet resultSet = statement.executeQuery(query);
            
            int count = 1;

            // Process the result set
            while (resultSet.next()) {
            	
            	first_name = resultSet.getString("first_name") + "";
            	last_name = resultSet.getString("last_name") + "";
            	
                System.out.println("First Name: " + first_name );
                System.out.println("Last Name: " + last_name );
            	
            	System.out.println("row number" + count);
            	count++;
            	
            	

            }
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database!");
            e.printStackTrace();
        }
		return first_name +" " + last_name;
   }

    

        

}
