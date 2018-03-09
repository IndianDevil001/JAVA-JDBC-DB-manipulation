package projectmng;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.Image.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;

public class deltable extends JFrame {
			
	JComboBox cb = new JComboBox();
public 	String tablen;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnDelete;
	Connection con;
	public String  id;
	String tname;
	int i;
public	String query;
  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deltable frame = new deltable();
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
	public deltable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1500, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(145, 108, 108, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterId = new JLabel("Enter ID");
		lblEnterId.setBounds(27, 108, 83, 26);
		contentPane.add(lblEnterId);
		
		
		cb.setBounds(145, 24, 108, 26);
		contentPane.add(cb);

		cb.addActionListener(new ActionListener() {
		   	 public void actionPerformed(ActionEvent e) {

		   	        
			 tablen = (String) cb.getSelectedItem();
			 
		   }
		    } );
		
		
		cb.addActionListener(new ActionListener() {
	    	 public void actionPerformed(ActionEvent e) {

	    	        
		 tname = (String) cb.getSelectedItem();
	    }
	    });
		
		
	//	id=textField.getText();
		
//	i=Integer.parseInt(id);	
	
		
	    cb.addItem("indian");
	    cb.addItem("italian");
	    cb.addItem("chinese");
	    cb.addItem("juice");
	    cb.addItem("desserts");
	    cb.addItem("starters");
	    
		JLabel lblSelectTable = new JLabel("Select Table");
		lblSelectTable.setBounds(27, 24, 83, 26);
		contentPane.add(lblSelectTable);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					
					
					 Class.forName("com.mysql.jdbc.Driver"); 
					   System.out.println("CLASS FOR NAME DONE");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.121:3306/mdb","anon","root");
					   System.out.println("CONECTIOON DONE");
					   
					   
					   
					   
					   PreparedStatement ps = con.prepareStatement("DELETE FROM "+tname+" WHERE id = (?)");
					   ps.setString(1,textField.getText());
					   ps.executeUpdate();
					   System.out.println("Row Deleted");
					   JOptionPane.showMessageDialog(null, "Data Deleted");
				}
		
			catch(Exception ex) {	ex.printStackTrace();
			}
			}
		});
		
		
		
		
		btnDelete.setBounds(98, 196, 89, 23);
		contentPane.add(btnDelete);
	}
}
