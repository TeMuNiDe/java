// A simple command-line interface for the IDEA file encryption module.

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import biz.source_code.crypto.IdeaFileEncryption;

public class IdeaCmd {
public static void main (String[] args) throws Exception {
   // The syntax of the command line parameters is kept compatible with that of IDEA V1.1 (IDEA_CMD.C, ETH version).
   // It's a subset of the original command line syntax and has a very simple, fixed structure.
	
	String[] approval = {"yeah","go on","carry on","yes","do it","go for it","yup","yep","ok","okay"};
	Scanner sc = new Scanner(System.in);
   boolean encrypt = true;
  boolean protection = true;
   String pure = "F:\\Documents\\note.txt";
   String dirty = "F:\\Documents\\notecrypt.txt" ;
   System.out.println("Hey There \n ");
   System.out.println("Enter Your Password to Continue ...\n" );
   String charKey = sc.next();
   if(!charKey.equals("varma1.618")){
	    System.exit(0);
   }
    System.out.println("Welcome Master..\n\nHow May I Assiste You\n");
    
    File f = new File(pure);
    if(f.exists()){
    	protection = false;
 	   System.out.println("Status : UnProtected \n");
    }
    sc.nextLine();
    while(true){
  
    String command = sc.nextLine();
    switch(command){
    case "reveal":
    	if(protection){
    	
    	System.out.println("Okay Master...\n\nDecrypting...");
	encrypt = false;
IdeaFileEncryption.cryptFile(dirty,pure, charKey, encrypt, IdeaFileEncryption.Mode.CBC);
System.out.println("Done .. Here is your Notes");
File ip = new File(dirty);
ip.delete();
    	}
Runtime.getRuntime().exec("notepad "+pure);
protection = false;
break;
    case "lockup":
    	if(!protection){
    	System.out.println("Okay Master...\n\nEncrypting.......");
			
	encrypt = true;
IdeaFileEncryption.cryptFile(pure,dirty, charKey, encrypt, IdeaFileEncryption.Mode.CBC);
new File(pure).delete();
    	}
System.out.println("Everything Locked Up and Secure ...");
protection = true;
  break;
    case "search":
    
    	System.out.println("search for..?");
    	String search = sc.nextLine();
    	Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe https://www.google.co.in/webhp?gws_rd=ssl#q="+URLEncoder.encode(search));
    	break;
    case "done":
    	
    	System.out.println("Ok Master \n");Thread.sleep(1000);
    System.out.println("See you later\n");Thread.sleep(1000);
    System.out.println("Packing Things up..\n\n");
    Thread.sleep(1000);
    if(!protection){
    
  encrypt = true;
IdeaFileEncryption.cryptFile(pure,dirty, charKey, encrypt, IdeaFileEncryption.Mode.CBC);
new File(pure).delete();
    }
System.out.println("Everything Locked Up and Secure ...");
Thread.sleep(1000);
    System.out.println("Bye.. :-)  \n");
    	Thread.sleep(2000);
    	System.exit(0);
    break;
    
    default :
    	System.out.println("Thinking....!");
    	Thread.sleep(2000);
    	System.out.println("Sorry Master ...  I dont think i can do that.. \n\n");
    	System.out.println("Shall I ask Mr Google for help..?");
    	String response = sc.nextLine();
    	List po = Arrays.asList(approval);
    	if(po.contains(response)){
    		
        	Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe https://www.google.co.in/webhp?gws_rd=ssl#q="+URLEncoder.encode(command));

    		
    	}
    	};
    }}}
  
   
   
    

