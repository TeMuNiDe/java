package inheritance;

public class rect extends polygon {
 public String s="world";
	public double area(){
		
		return (hig*wid);
	}

public void main(String args[])
{
	polygon p = new rect();
	System.out.println(p.s);
}
	
}
