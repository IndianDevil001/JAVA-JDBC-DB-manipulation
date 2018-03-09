package projectmng;
import java.util.*;
import java.lang.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.ScrollPane;

public class Orders extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public void Order() {
		
		 ArrayList columnNames1 = new ArrayList();
	        ArrayList data1 = new ArrayList();
	        ArrayList columnNames2 = new ArrayList();
	        ArrayList data2 = new ArrayList();
	        ArrayList columnNames3 = new ArrayList();
	        ArrayList data3 = new ArrayList();
	        ArrayList columnNames4 = new ArrayList();
	        ArrayList data4 = new ArrayList();
	        ArrayList columnNames5 = new ArrayList();
	        ArrayList data5 = new ArrayList();
	        ArrayList columnNames6 = new ArrayList();
	        ArrayList data6 = new ArrayList();
	        ArrayList columnNames7 = new ArrayList();
	        ArrayList data7 = new ArrayList();
	        ArrayList columnNames8 = new ArrayList();
	        ArrayList data8 = new ArrayList();
	        ArrayList columnNames9 = new ArrayList();
	        ArrayList data9 = new ArrayList();
	        ArrayList columnNames10 = new ArrayList();
	        ArrayList data10 = new ArrayList();
	        String url = "jdbc:mysql://192.168.1.121:3306/mdb";
	        String userid = "anon";
	        String password = "root";
	        String sql1 = "SELECT name,qty FROM table1";
	        String sql2 = "SELECT name,qty FROM table2";
	        String sql3 = "SELECT name,qty FROM table3";
	        String sql4 = "SELECT name,qty FROM table4";
	        String sql5 = "SELECT name,qty FROM table5";
	        String sql6 = "SELECT name,qty FROM table6";
	        String sql7 = "SELECT name,qty FROM table7";
	        String sql8 = "SELECT name,qty FROM table8";
	        String sql9 = "SELECT name,qty FROM table9";
	        String sql10 = "SELECT name,qty FROM table10";

	        try (
	        		Connection con1 = DriverManager.getConnection( "jdbc:mysql://192.168.1.121:3306/mdb","anon","root" );
	        		
	        		
	        		PreparedStatement ps1 = con1.prepareStatement("select name,qty form table1 ");
	           
	            ResultSet rs1 = ps1.executeQuery(sql1))
	        
	        
/*try*/	        {
	            ResultSetMetaData md1 = rs1.getMetaData();
	            int columns1 = md1.getColumnCount();

	            //  Get column names
	            for (int i = 1; i <= columns1; i++)
	            {
	                columnNames1.add( md1.getColumnName(i) );
	            }

	            //  Get row data
	            while (rs1.next())
	            {
	                ArrayList row1 = new ArrayList(columns1);

	                for (int i = 1; i <= columns1; i++)
	                {
	                    row1.add( rs1.getObject(i) );
	                }

	                data1.add( row1 );
	            }
	        }
	        catch (SQLException e)
	        {
	            System.out.println( e.getMessage() );
	        } 
	        finally 
	        {
			}
	        
	        
	        
	        
	        
	        
	        Vector columnNamesVector1 = new Vector();
	        Vector dataVector1 = new Vector();

	        
	        
	        for (int i = 0; i < data1.size(); i++)
	        {
	            ArrayList subArray1 = (ArrayList)data1.get(i);
	            Vector subVector1 = new Vector();
	            for (int j = 0; j < subArray1.size(); j++)
	            {
	                subVector1.add(subArray1.get(j));
	            }
	            dataVector1.add(subVector1);
	        }
	        
	        
	        

	        for (int i = 0; i < columnNames1.size(); i++ )
	        		
	            columnNamesVector1.add(columnNames1.get(i));

	        
	        //  Create table with database data    
	        JTable table = new JTable(dataVector1, columnNamesVector1)
	        {
	            public Class getColumnClass(int column)
	            {
	                for (int row = 0; row < getRowCount(); row++)
	                {
	                    Object o = getValueAt(row, column);

	                    if (o != null)
	                    {
	                        return o.getClass();
	                    }
	                }

	                return Object.class;
	            }
	        };
	        
	        

