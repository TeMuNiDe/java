import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.Math;

public class PieProblem {

	public static void main(String[] args) throws Exception {
		double[] percentage,x,y;
File output = new File("output.txt");
if(!output.exists()){
	output.createNewFile();
}
OutputStream stream = new FileOutputStream(output);
PrintWriter writer = new PrintWriter(stream);
    Scanner sc;
			sc = new Scanner(new File("input.txt"));
	
    int T = sc.nextInt();
    percentage = new double[T];
    x = new double[T];
    y = new double[T];
    
   for(int i=0;i<T;i++){
	   percentage[i] = sc.nextInt();
	   x[i] = sc.nextInt();
	   y[i] = sc.nextInt();
	   
   }
   for(int p = 0;p<T;p++){
	   boolean res = isIn(new Point(x[p],y[p]),percentage[p]);
	  	   writer.println("Case #"+(p+1)+": "+((res)? "black":"white"));
	   
   }
   writer.flush();
   stream.flush();
   stream.close();
   
}
	public static boolean isIn(Point p,double percent){
		double sector = Math.PI*2;
		if(((p.x)*(p.x))+((p.y)*(p.y))<2500){
		double angle = 0.0;
		if(p.x!=0){
		angle = Math.atan(Math.abs(p.y)/Math.abs(p.x));
		switch(p.quadrant){
		case Point.QUADRANT_1:angle  = (Math.PI/2)-angle;break;
		case Point.QUADRANT_2 :angle = (Math.PI/2)+angle;break;
		case Point.QUADRANT_3:angle  = (Math.PI*1.5)-angle;break;
		case Point.QUADRANT_4:angle = (Math.PI*2)-angle;break;
		}
		}else{
			if(p.x>0){
				angle=Math.PI/2;
			}
			else{
				angle = 0-Math.PI/2;
			}
		}
	//System.out.println("Angle = "+ Math.toDegrees(angle)+"<"+360*(percent/100));
		return angle<=sector*(percent/100);
		}
		return false;
	}
	}
class Point{
	public double x,y;
	static final int QUADRANT_1 = 1;
	static final int QUADRANT_2 = 2;
	static final int QUADRANT_3 = 3;
	static final int QUADRANT_4 = 4;
	public int quadrant;
	public Point(double x,double y){
		this.x =x-50;
		this.y = y-50;
		if(this.x>0){
			if(this.y>0){
				this.quadrant = QUADRANT_1;
			}else{this.quadrant = QUADRANT_2;}
			
		}
		else{
			if(this.y>0){
				this.quadrant = QUADRANT_4;
			}else{
				this.quadrant = QUADRANT_3;
			}
			
		}
		//System.out.println("Point is :("+this.x+","+this.y+")quadrant :"+this.quadrant);
	}
}
	

