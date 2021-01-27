
public class Tester {

	public static void main(String[] args) {
		
	Student_Dao studentDao=new Student_DaoImp();
   for(StudentG std:studentDao.getAllStudents()) {
	   System.out.println(std);
	   //new student
	   StudentG newS=new StudentG();
	   newS.setName("Z");
	   newS.setStudentID(103);
	   newS.setBatchID(1001);
	   newS.setPhone(87654);
      newS.setEmail("z@123"); 
      newS.setPaymentStatus("Paid");
      studentDao.addStudent(newS);
      //get unpaid batches
       String status="NotPaid";
       System.out.println("Batches which have students yet to pay");
       studentDao.getBatches();
       //batch strength
       studentDao.batchStrength();
       
	TeacherDao teacherDao=new TeacherDaoImp();
	for(Teacher teacher:teacherDao.getAllTeachers()) {
		System.out.println(teacher);
	}
	//add new teacher
	Teacher tn=new Teacher();
	tn.setFacultyID(04);
	tn.setFacultyName("DD");
	tn.setDesignation("Associate Professor");
	tn.setContact(98765421);
	tn.setEmail("dd@987");
	teacherDao.addTeacher(tn);
	
		BatchDao batchDao=new BatchDaoImp();
		for(Batch batch:batchDao.getAllBatches()) {
			System.out.println(batch);
			}
		//add new batch
		Batch bn=new Batch();
		bn.setBatchID(1004);
		bn.setBatchName("Humanities");
		bn.setCourses("Regular");
		bn.setFacultyID(05);
		bn.setFeeDetails(45000);
		batchDao.addBatch(bn);
   }
	}
}


