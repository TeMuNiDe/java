package application;

public class Sortn {

	public static String[] sorting(String[] n){
		int i = 0;
		int j = 0;
	
		for(i=0;i<5;i++){
			for(j=i+1;j<5;j++){
	if(n[i].compareTo(n[j])>0)
	{
	String temp = n[i];
	n[i]= n[j];
	n[j] = temp;
	}
			}
			}
		return n;
}
}
