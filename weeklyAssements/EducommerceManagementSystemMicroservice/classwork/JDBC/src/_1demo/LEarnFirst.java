package _1demo;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class LEarnFirst {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sql="Select job from emp where ename='james'";
		String sql2="Insert into gurp(id, name) values (101, 'hani'), (102, 'gui'), (103, 'tim')";
		String url="jdbc:mysql://localhost:3306/scott";
		String username="root";
		String password="Hani@2004";
		try {
			Connection conn=DriverManager.getConnection(url, username, password);
			Statement st=conn.createStatement();
		
			ResultSet rs=st.executeQuery(sql);
			rs.next();
			String job=rs.getString(1);
			System.out.println(job);
	
			int rows=st.executeUpdate(sql2);
			System.out.println(rows+" row inserted successfully");
			conn.close();
			
		}
		catch(Exception e) {
			System.out.println("exception has come");
		}
	}
}
