import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class GFG{
	
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int test = sc.nextInt();
    	while(test > 0){
    		test-= 1;
    		int v = sc.nextInt();
    		int n = sc.nextInt();
    		int w[] = new int[n];
    		for(int i = 0; i < n; i++){
    			w[i] = sc.nextInt();
    		}
    		int k =  change(w, v);
    		if(k == Integer.MAX_VALUE)
    			System.out.println("-1");
    		else
    			System.out.println(k);
    	}
    }
	
	public static int change(int coins[], int N){
		int knp[] = new int[N+1];
		int min;
		knp[0] = 0;
		
		for(int i = 1; i <= N; i++){
			min = Integer.MAX_VALUE;
			for(int j = 0; j < coins.length; j++){
				if(i - coins[j] >= 0){
					if(knp[i-coins[j]]  < min)
						min = knp[i-coins[j]];
				}
			}
			if(min != Integer.MAX_VALUE)
				knp[i] = min+1;
			else
				knp[i] = min;
		}
		
		return knp[N];
	}
}
