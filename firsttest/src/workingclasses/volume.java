package workingclasses;

public class volume{
	
	 int len;
	 int ber;
	 int hig;
	public int getvolume(){
		return(len * ber * hig);
		
	}
	volume () {
		len = 10;
		ber = 5;
		hig = 2;
	}
   volume (int l,int b,int h) {
	   
	   len = l;
	   ber = b;
	   hig = h;
   }
}
