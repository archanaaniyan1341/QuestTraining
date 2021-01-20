import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONDemo {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		 JSONArray ja=new JSONArray();
		 String output;
		 String filenameIn="E:\\Test.txt";
		 BufferedReader bufferedReader = new BufferedReader(new FileReader(filenameIn));
		 String s ;
	        int count=0;
		    while ( (s = bufferedReader.readLine() ) != null)
		    {
		    	if(s.contains("INSERT")) {
		    	count=count+1;
		        String[] stringsArr = s.split(" ");
		    	JSONObject jsonObject = new JSONObject();
		    	 jsonObject.put("id", count);  
		        jsonObject.put( "appName" , stringsArr[5].replace(',', ' '));
		        jsonObject.put("timeStamp" , stringsArr[1]);  
		        
		        ja.add(jsonObject);
		    
		    } 
		    }
		    s= bufferedReader.readLine();
		    bufferedReader.close();
		    PrintWriter printWriter = new PrintWriter(".\\test.json");
		    JSONObject obj = new JSONObject();
		    obj.put("student", ja);
		    printWriter.write(obj.toJSONString());
		    printWriter.close();
		    System.out.println(obj);
	}

}