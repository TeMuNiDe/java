
public class Runner{
	public static void main(String[] args) {
		int count =1;
		char[] op = new char[4];
		char[] alp = {'a','b','c','d'};
		String pss = "badc";
		int i,j,k,l;
		for(i=0;i<4;i++){
			
			for(j=0;j<4;j++){
				
				for(k=0;k<4;k++){
					
					for(l=0;l<4;l++){
					
						op[0]=alp[i];
						op[1]=alp[j];
						op[2]=alp[k];
						op[3]=alp[l];
						//System.out.println("\n\n entry no :"+count);
						count++;
					if(String.valueOf(op).equals(pss)){
						System.out.println("succss at" + count);
					}
						
					
				}
			}
				
			}
			
		}
		
		

		
		
	}
	

}
