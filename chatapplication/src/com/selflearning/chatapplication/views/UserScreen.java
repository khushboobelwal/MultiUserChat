package com.selflearning.chatapplication.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.selflearning.chatapplication.dao.UserDAO;
import com.selflearning.chatapplication.dto.UserDTO;
import com.selflearning.chatapplication.utils.UserInfo;

public class UserScreen extends JFrame{
	private JTextField useridtxt;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		
					UserScreen window = new UserScreen();
					
	}
	UserDAO userDAO=new UserDAO();
	private void doLogin() {
		String userid=useridtxt.getText();
		char[] password=passwordField.getPassword();
		
		UserDTO userDTO=new UserDTO(userid,password);
		try {
			String message=" ";
			if(userDAO.isLogin(userDTO)) {
				message="Welcome"+userid;
				UserInfo.USER_NAME=userid;
				JOptionPane.showMessageDialog(this,message);
				setVisible(false);
				dispose();
				DashBoard dashboard = new DashBoard(message);
				dashboard.setVisible(true);
			}
			else {
			message="Invalid Userid or Password";	
			JOptionPane.showMessageDialog(this,message);
			}
			JOptionPane.showMessageDialog(this,message);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void register() {
String userid=useridtxt.getText();
char[] password=passwordField.getPassword();
UserDTO userDTO=new UserDTO(userid,password);
try {
int result=userDAO.add(userDTO);
if(result>0) {
	JOptionPane.showMessageDialog(this,"Register Successfully");
	//System.out.println("Record added...");
}
else {
	JOptionPane.showMessageDialog(this,"Register failed");
	//System.out.println("Record Not added");
}
}
catch(ClassNotFoundException | SQLException ex) {
	System.out.println("DB issue....");

	ex.printStackTrace();
	
	 
}
catch(Exception ex) {
	System.out.println("Some Generic Exception raised");
	ex.printStackTrace();
}
System.out.println("userid"+userid+"password"+password+" "+password.toString());
	}

	/**
	 * Create the application.
	 */
	public UserScreen() {
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("LOGIN");
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(0, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER LOGIN");
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(132, 10, 282, 54);
		getContentPane().add(lblNewLabel);
		useridtxt = new JTextField();
		useridtxt.setBackground(new Color(255, 255, 255));
		useridtxt.setBounds(268, 108, 207, 36);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		JLabel useridlbl = new JLabel("Userid");
		useridlbl.setHorizontalAlignment(SwingConstants.CENTER);
		useridlbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		useridlbl.setBounds(27, 110, 71, 25);
		getContentPane().add(useridlbl);
		
		JLabel passwordlbl = new JLabel("Password");
		passwordlbl.setBackground(new Color(240, 240, 240));
		passwordlbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwordlbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordlbl.setBounds(25, 173, 85, 25);
		getContentPane().add(passwordlbl);
		
		JButton loginbt = new JButton("Login");
		loginbt.setBackground(new Color(231, 251, 225));
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		loginbt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginbt.setBounds(62, 252, 97, 36);
		getContentPane().add(loginbt);
		
		JButton registerbt = new JButton("Register");
		registerbt.setBackground(new Color(231, 251, 225));
		registerbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		registerbt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		registerbt.setBounds(284, 252, 97, 36);
		getContentPane().add(registerbt);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(268, 173, 207, 35);
		getContentPane().add(passwordField);
		setBackground(new Color(64, 0, 64));
		
		setSize(621, 355);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
        setVisible(true);
	}
}