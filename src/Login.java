import java.awt.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Login {
        JPanel p1;
        JFrame f1;
        JTextField t1;
        JPasswordField t2;
        JLabel l1,name,pas,bg1;
        JButton b1,b2;
        String list[]={"img2.jpg"};
        ImageIcon img;
        JLabel bgl;
        int h,w;
        Login(){
            	f1=new JFrame("Login Page");
                
		Dimension sc=Toolkit.getDefaultToolkit().getScreenSize();
                w=sc.width;
                h=sc.height;
                f1.setSize(w,h);
                p1=new JPanel();
                p1=(JPanel) f1.getContentPane();
                p1.setBackground(new Color(21,0,0));
                f1.addWindowListener(new mywin());
                f1.setLayout(null);
                Font f = new Font("Ubuntu",Font.BOLD,14);
                
                System.out.println(w/2+","+h);
                
                ImageIcon img=new ImageIcon("C:\\Users\\adity\\OneDrive\\Documents\\NetBeansProjects\\mini1\\src\\login.jpg");
                bgl=new JLabel("",img,JLabel.CENTER);
                bgl.setBounds(0, 0, w/2, h);
               
                
                
                
                t1=new JTextField(100);
                t1.setBounds((w/2)+200,250,200,25);
                t1.setForeground(new Color(255,255,255));
                t1.setBackground(new Color(21,0,0));
                t1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		t1.setFont(f);
                
                
                
                name=new JLabel("Username:");
                name.setBounds((w/2)+100,250,200,25);
                name.setForeground(Color.white);
                name.setFont(f);
                
                t2=new JPasswordField(100);
                t2.setBounds((w/2)+200,300,200,25);
                t2.setForeground(new Color(255,255,255));
                t2.setBackground(new Color(21,0,0));
                t2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                t2.setFont(f);
                
                pas=new JLabel("Password:");
                pas.setBounds((w/2)+100,300,200,25);
		pas.setForeground(Color.white);
                pas.setFont(f);
                
                b1=new JButton("Employee Login");
                b1.setForeground(new Color(255,255,255));
                b1.setBackground(new Color(21,0,0));
                b1.setBounds((w/2)+300,400,200,50);
                b1.setBorder( new LineBorder(Color.white) );
                b1.setMnemonic('L');
                b1.setToolTipText("Click Here to Login");
                b1.addActionListener(new myAction());
                
                
                b2=new JButton("Administrator Login");
                b2.setForeground(new Color(21,0,0));
                b2.setBackground(new Color(255,255,255));
                b2.setBounds((w/2)+50,400,200,50);
                b2.setBorder( new LineBorder(new Color(21,0,0)) );
                b2.setMnemonic('A');
                b2.setToolTipText("Click Here to Login");
                b2.addActionListener(new myActionAdmin());
                
               
				Cursor c1=new Cursor(Cursor.DEFAULT_CURSOR);
				f1.setCursor(c1);
			        
                                
				p1.add(b1);
				p1.add(t1);
				p1.add(t2);
                                p1.add(bgl);
                
                p1.add(b2);
				p1.add(name);
                p1.add(pas);

                f1.setVisible(true);
        }
    
    class myAction implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            
        	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        	LocalDateTime now=LocalDateTime.now();
        	
        	String username,pass,instance;
        	instance=dtf.format(now);
        	username=t1.getText();
        	pass=new String(t2.getPassword());
            
        	try
			{
						
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject1","root","aditya");
			
			Statement st = con.createStatement();
			
			ResultSet rs;
			String str,str2;
			
						
			str = "select * from login where user_id='"+username+"'and pass='"+pass+"';";
			rs = st.executeQuery(str);
			
			if(rs.next()){
				str2= "insert into login_history values('"+username+"','"+pass+"','"+instance+"')";
				st.executeUpdate(str2);
			   
				System.out.println("Login");
	            new Menu();
	            f1.dispose();
				
			}
			else{
				JOptionPane.showMessageDialog(null, "Wrong Credentials","Error",2);
				
			}
			
			rs.close();
			con.close();	
			
			}
			catch(Exception e)
				{
				System.out.println(""+e);
				}
		
        	
        }
    }
    
    
    
     
    class myActionAdmin implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            
        	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        	LocalDateTime now=LocalDateTime.now();
        	
        	String username,password,instance;
        	instance=dtf.format(now);
        	username=t1.getText();
        	password=new String(t2.getPassword());
            
        	try
			{
						
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject1","root","aditya");
			
			Statement st = con.createStatement();
			
			ResultSet rs;
			String str,str2;
			
						
			str = "select * from admin_login where admin_id='"+username+"'and pass='"+password+"';";
			rs = st.executeQuery(str);
			
			if(rs.next()){
				str2= "insert into admin_login_history values('"+username+"','"+password+"','"+instance+"')";
				st.executeUpdate(str2);
			   
				System.out.println("Login");
	            new Employee();
	            f1.dispose();
				
			}
			else{
				JOptionPane.showMessageDialog(null, "You are not an Admin!","Authority Error",0);
				
			}
			
			rs.close();
			con.close();	
			
			}
			catch(Exception e)
				{
				System.out.println(""+e);
				}
        }
    }
   
    
    
    
    class mywin extends WindowAdapter{
        public void windowClosing(WindowEvent we){
            System.out.println("Exit via window x");
            f1.dispose();
        }
    }

    public static void main(String a[]){
		new Login();
	}    
    
}
