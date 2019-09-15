import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class newCust{
        JPanel p1;
        JFrame f1;        
        JTextField tname,tno,tidno;
        JLabel lname,lno,lid,lidno,bgl;
        Choice id;
        JButton addcust;
        int h,w;
        newCust()
        {
          f1=new JFrame("Check in");
		Dimension sc=Toolkit.getDefaultToolkit().getScreenSize();
                w=sc.width;
                h=sc.height;
                f1.setSize(w,h);
                p1=(JPanel) f1.getContentPane();
		f1.addWindowListener(new newCust.mywin());
                f1.setLayout(null);  
                p1.setBackground(new Color(11,10,6));
                Font f = new Font("Ubuntu",Font.BOLD,14);
                
                bgl=new JLabel();
                ImageIcon img=new ImageIcon("C:\\Users\\adity\\OneDrive\\Documents\\NetBeansProjects\\mini1\\src\\newcust.jpg");
                bgl=new JLabel("",img,JLabel.CENTER);
                bgl.setBounds(400, 0, w-400, h);
                
                lno=new JLabel("Customer ID:");
		lno.setBounds(50,100,100,50);
                lno.setForeground(new Color(239,199,84));
                lno.setFont(f);
                
                tno=new JTextField(30);
		tno.setBounds(180,110,150,25);
                tno.setForeground(new Color(239,199,84));
                tno.setBackground(new Color(11,10,6));
                tno.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tno.setFont(f);
                
                lname=new JLabel("Customer Name:");
		lname.setBounds(50,150,150,50);
                lname.setForeground(new Color(239,199,84));
                lname.setFont(f);
                
                tname=new JTextField(30);
		tname.setBounds(180,160,150,25);
                tname.setForeground(new Color(239,199,84));
                tname.setBackground(new Color(11,10,6));
                tname.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tname.setFont(f);
                
                lid=new JLabel("Identification:");
		lid.setBounds(50,200,100,50);
                lid.setForeground(new Color(239,199,84));
                lid.setFont(f);
                
                addcust=new JButton("Add Customer");
		addcust.setBounds(50,350,200,50);
		addcust.setMnemonic('A');
		addcust.setToolTipText("Click Here");
                addcust.setBorder( new LineBorder(new Color(239,199,84)) );
                addcust.setBackground(new Color(11,10,6));
                addcust.setForeground(new Color(239,199,84));
                
                addcust.addActionListener(new myadd());
                
                id=new Choice();
		id.setBounds(180,210,150,25);
                id.add("Select ID");
		id.add("Adhaar"); 
		id.add("Pan Card"); 	
		id.add("Lisence");
                id.add("Voter's ID");
                id.setForeground(new Color(239,199,84));
                id.setBackground(new Color(11,10,6));
                id.setFont(f);  
                
                lidno=new JLabel("Identification No.:");
		lidno.setBounds(50,250,250,50);
                lidno.setForeground(new Color(239,199,84));
                lidno.setFont(f);
                
                tidno=new JTextField(30);
		tidno.setBounds(180,260,150,25);              
                tidno.setForeground(new Color(239,199,84));
                tidno.setBackground(new Color(11,10,6));
                tidno.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tidno.setFont(f);
                
                setId();
                p1.add(tname);
                p1.add(lname);
                p1.add(tno);
                p1.add(lno);
                p1.add(id);
                p1.add(lid);
                p1.add(tidno);
                p1.add(lidno);
                p1.add(bgl);
                p1.add(addcust);
                f1.setVisible(true);
        }

        void setId() {
        
            try {
                
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(newCust.class.getName()).log(Level.SEVERE, null, ex);
                }
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject1","root","aditya");
                Statement st = con.createStatement();
                ResultSet rs;
                String str;
                
                str="SELECT * FROM customer WHERE cid=(SELECT MAX(cid) FROM customer);";
                rs=st.executeQuery(str);
                rs.next();
                
                int id=rs.getInt(1);
                tno.setText(Integer.toString(id+1));
            } catch (SQLException ex) {
                Logger.getLogger(newCust.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


 

    class myadd implements ActionListener{
              public void actionPerformed(ActionEvent ae){
                  try{
                        System.out.println("Add Customer");
                        int custidno,custno;
                        String custname,custid;
                        custname=(String)tname.getText();
                        custid=(String)id.getSelectedItem();
                        custidno=Integer.parseInt(tidno.getText());
                        custno=Integer.parseInt(tno.getText());

                        try
                            {
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject1","root","aditya");
                                Statement st = con.createStatement();
                                ResultSet rs;
                                String str,str2;

                                str="select * from customer where cid="+custno;
                                rs=st.executeQuery(str);
                                if(!rs.next())
                                {
                                    str2="insert into customer(cid,cname,id,idno)values('"+custno+"','"+custname+"','"+custid+"','"+custidno+"')";
                                    st.executeUpdate(str2);
                                    JOptionPane.showMessageDialog(f1,"Customer Added","Save Record",JOptionPane.INFORMATION_MESSAGE);
                                    new checkin();
                                    f1.dispose();
                                }
                                else
                                {
                                     JOptionPane.showMessageDialog(f1,"Customer ID Already Exists","Error",JOptionPane.INFORMATION_MESSAGE);
                                }
                                rs.close();
                                con.close();
                            }
                        catch(Exception e)
                            {
                            }
                  }
                  catch(NumberFormatException e)
                  {                  
                  }
              }
    
    }     
    
  
    
    class mywin extends WindowAdapter{
        public void windowClosing(WindowEvent we){
            System.out.println("Exit via window x");
            f1.dispose();
        }
    }
 public static void main(String a[]){
		new newCust();
	}  
}
