package managementdao;

import java.sql.SQLException;
import java.util.List;

public interface Student_Dao {
List<Student>getAllStudents();
public void addStudent(Student student,Fee fee) throws SQLException;;
public void getBatches();
public void batchStrength();

}

