import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImp implements TeacherDao {
	ConnectionEx conex=new ConnectionEx();
	@Override
	public List<Teacher> getAllTeachers() {
		List<Teacher>teacher=new ArrayList<Teacher>();
		 String query="SELECT * FROM faculty";
			try {
				Connection conn=conex.getConnection();
				Statement st=conn.createStatement();
				ResultSet res=st.executeQuery(query);
				while(res.next()) {
					Teacher t=new Teacher();
					t.setFacultyID(res.getInt("facultyID"));
					t.setFacultyName(res.getString("facultyName"));
					t.setDesignation(res.getString("designation"));
					t.setContact(res.getInt("contactno"));
					t.setEmail(res.getString("email"));
				    teacher.add(t);
				
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return teacher;
	}

	@Override
	public void addTeacher(Teacher teacher) {
		String query="INSERT INTO faculty values("+teacher.getFacultyID()+","+"'"+teacher.getFacultyName()+"'"+","+
	"'"+teacher.getDesignation()+"'"+","+teacher.getContact()+","+"'"+teacher.getEmail()+"'"+")";
		try {
			Connection conn= conex.getConnection();
			Statement st=conn.prepareStatement(query);
			st.executeUpdate(query);
			System.out.println("Record inserted to student for"+teacher.getFacultyName());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
