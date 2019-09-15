import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Out {
        JPanel p1;
        JFrame f1;
        JTextField tname,tno;
        JLabel lname,lno,bgl;
        JButton back,search;
        int h,w;
        Out(){
            	f1=new JFrame("Check Out");
		Dimension sc=Toolkit.getDefaultToolkit().getScreenSize();
                w=sc.width;
                h=sc.height;
                f1.setSize(w,h);
                p1=(JPanel) f1.getContentPane();
		f1.addWindowListener(new mywin());
                f1.setLayout(null);
                
                p1.setBackground(new Color(10,10,10));
                Font f = new Font("Ubuntu",Font.BOLD,14);
                
		bgl=new JLabel();
                ImageIcon img=new ImageIcon("C:\\Users\\adity\\OneDrive\\Documents\\NetBeansProjects\\mini1\\src\\out.jpg");
                bgl=new JLabel("",img,JLabel.CENTER);
                bgl.setBounds(400, 0, w-400, h);
                
                lname=new JLabel("Name:");
		lname.setBounds(50,100,50,50);
                lname.setForeground(new Color(220,220,220));
                lname.setFont(f);
                
                tname=new JTextField(30);
		tname.setBounds(150,110,150,25);
                tname.setForeground(new Color(220,220,220));
                tname.setBackground(new Color(10,10,10));
                tname.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tname.setFont(f);
                
                lno=new JLabel("Room No.:");
		lno.setBounds(50,150,100,50);
                lno.setForeground(new Color(220,220,220));
                lno.setFont(f);
                
                tno=new JTextField(30);
		tno.setBounds(150,160,150,25);
                tno.setForeground(new Color(220,220,220));
                tno.setBackground(new Color(10,10,10));
                tno.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tno.setFont(f);
               
		Cursor c1=new Cursor(Cursor.DEFAULT_CURSOR);
		f1.setCursor(c1);
                
                back=new JButton("Back");
		back.setBounds(200,300,100,50);
		back.setMnemonic('B');
		back.setToolTipText("Click Here");
                back.setBorder( new LineBorder(new Color(220,220,220)) );
                back.setBackground(new Color(10,10,10));
                back.setForeground(new Color(220,220,220));
                
                search=new JButton("Search");
		search.setBounds(50,300,100,50);
		search.setMnemonic('S');
		search.setToolTipText("Click Here");
                search.setBorder( new LineBorder(new Color(220,220,220)) );
                search.setForeground(new Color(10,10,10));
                search.setBackground(new Color(220,220,220));
                
                back.addActionListener(new myBack());
                search.addActionListener(new mySearch());
                
               
                p1.add(tname);
                p1.add(tno);
               
                p1.add(bgl);
                p1.add(lname);
                p1.add(lno);
               
                
                p1.add(back);
                p1.add(search);
		
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
                                    new Menu();
                        }		
		}
   
    class mySearch implements ActionListener{
                              public void actionPerformed(ActionEvent ae){
                                  
                                  System.out.println("final out");
                                  String cname = tname.getText();
                                  int cno = Integer.parseInt(tno.getText());
                                  
                                  try
                                     {
                                         System.out.println("final out1");
                                         ResultSet rs=null;
                                          Statement st=null;
                                      Class.forName("com.mysql.jdbc.Driver");
                                      Connection con = DriverManager.getConnection("jdbc:myqsl://localhost:3306:/miniproject","root","ketki");
                                      st = con.createStatement();
                                      String str;
                                      
                                      str = "select * from customer where cname = '"+cname+"' or rno = "+cno;
                                      rs = st.executeQuery(str);
                                      if(rs.next())
                                      {                     
                                          System.out.println("final out2");
                                        f1.dispose();
                                        new FinalOut();
                                      }
                                      else
                                      {
                                          System.out.println("final out3");
                                          JOptionPane.showMessageDialog(f1,"Invalid Data","Error",JOptionPane.INFORMATION_MESSAGE);
                                      }
                                      rs.close();
                                      con.close();
                                      
                                     }
                                     catch(Exception e)
                                     {
                                     }
                                  }
                               
                                  
                                   
                        }		
		
          

public static void main(String a[])

{
new Out();
}   
   
}
