package labbook;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


//Write a java program to accept the details of Hospital (HId, HName, Address, PH_No)
//and store it into the database. (Use Swing).
public class Assignment1_B1 {
	
	public static void main(String[] args) {
		GUI();
	}
	
	public static void GUI()
	{
		JFrame hospitalFrame=new JFrame("Hospital Frame");
		hospitalFrame.setDefaultCloseOperation(3);
		hospitalFrame.setVisible(true);
		hospitalFrame.setSize(400,400);
		
		JPanel hosPanel=new JPanel(new FlowLayout());
		
		JLabel hidJLabel=new JLabel("Enter Hid:");
		JTextField hidField=new JTextField(15);
		
		JLabel hnameLabel=new JLabel("Enter Hname:");
		JTextField hnameField=new JTextField(15);
		
		JLabel hadddressLabel=new JLabel("Enter Haddress:");
		JTextField haddressField=new JTextField(15);
		
		JLabel hphoneLabel=new JLabel("Enter Hphone:");
		JTextField hphoneField=new JTextField(15);
		
		JLabel statusLabel=new JLabel("");
		hosPanel.add(hidJLabel);
		hosPanel.add(hidField);
		
		hosPanel.add(hnameLabel);
		hosPanel.add(hnameField);
		
		hosPanel.add(hadddressLabel);
		hosPanel.add(haddressField);
		
		hosPanel.add(hphoneLabel);
		hosPanel.add(hphoneField);
		
		hosPanel.add(statusLabel);
		JButton submitButton=new JButton("Submit");
		hosPanel.add(submitButton);
		hospitalFrame.add(hosPanel);
		
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int hid=Integer.parseInt(hidField.getText());
				String hname=hnameField.getText();
				String haddress=haddressField.getText();
				String hphone=hphoneField.getText();
				
				String urlString="jdbc:mysql://localhost:3306/ty";
				String nameString="root";
				String passString="root";
				String queryString="INSERT INTO Hospital(Hid,Hname,Haddress,Hphone) VALUES(?,?,?,?)";
				
				try {
					Connection connection=DriverManager.getConnection(urlString,nameString,passString);
					PreparedStatement prpStatement=connection.prepareStatement(queryString);
					prpStatement.setInt(1, hid);
					prpStatement.setString(2, hname);
					prpStatement.setString(3, haddress);
					prpStatement.setString(4, hphone);
					
					int rowaffected=prpStatement.executeUpdate();
					System.out.println("Rows Affected:"+rowaffected);
					prpStatement.close();
					connection.close();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				

			}
		});
		
	}

}
