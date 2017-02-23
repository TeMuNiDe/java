package lesson1;

public class Class1 {
	static String a = "AMITABH BACHCHAN"; static String b = "RAJNIKANTH";static char[] result = new char[16];
static	int pos=0;
	public static void main(String[] args) {
		
		
for(int i = 0;i<a.length();i++){
	for(int j=0;j<b.length();j++){
		if(a.charAt(i)==b.charAt(j)){
			add(a.charAt(i));
		}
		
	}
	
}
System.out.println(String.valueOf(result));
	}
	public static void add(char p){
		for(int i=0;i<16;i++)
	{
		if(result[i]==p){
		return;
		}
	}
		
		result[pos]=p;
		pos++;
		}

}
