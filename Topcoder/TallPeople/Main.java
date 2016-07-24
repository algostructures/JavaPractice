/*
A group of people stands before you arranged in rows and columns. Looking from above, they form an R by C rectangle of people.
Your job is to return 2 specific heights – the first is computed by finding the shortest person in each row, 
and then finding the tallest person among them (the "tallest-of-the-shortest");
and the second is computed by finding the tallest person in each column, 
and then finding the shortest person among them (the "shortest-of-the-tallest").
*/

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	public static void main(String arg[]){
		String s[] = {"1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20", 
				"1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20", 
				"1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20",
				"1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20", 
				"1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20", 
				"1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20", 
				"1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20", 
				"1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20", 
				"1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20", 
				"1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20", 
				"1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20"};
		
		int a[] = getPeople(s);
		System.out.println(a[0]+" "+a[1]);
	}
	public static int[] getPeople(String[] people){
		int [][]a;
		StringTokenizer st = new StringTokenizer(people[0]);
		int y = st.countTokens();
		int x = people.length;
		a = new int[x][y];
		
		for(int i = 0; i < x; i++){
			st = new StringTokenizer(people[i]);
			for(int j = 0; j < y; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int min = 0;
		int max= 0;
		int m[] = new int[x];
		
		for(int i = 0; i < x; i++){
			m[i] = Integer.MAX_VALUE;
			for(int j = 0; j < y; j++)
				m[i] = Math.min(a[i][j], m[i]);
			min = Math.max(min, m[i]);
		}
		
		max = Integer.MAX_VALUE;
		m = new int[y];
		
		for(int i = 0; i < y; i++){
			m[i] = -1;
			for(int j = 0; j < x; j++)
				m[i] = Math.max(a[j][i], m[i]);
			max = Math.min(max, m[i]);
		}
		
		return new int[]{min, max}; 
	}
	
}
