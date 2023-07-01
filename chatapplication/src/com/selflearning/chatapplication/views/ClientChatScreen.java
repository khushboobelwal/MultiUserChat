package com.selflearning.chatapplication.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.selflearning.chatapplication.network.Client;
import com.selflearning.chatapplication.utils.UserInfo;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class ClientChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JTextArea textArea ;
	private Client client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					ClientChatScreen frame;
					try {
						frame = new ClientChatScreen();
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
	}
private void sendIt() {
	String message=textField.getText();
	try {
		client.sendMessage(UserInfo.USER_NAME+"-"+message);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public ClientChatScreen() throws UnknownHostException, IOException {
		setBackground(new Color(255, 255, 255));
		textArea = new JTextArea();
		textArea.setForeground(new Color(255, 0, 0));
		textArea.setBackground(new Color(231, 251, 225));
		client=new Client(textArea);
		setTitle("Chit Chat");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2, true), null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 6, 768, 313);
		contentPane.add(scrollPane);
		
		
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setBounds(10, 10, 818, 432);
	    scrollPane.setViewportView(textArea);
	    
	    textField = new JTextField();
	    textField.setForeground(new Color(255, 128, 128));
	    textField.setBackground(new Color(231, 251, 225));
	    textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    textField.setBounds(10, 350, 616, 70);
	    contentPane.add(textField);
	    textField.setColumns(10);
	    
	    JButton sendIt = new JButton("Send Message");
	    sendIt.setBackground(new Color(231, 251, 225));
	    sendIt.setForeground(new Color(255, 128, 128));
	    sendIt.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		sendIt();
	    		
	    	}
	    });
	    sendIt.setFont(new Font("Tahoma", Font.PLAIN, 13));
	    sendIt.setBounds(657, 360, 149, 50);
	    contentPane.add(sendIt);
		setVisible(true);
		
		
	}
}
