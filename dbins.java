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


public class dbins  extends JFrame  {
    JButton btnInsert ;
    JButton button2;
    JLabel label; 
    JTextField textID;
    JTextField textNAME;
    JTextField textPrice;
    public String tname;
    JComboBox cb = new JComboBox();
    
    //JTextAreextPrice;
    
    public String s;
    private JTextField textDesc;
     
    public dbins(){
   
    super("insert image to database in java");
    
    btnInsert = new JButton("Insert");
    btnInsert.setBounds(385,495,107,40);
    
    button2 = new JButton("Browse");
    button2.setBounds(251, 495, 100, 40);
    
    textID = new JTextField("ID");
    textID.setBounds(276,370,100,20);

    textNAME = new JTextField("Name");
    textNAME.setBounds(401,370,107,20);

    //area = new JTextArea("DESCRIPTION",100, 100);
    
    //JScrollPane pane = new JScrollPane(area);
    ///pane.setBounds(450, 270, 200, 100);
    
    label = new JLabel();
    label.setBounds(10,10,670,250);   
  
    //button to browse the image into jlabel
    button2.addActionListener(new ActionListener(){
        @Override
     public void actionPerformed(ActionEvent e){
         JFileChooser fileChooser = new JFileChooser();
         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
         fileChooser.addChoosableFileFilter(filter);
         int result = fileChooser.showSaveDialog(null);
         if(result == JFileChooser.APPROVE_OPTION){
             File selectedFile = fileChooser.getSelectedFile();
             String path = selectedFile.getAbsolutePath();
             label.setIcon(ResizeImage(path));
             s = path;
              }
         else if(result == JFileChooser.CANCEL_OPTION){
             System.out.println("No Data");
         }
     }
    });

    //button to insert image and some data into mysql database
    btnInsert.addActionListener(new ActionListener(){
    
       @Override
       public void actionPerformed(ActionEvent e){
           try{		
			   Class.forName("com.mysql.jdbc.Driver"); 
			   System.out.println("CLASS FOR NAME DONE");
              
			   Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.121:3306/mdb","anon","root");
			   System.out.println("CONECTIOON DONE");
			   PreparedStatement ps = con.prepareStatement("insert into "+s+" (id,name,des,price,img) values(?,?,?,?,?)");
			   System.out.println("FIRED");
			   InputStream is = new FileInputStream(new File(s));
               ps.setString(1, textID.getText());
               ps.setString(2, textNAME.getText());
               ps.setString(3, textDesc.getText());
               ps.setString(4, textPrice.getText());
               
               ps.setBlob(5,is);
               ps.executeUpdate();
               System.out.println("DATA INSERTED");
               JOptionPane.showMessageDialog(null, "Data Inserted");
               textID.setText("");
               textNAME.setText("");
               textDesc.setText("");
               textPrice.setText("");
             
                
               
               
           }catch(Exception ex){
               ex.printStackTrace();
           }
       }
    });

    getContentPane().add(label);
    getContentPane().add(textID);
    getContentPane().add(textNAME);
    
   // add(pane);
    getContentPane().add(btnInsert);
    getContentPane().add(button2);
    getContentPane().setLayout(null);
    
    textPrice = new JTextField();
    textPrice.setText("Price");
    textPrice.setBounds(548, 370, 100, 20);
    getContentPane().add(textPrice);
    
    textPrice.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent pe) {
            if (textPrice.getText().equals("Price")) {
            	textPrice.setText("");
            	textPrice.setForeground(Color.BLACK);
            }
        }
        
        public void focusLost(FocusEvent pe) {
            if (textPrice.getText().isEmpty()) {
            	textPrice.setForeground(Color.GRAY);
            	textPrice.setText("Price");
            }
        }
    });
    
    textID.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent ie) {
            if (textID.getText().equals("ID")) {
            	textID.setText("");
            	textID.setForeground(Color.BLACK);
            }
        }
        
        public void focusLost(FocusEvent ie) {
            if (textID.getText().isEmpty()) {
            	textID.setForeground(Color.GRAY);
            	textID.setText("ID");
            }
        }
    });
    
    
    
    textNAME.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent ne) {
            if (textNAME.getText().equals("Name")) {
            	textNAME.setText("");
            	textNAME.setForeground(Color.BLACK);
            }
        }
        
        public void focusLost(FocusEvent ne) {
            if (textNAME.getText().isEmpty()) {
            	textNAME.setForeground(Color.GRAY);
            	textNAME.setText("Name");
            }
        }
    });
    

	cb.addActionListener(new ActionListener() {
    	 public void actionPerformed(ActionEvent e) {

    	        
	 tname = (String) cb.getSelectedItem();
    }
    });
   
       
   
    
    btnInsert.addActionListener(new ActionListener(){
    
       @Override
       public void actionPerformed(ActionEvent e){
           try{		
			   Class.forName("com.mysql.jdbc.Driver"); 
			   System.out.println("CLASS FOR NAME DONE");
              
			   Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.121:3306/mdb","anon","r"
			   		+ "oot");
			   System.out.println("CONECTIOON DONE");
			   PreparedStatement ps = con.prepareStatement("insert into "+tname+" (id,name,des,price,img) values(?,?,?,?,?)");
			   System.out.println("FIRED");
			   InputStream is = new FileInputStream(new File(s));
               ps.setString(1, textID.getText());
               ps.setString(2, textNAME.getText());
               ps.setString(3, textDesc.getText());
               ps.setString(4, textPrice.getText());
               ps.setBlob(5,is);
               ps.executeUpdate();
               System.out.println("DATA INSERTED");
               JOptionPane.showMessageDialog(null, "Data Inserted");
           }catch(Exception ex){
               ex.printStackTrace();
           }
       }
    });

    getContentPane().add(label);
    getContentPane().add(textID);
    getContentPane().add(textNAME);
   // add(pane);
    getContentPane().add(btnInsert);
    getContentPane().add(button2);
    getContentPane().setLayout(null);
    
    JButton btnViewDatabase = new JButton("View DataBase");
    btnViewDatabase.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		dbtable info=new dbtable();
			dbtable.main(null);

    	}
    });
    btnViewDatabase.setBounds(525, 495, 123, 40);
    getContentPane().add(btnViewDatabase);
    
    textDesc = new JTextField();
    textDesc.setText("Descript");
    textDesc.setBounds(690, 370, 100, 20);
    getContentPane().add(textDesc);
    textDesc.setColumns(10);
    
    
    
    cb.addItem("indian");
    cb.addItem("italian");
    cb.addItem("chinese");
    cb.addItem("juice");
    cb.addItem("dessert");
    cb.addItem("starter");
    
  
    cb.setBounds(826, 370, 94, 20);
    getContentPane().add(cb);
    
    JButton btnNewButton = new JButton("Delete From DB");
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		deltable info=new deltable();
			deltable.main(null);

    		
    	}
    });
    btnNewButton.setBounds(677, 495, 123, 40);
    getContentPane().add(btnNewButton);
    
    JButton btnUpdateDb = new JButton("Update DB");
    btnUpdateDb.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		updatedb info=new updatedb();
			updatedb.main(null);
    	}
    });
    btnUpdateDb.setBounds(824, 495, 116, 40);
    getContentPane().add(btnUpdateDb);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1444,788);
    setVisible(true);
    
    
    
    
    }


    
    //Methode To Resize The ImageIcon
    public ImageIcon ResizeImage(String imgPath){
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
 
    public static void main(String[] args){
     new dbins();
    }
   }