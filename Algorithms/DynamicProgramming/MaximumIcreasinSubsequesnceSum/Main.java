/*
program to find the sum of maximum sum subsequenceof the given array such that 
the integers in the subsequence are sorted in increasing order.
*/
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class Main{
	
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int test = sc.nextInt();
    	while(test > 0){
    		test -= 1;
    		int n = sc.nextInt();
    		int a[] = new int[n];
    		for(int i = 0; i < n; i++){
    			a[i] = sc.nextInt();
    		}
    		
    		System.out.println(msis(a));
    	}
    }

	private static int msis(int[] a) {
		int n = a.length;
		int msis[] = new int[n];
		for(int i = 0; i < n; i++){
			msis[i] = a[i];
		}
		
		for(int i = 1; i < n; i++){
			for(int j = 0; j < i; j++){
				if(a[i] > a[j] && msis[i] < msis[j] + a[i]){
					msis[i] = msis[j] + a[i];
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++){
			if(max < msis[i]){
				max = msis[i];
			}
		}
		return max;
	}
}

