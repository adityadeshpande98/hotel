import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

class Employee {
	JFrame f1;
	JButton b1,b2,b3,back;
        JLabel bg;
	JPanel p1;
	ImageIcon img;
        int w,h;
        
	Employee(){
		f1=new JFrame("Administrator Controls");
                Dimension sc=Toolkit.getDefaultToolkit().getScreenSize();
                w=sc.width;
                h=sc.height;
                f1.setSize(w,h);
    
		p1=(JPanel) f1.getContentPane();
		f1.addWindowListener(new mywin());
		f1.setLayout(null);		
                
                
                ImageIcon img=new ImageIcon("C:\\Users\\adity\\OneDrive\\Documents\\NetBeansProjects\\mini1\\src\\emp.jpg");
                bg=new JLabel("",img,JLabel.CENTER);
                bg.setBounds(0, 0, w, h);
                
		b1=new JButton("Add Employee");
		b1.setBounds(40,290,200,75);
		b1.setMnemonic('A');
		b1.setToolTipText("Click Here");
                b1.setBackground(new Color(243,243,243));
                b1.setForeground(new Color(255,0,0));
                b1.setBorder( new LineBorder(Color.white) );
		
		b2=new JButton("Delete Employee");
		b2.setBounds(550,290,200,75);
		b2.setMnemonic('D');
		b2.setToolTipText("Click Here");
                b2.setBackground(new Color(243,243,243));
                b2.setForeground(new Color(255,0,0));
                b2.setBorder( new LineBorder(Color.white) );
                
		b3=new JButton("Retrive Employee");
                b3.setBounds(1100,290,200,75);
		b3.setMnemonic('R');
		b3.setToolTipText("Click Here");p1.add(b3);
                b3.setBackground(new Color(243,243,243));
                b3.setForeground(new Color(255,0,0));
                b3.setBorder( new LineBorder(Color.white) );		
		
		back=new JButton("Logout");
		back.setBounds(550,450,200,75);
		back.setMnemonic('B');
		back.setToolTipText("Click Here");
                back.setBackground(new Color(243,243,243));
                back.setForeground(new Color(255,0,0));
                back.setBorder( new LineBorder(Color.white) );
                
		b1.addActionListener(new myAdd());
		b2.addActionListener(new myDel());
		b3.addActionListener(new myRet());
		back.addActionListener(new myBack());
		
		Cursor c1=new Cursor(Cursor.HAND_CURSOR);
		f1.setCursor(c1);
		
                p1.add(bg);
		p1.add(b1);
		p1.add(b2);
		p1.add(back);
		
        f1.setVisible(true);
	}
		
	class mywin extends WindowAdapter{
		          public void windowClosing(WindowEvent we){
		                    System.out.println("Exit via window x");
		                    f1.dispose();
		          }
		}
		
		class myAdd implements ActionListener{
                              public void actionPerformed(ActionEvent ae){
                                   System.out.println("Add");
                                   new Add();
                                   f1.dispose();
                   }		
		}
		
		class myDel implements ActionListener{
                              public void actionPerformed(ActionEvent ae){
                                  System.out.println("Delete");
                                    f1.dispose();
                                    new Del();
                     }		
		}
        class myRet implements ActionListener{
                              public void actionPerformed(ActionEvent ae){
                                  System.out.println("Retrieve");
                                     f1.dispose();
                                    new Ret();
                      }		
		}
 
        class myBack implements ActionListener{
            public void actionPerformed(ActionEvent ae){
                System.out.println("back");
                 f1.dispose();
                 new Login();
      }		
}
    public static void main(String a[]){
		new Employee();
	}   
}