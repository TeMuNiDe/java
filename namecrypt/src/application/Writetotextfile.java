package application;
import java.util.Random;
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
public class Writetotextfile {

	public static long gen(long ip) {
	
		long op = 0;
		
	
		try{
			File f1 = new File(Long.toString(ip));
			if(!f1.exists())
			{
				f1.createNewFile();
			}
			PrintWriter pw = new PrintWriter(f1);
			
		Random r = new Random();
	long code = r.nextInt(100);
	op = code*ip;
			pw.println(code + "---" + op);

			
			pw.close();
			System.out.println("written successsfuly");
		}catch (IOException e){
			e.printStackTrace();
			
		}

	return op;
	}

}
