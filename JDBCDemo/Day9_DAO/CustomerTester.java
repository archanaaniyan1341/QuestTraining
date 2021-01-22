import java.util.List;
import java.util.Scanner;

public class CustomerTester {

	public static void main(String[] args) {
		CustomerDaoImp customerDao=new CustomerDaoImp();
		
		List<Customer> details=customerDao.getAllCustomers();
		System.out.println("id "+"name "+"gender "+"stream "+"marks ");
		for(Customer customer:details) {
			System.out.println(customer);
				
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name");
		String name=sc.next();
		System.out.println("marks of customer "+name+"is "+customerDao.getCustomerMark(name));
	sc.close();
	}

}
