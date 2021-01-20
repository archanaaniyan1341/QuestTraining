import java.util.Scanner;

public class MatrixAddition {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of rows and columns in the matrix");
		int row=sc.nextInt();//row size of input matrix
		int col=sc.nextInt();//column size of input matrix
		int matrix1[][]=new int[row][col];
		int matrix2[][]=new int[row][col];
		System.out.println("Enter elements of matrix 1");
				for(int incr=0;incr<matrix1.length;incr++) {
					for(int inc=0;inc<matrix1[incr].length;inc++) {
						matrix1[incr][inc]=sc.nextInt();
					}//end of inner for loop
				}//end of outer for loop
		System.out.println("Enter elements of matrix 2");
				for(int incr1=0;incr1<matrix2.length;incr1++) {
					for(int inc1=0;inc1<matrix2[incr1].length;inc1++) {
						matrix2[incr1][inc1]=sc.nextInt();
					}//end of inner for loop
				}//end of outer for loop
		System.out.println("Enter no of rows and columns in resultant matrix");	
		int rowS=sc.nextInt();//row size of output matrix
		int colS=sc.nextInt();//column size of output matrix
		int sum[][]=new int[rowS][colS];
			try {
						for(int incrS=0;incrS<sum.length;incrS++) {
							for(int incS=0;incS<sum[incrS].length;incS++) {
								sum[incrS][incS]=matrix2[incrS][incS]+matrix1[incrS][incS];
						}//end of inner for loop
						}//end of outer for loop
			}//end of try block
			catch(ArrayIndexOutOfBoundsException arr) {
				arr.printStackTrace();
				System.out.println("Row or column size shoul be equal to input matrix size");
			}//end of catch block
			finally {
				sc.close();
			}//end of finally block
			System.out.println("Sum matrix is:");
					for(int incrS=0;incrS<sum.length;incrS++) {
						for(int incS=0;incS<sum[incrS].length;incS++) {
							System.out.print(sum[incrS][incS]+"\t");
					}	//end of inner for loop
						System.out.println();
					}//end of outer for loop
					}//end of main method

	

}
