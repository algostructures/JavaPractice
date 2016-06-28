/*
Problem : Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
Complexity : O(n)
*/
import java.util.regex.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;



public class GFG{
	
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int test = sc.nextInt();
    	sc.nextLine();
    	while(test > 0){
    		test -= 1;
    		int n = sc.nextInt();
    		int k = sc.nextInt();
    		int a[] = new int[n];
    		for(int i = 0; i < n; i++){
    			a[i] = sc.nextInt();
    		}
    		printKMax(a,k);
    		System.out.println();
    	}
    }

	private static void printKMax(int[] a, int k) {
		ArrayDeque<Integer> Q = new ArrayDeque<Integer>();
		int n = a.length;
		int i;
		for(i = 0; i < k; ++i){
			while((!(Q.size() == 0)) && a[i] >= a[Q.getLast()])
				Q.removeLast();
			Q.addLast(i);
		}
		
		for(;i < n; ++i){
			System.out.print(a[Q.getFirst()]+" ");
			
			while((!(Q.size() == 0)) && Q.getFirst() <= i - k)
				Q.removeFirst();
			
			while((!(Q.size() == 0)) && a[i] >= a[Q.getLast()])
				Q.removeLast();
			Q.addLast(i);
		}
		System.out.print(a[Q.getFirst()]);
	}
}

