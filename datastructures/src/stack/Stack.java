package stack;

public class Stack{
	public static int st[] = new int[1000];
public static	int tos = -1;
static int pop(){
	int ele = st[tos];
	tos = tos-1;
	return ele;
}
	
  

}