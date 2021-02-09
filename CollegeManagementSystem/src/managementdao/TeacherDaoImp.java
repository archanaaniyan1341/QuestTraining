package managementdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImp implements TeacherDao {
	static Connection conn = DatabaseConnection.getConnection(); 

	@Override
	public List<Teacher> getAllTeachers() {
		List<Teacher>teacher=new ArrayList<Teacher>();
		 String query="SELECT * FROM teacher";
			try {
				Statement st=conn.createStatement();
				ResultSet res=st.executeQuery(query);
				while(res.next()) {
					Teacher t=new Teacher();
					t.setTeacher_id(res.getString("teacher_id"));
					t.setName(res.getString("name"));
					t.setDesignation(res.getString("designation"));
					t.setBatch_id(res.getInt("batch_id"));
				    teacher.add(t);	
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return teacher;
	}

	@Override
	public void addTeacher(Teacher teacher) {
		String query="INSERT INTO teacher values("+"'"+teacher.getTeacher_id()+"'"+","+"'"+teacher.getName()+"'"+","+
	"'"+teacher.getDesignation()+"'"+","+teacher.getBatch_id()+")";
		try {
			Statement st=conn.prepareStatement(query);
			st.executeUpdate(query);
			System.out.println("Record inserted to student for"+teacher.getName());
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
