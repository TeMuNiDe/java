import java.util.Arrays;

public abstract class Doer {
public void generate(char[] input){
	char[] result = new char[input.length];
	int[] index = new int[input.length];
	Arrays.fill(index,0,index.length,0);
	Arrays.fill(result, 0,result.length,input[0]);
	
	for(int length = 1;length<=input.length;length++){
		int updateIndex = 0;
		do{
			element(result,0,length);
			for(updateIndex = length-1;updateIndex!=-1&&++index[updateIndex]==input.length;result[updateIndex]=input[0],index[updateIndex]=0,updateIndex--){
				if(updateIndex!=-1){
					result[updateIndex] = input[index[updateIndex]];
				}
				
			}
		}while(updateIndex!=-1);
		
	}
}

public abstract void element(char[] op, int offset, int length);
}
