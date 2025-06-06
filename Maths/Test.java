package pack1;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
	
	  public static String howManyDalmations(int numer) {
		  
		    String[] dogs= {"Hardly any", "More than a handful!", "Woah that's a lot of dogs!", "101 DALMATIONS!!!"};
		    
		    String respond = numer <= 10 ? dogs[0] : (numer <= 50 ? dogs[1] : (numer == 101 ? dogs[3] : dogs[2]) ) ;
		    
		    return respond;
		  
		}
	
	 public static void main(String[] args) {
	
	 System.out.println(howManyDalmations(6));

	 }
	 

}


