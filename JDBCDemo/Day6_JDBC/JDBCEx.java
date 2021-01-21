import java.sql.*;                                                     
import java.util.Scanner;
public class JDBCEx {

	public static void main(String[] args) {
		try {
			Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1","root","root");
		Statement myStmt=myConn.createStatement();
		ResultSet myRs=myStmt.executeQuery("select * from customer");
		while (myRs.next()) {
			System.out.println(myRs.getString("name")+" "+myRs.getString("marks"));
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a name");
		String name=sc.next();
		String q="Select Marks from customer where Name='"+name+"'";
		ResultSet res=myStmt.executeQuery(q);
		while(res.next()) {
		System.out.println("Marks for "+name+" is "+res.getString("Marks"));}
		sc.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
