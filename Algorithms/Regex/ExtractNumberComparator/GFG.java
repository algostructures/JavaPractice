/*
Link : http://www.practice.geeksforgeeks.org/problem-page.php?pid=988
*/
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    		ArrayList<String> as = new ArrayList<String>();
    		while (m.find()){
    			String temp  = m.group();
    			if(!temp.contains("9"))
    				as.add(temp);
    		}
    		Collections.sort(as,
                    new Comparator<String>()
                    {
                        public int compare(String s1, String s2)
                        {
                            return Long.parseLong(s1) < Long.parseLong(s2) ? -1 : 1 ;
                        }        
                    });
    		System.out.println(as.get(as.size()-1));
    	}
    }
}

