package labbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//Write a java program to delete the details of given Teacher. 
//Assume Teacher table with attributes tno, tname, subject is already created.

public class Assignment1_A5 {

	public static void main(String[] args) {
		String urlString="jdbc:mysql://localhost:3306/ty";
		String userString="root";
		String passString="root";
		String queryString="DELETE FROM Teacher";
		
		try {
			Connection connection=DriverManager.getConnection(urlString,userString,passString);
			Statement stmtStatement=connection.createStatement();
			stmtStatement.execute(queryString);
			System.out.println("Deleted..!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
