import java.awt.*; 
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Del {
        JPanel p1;
        JFrame f1;
        JTextField tname,tpass;
        JLabel lname,lpass,bgl;
        JButton back,del;
        int h,w;
        Del(){
            	f1=new JFrame("Delete Employee");
		Dimension sc=Toolkit.getDefaultToolkit().getScreenSize();
                w=sc.width;
                h=sc.height;
                f1.setSize(w,h);
                p1=(JPanel) f1.getContentPane();
		f1.addWindowListener(new mywin());
                f1.setLayout(null);
                p1.setBackground(new Color(30,26,25));
                Font f = new Font("Ubuntu",Font.BOLD,14);

		bgl=new JLabel();
                ImageIcon img=new ImageIcon("C:\\Users\\adity\\OneDrive\\Documents\\NetBeansProjects\\mini1\\src\\del.jpg");
                bgl=new JLabel("",img,JLabel.CENTER);
                bgl.setBounds(400, 0, w-400, h);
                
                lname=new JLabel("Name:");
		lname.setBounds(50,100,50,50);
                lname.setForeground(new Color(255,255,255));
                lname.setFont(f);
                
                tname=new JTextField(30);
		tname.setBounds(150,110,150,25);
                tname.setForeground(new Color(255,255,255));
                tname.setBackground(new Color(30,26,25));
                tname.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tname.setFont(f);
                
                
                
		Cursor c1=new Cursor(Cursor.DEFAULT_CURSOR);
		f1.setCursor(c1);
                
                back=new JButton("Back");
		back.setBounds(75,310,200,50);
		back.setMnemonic('B');
		back.setToolTipText("Click Here");
                back.setBackground(new Color(30,26,25));
                back.setForeground(new Color(255,255,255));
                back.setBorder( new LineBorder(Color.white) );
                
                del=new JButton("Delete");
		del.setBounds(75,250,200,50);
		del.setMnemonic('S');
		del.setToolTipText("Click Here");
                del.setForeground(new Color(30,26,25));
                del.setBackground(new Color(255,255,255));
                del.setBorder( new LineBorder(Color.white) );
                
                back.addActionListener(new myBack());
                del.addActionListener(new myDel());
                
               
                p1.add(tname);
               
                p1.add(bgl);
                p1.add(lname);
               
                
                p1.add(back);
                p1.add(del);
		
                f1.setVisible(true);
        }
    
    
    
    class mywin extends WindowAdapter{
        public void windowClosing(WindowEvent we){
            System.out.println("Exit via window x");
            f1.dispose();
        }
    }

    class myBack implements ActionListener{
                              public void actionPerformed(ActionEvent ae){
                                  System.out.println("back");
                                   f1.dispose();
                                    new Employee();
                        }		
		}
    class myDel implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            
        	String username;
        	username=tname.getText();
        	
        	try
			{
						
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject1","root","aditya");
			
			Statement st = con.createStatement();
			
			
			String str;
						
			str= "delete from login where user_id='"+username+"'";
			int ask=st.executeUpdate(str);
		   
			
			
			if(ask!=0){
				JOptionPane.showMessageDialog(null, "Employee Deleted","Task Completed",ask);
				}
			else{
				JOptionPane.showMessageDialog(null, "Employee not found","Error",ask);
			}
			
			con.close();	
			
			f1.dispose();
			new Employee();
			
			}
			catch(Exception e)
				{
				System.out.println(""+e);
				}
        }
    }
   public static void main(String a[]){
		new Del();
	}   
}
