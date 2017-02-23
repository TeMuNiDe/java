



public class A {
	public String s="hello";
	
}


 class B extends A {
	public String s="world";
	
	
public static void main(String[] args){
	A obj = new B();
	System.out.println(obj.s);
}

}