package stack;
import java.util.Scanner;
public class Linkedlist {

	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  
	int item;
	int ch=4;
System.out.println("1. push\n2.pop\n3.peek\n0.exit\n\nselect your option :");
while(ch!=0){
ch = sc.nextInt();
switch(ch)
{
case 1 :if(Stack.tos < 1000)
{
	System.out.println("enter element to push :");
	item = sc.nextInt();
	Stack.tos++;
	Stack.st[Stack.tos]= item;
	
	System.out.println("push success");
}else{System.out.println("stack over flow");}	
	break;
case 2 :	
	if(Stack.tos!=-1)
	{
	item = Stack.pop();
	System.out.println("element poped is :" + item);
	}
	else{
		System.out.println("stack empty");
	}
	break;


case 3 :if(Stack.tos!=-1){
	System.out.println("elements in the stack are :");
	int i = 0;
	while(i <= Stack.tos){
		System.out.println(Stack.st[Stack.tos-i]);
		i++;
		}
}
	else{
		System.out.println("stack empty");
		
	}break;
	}}}}


	


