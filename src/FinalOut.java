import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import com.itextpdf.text.BaseColor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.border.LineBorder;

public class FinalOut {
        JPanel p1;
        JFrame f1;
        JTextField tname,tno,ttype,tdays,trent,tdatein,tdateout,trenttot;
        JLabel lname,lno,ltype,ldays,lrent,ldatein,ldateout,lrenttot,bgl;
        JButton back,search,out;
        int h,w;
        FinalOut(){
            	f1=new JFrame("Check Out");
		Dimension sc=Toolkit.getDefaultToolkit().getScreenSize();
                w=sc.width;
                h=sc.height;
                f1.setSize(w,h);
                p1=(JPanel) f1.getContentPane();
		f1.addWindowListener(new mywin());
                f1.setLayout(null);
                
                p1.setBackground(new Color(252,214,126));
                java.awt.Font f = new java.awt.Font("Ubuntu",java.awt.Font.BOLD,14);
		
                bgl=new JLabel();
                ImageIcon img=new ImageIcon("C:\\Users\\adity\\OneDrive\\Documents\\NetBeansProjects\\mini1\\src\\finalout.jpg");
                bgl=new JLabel("",img,JLabel.CENTER);
                bgl.setBounds(400, 0, w-400, h);
                
                
                lno=new JLabel("Room No.:");
		lno.setBounds(50,100,90,50);
                lno.setForeground(new Color(97,92,87));
                lno.setFont(f);
                
                tno=new JTextField(100);
		tno.setBounds(150,110,150,25);
                tno.setText("");
                tno.setBackground(new Color(252,214,126));
                tno.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tno.setFont(f);
                
                
                lname=new JLabel("Name:");
		lname.setBounds(50,150,100,50);
                lname.setForeground(new Color(97,92,87));
                lname.setFont(f);
                
                tname=new JTextField(100);
		tname.setBounds(150,160,150,25);
                tname.setText("");
                tname.setBackground(new Color(252,214,126));
                tname.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tname.setFont(f);
                
                ltype=new JLabel("Room Type:");
		ltype.setBounds(50,200,100,50);
                ltype.setForeground(new Color(97,92,87));
                ltype.setFont(f);
                
                ttype=new JTextField(100);
		ttype.setBounds(150,210,150,25);
                ttype.setText("");
                ttype.setEditable(false);
                ttype.setBackground(new Color(252,214,126));
                ttype.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                ttype.setFont(f);
                
                lrent=new JLabel("Room Rent:");
		lrent.setBounds(50,250,100,50);
                lrent.setForeground(new Color(97,92,87));
                lrent.setFont(f);
                
                trent=new JTextField(100);
		trent.setBounds(150,260,150,25);
                trent.setText("");
                trent.setEditable(false);
                trent.setBackground(new Color(252,214,126));
                trent.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                trent.setFont(f);
                
                ldays=new JLabel("No. of days:");
		ldays.setBounds(50,300,100,50);
                ldays.setForeground(new Color(97,92,87));
                ldays.setFont(f);
                
                tdays=new JTextField(100);
		tdays.setBounds(150,310,150,25);
                tdays.setText("");
                tdays.setEditable(false);
                tdays.setBackground(new Color(252,214,126));
                tdays.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tdays.setFont(f);
                
                ldatein=new JLabel("Check In Date:");
		ldatein.setBounds(50,350,200,50);
                ldatein.setForeground(new Color(97,92,87));
                ldatein.setFont(f);
                
                tdatein=new JTextField(100);
		tdatein.setBounds(150,360,150,25);
                tdatein.setText("");
                tdatein.setEditable(false);
		tdatein.setBackground(new Color(252,214,126));
                tdatein.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tdatein.setFont(f);
                
                ldateout=new JLabel("Check Out Date:");
		ldateout.setBounds(50,400,230,50);
                ldateout.setForeground(new Color(97,92,87));
                ldateout.setFont(f);
                
                tdateout=new JTextField(100);
		tdateout.setBounds(160,410,145,25);
                tdateout.setText("");
                tdateout.setEditable(false);
                tdateout.setBackground(new Color(252,214,126));
                tdateout.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                tdateout.setFont(f);
                
                lrenttot=new JLabel("Total Rent:");
		lrenttot.setBounds(50,450,100,50);
                lrenttot.setForeground(new Color(97,92,87));
                lrenttot.setFont(f);
                
                trenttot=new JTextField(100);
		trenttot.setBounds(150,460,150,25);
                trenttot.setText("");
                trenttot.setEditable(false);
                trenttot.setBackground(new Color(252,214,126));
                trenttot.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
                trenttot.setFont(f);
                
                Cursor c1=new Cursor(Cursor.DEFAULT_CURSOR);
		f1.setCursor(c1);
                
                back=new JButton("Back");
		back.setBounds(50,530,100,50);
		back.setMnemonic('B');
		back.setToolTipText("Click Here");
                back.setBorder( new LineBorder(new Color(97,92,87)) );
                back.setBackground(new Color(252,214,126));
                back.setForeground(new Color(97,92,87));
                
                out=new JButton("Check Out");
		out.setBounds(75,600,150,50);
		out.setMnemonic('C');
		out.setToolTipText("Click Here");
                out.setBorder( new LineBorder(new Color(97,92,87)) );
                out.setBackground(new Color(252,214,126));
                out.setForeground(new Color(97,92,87));
                
                search=new JButton("Search");
		search.setBounds(160,530,100,50);
		search.setMnemonic('S');
		search.setToolTipText("Click Here");
                search.setBorder( new LineBorder(new Color(97,92,87)) );
                search.setBackground(new Color(252,214,126));
                search.setForeground(new Color(97,92,87));
                
                
                back.addActionListener(new myBack());
                out.addActionListener(new myOut());
                search.addActionListener(new mySearch());
                
                p1.add(bgl);
                p1.add(tno);
                p1.add(tname);
                p1.add(ttype);
                p1.add(trent);
                p1.add(tdays);
                p1.add(tdatein);
                p1.add(tdateout);
                p1.add(trenttot);
                
                p1.add(lno);
                p1.add(lname);
                p1.add(ltype);
                p1.add(lrent);
                p1.add(ldays);
                p1.add(ldatein);
                p1.add(ldateout);
                p1.add(lrenttot);
                
                p1.add(back);
                p1.add(out);
		p1.add(search);
                
                f1.setVisible(true);
        }
    
    
    
