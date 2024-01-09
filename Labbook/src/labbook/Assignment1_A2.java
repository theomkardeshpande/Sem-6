package labbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//Write a java program to display all the EName from Emp table. 
//Assume Emp (ENo, EName, Salary) table is already created.
public class Assignment1_A2 {

	public static void main(String[] args) {
		String urlString="jdbc:mysql://localhost:3306/ty";
		String userString="root";
		String passString="root";
		String queryString="Select * from Employee";
		
		try {
			Connection connection=DriverManager.getConnection(urlString,userString,passString);
			Statement stmtStatement=connection.createStatement();
			ResultSet rSet=stmtStatement.executeQuery(queryString);
			while (rSet.next()) {
				System.out.println("Employee ID:"+rSet.getInt("Empid"));
				System.out.println("Empolyee Name:"+rSet.getString("Name"));
				System.out.println("Employee Salary:"+rSet.getInt("Salary"));
			}
			rSet.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
