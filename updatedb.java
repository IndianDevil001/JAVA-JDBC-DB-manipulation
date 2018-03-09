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

public class updatedb extends JFrame {
			
	JComboBox cb = new JComboBox();
public 	String tablen;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnUpdate;
	Connection con;
	public String  id;
	String tname;
	int i;
public	String query;
private JTextField textprice;
private JLabel lblEnterNewPrice;
  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatedb frame = new updatedb();
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
	public updatedb() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1500, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(189, 93, 108, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterId = new JLabel("Enter ID");
		lblEnterId.setBounds(27, 93, 83, 26);
		contentPane.add(lblEnterId);
		
		
		cb.setBounds(189, 24, 108, 26);
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
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					
					
					 Class.forName("com.mysql.jdbc.Driver"); 
					   System.out.println("CLASS FOR NAME DONE");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.121:3306/mdb","anon","root");
					   System.out.println("CONECTIOON DONE");
					   
					   
					   
					   
					   PreparedStatement ps = con.prepareStatement("Update "+tname+" SET price = (?) where id = (?)");
					   ps.setString(1,textprice.getText());
					   ps.setString(2,textField.getText());
					   ps.executeUpdate();
					   System.out.println("Row Updated");
					   JOptionPane.showMessageDialog(null, "ROW UPDATE");
				}
		
			catch(Exception ex) {	ex.printStackTrace();
			}
			}
		});
		
		
		
		
		btnUpdate.setBounds(84, 227, 113, 26);
		contentPane.add(btnUpdate);
		
		textprice = new JTextField();
		textprice.setBounds(189, 161, 108, 26);
		contentPane.add(textprice);
		textprice.setColumns(10);
		
		lblEnterNewPrice = new JLabel("Enter New Price");
		lblEnterNewPrice.setBounds(27, 161, 127, 26);
		contentPane.add(lblEnterNewPrice);
	}
}
