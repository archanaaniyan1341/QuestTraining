package managementdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

	public class Student_DaoImp implements Student_Dao {
		ConnectionEx conex=new ConnectionEx();
			@Override
			public List<Student> getAllStudents() {
				 List<Student>student=new ArrayList<Student>();
				 String query="SELECT * FROM student";
				try {
					Connection conn=conex.getConnection();
					Statement st=conn.createStatement();
					ResultSet res=st.executeQuery(query);
					while(res.next()) {
						Student std=new Student();
						std.setStudent_id(res.getInt("student_id"));
						std.setFirst_name(res.getString("first_name"));
						std.setLast_name(res.getString("last_name"));
						std.setBatch_id(res.getInt("batch_id"));
						std.setGender(res.getString("gender"));
						
						student.add(std);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				return student;
			}

			@Override
			public void addStudent(Student student,Fee fee) {
				String sql="INSERT INTO student values("+student.getStudent_id()+","+"'"+student.getFirst_name()+"'"+","+"'"+student.getLast_name()+"'"+","+student.getBatch_id()+
						","+"'"+student.getGender()+"'"+")";
				String sql2="INSERT INTO fee_details values("+fee.getPayment_id()+","+fee.getStudent_id()+","+fee.getPayment_amount()+","+"'"+fee.getPayment_status()+"'"+")";
				try {
					Connection conn= conex.getConnection();
					Statement st=conn.prepareStatement(sql);
					Statement st2=conn.prepareStatement(sql2);
					st.executeUpdate(sql);
					st2.executeUpdate(sql2);
					System.out.println("Record inserted to student for"+student.getFirst_name());
					
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
			@Override
			public void getBatches() {
				String query="select student.first_name,fee_details.payment_status,batch_details.batch_name from (student join fee_details"
						+ " on student.student_id=fee_details.student_id) join batch_details "	
						+"on student.batch_id=batch_details.batch_id where "
						+ "fee_details.payment_status='NotPaid';" ;
				try {
					Connection conn= conex.getConnection();
					Statement st=conn.createStatement();
					ResultSet res=st.executeQuery(query);
				while( res.next()) {
					System.out.println(res.getString("first_name")+" "+res.getString("batch_name"));
				}	
				} catch (SQLException e) {
					e.printStackTrace();
				}

				
			}

			@Override
			public void batchStrength() {
				int count=0;
			String query="Select first_name from student where batch_id=1001";
			try {
				Connection conn= conex.getConnection();
				Statement st=conn.createStatement();
				ResultSet res=st.executeQuery(query);
			while( res.next()) {
				count+=1;
		        res.getString("first_name");
			}
			System.out.println("Strength of science batch is"+count);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			}
}
