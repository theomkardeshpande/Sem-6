package labbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//Write a java program to delete salary column from Emp table. 
//Assume Emp table with attributes ENo, EName and salary is already created

public class Assignment1_A4 {

	public static void main(String[] args) {
		String urlString="jdbc:mysql://localhost:3306/ty";
		String userString="root";
		String passString="root";
		String queryString="ALTER TABLE Employee DROP COLUMN Salary";
		
		try {
			Connection connection=DriverManager.getConnection(urlString,userString,passString);
			Statement stmtStatement=connection.createStatement();
			stmtStatement.execute(queryString);
			System.out.println("Table is Altered..!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
