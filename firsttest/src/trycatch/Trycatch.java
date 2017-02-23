package trycatch;

public class Trycatch {
	public static void main(String[] args){
		try{
			int a = 100/0;
			
		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println("exception handled");
	}

}
