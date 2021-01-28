import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
	Student_Dao studentDao=new Student_DaoImp();
	TeacherDao teacherDao=new TeacherDaoImp();
	BatchDao batchDao=new BatchDaoImp();
	Scanner sc = new Scanner(System.in);

	String repeat;
	do {
		System.out.println("1. Add a student" + "\n" 	+
	"2. get the batches which have students who have yet to pay" + "\n"
	+"3. strength of science batch" + "\n"	
     + "4.  Add a newly joined teacher\r\n" + "5.  Add a new batch ");
		System.out.println("enter your choice: ");
		int choice = sc.nextInt();

		switch (choice) {
		
		
   
		case 1:
	   StudentG newS=new StudentG();
	   System.out.println("enter name");
	   String name=sc.next();
	   newS.setName(name);
	   System.out.println("enter id");
	   int id=sc.nextInt();
	   newS.setStudentID(id);
	   System.out.println("enter batch id");
	   int bid=sc.nextInt();
	   newS.setBatchID(bid);
	   System.out.println("enter phone");
	   int ph=sc.nextInt();
	   newS.setPhone(ph);
	   System.out.println("enter email");
	   String mail=sc.next();
      newS.setEmail(mail); 
      System.out.println("enter paymenyt status");
      String status=sc.next();
      newS.setPaymentStatus(status);
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
	System.out.println("enter faculty id");
	int fid=sc.nextInt();
	tn.setFacultyID(fid);
	System.out.println("enter name");
	String fname=sc.next();
	tn.setFacultyName(fname);
	System.out.println("enter designation");
	String desig=sc.next();
	tn.setDesignation(desig);
	System.out.println("enter contact no");
	int fcontact=sc.nextInt();
	tn.setContact(fcontact);
	System.out.println("enter email id");
	String fmail=sc.next();
	tn.setEmail(fmail);
	teacherDao.addTeacher(tn);
	for(Teacher teacher:teacherDao.getAllTeachers()) {
		System.out.println(teacher);
	}
	 break;
	
		
		case 5:
		//add new batch
		Batch bn=new Batch();
		System.out.println("enter id");
		int sid=sc.nextInt();
		bn.setBatchID(sid);
		  System.out.println("enterbatch name");
		String bname=sc.next();
		bn.setBatchName(bname);
		  System.out.println("enter course type");
		  String course=sc.next();
		bn.setCourses(course);
		  System.out.println("enter faculty id");
			int faid=sc.nextInt();
		bn.setFacultyID(faid);
		  System.out.println("enter fee details");
			int fee=sc.nextInt();
		bn.setFeeDetails(fee);
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

