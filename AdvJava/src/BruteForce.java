import java.util.ArrayList;

public class BruteForce {

	public static void main(String[] args) {
		char[] ip = "abcd".toCharArray();
	new Doer(){

		@Override
		public void element(char[] result, int offset, int length) {
			System.out.println(new String(result,offset,length));
		}
		
	}.generate(ip);
	
}
}
