import java.sql.*;
import java.io.*;

class roominstall
	{
	public static void main(String args[])
		{
			
		try
			{
			int a,b,c,d;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject1","root","aditya");
			
			Statement st = con.createStatement();
			
			String str,s;
			for(a=1;a<=20;a++)
                        {
                        str = "insert into room values('"+a+"','Double','2','y','1000')";
			st.executeUpdate(str);
                        }
                        for(a=21;a<=40;a++)
                        {
                        str = "insert into room values('"+a+"','Delux','2','y','2500')";
			st.executeUpdate(str);
                        }
                        for(a=41;a<=50;a++)
                        {
                        str = "insert into room values('"+a+"','Cottage','2','y','3800')";
			st.executeUpdate(str);
                        }
                        for(a=51;a<=60;a++)
                        {
                        str = "insert into room values('"+a+"','Villa','4','y','5000')";
			st.executeUpdate(str);
                        }
			
			con.close();	
			
			}
		catch(Exception e)
			{
			System.out.println(""+e);
			}
		}
	}
