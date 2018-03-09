package projectmng;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class signinpage extends JFrame {

	protected static final Component su = null;
	private JPanel contentPane;
	private JTextField txtUsername;
	protected Component frmLogin_System;
	private JPasswordField txtPassword;

	
  
   
      
	public static void main(String[] args)
	{
		
		String a;
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signinpage frame = new signinpage();
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
	public signinpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1500, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(41, 44, 75, 14);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(210, 41, 188, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(41, 95, 75, 14);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String password=txtPassword.getText();
				String  username =txtUsername.getText();
				
				if (password.contains("devil")&&username.contains("devil")) {
					txtPassword.setText(null);
					txtUsername.setText(null);
					dbins info=new dbins();
					dbins.main(null);
						}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Login Details ","Login Error",JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
					txtUsername.setText(null);
					
				}
				
				
			 	
			}
		});
		btnLogin.setBounds(108, 168, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUsername.setText(null);
				txtPassword.setText(null);
				
			}
		});
		btnReset.setBounds(210, 168, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				frmLogin_System= new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLogin_System,"Confirm if you want to exit","Login Systems",
						JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(309, 168, 89, 23);
		contentPane.add(btnExit);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(210, 92, 188, 20);
		contentPane.add(txtPassword);
	}
}
