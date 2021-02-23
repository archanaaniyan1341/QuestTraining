package com.model.service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.database.ConnectorClass;
import com.model.example.Student;

public class  StudentDaoImp implements StudentDao {
	ConnectorClass connector=new ConnectorClass();

	@Override
	public  List<Student> listAllStudents() {
		List <Student>students=new ArrayList<Student>();
		
		 try {	
			 Connection connection = connector.getConnection();
		Statement st=connection.createStatement();
		ResultSet res=st.executeQuery("SELECT * FROM student");
		while(res.next()) {
		 Student std=new Student();
		 std.setId(res.getInt("id"));
		 std.setName(res.getString("name"));
		 std.setGender(res.getString("gender"));
		 std.setStream(res.getString("stream"));
		 std.setMarks(res.getInt("marks"));
		 students.add(std);
		} 
		 }catch (SQLException e) {
						e.printStackTrace();
		}
		
		return students;
	}

	@Override
	public Student getStudent(int id) {
		String	student=" ";
		 try {	
			Connection connection = connector.getConnection();
			Statement st=connection.createStatement();
			ResultSet res=st.executeQuery("SELECT * FROM student where id="+id);
			while(res.next()) {
				 Student std=new Student();
				 std.setId(res.getInt("id"));
				 std.setName(res.getString("name"));
				 std.setGender(res.getString("gender"));
				 std.setStream(res.getString("stream"));
				 std.setMarks(res.getInt("marks"));
				 return std;
			} 
		 }catch (SQLException e) {
						e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public Student addStudent(Student student) {
		 String sql = "insert into student values(" + student.getId() + ","             + "'" + student.getName()+"'"+  ","   + "'" + student.getGender() +"'"+ ","   +
					"'" + student.getStream()+"'" + ","   + student.getMarks()            + ")";

		 try {	
				Connection connection = connector.getConnection();
								 Statement st=connection.prepareStatement(sql);
				 st.executeUpdate(sql);
				   System.out.println("Record is inserted into Employee table for  Employee : " + student.getName());

			 }catch (SQLException e) {
							e.printStackTrace();
			}
		return student;
	}

	@Override
	public void deleteStudent(int id) {
		 try {	
				Connection connection = connector.getConnection();
				  String del = "delete from student where id="+id;
				 Statement st=connection.prepareStatement(del);
				 st.executeUpdate(del);
			 }catch (SQLException e) {
							e.printStackTrace();
			}	
	}

	@Override
	public Student updateStudent(Student student) {
		 try {	
				Connection connection = connector.getConnection();
				  String upd = "update student set name=" + "'" + student.getName() + "'"+"," +"Gender="+"'"+student.getGender()+"'"+","+"stream="+"'"+student.getStream()+"'"+","
				+"marks="+student.getMarks()+" WHERE id="+student.getId();
				 Statement st=connection.prepareStatement(upd);
				 st.executeUpdate(upd);
			 }catch (SQLException e) {
							e.printStackTrace();
			}
		return student;
	}

	@Override
	public void getStudentMarks(int id) {
		 try {	
				Connection connection = connector.getConnection();
				  String marks = "Select marks from student where id="+id;
				 Statement st=connection.createStatement();
				ResultSet res= st.executeQuery(marks);
				while(res.next()) {
					System.out.println(res.getString("marks"));
				}
			 }catch (SQLException e) {
							e.printStackTrace();
			}
		
	}

}
