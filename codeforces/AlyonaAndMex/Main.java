/*
Link : http://codeforces.com/problemset/problem/682/B
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;






public class Main {
	
	public static void main(String arg[]){
		//InputReader in = new InputReader(System.in);
		//OutputWriter out = new OutputWriter(System.out);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for(int i = 0; i < n; i++){
			ar.add(sc.nextInt());
		}
		Collections.sort(ar);
		int cur = 1;
		for(int i = 0; i < n; i++){
			if(ar.get(i) >= cur){
				cur++;
			}
		}
		System.out.println(cur);	
		sc.close();
	}
}