    class mywin extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent we){
            System.out.println("Exit via window x");
            f1.dispose();
        }
    }

    void clear()
        {
           tname.setText("");
           tno.setText("");
           ttype.setText("");
           trent.setText("");
           tdays.setText("");
           tdatein.setText("");
           tdateout.setText("");
           trenttot.setText("");
        }
    
    
    void myBill(int rent,int rno,String indate,String outdate) 
    {
                System.out.println("Bill");
                try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","ketki");
                Statement s=con.createStatement(); 
               
                    
                ResultSet rs;
		System.out.println("0");
		String q="select * from customer where cid=(select cid from checkin where rno="+rno+");";
                s=con.createStatement();
                rs=s.executeQuery(q);
                rs.next();
                String name=rs.getString(2);
                System.out.println("1");
                int Id=rs.getInt(1);
                String str4="select tid from checkin where rno="+rno+" and cid="+Id;
                rs=s.executeQuery(str4);
                rs.next();
                int tid=rs.getInt("tid");
                String q1="select * from bill where tid="+tid+" and cid="+Id;
                s=con.createStatement();
                System.out.println("1");
                rs=s.executeQuery(q1);
                rs.next();  
                System.out.println("bill");
                System.out.println("2");
                int cab=rs.getInt("cab");
                System.out.println("3");
                int tea=rs.getInt("refresh");
                System.out.println("4");
                int damage=rs.getInt("dam");
                System.out.println("5");
                int tot_bill=cab+tea+damage+rent;
                System.out.println("6");

       
                 
                        
                        float fi=(float) (tot_bill*1.18); 
                        String sdf=String.format("%.2f",fi);
                        
                        String tbill=Integer.toString(tot_bill);
                        String srent=Integer.toString(rent);
                        String sdam=Integer.toString(damage);
                        String refr=Integer.toString(tea);
                        String scab=Integer.toString(cab);
                         
                         Document document = new Document();
		     
                        System.out.println("---2");
		        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(Id+" "+outdate+".pdf"));
		        document.open();
                        
                        Font inv= FontFactory.getFont(FontFactory.COURIER_OBLIQUE, 20, BaseColor.BLACK);
                        Paragraph invTitle = new Paragraph("INVOICE", inv);
                        invTitle.setAlignment(Element.ALIGN_RIGHT);
                        document.add(invTitle);
                                       
                                                                      
                         Font titleFont = FontFactory.getFont(FontFactory.COURIER_BOLD, 18, BaseColor.BLACK);
                         Paragraph docTitle = new Paragraph("The Regimental", titleFont);
                         docTitle.setAlignment(Element.ALIGN_RIGHT);
                         document.add(docTitle);
                        
                         Font addtitleFont = FontFactory.getFont(FontFactory.COURIER_BOLD, 10, BaseColor.BLACK);
                         Paragraph adddocTitle = new Paragraph("Plot no. 36,KarveNagar,Pune-36\n", addtitleFont);
                         adddocTitle.setAlignment(Element.ALIGN_RIGHT);
                         document.add(adddocTitle);
                      
                              document.add(new Paragraph("\n-------------------------------------------------------------------------------------------------------------------------- "));
                        // document.add(new Paragraph("\n "));
                           
                         document.add(new Paragraph("\n "));
                        document.add(new Paragraph(" Bill No. "+tid));
                        document.add(new Paragraph(" Customer Id: "+Id));
                        document.add(new Paragraph(" Customer Name: "+name));
                        
                        document.add(new Paragraph(" Room No. "+rno));
                        
                       // document.add(new Paragraph(""));
                        document.add(new Paragraph(" Arrival Date : "+indate+" \t Departure Date : "+outdate)); 
                        //document.add(new Paragraph("")); 
                        document.add(new Paragraph("\n ")); 
                        
                           PdfPTable table = new PdfPTable(3); 
   
    PdfPCell cell1 = new PdfPCell(new Paragraph("Sr. No"));
    PdfPCell cell2 = new PdfPCell(new Paragraph("Particulars"));
    PdfPCell cell3 = new PdfPCell(new Paragraph("Amount"));
    PdfPCell cell4 = new PdfPCell(new Paragraph("1."));
    PdfPCell cell5 = new PdfPCell(new Paragraph("Room Rent"));
    PdfPCell cell6 = new PdfPCell(new Paragraph(srent));
    PdfPCell cell7 = new PdfPCell(new Paragraph("2."));
    PdfPCell cell8 = new PdfPCell(new Paragraph("Cab"));
    PdfPCell cell9 = new PdfPCell(new Paragraph(scab));
    PdfPCell cell10 = new PdfPCell(new Paragraph("3."));
    PdfPCell cell11 = new PdfPCell(new Paragraph("Refreshments"));
    PdfPCell cell12 = new PdfPCell(new Paragraph(refr));
    PdfPCell cell13 = new PdfPCell(new Paragraph("4."));
    PdfPCell cell14 = new PdfPCell(new Paragraph("Damage"));
    PdfPCell cell15 = new PdfPCell(new Paragraph(sdam));
    PdfPCell cell16 = new PdfPCell(new Paragraph("5."));
    PdfPCell cell17 = new PdfPCell(new Paragraph("Gross Total"));
    PdfPCell cell18 = new PdfPCell(new Paragraph(tbill));
    PdfPCell cell19 = new PdfPCell(new Paragraph("6."));
    PdfPCell cell20 = new PdfPCell(new Paragraph("GST"));
    PdfPCell cell21 = new PdfPCell(new Paragraph("18%"));
    PdfPCell cell22 = new PdfPCell(new Paragraph("7."));
    PdfPCell cell23 = new PdfPCell(new Paragraph("Total Bill"));
    PdfPCell cell24 = new PdfPCell(new Paragraph(sdf));
    
    
    
    table.addCell(cell1);
    table.addCell(cell2);
    table.addCell(cell3);
    table.addCell(cell4);
    table.addCell(cell5);
    table.addCell(cell6);
    table.addCell(cell7);
    table.addCell(cell8);
    table.addCell(cell9);
    table.addCell(cell10);
    table.addCell(cell11);
    table.addCell(cell12);
    table.addCell(cell13);
    table.addCell(cell14);
    table.addCell(cell15);
    table.addCell(cell16);
    table.addCell(cell17);
    table.addCell(cell18);
    table.addCell(cell19);
    table.addCell(cell20);
    table.addCell(cell21);
    table.addCell(cell22);
    table.addCell(cell23);
    table.addCell(cell24);
    document.add(table);
        
                     
                         
		   
                        
                        
                        
		         document.close();
		         writer.close();
		         System.out.println("Done");
		      } catch (DocumentException e)
		      {
		         e.printStackTrace();
		      } catch (FileNotFoundException e)
		      {
		         e.printStackTrace();
		      }
                      
                     catch(Exception e)
                     {}
    }
    
    
    class myOut implements ActionListener{
                              @Override
                              public void actionPerformed(ActionEvent ae){
                                    String cname,rtype,indate,outdate;
                                    int rno,rrent,duration,tot_rent,cab,dam,refresh;
                                    cname=tname.getText();
                                    rrent=Integer.parseInt(trent.getText());
                                    rtype=ttype.getText();
                                    indate=tdatein.getText();
                                    outdate=tdateout.getText();
                                    rno=Integer.parseInt(tno.getText());
                                    duration=Integer.parseInt(tdays.getText());
                                    tot_rent=Integer.parseInt(trenttot.getText());
                                   System.out.println("Check Out");
                                
                                   try
                                   {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject1","root","aditya");
                                    
                                    ResultSet rs;
                                    String str,str2,str3,str4,str5,str1;
                                    System.out.println("Check Out1");
                                    
                                    
                                    
                                    str1="select * from checkin where rno="+rno;
                                    Statement st;
                                    st = con.createStatement();
                                    rs = st.executeQuery(str1);
                                    rs.next();    
                                    int cid=rs.getInt(6);
                                    System.out.println(cid);
                                    int tid=rs.getInt(1);
                                    str4="select * from services where rno="+rno;
                                    rs=st.executeQuery(str4);
                                    rs.next();
                                    refresh=rs.getInt(3);
                                    cab=rs.getInt(4);
                                    dam=rs.getInt(5);
                                    System.out.println("Check Out2"+refresh+cab+dam);
                                    System.out.println("Check Out3"+cname+rtype+rrent+duration+indate+outdate+rno+tot_rent);
                                    str="insert into checkout(cname,rtype,rrent,duration,indate,outdate,rno,tot_rent)values('"+cname+"','"+rtype+"','"+rrent+"',"+duration+",'"+indate+"','"+outdate+"',"+rno+","+tot_rent+");";
                                    System.out.println(str);
                                    st = con.createStatement();
                                    st.executeUpdate(str);
                                    System.out.println("Check Out4");
                                    
                                    str5="insert into bill (tid,rno,cid,rent,refresh,cab,dam,tot_bill)values("+tid+","+rno+","+cid+","+rrent+","+refresh+","+cab+","+dam+","+tot_rent+");";
                                    st = con.createStatement();
                                    st.executeUpdate(str5);
                                    System.out.println("Check Out5");
////                                    
                                    System.out.println("1");
                                    str2 = "update room set avail='y' where rno="+rno;
                                    st = con.createStatement();
                                    st.executeUpdate(str2);
                                    System.out.println("Check Out");
                                    myBill(rrent,rno,indate,outdate);
                                    str3 = "delete from checkin where rno="+rno;
                                    st = con.createStatement();
                                    st.executeUpdate(str3);
                                    String str6 = "delete from services where rno="+rno;
                                    st = con.createStatement();
                                    st.executeUpdate(str6);
                                    
//                                    
                                    JOptionPane.showMessageDialog(f1,"Checked Out Successfully","Check Out",JOptionPane.INFORMATION_MESSAGE);
                                    con.close();
                                       System.out.println("Final Done");
                                   
                                    clear();
                                   }
                                   catch(Exception e)
                                   {
                                       
                                   }
                                   
                             
                        
			}		
		}
    class myBack implements ActionListener{
                              @Override
                              public void actionPerformed(ActionEvent ae){
                                  System.out.println("back");
                                   f1.dispose();
                                   new Menu();
                        }		
		} 


        class mySearch implements ActionListener{
                              public void actionPerformed(ActionEvent ae){
                                  try{
                                      System.out.println("Search");
                                  String in_date;
                                  int rent,tot_rent,tot_days,cab,dam,refresh;
                                  //String cname = tname.getText();
                                  int cno = Integer.parseInt(tno.getText());
                                  LocalDate c_date = LocalDate.now();
                                  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-LL-dd");
                                  String sdate=c_date.format(formatter);
                                  try
                                     {
                                      Class.forName("com.mysql.jdbc.Driver");
                                      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject1","root","aditya");
                                      Statement st = con.createStatement();
                                      ResultSet rs,rs2,rs3;
                                      String str,str2,str4,str1;
                                      
                                    str1="select * from customer where cid=(select cid from checkin where rno="+cno+");";
                                    st=con.createStatement();
                                    rs=st.executeQuery(str1);
                                    rs.next();
                                    String name=rs.getString(2);
                                      
                                      
                                      str = "select * from checkin as c,room as r where c.rno = "+cno+" and c.rno=r.rno ";
                                      rs = st.executeQuery(str);
                                      if(rs.next())
                                          {
                                              

                                              System.out.println("Search");    
                                              rent=rs.getInt(12);
                                              String r_type=rs.getString(9);  
                                              in_date = rs.getString(2);
                                              str2="select datediff('"+sdate+"','"+in_date+"') as tot from checkin where rno="+cno;
                                              rs2 = st.executeQuery(str2);
                                              rs2.next(); 
                                              
                                              tname.setText(name);
                                              ttype.setText(r_type);
                                              tdatein.setText(in_date);
                                              tdateout.setText(sdate);
                                              tot_days=rs2.getInt(1);
                                              tdays.setText(tot_days+"");
                                              if(tot_days!=0)
                                              rent=rent*tot_days;
                                              else
                                                  rent=rent*1;
                                              trent.setText(rent+"");
                                               System.out.println("1");
                                              str4="select * from services where rno="+cno;
                                              rs3=st.executeQuery(str4);
                                              rs3.next();
                                              System.out.println("2");
                                              refresh=rs3.getInt("refresh");
                                              System.out.println("1");
                                              cab=rs3.getInt("cab");
                                              System.out.println("1");
                                              dam=rs3.getInt("damage");
                                              System.out.println("3");
                                              tot_rent=rent+cab+dam+refresh;
                                               
                                              trenttot.setText(tot_rent+"");
                                          }
                                      else
                                          {
                                              JOptionPane.showMessageDialog(f1,"Invalid Data","Error",JOptionPane.INFORMATION_MESSAGE);
                                          }   rs.close();
                                    
                                      
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
    
    /**
     *
     * @param a
     */
    public static void main(String a[])
{
            FinalOut finalOut = new FinalOut();
}   
}