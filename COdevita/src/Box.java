import java.util.ArrayList;
import java.util.Scanner;

public class Box {

	public static void main(String[] args) {
		 ArrayList<Integer> al = new ArrayList<Integer>();
		 al.add(3);
		 Scanner sc = new Scanner(System.in);
		int NOBX = sc.nextInt();
		int MAX_SIZE = 2*NOBX+1;
		for(int p=0;p<NOBX;p++){
		al.add(al.get(p)+2);	
		}
		
		StringBuffer sb = new StringBuffer();
		StringBuffer op = new StringBuffer();

			for(int j=0;j<MAX_SIZE;j++){
				for(int k=0;k<MAX_SIZE;k++){
					
				if(j==0||k==0||(al.contains(j+1)&&k<=j)||(al.contains(k+1)&&j<=k)){
					sb.append("*");
				}
				else{
					sb.append(" ");
				}
				}
				op.append(sb.toString());;
				sb.delete(0,sb.length());
				}
			System.out.println(op.toString());
		
			}
		
		
		
	}


