
		import java.io.BufferedReader;
		import java.io.File;
		import java.io.FileNotFoundException;
		import java.io.FileReader;
		import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
		import java.util.Map;
		import java.util.Scanner;

		public class TestApp {

			public static void main(String[] args) throws FileNotFoundException,IOException {
				Map<String,String>map=new HashMap<>();
				Scanner sc=new Scanner(System.in);
				
					try {	
						InputStream res = FileRead.class.getResourceAsStream("/test.txt");
						BufferedReader in = new BufferedReader(new InputStreamReader(res));
						String line = null;
						 line = in.readLine();
						while(line != null) {
							if(line.contains("INSERT")) {
						 String[] sub=line.split(" ");
						 String time=sub[1];
						 String name=sub[5].replace(',',' ');
						String appName=name.length()>15?name.substring(0, 14):name;
						 map.put(appName, time);
							}
						  line = in.readLine();
						}
						in.close();
					}catch(FileNotFoundException fn) {
						System.out.println("File not found");
					}catch(IOException io) {
						System.out.println("IO Exception");
					}
					System.out.println("App names:"+map.keySet());
					 System.out.println("Enter app name:");
					 String name=sc.next();
					if(map.containsKey(name)) {
						System.out.println("Time created for "+name+" is "+map.get(name));
			}else {
			System.out.println("not found");
			}sc.close();
		}//end of main method
		}//end of class 
	


