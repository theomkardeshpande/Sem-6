package labbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//1. Write a java program to count number of records in a table.

public class Assignment1_A1 {

	static final String URL_STRING="jdbc:mysql://localhost:3306/ty";
	static final String USER_STRING="root";
	static final String PASS_STRING="root";
	static final String QUERY_STRING="select * from Student";
	public static void main(String[] args) {
		
		try {
			Connection connection=DriverManager.getConnection(URL_STRING,USER_STRING,PASS_STRING);
			Statement stmtStatement=connection.createStatement();
			ResultSet rs=stmtStatement.executeQuery(QUERY_STRING);
			int count=0;
			while(rs.next())
			{
				 count++;
				 
			}
			System.out.println("Count :"+count);
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
