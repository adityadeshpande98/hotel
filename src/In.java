import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalTime;  
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.text.DateFormatter;


public class In implements ItemListener {
        JPanel p1;
        JFrame f1;
        JTextField tname,tno,tdate,tid,trent,tidno;
        JLabel lname,lno,lroom,ldate,lid,lrent,ltype,lidno,l1;
        Choice ava,id,type;
        JButton back,in;
        int h,w;
        In(){
                String cdate;
            	f1=new JFrame("Check In");
		Dimension sc=Toolkit.getDefaultToolkit().getScreenSize();
                w=sc.width;
                h=sc.height;
                f1.setSize(w,h);
                p1=(JPanel) f1.getContentPane();
		f1.addWindowListener(new mywin());
                f1.setLayout(null);

		l1=new JLabel("The Regimental!");
                l1.setBounds(900,250,900,100);
                l1.setFont(new Font("Times New Roman",Font.BOLD ,50));
                l1.setForeground(Color.red);
                
                lname=new JLabel("Name:");
		lname.setBounds(50,100,50,50);
               
                tname=new JTextField(30);
		tname.setBounds(150,110,150,25);
                
                lno=new JLabel("Accomodation:");
		lno.setBounds(50,150,100,50);
                
                tno=new JTextField(30);
		tno.setBounds(150,160,150,25);
                
                ltype=new JLabel("Room Type:");
		ltype.setBounds(50,200,100,50);
                
                type=new Choice();
		type.setBounds(150,210,150,25); 	
                type.add("Select Room Type");
                type.add("Double"); 
                type.add("Delux");
                type.add("Villa"); 
		type.add("Cottage");
                type.addItemListener((ItemListener) new mycombo());
                
                
                lroom=new JLabel("Room Available:");
		lroom.setBounds(50,250,150,50);
                
                ava=new Choice();
		ava.setBounds(150,260,150,25);
		ava.add("Room No.");
                ava.addItemListener(this);
                
                lrent=new JLabel("Rent:");
		lrent.setBounds(50,300,150,50);
                
                trent=new JTextField(30);
		trent.setBounds(150,310,150,25);
                trent.setEditable(false);
                
                lid=new JLabel("Identification:");
		lid.setBounds(50,350,150,50);
                
                id=new Choice();
		id.setBounds(150,360,150,25);
                id.add("Select ID");
		id.add("Adhaar"); 
		id.add("Pan Card"); 	
		id.add("Lisence");
                id.add("Voter's ID");
                id.addItemListener(this);
                lidno=new JLabel("Identification No.:");
		lidno.setBounds(50,400,150,50);
                
                tidno=new JTextField(30);
		tidno.setBounds(150,410,150,25);
                
                ldate=new JLabel("Date:");
		ldate.setBounds(50,450,150,50);
                
                tdate=new JTextField(30);
                LocalDate now=LocalDate.now();
                tdate.setText(now.toString());
                tdate.setEditable(false);
		tdate.setBounds(150,460,150,25);
                
		Cursor c1=new Cursor(Cursor.DEFAULT_CURSOR);
		f1.setCursor(c1);
                
                back=new JButton("Back");
		back.setBounds(500,275,150,25);
		back.setMnemonic('B');
		back.setToolTipText("Click Here");
                
                in=new JButton("Check In");
		in.setBounds(500,300,150,25);
		in.setMnemonic('C');
		in.setToolTipText("Click Here");
                
                back.addActionListener(new myBack());
                in.addActionListener(new myIn());
                
                p1.add(ava);
                p1.add(id);
                p1.add(type);
                p1.add(tname);
                p1.add(tno);
                p1.add(tdate);
                p1.add(tidno);
                p1.add(trent);
                
                p1.add(l1);
                
                p1.add(lname);
                p1.add(lno);
                p1.add(lroom);
                p1.add(ldate);
                p1.add(lid);
                p1.add(lrent); 
                p1.add(lidno); 
                p1.add(ltype); 
                
                p1.add(back);
                p1.add(in);
		
                f1.setVisible(true);
        }
 //To change body of generated methods, choose Tools | Templates.

    @Override
    public void itemStateChanged(ItemEvent e) {
        new mycombo(); //To change body of generated methods, choose Tools | Templates.
    }

    

   public class mycombo implements ItemListener{
       
    public void itemStateChanged(ItemEvent ie) 
        {
            String r_type;
            r_type = (String) type.getSelectedItem();
            ava.removeAll();
            ava.add("Room No.");
            try
		{
					
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject1","root","aditya");
		Statement st = con.createStatement();
		ResultSet rs;
		String str;
                
                str="select * from room where rtype like'"+r_type+"' and avail='y'";
                rs = st.executeQuery(str);
                
                while(rs.next())
				{
                                     trent.setText(rs.getInt(5)+"");
				ava.add(rs.getInt(1)+"");
				}
               
                rs.close();
                con.close();
                }
            catch (Exception e)
                {
                }
        }
    }
   
     void clear()
      {
      tname.setText("");
      tno.setText("");
      trent.setText("");
      tidno.setText("");
      id.select(0);
      type.select(0);
      ava.removeAll();
      ava.add("Room No.");
      }
   

    class mywin extends WindowAdapter{
        public void windowClosing(WindowEvent we){
            System.out.println("Exit via window x");
            f1.dispose();
        }
    }

    class myIn implements ActionListener{
                           
                            
                              public void actionPerformed(ActionEvent ae){
                                  try{
                                   int accom,rno;
                                   String aid,cname,id_no;
                                   System.out.println("Check in");
                                   cname=(String)tname.getText();
                                   rno=Integer.parseInt(ava.getSelectedItem());
                                   accom=Integer.parseInt(tno.getText());
                                   aid =(String)id.getSelectedItem();
                                   id_no = (String)tidno.getText();
                                   LocalTime in_time = LocalTime.now();
                                   LocalDate in_date = LocalDate.now();
                                   
                                   try
                                    {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject1","root","aditya");
                                    Statement st = con.createStatement();
                                    //ResultSet rs;
                                    String str,str2;

                                    str = "insert into checkin(cname,accom,rno,id,idno,indate,intime) values('"+cname+"',"+accom+","+rno+",'"+aid+"',"+id_no+",'"+in_date+"','"+in_time+"')";
                                    st.executeUpdate(str);
                                    
                                    str2="update room set avail='n' where rno="+rno;
                                    st.executeUpdate(str2);
                                    JOptionPane.showMessageDialog(f1,"Record Saved","Save Record",JOptionPane.INFORMATION_MESSAGE);
                                    
                                    con.close();
                                    clear();
                                            }
                                    catch(Exception e)
                                            {
                                            }
                                  }
                                   catch(NumberFormatException e)
                                            {
                                                JOptionPane.showMessageDialog(f1,"Insuffiecient Data","Error",JOptionPane.INFORMATION_MESSAGE);
                                                
                                            }
                                   
			}		
		}
    class myBack implements ActionListener{
                              public void actionPerformed(ActionEvent ae){
                                  System.out.println("back");
                                   f1.dispose();
                                    new Menu();
                        }		
		}
    
        
  
public static void main(String a[])
{
new In();
}   

}


