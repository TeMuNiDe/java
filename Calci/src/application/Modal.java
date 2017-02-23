package application;

public class Modal {

	public float calc(long n1,long n2,String op){
		switch(op){
		case"+":return(n1+n2);
		case"-":return(n1-n2);
		case"*":return(n1*n2);
		case"/":return(n1/n2);
		
		
		
		default : return 0;
		
		
		}
		
		
		
	}
	
	
}
