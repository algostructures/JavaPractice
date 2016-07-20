import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class MooreVotingAlgo{
	
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
    		int cand = majele(a,n);
    		if(isMajority(a,n,cand)){
    			System.out.println(cand);
    		}
    		else{
    			System.out.println("NO Majority Element");
    		}
    	}
		
	}
	private static int majele(int[] a, int n) {
		int majindex = 0, count = 1;
		int i;
		for(i = 1; i < n; i++){
			if(a[majindex] == a[i]){
				count++;
			}
			else 
				count--;
			if(count == 0){
				majindex = i;
				count = 1;
			}
		}
		return a[majindex];
	}
	static boolean isMajority(int a[], int n, int cand){
		int count = 0;
		for(int i = 0; i < n; i++){
			if(a[i] == cand){
				count++;
			}
		}
		return (count > (n/2));
	}
}
