import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

class Admin {
	JFrame f1;
	JButton b1,b2,b3;
        JLabel bgl;
	JPanel p1;
	int w,h;
        
	Admin(){
		f1=new JFrame("Administrator Controls");
                Dimension sc=Toolkit.getDefaultToolkit().getScreenSize();
                w=sc.width;
                h=sc.height;
                f1.setSize(w,h);
    
		p1=(JPanel) f1.getContentPane();
		f1.addWindowListener(new mywin());
		f1.setLayout(null);		
                
                ImageIcon img=new ImageIcon("C:\\Users\\adity\\OneDrive\\Documents\\NetBeansProjects\\mini1\\src\\admin.jpg");
                bgl=new JLabel("",img,JLabel.CENTER);
                bgl.setBounds(0, 0, w, h);
                
		b1=new JButton("New Employee");
		b1.setBounds(40,450,200,75);
		b1.setMnemonic('N');
		b1.setToolTipText("Click Here");
		b1.setBackground(new Color(67,67,67));
                b1.setForeground(new Color(255,255,255));
                b1.setBorder( new LineBorder(Color.white) );
                
		/*b2=new JButton("Stats");
		b2.setBounds(550,450,200,75);
		b2.setMnemonic('S');
		b2.setToolTipText("Click Here");
		b2.setForeground(new Color(67,67,67));
                b2.setBackground(new Color(255,255,255));
                b2.setBorder( new LineBorder(Color.white) );
                */
		b3=new JButton("Log Out");
                b3.setBounds(1100,450,200,75);
		b3.setMnemonic('L');
		b3.setToolTipText("Click Here");
		b3.setBackground(new Color(67,67,67));
                b3.setForeground(new Color(255,255,255));
                b3.setBorder( new LineBorder(Color.white) );
                
		b1.addActionListener(new myNew());
		//b2.addActionListener(new myStats());
		b3.addActionListener(new myOut());
		        
		Cursor c1=new Cursor(Cursor.HAND_CURSOR);
		f1.setCursor(c1);
		
                p1.add(bgl);
		p1.add(b1);
		//p1.add(b2);
		p1.add(b3);
		
        f1.setVisible(true);
	}
		
	class mywin extends WindowAdapter{
		          public void windowClosing(WindowEvent we){
		                    System.out.println("Exit via window x");
		                    f1.dispose();
		          }
		}
		
		class myNew implements ActionListener{
                              public void actionPerformed(ActionEvent ae){
                                   System.out.println("Check in");
                                   new Employee();
                                   f1.dispose();
                   }		
		}
		
		class myOut implements ActionListener{
                              public void actionPerformed(ActionEvent ae){
                                  System.out.println("Check out");
                                    f1.dispose();
                                    new Login();
                     }		
		}
   /*     class myStats implements ActionListener{
                              public void actionPerformed(ActionEvent ae){
                                  System.out.println("Stats");
                                     f1.dispose();
                                    new Stats();
                      }		
		}*/
    public static void main(String a[]){
		new Admin();
	} 
}