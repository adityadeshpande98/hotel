import java.awt.*; 
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Ret {
        JPanel p1;
        JFrame f1;
        JTextField tname,tpass;
        JLabel lname,lpass,bgl;
        JButton back,ret;
        int h,w;
        Ret(){
            	f1=new JFrame("Retrieve Employee Details");
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
                ImageIcon img=new ImageIcon("C:\\Users\\adity\\OneDrive\\Documents\\NetBeansProjects\\mini1\\src\\ret.jpg");
                bgl=new JLabel("",img,JLabel.CENTER);
                bgl.setBounds(400, 0, w-400, h);
                
                lname=new JLabel("Name:");
		lname.setBounds(50,100,50,50);
                lname.setForeground(new Color(11,11,18));
                lname.setFont(f);
                
                tname=new JTextField(30);
		tname.setBounds(150,110,150,25);
                tname.setForeground(new Color(11,11,18));
                tname.setBackground(new Color(255,255,255));
                tname.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
                tname.setFont(f);
                
                lpass=new JLabel("Password:");
		lpass.setBounds(50,150,100,50);
                lpass.setForeground(new Color(11,11,18));
                lpass.setFont(f);
                
                tpass=new JTextField(30);
		tpass.setBounds(150,160,150,25);
                tpass.setForeground(new Color(11,11,18));
                tpass.setBackground(new Color(255,255,255));
                tpass.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
                tpass.setFont(f);
                tpass.setEditable(false);
                
		Cursor c1=new Cursor(Cursor.DEFAULT_CURSOR);
		f1.setCursor(c1);
                
                back=new JButton("Back");
		back.setBounds(75,310,200,50);
		back.setMnemonic('B');
		back.setToolTipText("Click Here");
                back.setBackground(new Color(255,255,255));
                back.setForeground(new Color(11,11,18));
                back.setBorder( new LineBorder(Color.black) );
                
                ret=new JButton("Retrieve");
		ret.setBounds(75,250,200,50);
		ret.setMnemonic('S');
		ret.setToolTipText("Click Here");
                ret.setForeground(new Color(255,255,255));
                ret.setBackground(new Color(11,11,18));
                ret.setBorder( new LineBorder(Color.white) );
                
                back.addActionListener(new myBack());
                ret.addActionListener(new myRet());
                
               
                p1.add(tname);
                p1.add(tpass);
               
                p1.add(bgl);
                p1.add(lname);
                p1.add(lpass);
               
                
                p1.add(back);
                p1.add(ret);
		
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
    class myRet implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            
        	String username,password;
        	username=tname.getText();
        	
        	try
			{
						
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject1","root","aditya");
			
			Statement st = con.createStatement();
			
			ResultSet rs ;
			String str;
						
			str= "select *from login where user_id='"+username+"'";
			rs=st.executeQuery(str);
		   
			
			
			if(rs.next()){
				tpass.setText(rs.getString(2)+"");
			}
			else{
				JOptionPane.showMessageDialog(null, "Employee not found","Error",0);
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
   public static void main(String a[]){
		new Ret();
	}   
}
