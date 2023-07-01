package com.selflearning.chatapplication.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class DashBoard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public DashBoard(String message) {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 489);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(255, 128, 128));
		menuBar.setBackground(new Color(255, 128, 128));
		setJMenuBar(menuBar);
		
		JMenu chatMenu = new JMenu("Chat");
		chatMenu.setForeground(new Color(255, 0, 0));
		chatMenu.setFont(new Font("Segoe Script", Font.BOLD, 12));
		chatMenu.setBackground(new Color(255, 0, 0));
		menuBar.add(chatMenu);
		
		JMenuItem startChat = new JMenuItem("Start  Chat");
		startChat.setForeground(new Color(0, 0, 255));
		startChat.setFont(new Font("Segoe UI", Font.BOLD, 12));
		startChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					new ClientChatScreen();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		chatMenu.add(startChat);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(162, 240, 142));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 11));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle(message);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(DashBoard.class.getResource("/images/chit.jpg")));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}
}