	        JScrollPane scrollPane = new JScrollPane( table );
	        getContentPane().add( scrollPane );

		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1500, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2,5 ,0, 0));
		contentPane.add(scrollPane);
		
		
		
		
		
		
		
		/* Table 2*/
		
		
		try (
        		Connection con = DriverManager.getConnection( "jdbc:mysql://192.168.1.121:3306/mdb","anon","root" );
        		
        		
        		PreparedStatement ps = con.prepareStatement("select name,qty form table2");
           
            ResultSet rs = ps.executeQuery(sql2))
        
        
/*try*/	        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++)
            {
                columnNames2.add( md.getColumnName(i) );
            }

            //  Get row data
            while (rs.next())
            {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }

                data2.add( row );
            }
        }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        } 
        finally 
        {
		}
        
        
        
        
        
        
        Vector columnNamesVector2 = new Vector();
        Vector dataVector2 = new Vector();

        
        
        for (int i = 0; i < data2.size(); i++)
        {
            ArrayList subArray2 = (ArrayList)data2.get(i);
            Vector subVector2 = new Vector();
            for (int j = 0; j < subArray2.size(); j++)
            {
                subVector2.add(subArray2.get(j));
            }
            dataVector2.add(subVector2);
        }
        
        
        

        for (int i = 0; i < columnNames2.size(); i++ )
        		
            columnNamesVector2.add(columnNames2.get(i));

        
        //  Create table with database data    
        JTable table2 = new JTable(dataVector2, columnNamesVector2)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
        
        JScrollPane scrollPane_1 = new JScrollPane( table2 );
        getContentPane().add( scrollPane_1 );
		
		contentPane.add(scrollPane_1);
		
		
		
		
		
		
		/*Table3*/
		
		
		try (
        		Connection con = DriverManager.getConnection( "jdbc:mysql://192.168.1.121:3306/mdb","anon","root" );
        		
        		
        		PreparedStatement ps = con.prepareStatement("select name,qty form table3");
           
            ResultSet rs = ps.executeQuery(sql3))
        
        
/*try*/	        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++)
            {
                columnNames3.add( md.getColumnName(i) );
            }

            //  Get row data
            while (rs.next())
            {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }

                data3.add( row );
            }
        }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        } 
        finally 
        {
		}
        
        
        
        
        
        
        Vector columnNamesVector3 = new Vector();
        Vector dataVector3 = new Vector();

        
        
        for (int i = 0; i < data3.size(); i++)
        {
            ArrayList subArray3 = (ArrayList)data3.get(i);
            Vector subVector3 = new Vector();
            for (int j = 0; j < subArray3.size(); j++)
            {
                subVector3.add(subArray3.get(j));
            }
            dataVector3.add(subVector3);
        }
        
        
        

        for (int i = 0; i < columnNames3.size(); i++ )
        		
            columnNamesVector3.add(columnNames3.get(i));

        
        //  Create table with database data    
        JTable table3 = new JTable(dataVector3, columnNamesVector3)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
        
        JScrollPane scrollPane_2 = new JScrollPane( table3 );
        getContentPane().add( scrollPane_2 );
		
		contentPane.add(scrollPane_2);
		
	
		/*Table4*/
		
		
		try (
        		Connection con = DriverManager.getConnection( "jdbc:mysql://192.168.1.121:3306/mdb","anon","root" );
        		
        		
        		PreparedStatement ps = con.prepareStatement("select name,qty form table4");
           
            ResultSet rs = ps.executeQuery(sql4))
        
        
