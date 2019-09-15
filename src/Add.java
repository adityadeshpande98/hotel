import java.awt.*; 
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Add {
        JPanel p1;
        JFrame f1;
        JTextField tname,tpass;
        JLabel lname,lpass,bgl;
        JButton back,add;
        int h,w;
        Add(){
            	f1=new JFrame("Add Employee");
		Dimension sc=Toolkit.getDefaultToolkit().getScreenSize();
                w=sc.width;
                h=sc.height;
                f1.setSize(w,h);
                p1=(JPanel) f1.getContentPane();
		f1.addWindowListener(new mywin());
                f1.setLayout(null);
                p1.setBackground(new Color(255,255,255));
                Font f = new Font("Ubuntu",Font.BOLD,14);

		bgl=new JLabel();
                ImageIcon img=new ImageIcon("C:\\Users\\adity\\OneDrive\\Documents\\NetBeansProjects\\mini1\\src\\add.jpg");
                bgl=new JLabel("",img,JLabel.CENTER);
                bgl.setBounds(400, 0, w-400, h);
                
                lname=new JLabel("Name:");
		lname.setBounds(50,100,50,50);
                lname.setForeground(new Color(0,0,0));
                lname.setFont(f);
                
                tname=new JTextField(30);
		tname.setBounds(150,110,150,25);
                tname.setForeground(new Color(0,0,0));
                tname.setBackground(new Color(255,255,255));
                tname.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
                tname.setFont(f);
                
                lpass=new JLabel("Password:");
		lpass.setBounds(50,150,100,50);
                lpass.setForeground(new Color(0,0,0));
                lpass.setFont(f);
                
                tpass=new JTextField(30);
		tpass.setBounds(150,160,150,25);
                tpass.setForeground(new Color(0,0,0));
                tpass.setBackground(new Color(255,255,255));
                tpass.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
                tpass.setFont(f);
               
                
		Cursor c1=new Cursor(Cursor.DEFAULT_CURSOR);
		f1.setCursor(c1);
                
                back=new JButton("Back");
		back.setBounds(75,310,200,50);
		back.setMnemonic('B');
		back.setToolTipText("Click Here");
                back.setBackground(new Color(255,255,255));
                back.setForeground(new Color(0,0,0));
                back.setBorder( new LineBorder(Color.black) );
                
                add=new JButton("Add");
		add.setBounds(75,250,200,50);
		add.setMnemonic('S');
		add.setToolTipText("Click Here");
                add.setForeground(new Color(255,255,255));
                add.setBackground(new Color(0,0,0));
                add.setBorder( new LineBorder(Color.white) );
                
                back.addActionListener(new myBack());
                add.addActionListener(new myAdd());
                
               
                p1.add(tname);
                p1.add(tpass);
               
                p1.add(bgl);
                p1.add(lname);
                p1.add(lpass);
               
                
                p1.add(back);
                p1.add(add);
		
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
    class myAdd implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            
        	String username,password;
        	username=tname.getText();
        	password=tpass.getText();
            
        	try
			{
						
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject1","root","aditya");
			
			Statement st = con.createStatement();
			
			//ResultSet rs ;
			String str;
						
			str= "insert into login values('"+username+"','"+password+"')";
			int ask=st.executeUpdate(str);
		   
			
			
			if(ask!=0){
				JOptionPane.showMessageDialog(null, "Employee added","Task Completed", ask);
				System.out.println(ask);
				
			}
			else{
				JOptionPane.showMessageDialog(null, "Employee not added","Error",0);
			}
			
			//rs.close();
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
		new Add();
	}   
}
