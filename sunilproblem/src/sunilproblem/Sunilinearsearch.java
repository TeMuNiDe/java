package sunilproblem;
import java.util.Scanner;
public class Sunilinearsearch {

	public static void main(String[] args) {
	int[] a = new int[10];
	int s;
	Scanner sc = new Scanner(System.in);
System.out.println("enter the array");
for(int i = 0;i<10;i++){
	a[i] = sc.nextInt();
}
System.out.println("enter search element");
s = sc.nextInt();
int pos = linear(a,s);
if(pos!=11)
{
	System.out.println("element found in position" + (pos+1));
}
else{
	System.out.println("not found");
}

	}
	 static int linear(int[] a,int s){
		for(int i = 0;i<=10;i++){
			if(a[i] == s){
				return i;
			}
			
		}
		return 11;
	}

}