/*try*/	        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++)
            {
                columnNames4.add( md.getColumnName(i) );
            }

            //  Get row data
            while (rs.next())
            {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }

                data4.add( row );
            }
        }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        } 
        finally 
        {
		}
        
        
        
        
        
        
        Vector columnNamesVector4 = new Vector();
        Vector dataVector4 = new Vector();

        
        
        for (int i = 0; i < data4.size(); i++)
        {
            ArrayList subArray4 = (ArrayList)data4.get(i);
            Vector subVector4= new Vector();
            for (int j = 0; j < subArray4.size(); j++)
            {
                subVector4.add(subArray4.get(j));
            }
            dataVector3.add(subVector4);
        }
        
        
        

        for (int i = 0; i < columnNames4.size(); i++ )
        		
            columnNamesVector4.add(columnNames4.get(i));

        
        //  Create table with database data    
        JTable table4 = new JTable(dataVector4, columnNamesVector4)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
        
        JScrollPane scrollPane_3 = new JScrollPane( table4 );
        getContentPane().add( scrollPane_3);
		
		contentPane.add(scrollPane_3);
		
		
		
		
		
		/*Table5*/
		
		
		try (
        		Connection con = DriverManager.getConnection( "jdbc:mysql://192.168.1.121:3306/mdb","anon","root" );
        		
        		
        		PreparedStatement ps = con.prepareStatement("select name,qty form table5");
           
            ResultSet rs = ps.executeQuery(sql5))
        
        
/*try*/	        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++)
            {
                columnNames5.add( md.getColumnName(i) );
            }

            //  Get row data
            while (rs.next())
            {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }

                data5.add( row );
            }
        }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        } 
        finally 
        {
		}
        
        
        
        
        
        
        Vector columnNamesVector5 = new Vector();
        Vector dataVector5 = new Vector();

        
        
        for (int i = 0; i < data5.size(); i++)
        {
            ArrayList subArray5 = (ArrayList)data5.get(i);
            Vector subVector5 = new Vector();
            for (int j = 0; j < subArray5.size(); j++)
            {
                subVector5.add(subArray5.get(j));
            }
            dataVector5.add(subVector5);
        }
        
        
        

        for (int i = 0; i < columnNames5.size(); i++ )
        		
            columnNamesVector5.add(columnNames5.get(i));

        
        //  Create table with database data    
        JTable table5 = new JTable(dataVector5, columnNamesVector5)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
        
        JScrollPane scrollPane_4 = new JScrollPane( table5 );
        getContentPane().add( scrollPane_4 );
		
		contentPane.add(scrollPane_4);
		
		
		
		
/*Table6*/
		
		
		try (
        		Connection con = DriverManager.getConnection( "jdbc:mysql://192.168.1.121:3306/mdb","anon","root" );
        		
        		
        		PreparedStatement ps = con.prepareStatement("select name,qty form table6");
           
            ResultSet rs = ps.executeQuery(sql6))
        
        
/*try*/	        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++)
            {
                columnNames6.add( md.getColumnName(i) );
            }

            //  Get row data
            while (rs.next())
            {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }

                data6.add( row );
            }
        }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        } 
        finally 
        {
		}
        
        
        
        
        
        
        Vector columnNamesVector6 = new Vector();
        Vector dataVector6 = new Vector();

        
        
        for (int i = 0; i < data6.size(); i++)
        {
            ArrayList subArray6 = (ArrayList)data6.get(i);
            Vector subVector6 = new Vector();
            for (int j = 0; j < subArray6.size(); j++)
            {
                subVector6.add(subArray6.get(j));
            }
            dataVector6.add(subVector6);
        }
        
        
        

        for (int i = 0; i < columnNames6.size(); i++ )
        		
            columnNamesVector6.add(columnNames6.get(i));

        
        //  Create table with database data    
        JTable table6 = new JTable(dataVector6, columnNamesVector6)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
        
        JScrollPane scrollPane_5 = new JScrollPane( table6 );
        getContentPane().add( scrollPane_5 );
		
		contentPane.add(scrollPane_5);
		
		
/*Table7*/
		
		
		try (
        		Connection con = DriverManager.getConnection( "jdbc:mysql://192.168.1.121:3306/mdb","anon","root" );
        		
        		
        		PreparedStatement ps = con.prepareStatement("select name,qty form table7");
           
            ResultSet rs = ps.executeQuery(sql7))
        
        
