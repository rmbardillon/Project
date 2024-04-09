package com.library.management.system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JTextField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(812, 497); // Set the size of the frame
		setLocationRelativeTo(null); // Center the frame on the screen
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LoginTitleLabel = new JLabel("Library Management System");
		LoginTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		LoginTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LoginTitleLabel.setBounds(265, 87, 251, 60);
		contentPane.add(LoginTitleLabel);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(287, 158, 61, 22);
		contentPane.add(usernameLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(358, 158, 144, 22);
		contentPane.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(287, 191, 61, 22);
		contentPane.add(passwordLabel);
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(358, 191, 144, 22);
		contentPane.add(passwordTextField);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameTextField.getText();
				String password = passwordTextField.getText();
				boolean isLoginValid = isLoginValid(username,password);
				if(isLoginValid) {
					//Call the dashboard
					JOptionPane.showMessageDialog(null, "Login Successful");
					dispose();
					new Dashboard(username).setVisible(true);;
					
				} else {
					JOptionPane.showMessageDialog(null, "Username or password is incorrect.");
				}
			}
		});
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		loginButton.setBounds(358, 224, 144, 34);
		contentPane.add(loginButton);
	}
	
	public static boolean isLoginValid(String username, String password) {
		return username.trim().equals("admin") && password.trim().equals("admin");
	}
}
