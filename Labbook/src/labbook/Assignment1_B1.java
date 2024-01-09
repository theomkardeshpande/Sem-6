package labbook;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


//Write a java program to accept the details of Hospital (HId, HName, Address, PH_No)
//and store it into the database. (Use Swing).
public class Assignment1_B1 {
	public static String QUERY_STRING;
	public static void main(String[] args) {
		String urlString="jdbc:mysql://localhost;3306/ty";
		String nameString="root";
		String passString="root";
		GUI();
		
//		try {
//			Connection connection=DriverManager.getConnection(urlString,nameString,passString);
//			Statement stmtStatement=connection.createStatement();
//			stmtStatement.executeQuery(QUERY_STRING);
//			System.out.println("Values Inserted..!");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	public static void GUI()
	{
		JFrame hospitalFrame=new JFrame();
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
				
				QUERY_STRING="insert into Hospital values("+hid+","+hname+","+haddress+","+hphone+")";
				
				statusLabel.setText("Values is Inserted..!");
				
			}
		});
		
	}

}
