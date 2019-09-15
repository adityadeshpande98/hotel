import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class customer {
        JPanel p1;
        JFrame f1;
        JButton ecust,ncust;
        JLabel bg;
        ImageIcon img;
        int h,w;
        customer()
        {
          f1=new JFrame("Check in");
		Dimension sc=Toolkit.getDefaultToolkit().getScreenSize();
                w=sc.width;
                h=sc.height;
                f1.setSize(w,h);
                p1=(JPanel) f1.getContentPane();
		f1.addWindowListener(new customer.mywin());
                f1.setLayout(null);  
                
                ImageIcon img=new ImageIcon("C:\\Users\\adity\\OneDrive\\Documents\\NetBeansProjects\\mini1\\src\\cust.jpg");
                bg=new JLabel("",img,JLabel.CENTER);
                bg.setBounds(0, 0, w, h);
                bg.setBorder(new LineBorder(Color.black));
                
                ecust=new JButton("Existing Customer");
		ecust.setBounds(w/2-500,300,200,75);
		ecust.setMnemonic('E');
		ecust.setToolTipText("Click Here");
                
                ncust=new JButton("New Customer");
		ncust.setBounds(w/2+250,300,200,75);
		ncust.setMnemonic('N');
		ncust.setToolTipText("Click Here");
                
                
                ecust.setForeground(new Color(255,255,255));
                ecust.setBackground(new Color(0,0,21));
                ecust.setBorder( new LineBorder(Color.white) );
               
                ncust.setForeground(new Color(0,0,21));
                ncust.setBackground(new Color(255,255,255));
               
                ncust.setBorder( new LineBorder(new Color(0,0,21)) );
     
          
               
                
                ecust.addActionListener(new existing());
                ncust.addActionListener(new newcust());
                
                p1.add(bg);
                p1.add(ecust);
                p1.add(ncust);
                f1.setVisible(true);
        }


    class existing implements ActionListener{
              public void actionPerformed(ActionEvent ae){
                  new checkin();
                  f1.dispose();
                  
              }
    
    }     
    
     class newcust implements ActionListener{
              public void actionPerformed(ActionEvent ae){
                  new newCust();
                  f1.dispose();
              }
    
    }  
    
    
    class mywin extends WindowAdapter{
        public void windowClosing(WindowEvent we){
            System.out.println("Exit via window x");
            f1.dispose();
        }
    }
    
    
    
public static void main(String a[])
{
new customer();
} 

}
