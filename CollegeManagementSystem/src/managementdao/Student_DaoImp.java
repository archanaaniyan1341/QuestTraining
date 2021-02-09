package managementdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Student_DaoImp implements Student_Dao {
	static  Connection conn = DatabaseConnection.getConnection();

	@Override
	public List<Student> getAllStudents() {
		List<Student> student = new ArrayList<Student>();
		String query = "SELECT * FROM student";
		try(Connection conn = DatabaseConnection.getConnection()) {

			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				Student std = new Student();
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
	public void addStudent(Student student, Fee fee) throws SQLException  {
		try {
			conn.setAutoCommit(false);
			try(Statement stmt = conn.createStatement()){
				String sql1 = "INSERT INTO student values(" + student.getStudent_id() + "," + "'" + student.getFirst_name()
				+ "'" + "," + "'" + student.getLast_name() + "'" + "," + student.getBatch_id() + "," + "'"
				+ student.getGender() + "'" + ");";
		String sql3 = "INSERT INTO fee_details values(" + fee.getPayment_id() + "," + fee.getStudent_id() + ","
				+ fee.getPayment_amount() + "," + "'" + fee.getPayment_status() + "'" + ");";
			PreparedStatement st1 = conn.prepareStatement(sql1);
			PreparedStatement st3 = conn.prepareStatement(sql3);
			st1.executeUpdate();
			st3.executeUpdate();
			conn.commit();
			System.out.println("Record inserted to student for" + student.getFirst_name());
		}
			} catch (Exception e) { 
		    conn.rollback();
			System.out.println(e);
		}
	}

	@Override
	public void getBatches() {
		String query = "select student.first_name,fee_details.payment_status,batch_details.batch_name from (student join fee_details"
				+ " on student.student_id=fee_details.student_id) join batch_details "
				+ "on student.batch_id=batch_details.batch_id where " + "fee_details.payment_status='NotPaid';";
		try {
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				System.out.println(res.getString("first_name") + " " + res.getString("batch_name"));
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void batchStrength() {
		int count = 0;
		String query = "Select first_name from student where batch_id=1001";
		try {
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				count += 1;
				res.getString("first_name");
			}
			System.out.println("Strength of science batch is" + count);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
