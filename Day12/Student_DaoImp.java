import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Student_DaoImp implements Student_Dao {
ConnectionEx conex=new ConnectionEx();
	@Override
	public List<StudentG> getAllStudents() {
		 List<StudentG>student=new ArrayList<StudentG>();
		 String query="SELECT * FROM student";
		try {
			Connection conn=conex.getConnection();
			Statement st=conn.createStatement();
			ResultSet res=st.executeQuery(query);
			while(res.next()) {
				StudentG std=new StudentG();
				std.setStudentID(res.getInt("studentID"));
				std.setName(res.getString("name"));
				std.setBatchID(res.getInt("batchID"));
				std.setPhone(res.getInt("phone"));
				std.setEmail(res.getString("email"));
				std.setPaymentStatus(res.getString("paymentStatus"));
				student.add(std);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public void addStudent(StudentG student) {
		String sql="INSERT INTO student values("+student.getStudentID()+","+"'"+student.getName()+"'"+","+student.getBatchID()+
				","+student.getPhone()+","+"'"+student.getEmail()+"'"+","+"'"+student.getPaymentStatus()+"'" +")";
		try {
			Connection conn= conex.getConnection();
			Statement st=conn.prepareStatement(sql);
			st.executeUpdate(sql);
			System.out.println("Record inserted to student for"+student.getName());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void getBatches() {
		String query="Select batchID FROM student where paymentStatus='NotPaid'";
		try {
			Connection conn= conex.getConnection();
			Statement st=conn.createStatement();
			ResultSet res=st.executeQuery(query);
		while( res.next()) {
			int BatchId=res.getInt("batchID");
			if(BatchId==1001) {
				System.out.println("Science");
			}else if(BatchId==1002) {
				System.out.println("Commerce");
			}else if(BatchId==1003) {
				System.out.println("Arts");
		}
		}	
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void batchStrength() {
		int count=0;
	String query="Select name from student where batchID=1001";
	try {
		Connection conn= conex.getConnection();
		Statement st=conn.createStatement();
		ResultSet res=st.executeQuery(query);
	while( res.next()) {
		count+=1;
        res.getString("name");
	}
	System.out.println("Strength of science batch is"+count);
	} catch (SQLException e) {
		e.printStackTrace();
	}

	
	}

}