/*try*/	        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++)
            {
                columnNames7.add( md.getColumnName(i) );
            }

            //  Get row data
            while (rs.next())
            {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }

                data7.add( row );
            }
        }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        } 
        finally 
        {
		}
        
        
        
        
        
        
        Vector columnNamesVector7 = new Vector();
        Vector dataVector7 = new Vector();

        
        
        for (int i = 0; i < data7.size(); i++)
        {
            ArrayList subArray7 = (ArrayList)data7.get(i);
            Vector subVector7 = new Vector();
            for (int j = 0; j < subArray7.size(); j++)
            {
                subVector7.add(subArray7.get(j));
            }
            dataVector7.add(subVector7);
        }
        
        
        

        for (int i = 0; i < columnNames7.size(); i++ )
        		
            columnNamesVector7.add(columnNames7.get(i));

        
        //  Create table with database data    
        JTable table7 = new JTable(dataVector7, columnNamesVector7)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
        
        JScrollPane scrollPane_6 = new JScrollPane( table7 );
        getContentPane().add( scrollPane_6 );
		
		contentPane.add(scrollPane_6);
		
		
		
		
/*Table8*/
		
		
		try (
        		Connection con = DriverManager.getConnection( "jdbc:mysql://192.168.1.121:3306/mdb","anon","root" );
        		
        		
        		PreparedStatement ps = con.prepareStatement("select name,qty form table8");
           
            ResultSet rs = ps.executeQuery(sql8))
        
        
/*try*/	        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++)
            {
                columnNames8.add( md.getColumnName(i) );
            }

            //  Get row data
            while (rs.next())
            {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }

                data8.add( row );
            }
        }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        } 
        finally 
        {
		}
        
        
        
        
        
        
        Vector columnNamesVector8 = new Vector();
        Vector dataVector8 = new Vector();

        
        
        for (int i = 0; i < data8.size(); i++)
        {
            ArrayList subArray8 = (ArrayList)data8.get(i);
            Vector subVector8 = new Vector();
            for (int j = 0; j < subArray8.size(); j++)
            {
                subVector8.add(subArray8.get(j));
            }
            dataVector8.add(subVector8);
        }
        
        
        

        for (int i = 0; i < columnNames8.size(); i++ )
        		
            columnNamesVector8.add(columnNames8.get(i));

        
        //  Create table with database data    
        JTable table8 = new JTable(dataVector8, columnNamesVector8)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
        
        JScrollPane scrollPane_7 = new JScrollPane( table8 );
        getContentPane().add( scrollPane_7 );
		
		contentPane.add(scrollPane_7);
		
		
	
		

/*Table9*/
		
		
		try (
        		Connection con = DriverManager.getConnection( "jdbc:mysql://192.168.1.121:3306/mdb","anon","root" );
        		
        		
        		PreparedStatement ps = con.prepareStatement("select name,qty form table9");
           
            ResultSet rs = ps.executeQuery(sql9))
        
        
/*try*/	        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++)
            {
                columnNames9.add( md.getColumnName(i) );
            }

            //  Get row data
            while (rs.next())
            {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }

                data9.add( row );
            }
        }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        } 
        finally 
        {
		}
        
        
        
        
        
        
        Vector columnNamesVector9 = new Vector();
        Vector dataVector9= new Vector();

        
        
        for (int i = 0; i < data9.size(); i++)
        {
            ArrayList subArray9 = (ArrayList)data9.get(i);
            Vector subVector9 = new Vector();
            for (int j = 0; j < subArray9.size(); j++)
            {
                subVector9.add(subArray9.get(j));
            }
            dataVector8.add(subVector9);
        }
        
        
        

        for (int i = 0; i < columnNames9.size(); i++ )
        		
            columnNamesVector9.add(columnNames9.get(i));

        
        //  Create table with database data    
        JTable table9 = new JTable(dataVector9, columnNamesVector9)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
        
        JScrollPane scrollPane_8 = new JScrollPane( table9 );
        getContentPane().add( scrollPane_8 );
		
		contentPane.add(scrollPane_8);
		
		
		
		

		
				
				
			
				
				
		
		
		
		
		ScrollPane scrollPane_9 = new ScrollPane();
		contentPane.add(scrollPane_9);
	}
	
	
	
	
	 public static void main(String[] args)
	    {
		

			Orders frame = new Orders();
	        
		 Timer timer = new Timer();
		 
		 TimerTask timerTask = new TimerTask() {
			 public void run()
			 {
			 	frame.Order();
			 	
		        frame.pack();
		        frame.setVisible(true);
			 }
			 };
			
	        timer.scheduleAtFixedRate(timerTask, 30, 5000);
	        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
	
	    }	
}




