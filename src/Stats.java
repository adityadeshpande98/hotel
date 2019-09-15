import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Stats {
        JPanel p1;
        JFrame f1;
        JTextField tnocust,trooms,tincome,tdam,tbill,tservices,tsecu,tstaff,tprofit;
        JLabel lnocust,lrooms,lincome,ldam,lbill,lservices,lsecu,lstaff,lprofit,bgl;
        JButton back;
        int h,w;
        Stats(){
            	f1=new JFrame("Stats");
		Dimension sc=Toolkit.getDefaultToolkit().getScreenSize();
                w=sc.width;
                h=sc.height;
                f1.setSize(w,h);
                p1=(JPanel) f1.getContentPane();
		f1.addWindowListener(new mywin());
                f1.setLayout(null);
                p1.setBackground(new Color(193,193,193));
                Font f = new Font("Ubuntu",Font.BOLD,14);
                
                ImageIcon img=new ImageIcon("C:\\Users\\adity\\OneDrive\\Documents\\NetBeansProjects\\mini1\\src\\stats.jpg");
                bgl=new JLabel("",img,JLabel.CENTER);
                bgl.setBounds(400, 0, w-400, h);
                
                lnocust=new JLabel("Total Customers:");
		lnocust.setBounds(50,100,100,50);
                lnocust.setForeground(new Color(0,0,0));
                lnocust.setFont(f);
                
                tnocust=new JTextField(100);
		tnocust.setBounds(150,110,150,25);
                tnocust.setText("");
                tnocust.setEditable(false);
                tnocust.setForeground(new Color(0,0,0));
                tnocust.setBackground(new Color(193,193,193));
                tnocust.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tnocust.setFont(f);
                
                lrooms=new JLabel("No. of Rooms:");
		lrooms.setBounds(50,150,100,50);
                lrooms.setForeground(new Color(0,0,0));
                lrooms.setFont(f);
                
                trooms=new JTextField(30);
		trooms.setBounds(150,160,150,25);
                trooms.setText("");
                trooms.setEditable(false);
                trooms.setForeground(new Color(0,0,0));
                trooms.setBackground(new Color(193,193,193));
                trooms.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                trooms.setFont(f);
                
                lincome=new JLabel("Total Income:");
		lincome.setBounds(50,200,100,50);
                lincome.setForeground(new Color(0,0,0));
                lincome.setFont(f);
                
                tincome=new JTextField(30);
		tincome.setBounds(150,210,150,25);
                tincome.setText("");
                tincome.setEditable(false);
                tincome.setForeground(new Color(0,0,0));
                tincome.setBackground(new Color(193,193,193));
                tincome.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tincome.setFont(f);
                
                ldam=new JLabel("Damages:");
		ldam.setBounds(50,250,150,50);
                ldam.setForeground(new Color(0,0,0));
                ldam.setFont(f);
                
                tdam=new JTextField(30);
		tdam.setBounds(150,260,150,25);
                tdam.setText("");
                tdam.setEditable(false);
                tdam.setForeground(new Color(0,0,0));
                tdam.setBackground(new Color(193,193,193));
                tdam.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tdam.setFont(f);
                
                lbill=new JLabel("Bills:");
		lbill.setBounds(50,300,150,50);
                lbill.setForeground(new Color(0,0,0));
                lbill.setFont(f);
                
                tbill=new JTextField(30);
		tbill.setBounds(150,310,150,25);
                tbill.setText("");
                tbill.setEditable(false);
                tbill.setForeground(new Color(0,0,0));
                tbill.setBackground(new Color(193,193,193));
                tbill.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tbill.setFont(f);
                
                lservices=new JLabel("Services:");
		lservices.setBounds(50,350,150,50);
                lservices.setForeground(new Color(0,0,0));
                lservices.setFont(f);
                
                tservices=new JTextField(30);
		tservices.setBounds(150,360,150,25);
                tservices.setText("");
                tservices.setEditable(false);
                tservices.setForeground(new Color(0,0,0));
                tservices.setBackground(new Color(193,193,193));
                tservices.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tservices.setFont(f);
                
                lsecu=new JLabel("Security:");
		lsecu.setBounds(50,400,150,50);
                lsecu.setForeground(new Color(0,0,0));
                lsecu.setFont(f);
                
                tsecu=new JTextField(30);
		tsecu.setBounds(150,410,150,25);
                tsecu.setText("");
                tsecu.setEditable(false);
                tsecu.setForeground(new Color(0,0,0));
                tsecu.setBackground(new Color(193,193,193));
                tsecu.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tsecu.setFont(f);
                
                lstaff=new JLabel("Staff Payments:");
		lstaff.setBounds(50,450,150,50);
                lstaff.setForeground(new Color(0,0,0));
                lstaff.setFont(f);
                
                tstaff=new JTextField(30);
		tstaff.setBounds(150,460,150,25);
                tstaff.setText("");
                tstaff.setEditable(false);
                tstaff.setForeground(new Color(0,0,0));
                tstaff.setBackground(new Color(193,193,193));
                tstaff.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tstaff.setFont(f);
                
                lprofit=new JLabel("Profits:");
		lprofit.setBounds(50,500,150,50);
                lprofit.setForeground(new Color(0,0,0));
                lprofit.setFont(f);
                
                tprofit=new JTextField(30);
		tprofit.setBounds(150,510,150,25);
                tprofit.setText("");
                tprofit.setEditable(false);
                tprofit.setForeground(new Color(0,0,0));
                tprofit.setBackground(new Color(193,193,193));
                tprofit.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tprofit.setFont(f);
                
		Cursor c1=new Cursor(Cursor.DEFAULT_CURSOR);
		f1.setCursor(c1);
                
                back=new JButton("Back");
		back.setBounds(50,600,150,50);
		back.setMnemonic('B');
		back.setToolTipText("Click Here");
                back.setBorder( new LineBorder(new Color(0,0,0)) );
                back.setBackground(new Color(193,193,193));
                back.setForeground(new Color(0,0,0));
                
                
                back.addActionListener(new myBack());
              
                
                p1.add(tnocust);
                p1.add(trooms);
                p1.add(tincome);
                p1.add(tdam);
                p1.add(tbill);
                p1.add(tservices);
                p1.add(tsecu);
                p1.add(tstaff);
                p1.add(tprofit);
               
                p1.add(bgl);
                
                p1.add(lnocust);
                p1.add(lrooms);
                p1.add(lincome);
                p1.add(ldam);
                p1.add(lbill);
                p1.add(lservices);
                p1.add(lsecu);
                p1.add(lstaff);
                p1.add(lprofit);
               
                p1.add(back);

		
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
                                   
                             
                        
			}		
		}
    class myBack implements ActionListener{
                              public void actionPerformed(ActionEvent ae){
                                  System.out.println("back");
                                   f1.dispose();
                                    new Admin();
                        }		
		}
   public static void main(String a[])
{
new Stats();
}   
     
   
}
