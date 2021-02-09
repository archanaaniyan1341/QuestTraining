package managementdao;

import java.sql.SQLException;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) throws SQLException  {

		Student_Dao studentDao = new Student_DaoImp();
		TeacherDao teacherDao = new TeacherDaoImp();
		BatchDao batchDao = new BatchDaoImp();
		Scanner sc = new Scanner(System.in);

		String repeat;
		do {
			System.out.println("1. Add a student" + "\n" + "2. get the batches which have students who have yet to pay"
					+ "\n" + "3. strength of science batch" + "\n" + "4.  Add a newly joined teacher\r\n"
					+ "5.  Add a new batch ");
			System.out.println("enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				Student newS = new Student();
				System.out.println("enter id");
				int id = sc.nextInt();
				newS.setStudent_id(id);
				System.out.println("enter first name");
				String fname = sc.next();
				newS.setFirst_name(fname);
				System.out.println("enter last name");
				String lname = sc.next();
				newS.setLast_name(lname);
				System.out.println("enter batch id");
				int bid = sc.nextInt();
				newS.setBatch_id(bid);
				System.out.println("enter gender");
				String gender = sc.next();
				newS.setGender(gender);

				Fee newf = new Fee();
				System.out.println("Enter payment id");
				newf.setPayment_id(sc.nextInt());
				newf.setStudent_id(id);
				System.out.println("Enter payment amount");
				newf.setPayment_amount(sc.nextInt());
				System.out.println("Enter paymentstatus");
				newf.setPayment_status(sc.next());

				studentDao.addStudent(newS, newf);
				for (Student std : studentDao.getAllStudents()) {
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
				Teacher tn = new Teacher();
				System.out.println("enter faculty id");
				String fid = sc.next();
				tn.setTeacher_id(fid);
				System.out.println("enter name");
				String name = sc.next();
				tn.setName(name);
				System.out.println("enter designation");
				String desig = sc.next();
				tn.setDesignation(desig);
				System.out.println("enter batch id");
				int batch = sc.nextInt();
				tn.setBatch_id(batch);
				teacherDao.addTeacher(tn);
				for (Teacher teacher : teacherDao.getAllTeachers()) {
					System.out.println(teacher);
				}
				break;

			case 5:
				// add new batch
				Batch bn = new Batch();
				System.out.println("enter batch id");
				bn.setBatchID(sc.nextInt());
				System.out.println("enterbatch name");
				bn.setBatchName(sc.next());
				System.out.println("enter fee details");
				bn.setFeeDetails(sc.nextInt());
				batchDao.addBatch(bn);
				for (Batch bat : batchDao.getAllBatches()) {
					System.out.println(bat);
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
