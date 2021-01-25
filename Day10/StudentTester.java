import java.util.Scanner;

public class StudentTester {

	public static void main(String[] args) {
	StudentDao studentDao=new StudentDaoImp();
	System.out.println("List of students:");
	for(Student std:studentDao.listAllStudents()) {
		System.out.println(std);
	}
	
	System.out.println("Enter id");
	Scanner sc=new Scanner(System.in);
	int val=sc.nextInt();	
	System.out.println("Student with id "+val+" is "+studentDao.getStudent(val));
	
	Student James=new Student();
	James.setId(2);
	James.setName("James");
	James.setGender("M");
	James.setStream("Science");
	James.setMarks(70);
	studentDao.addStudent(James);

	System.out.println("Enter id to be deleted");
	int var=sc.nextInt();	
	studentDao.deleteStudent(var);
	for(Student std:studentDao.listAllStudents()) {
		System.out.println(std);
	}
	Student john=new Student();
	john.setId(2);
	john.setName("John");
	john.setGender("M");
	john.setStream("Science");
	john.setMarks(79);
	studentDao.updateStudent(john);
	for(Student std:studentDao.listAllStudents()) {
		System.out.println(std);
	}
	System.out.println("Enter id to get marks");
	int var1=sc.nextInt();	
	studentDao.getStudentMarks(var1);
	sc.close();
	}
}
