import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
	Student_Dao studentDao=new Student_DaoImp();
	TeacherDao teacherDao=new TeacherDaoImp();
	BatchDao batchDao=new BatchDaoImp();
	Scanner sc = new Scanner(System.in);

	String repeat;
	do {
	System.out.println("1. Add a student" + "\n" 	
	+"2. get the batches which have students who have yet to pay" + "\n"
	+"3. strength of science batch" + "\n"	
        +"4. Add a newly joined teacher\r\n" + "5.  Add a new batch ");
		System.out.println("enter your choice: ");
		int choice = sc.nextInt();

		switch (choice) {
		
	case 1:
	   StudentG newS=new StudentG();
	   newS.setName("Z");
	   newS.setStudentID(103);
	   newS.setBatchID(1001);
	   newS.setPhone(87654);
           newS.setEmail("z@123"); 
           newS.setPaymentStatus("Paid");
           studentDao.addStudent(newS);
           for(StudentG std:studentDao.getAllStudents()) {
   	   System.out.println(std);
      }
       break;
     
	case 2:  
           System.out.println("Batches which have students yet to pay");
           studentDao.getBatches();
       break;
       
	case 3:
       studentDao.batchStrength();
       break;
	
	case 4:
	   Teacher tn=new Teacher();
	   tn.setFacultyID(04);
	   tn.setFacultyName("DD");
	   tn.setDesignation("Associate Professor");
	   tn.setContact(98765421);
	   tn.setEmail("dd@987");
	   teacherDao.addTeacher(tn);
	   for(Teacher teacher:teacherDao.getAllTeachers()) {
		System.out.println(teacher);
	 }
	 break;
	
		
	case 5:
		//add new batch
		Batch bn=new Batch();
		bn.setBatchID(1004);
		bn.setBatchName("Humanities");
		bn.setCourses("Regular");
		bn.setFacultyID(05);
		bn.setFeeDetails(45000);
		batchDao.addBatch(bn);
		for(Batch batch:batchDao.getAllBatches()) {
			System.out.println(batch);
	}
	break;
				
        default:
			System.out.println("Invalid case");
        }
		
   System.out.println("do you want to continue ? : Y/N ");
	repeat = sc.next();
		
   } while (!("N".equalsIgnoreCase(repeat)));

	sc.close();
   }
}

