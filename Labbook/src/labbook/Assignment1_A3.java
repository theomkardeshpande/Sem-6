package labbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//3. Write a java program to create Student table with attributes Rno, Sname, Per.
public class Assignment1_A3 {

	public static void main(String[] args) {
		String urlString="jdbc:mysql://localhost:3306/ty";
		String userString="root";
		String passString="root";
		String queryString="CREATE TABLE Student(Roll Integer,Name varchar(100),City varchar(50))";
		try {
			Connection connection=DriverManager.getConnection(urlString,userString,passString);
			Statement stmtStatement=connection.createStatement();
			stmtStatement.execute(queryString);
			System.out.println("Table is Created..!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
