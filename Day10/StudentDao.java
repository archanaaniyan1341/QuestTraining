import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
public  List<Student>listAllStudents() ;
public String getStudent(int id);
public void addStudent(Student student);
public void deleteStudent(int id);
public void updateStudent(Student student);
public void getStudentMarks(int id);
}
