import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.Scanner;
public class LazyLoading {
	
	
public static void main(String[] args) throws Exception{
	Scanner sc = new Scanner(new File("input2.txt"));
	File op = new File("output.txt");
	if(!op.exists()){
		op.createNewFile();
	}
	PrintWriter writer = new PrintWriter(new FileOutputStream(op));
	ArrayList<Integer> items = new ArrayList();
	int p = sc.nextInt();
	for(int k = 0;k<p;k++){
	int T = sc.nextInt();
	
	
	for(int i=0;i<T;i++){
		items.add(sc.nextInt());
	}
	int removed =1;
	int count = 0;
	Collections.sort(items);
	Collections.reverse(items);
	while(items.size()>1){
	removed = 50/items.get(0);
	//System.out.println("top :"+items.get(0)+"removed items"+removed+"of "+items.size()+" total");
	if(removed<items.size()){
	items = removeBottom(items,removed);
	items.remove(0);
}else{
		items.clear();
	}
//	System.out.println("new top :"+items.get(0));
	count++;
	}
	writer.println("Case #"+(k+1)+": "+count);
	
	}
	writer.flush();
	
}
	public static ArrayList<Integer> removeBottom(ArrayList<Integer> items,int index){
		
		int s =items.size();
		for(int b =0;b<index;b++){
			//System.out.println("removed Item :" +items.get(items.size()-1));
			items.remove(items.size()-1);
		}
		
		return items;
	}
}
