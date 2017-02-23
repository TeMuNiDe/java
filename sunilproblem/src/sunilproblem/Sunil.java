package sunilproblem;
import java.util.Scanner;
public class Sunil {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a value");
		int a = sc.nextInt();
		while( a!= 1   )
		{
			if(a%2==0)
		{
			a = a/2;
			System.out.println("exe2");
			
		}
		else{
			a= 3*a+1;
			System.out.println("exe");
		}
		}
		System.out.println("the answer is"+ a);
		
	}

}
