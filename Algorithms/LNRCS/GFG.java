/*
Given a string, find the length of the longest substring without repeating characters.
For example, the longest substrings without repeating characters for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”, with length 6. 
For “BBBB” the longest substring is “B”, with length 1.
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class GFG{
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int test = sc.nextInt();
    	while(test > 0){
    		test-= 1;
    		String s = sc.next();
    		//System.out.println(s);
    		int hash[] = new int[256];
    		Arrays.fill(hash, 0);
    		int len = 0, maxlen = 0, startWindow = 0;
    		for(int i = 0; i < s.length(); i++){
    			if(hash[s.charAt(i)] < startWindow)
    				hash[s.charAt(i)] = 0;
    			if(hash[s.charAt(i)] == 0)
    				len++;
    			else{
    				len = i+1 - hash[s.charAt(i)];
    				startWindow = hash[s.charAt(i)];
    			}
    			hash[s.charAt(i)] = i+1;
    			if(len > maxlen)
    				maxlen = len;
    		}
    		System.out.println(maxlen);
    	}
    }
	
}
