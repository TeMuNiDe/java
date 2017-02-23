import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.util.Scanner;
public class FightZombie {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(new File("input3.txt"));
		int health = sc.nextInt();
		int spellCount = sc.nextInt();
		Spell[] spells = new Spell[spellCount];
		for(int i=0;i<spellCount;i++){
			spells[i] = new Spell(sc.next(),health);
				}
		
	}

}
class Spell{
	public 	int faces,times,correction,max,min;
	public double probablity; 
	public Spell(String code,int health){
		boolean add = true;
		String[] prime = code.split("d");
		times = Integer.parseInt(prime[0]);
		
		//System.out.println(prime[0]+"<one two>"+prime[1]);
		String[] secondary =  prime[1].split("\\+");
		if(secondary.length==1){
			secondary = secondary[0].split("\\-");
			add = false;
		}
		faces = Integer.parseInt(secondary[0]);
		int correction = ((add)?Integer.parseInt(secondary[1]):0-Integer.parseInt(secondary[1]));
		max = (faces*times)+correction;
		min  = times+correction;
		this.probablity = ((double)max-(double)health)/((double)max-(double)min);
		System.out.println(this.probablity);
	}
	
}
