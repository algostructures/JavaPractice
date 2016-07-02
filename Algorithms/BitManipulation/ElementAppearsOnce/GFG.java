/*
Given an array of integers, every element appears n time except for one. 
Find that single one in linear time complexity and without using extra memory.
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
    		int n = sc.nextInt();
    		int a[] = new int[n];
    		for(int i = 0; i < n; i++){
    			a[i] = sc.nextInt();
    		}
    		int ans = 0;
    		for(int i = 0; i < n; i++){
    			ans = ans^a[i]; // when every element twice
    		}
    		System.out.println(ans);
    	}
    }

	private static int getSingle(int[] a) {
		int result = 0;
		int x, sum;
		for(int i = 0; i < Integer.SIZE; i++){
			sum = 0;
			x = (1 << i);
			for(int j = 0; j < a.length; j++){
				if((a[j] & x) != 0)
					sum++;
			}
			if(sum % 2 != 0){// use n at place of "2"
				result |= x;
			}
		}
		return result;
	}
	
}
