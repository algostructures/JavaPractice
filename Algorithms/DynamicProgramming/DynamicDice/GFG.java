/*
Given n dice each with m faces, numbered from 1 to m, find the number of ways to get sum X. 
X is the summation of values on each face when all the dice are thrown.
*/
import java.util.Scanner;


public class GFG {
	public static void main(String arg[]){
		Scanner Sc = new Scanner(System.in);
		int test = Sc.nextInt();
		while(test > 0){
			test -= 1;
			int m = Sc.nextInt();
			int n = Sc.nextInt();
			int sum = Sc.nextInt();
			
			System.out.println(dice(m,n,sum));
		}
	}

	private static long dice(int m, int n, int sum) {
		long tab[][] = new long[n+1][sum+1];
		
		if (m*n <= sum)
		    return (m*n == sum) ? 1 : 0 ;
		 
		if (n >= sum)
		    return (n == sum) ? 1 : 0;
		
		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= sum; j++){
				tab[i][j] = 0;
			}
		}
		
		for(int j = 1; j <= m && j <= sum ; j++){
			tab[1][j] = 1;
		}
		
		for(int i = 2; i <= n; i++){
			for(int j = 1; j <= sum; j++){
				for(int k = 1; k <= m && k < j; k++){
					tab[i][j] += tab[i-1][j-k];
				}
			}
		}
		return tab[n][sum];
	}
}
