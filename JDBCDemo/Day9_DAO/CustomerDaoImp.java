import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImp implements CustomerDao{

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer>customerList=new ArrayList<Customer>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1", "root", "root");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT* FROM customer");
		while(rs.next()) {
			Customer customer =new Customer();
			customer.setId(rs.getInt("ID"));
			customer.setName(rs.getString("Name"));
			customer.setGender(rs.getString("Gender"));
			customer.setStream(rs.getString("Stream"));
			customer.setMarks(rs.getInt("Marks"));
			customerList.add(customer);
		}
		}catch(Exception e) {
			System.out.println(e);
			}
		return customerList;
	}

	@Override
	public int getCustomerMark(String name) {
	int marks=0;	
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1", "root", "root");
		Statement stmt=con.createStatement();
		ResultSet res=stmt.executeQuery("SELECT Marks FROM customer where name=' "+name+"'");
		while(res.next()) {
			marks=res.getInt("Marks");
			
		}
		}catch(Exception e) {
			System.out.println(e);
			}
		return marks;
	}

}
