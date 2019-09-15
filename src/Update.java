import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Update {
        JPanel p1;
        JFrame f1;
        JTextField tcab,tdamc,ttea,tstay,trno;
        JLabel lcab,ldam,ldamc,ltea,lstay,bgl,lrno;
        Choice dam;
        JButton back,update;
        int h,w;
        Update(){
            	f1=new JFrame("Update");
		Dimension sc=Toolkit.getDefaultToolkit().getScreenSize();
                w=sc.width;
                h=sc.height;
                f1.setSize(w,h);
                p1=(JPanel) f1.getContentPane();
		f1.addWindowListener(new mywin());
                f1.setLayout(null);
                
                p1.setBackground(new Color(38,38,38));
                Font f = new Font("Ubuntu",Font.BOLD,14);
                
		bgl=new JLabel();
                ImageIcon img=new ImageIcon("C:\\Users\\adity\\OneDrive\\Documents\\NetBeansProjects\\mini1\\src\\update.jpg");
                bgl=new JLabel("",img,JLabel.CENTER);
                bgl.setBounds(400, 0, w-400, h);
                
                lrno=new JLabel("Room No.:");
                lrno.setBounds(50,100,100,50);
                lrno.setForeground(new Color(248,251,75));
                lrno.setFont(f);
                
                trno=new JTextField(30);
                trno.setBounds(200,110,150,25);
                trno.setForeground(new Color(248,251,75));
                trno.setBackground(new Color(38,38,38));
                trno.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                trno.setFont(f);
                
                lcab=new JLabel("Cab Services:");
		lcab.setBounds(50,150,100,50);
                lcab.setForeground(new Color(248,251,75));
                lcab.setFont(f);
                
                tcab=new JTextField(100);
		tcab.setBounds(200,160,150,25);
                tcab.setText("0");
                tcab.setForeground(new Color(248,251,75));
                tcab.setBackground(new Color(38,38,38));
                tcab.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tcab.setFont(f);
                
                ldam=new JLabel("Damage Type:");
		ldam.setBounds(50,200,100,50);
                ldam.setForeground(new Color(248,251,75));
                ldam.setFont(f);
                
                dam=new Choice();
		dam.setBounds(200,210,150,25); 
                dam.add("Select Item");
                dam.add("LED"); 	
                dam.add("Furniture"); 
		dam.add("Glass");
                dam.add("Electronics");
                dam.addItemListener((ItemListener) new mycombo());
                dam.setForeground(new Color(248,251,75));
                dam.setBackground(new Color(38,38,38));
                dam.setFont(f);
                
                ldamc=new JLabel("Damage Cost:");
		ldamc.setBounds(50,250,100,50);
                ldamc.setForeground(new Color(248,251,75));
                ldamc.setFont(f);
                
                tdamc=new JTextField(30);
		tdamc.setBounds(200,260,150,25);
                tdamc.setText("0");
                tdamc.setEditable(false);
                tdamc.setForeground(new Color(248,251,75));
                tdamc.setBackground(new Color(38,38,38));
                tdamc.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tdamc.setFont(f);
                
                ltea=new JLabel("Tea Refreshments:");
		ltea.setBounds(50,300,150,50);
                ltea.setForeground(new Color(248,251,75));
                ltea.setFont(f);
                
                ttea=new JTextField(30);
		ttea.setBounds(200,310,150,25);
                ttea.setText("0");
                ttea.setForeground(new Color(248,251,75));
                ttea.setBackground(new Color(38,38,38));
                ttea.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                ttea.setFont(f);
                
                lstay=new JLabel("Stay Period:");
		lstay.setBounds(50,350,150,50);
                lstay.setForeground(new Color(248,251,75));
                lstay.setFont(f);
                
                tstay=new JTextField(30);
		tstay.setBounds(200,360,150,25);
                tstay.setText("0");
                tstay.setForeground(new Color(248,251,75));
                tstay.setBackground(new Color(38,38,38));
                tstay.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tstay.setFont(f);
                
		Cursor c1=new Cursor(Cursor.DEFAULT_CURSOR);
		f1.setCursor(c1);
                
                back=new JButton("Back");
		back.setBounds(50,450,100,50);
		back.setMnemonic('B');
		back.setToolTipText("Click Here");
                back.setBorder( new LineBorder(new Color(248,251,75)) );
                back.setBackground(new Color(38,38,38));
                back.setForeground(new Color(248,251,75));
                
                back.addActionListener(new myBack());
                
                update=new JButton("Update");
		update.setBounds(200,450,100,50);
		update.setMnemonic('U');
		update.setToolTipText("Click Here");
                update.setBorder( new LineBorder(new Color(248,251,75)) );
                update.setBackground(new Color(38,38,38));
                update.setForeground(new Color(248,251,75));
                
                update.addActionListener(new myUpdate());
        
                p1.add(update);
                
                p1.add(lcab);
                p1.add(ldam);
                p1.add(ldamc);
                p1.add(ltea);
                p1.add(lstay); 
                p1.add(lrno);
                
                p1.add(bgl);
                
                p1.add(tcab);
                p1.add(dam);
                p1.add(tdamc);
                p1.add(ttea);
                p1.add(tstay);
                p1.add(trno);
                
                p1.add(back);
		
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
    
    
      public class mycombo implements ItemListener{
       
    public void itemStateChanged(ItemEvent ie) 
        {
           int opt =dam.getSelectedIndex();
           if(opt==1)
           {
               tdamc.setText("150");
           }
           else
               if(opt==2)
               {
                   tdamc.setText("1200");
               }
           else
               if(opt==3)
               {
                   tdamc.setText("1000");
               }
           else
                   if(opt==4)
                   {
                       tdamc.setText("1500");
                   }
        }
      }
    
    
    
    class myUpdate implements ActionListener{
                              public void actionPerformed(ActionEvent ae){
                                  
                                  System.out.println("Update");
                                   int cab,refresh,dam,rno,dur;
                                   cab=Integer.parseInt(tcab.getText());
                                   refresh=Integer.parseInt(ttea.getText());
                                   dam=Integer.parseInt(tdamc.getText());
                                   rno=Integer.parseInt(trno.getText());
                                   dur=Integer.parseInt(tstay.getText());
                                   
                                   try
                                   {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject1","root","aditya");
        		            Statement st = con.createStatement();
                                    ResultSet rs;
                                    String str,str2;
                  
                                    str="update services set damage="+dam+",refresh="+refresh+",cab="+cab+" where rno="+rno;
                                    st.executeUpdate(str);
                                    str2="update checkin set duration="+dur+" where rno="+rno;
                                    st.executeUpdate(str2);
                                    JOptionPane.showMessageDialog(f1,"Data Updated","Success",JOptionPane.INFORMATION_MESSAGE);
                                    clear();
                                   }
                                   catch(Exception e)
                                   {
                                   }
                                 
                        }		
		}            
   
    
    void clear()
    {
        trno.setText("");
        tcab.setText("0");
        tdamc.setText("0");
        ttea.setText("0");
        tstay.setText("0");
        dam.select(0);
    }
    
   public static void main(String a[])
{
new Update();
}  

}

