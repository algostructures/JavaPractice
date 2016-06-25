import java.util.regex.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class GFG{
	
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int test = sc.nextInt();
    	sc.nextLine();
    	while(test > 0){
    		test -= 1;
    		String s = sc.nextLine();
    		Pattern p = Pattern.compile("\\d+");
    		Matcher m = p.matcher(s);
    		ArrayList<Integer> as = new ArrayList<Integer>();
    		while (m.find())
    				as.add(Integer.parseInt(m.group()));
    				
    	  for(int i : as)
    	    System.out.println(i);
    	}
    }
}

