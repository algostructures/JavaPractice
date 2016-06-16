/*
Frog steps either 1, 2 or 3 steps to go to top. In how many ways it reaches the top?
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test > 0){
		    test -= 1;
		    int n = sc.nextInt();
		    int a[] = new int[n];
		    a[0] = 1;
		    if(n  >= 2){
		    	a[1] = 2;
		    }
		    if(n  > 2){
		    	a[2] = 4;
		    	if(n>3)
		    	for(int i = 3; i< n;i++){
			    	a[i] = a[i-1]+a[i-2]+a[i-3];
			    }
		    }
		    System.out.println(a[n-1]);
		}
	}
	
}
