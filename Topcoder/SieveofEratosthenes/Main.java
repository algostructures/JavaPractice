import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	public static void main(String arg[]){
		int n = 10000000;
		boolean b[] = sieve(n);
		for(int i = 0; i < n; i++){
			if(b[i]){
				System.out.println(i);
			}
		}
	}
	public static boolean[] sieve(int n){
		boolean[] prime = new boolean[n+1];
		Arrays.fill(prime, true);
		
		prime[0] = false;
		prime[1] = false;
		int m = (int) Math.sqrt(n);
		
		for(int i = 2; i <= m; i++){
			if(prime[i]){
				for(int k = i*i; k <= n; k+=i){
					prime[k] = false;
				}
			}
		}
		return prime;
	}
}
