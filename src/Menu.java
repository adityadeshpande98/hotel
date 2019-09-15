import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

class Menu {
	JFrame f1;
	JButton b1,b2,b3,b5;
        JLabel bg;
	JPanel p1;
	int w,h;
        
	Menu(){
		f1=new JFrame("Menu");
                Dimension sc=Toolkit.getDefaultToolkit().getScreenSize();
                w=sc.width;
                h=sc.height;
                f1.setSize(w,h);
    
		p1=(JPanel) f1.getContentPane();
		f1.addWindowListener(new mywin());
		f1.setLayout(null);		
                
                ImageIcon img=new ImageIcon("C:\\Users\\adity\\OneDrive\\Documents\\NetBeansProjects\\mini1\\src\\menu.jpg");
                bg=new JLabel("",img,JLabel.CENTER);
                bg.setBounds(0, 0, w, h);
                
		b1=new JButton("Check In");
		b1.setBounds(40,275,100,100);
		b1.setMnemonic('C');
		b1.setToolTipText("Click Here");
		b1.setForeground(new Color(51,63,79));
                b1.setBackground(new Color(207,168,88));
                b1.setBorder( new LineBorder(Color.black) );
		
                b2=new JButton("Update");
		b2.setBounds(600,275,100,100);
		b2.setMnemonic('U');
		b2.setToolTipText("Click Here");
		b2.setBackground(new Color(51,63,79));
                b2.setForeground(new Color(207,168,88));
               // b2.setBorder( new LineBorder(Color.black) );
                
		b3=new JButton("Check Out");
                b3.setBounds(1150,275,100,100);
		b3.setMnemonic('H');
		b3.setToolTipText("Click Here");
		b3.setForeground(new Color(51,63,79));
                b3.setBackground(new Color(207,168,88));
                b3.setBorder( new LineBorder(Color.black) );
        
                b5=new JButton("Log Out");
		b5.setBounds(600,500,100,100);
		b5.setMnemonic('B');
		b5.setToolTipText("Click Here");
                b5.setBackground(new Color(51,63,79));
                b5.setForeground(new Color(207,168,88));
               // b5.setBorder( new LineBorder(Color.black) );
                
		b1.addActionListener(new myIn());
		b2.addActionListener(new myUp());
		b3.addActionListener(new myOut());
		b5.addActionListener(new myBack());
                
		Cursor c1=new Cursor(Cursor.HAND_CURSOR);
		f1.setCursor(c1);
		
                p1.add(bg);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b5);
		
                f1.setVisible(true);
	}
		
	class mywin extends WindowAdapter{
		          public void windowClosing(WindowEvent we){
		                    System.out.println("Exit via window x");
		                    f1.dispose();
		          }
		}
		
		class myIn implements ActionListener{
                              public void actionPerformed(ActionEvent ae){
                                   System.out.println("Check in");
                                   new customer();
                                   f1.dispose();
                             
                        
			}		
		}
		
		class myUp implements ActionListener{
                              public void actionPerformed(ActionEvent ae){
                                    System.out.println("Update");
                                    f1.dispose();
                                    new Update();
                                   
                              }		
		}
		
		class myOut implements ActionListener{
                              public void actionPerformed(ActionEvent ae){
                                  System.out.println("Check out");
                                    f1.dispose();
                                    new FinalOut();
                        
                        }		
		}
         
                class myBack implements ActionListener{
                              public void actionPerformed(ActionEvent ae){
                                  System.out.println("back");
                                   f1.dispose();
                                    new Login();
                        }		
		}
	
	public static void main(String a[])
    {
        new Menu();
       } 
}