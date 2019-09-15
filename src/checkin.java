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
import javax.swing.border.LineBorder;
import javax.swing.text.DateFormatter;


public class checkin implements ItemListener {
        JPanel p1;
        JFrame f1;
        JTextField tno,tdate,trent,tdur;
        JLabel lno,lid,lroom,ldate,lrent,ltype,l1,ldur,bgl;
        Choice ava,cid,type;
        JButton back,in;
        int h,w;
        checkin(){
                String cdate;
            	f1=new JFrame("Check In");
		Dimension sc=Toolkit.getDefaultToolkit().getScreenSize();
                w=sc.width;
                h=sc.height;
                f1.setSize(w,h);
                p1=(JPanel) f1.getContentPane();
		f1.addWindowListener(new mywin());
                f1.setLayout(null);
                p1.setBackground(new Color(196,133,49));
                Font f = new Font("Ubuntu",Font.BOLD,14);
                
                lid=new JLabel("Customer ID:");
		lid.setBounds(50,100,100,50);
                lid.setForeground(new Color(255,255,255));
                lid.setFont(f);
                
                cid=new Choice();
		cid.setBounds(165,110,150,25);
                cid.setForeground(new Color(255,255,255));
                cid.setBackground(new Color(196,133,49));
                cid.setFont(f);
                
                lno=new JLabel("Accomodation:");
		lno.setBounds(50,150,210,50);
                lno.setForeground(new Color(255,255,255));
                lno.setFont(f);
                
                tno=new JTextField(30);
		tno.setBounds(165,160,150,25);
                tno.setForeground(new Color(255,255,255));
                tno.setBackground(new Color(196,133,49));
                tno.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tno.setFont(f);
                
                ltype=new JLabel("Room Type:");
		ltype.setBounds(50,200,100,50);
                ltype.setForeground(new Color(255,255,255));
                ltype.setFont(f);
                
                type=new Choice();
		type.setBounds(165,210,150,25); 	
                type.add("Select Room Type");
                type.add("Double"); 
                type.add("Delux");
                type.add("Villa"); 
		type.add("Cottage");
                type.addItemListener((ItemListener) new mycombo());
                type.setForeground(new Color(255,255,255));
                type.setBackground(new Color(196,133,49));
                type.setFont(f);        
                
                lroom=new JLabel("Room Available:");
		lroom.setBounds(50,250,250,50);
                lroom.setForeground(new Color(255,255,255));
                lroom.setFont(f);
                
                ava=new Choice();
		ava.setBounds(165,260,150,25);
		ava.add("Room No.");
                ava.addItemListener(this);
                ava.setForeground(new Color(255,255,255));
                ava.setBackground(new Color(196,133,49));
		ava.setFont(f);
                
                lrent=new JLabel("Rent:");
		lrent.setBounds(50,300,150,50);
                lrent.setForeground(new Color(255,255,255));
                lrent.setFont(f);
                
                trent=new JTextField(30);
		trent.setBounds(165,310,150,25);
                trent.setEditable(false);
                trent.setForeground(new Color(255,255,255));
                trent.setBackground(new Color(196,133,49));
                trent.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                trent.setFont(f);
                
                ldur=new JLabel("Duration:");
		ldur.setBounds(50,350,150,50);
                ldur.setForeground(new Color(255,255,255));
                ldur.setFont(f);
                
                tdur=new JTextField(30);
		tdur.setBounds(165,360,150,25);
                tdur.setForeground(new Color(255,255,255));
                tdur.setBackground(new Color(196,133,49));
                tdur.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tdur.setFont(f);
                
                ldate=new JLabel("Date:");
		ldate.setBounds(50,400,150,50);
                ldate.setForeground(new Color(255,255,255));
                ldate.setFont(f);
                
                tdate=new JTextField(30);
                LocalDate now=LocalDate.now();
                tdate.setText(now.toString());
                tdate.setEditable(false);
		tdate.setBounds(165,410,150,25);
                tdate.setForeground(new Color(255,255,255));
                tdate.setBackground(new Color(196,133,49));
                tdate.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tdate.setFont(f);
                
                Cursor c1=new Cursor(Cursor.DEFAULT_CURSOR);
		f1.setCursor(c1);
                
                bgl=new JLabel();
                ImageIcon img=new ImageIcon("C:\\Users\\adity\\OneDrive\\Documents\\NetBeansProjects\\mini1\\src\\checkin.jpg");
                bgl=new JLabel("",img,JLabel.CENTER);
                bgl.setBounds(400, 0, w-400, h);
        
                back=new JButton("Back");
		back.setBounds(45,500,150,50);
		back.setMnemonic('B');
		back.setToolTipText("Click Here");
                back.setBorder( new LineBorder(new Color(255,255,255)) );
                back.setBackground(new Color(196,133,49));
                back.setForeground(new Color(255,255,255));
                
                
                in=new JButton("Check In");
		in.setBounds(200,500,150,50);
		in.setMnemonic('C');
		in.setToolTipText("Click Here");
                in.setForeground(new Color(196,133,49));
                in.setBackground(new Color(255,255,255));
                in.setBorder( new LineBorder(new Color(196,133,49)) );

                back.addActionListener(new myBack());
                in.addActionListener(new myIn());
                
                p1.add(ava);
                p1.add(type);
                p1.add(tno);
                p1.add(tdate);
                p1.add(trent);
                p1.add(tdur);
                p1.add(cid);
                
                p1.add(bgl);
                
                p1.add(lno);
                p1.add(lid);
                p1.add(lroom);
                p1.add(ldate);
                p1.add(lrent); 
                p1.add(ltype); 
                p1.add(ldur);
                p1.add(back);
                p1.add(in);
		
                f1.setVisible(true);
                load();
        }
 //To change body of generated methods, choose Tools | Templates.

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println(e.getSource());
        new mycombo(); //To change body of generated methods, choose Tools | Templates.
    }

    
   void load()
            {
                 try
                    {
                    cid.add("Customer ID");
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject1","root","aditya");
                    Statement st = con.createStatement();
                    ResultSet rs;
                    String str;
                    
                    str="select cid from customer";
                    rs=st.executeQuery(str);
                    while(rs.next())
                        {
                            cid.add(rs.getInt(1)+"");
                        }
                    
                    }
                 catch (Exception e)
                    {
                    }
            }
   

   public class mycombo implements ItemListener{
       
    public void itemStateChanged(ItemEvent ie) 
        {
            System.out.println("hghghg");
            
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
                                System.out.println(rs.getInt(5)+"");    
                                trent.setText(rs.getInt(5)+"");
                                System.out.println(rs.getInt(1)+"");
				ava.add(rs.getInt(1)+"");
				}
               
                rs.close();
                con.close();
                }
            catch (Exception e)
                {
                }
            
            if(ie.getSource() == type)
            {
                System.out.println("Select room");
                 String a;
        a=type.getSelectedItem();
        if(a.equals("Double")/*=="Double"*/){
                ImageIcon img=new ImageIcon("/home/tanmay/NetBeansProjects/Hotel/src/room1.jpeg");
                bgl=new JLabel("",img,JLabel.CENTER);
                
        }
        else if(a=="Delux"){
                ImageIcon img=new ImageIcon("/home/tanmay/NetBeansProjects/Hotel/src/room2.jpeg");
                bgl=new JLabel("",img,JLabel.CENTER);
               
        }
        else if(a=="Cottage"){
                ImageIcon img=new ImageIcon("/home/tanmay/NetBeansProjects/Hotel/src/room3.jpeg");
                bgl=new JLabel("",img,JLabel.CENTER);
               
        }
        else if(a=="Villa"){
                ImageIcon img=new ImageIcon("/home/tanmay/NetBeansProjects/Hotel/src/room4.jpeg");
                bgl=new JLabel("",img,JLabel.CENTER);
        }
            }
        }
    }
   
   
     void clear()
      {
      tno.setText("");
      trent.setText("");
      tdur.setText("");
      type.select(0);
      cid.select(0);
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
                                   int accom,rno,custid,dur;
                                   System.out.println("Check in");
                                   custid=Integer.parseInt(cid.getSelectedItem());
                                   rno=Integer.parseInt(ava.getSelectedItem());
                                   accom=Integer.parseInt(tno.getText());
                                   dur=Integer.parseInt(tdur.getText());
                                   LocalTime in_time = LocalTime.now();
                                   LocalDate in_date = LocalDate.now();
                                   try
                                    {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject1","root","aditya");
                                    Statement st = con.createStatement();
                                    //ResultSet rs;
                                    String str,str2,str3;

                                    str = "insert into checkin(indate,intime,accom,duration,cid,rno) values('"+in_date+"','"+in_time+"',"+accom+","+dur+","+custid+","+rno+");";
                                    st.executeUpdate(str);
                                    str2="update room set avail='n' where rno="+rno;
                                    st.executeUpdate(str2);
                                    JOptionPane.showMessageDialog(f1,"Record Saved","Save Record",JOptionPane.INFORMATION_MESSAGE);
                                    
                                    str3="insert into services(rno,refresh,cab,damage)values('"+rno+"',0,0,0)";
                                    st.executeUpdate(str3);
                                    
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
new checkin();
}   

}


