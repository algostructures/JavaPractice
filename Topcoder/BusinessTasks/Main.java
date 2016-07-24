/*
 	
A busy businessman has a number of equally important tasks which he must accomplish. To decide which of the tasks to perform first,
he performs the following operation.

He writes down all his tasks in the form of a circular list, so the first task is adjacent to the last task.
He then thinks of a positive number. This number is the random seed, which he calls n. Starting with the first task, 
he moves clockwise (from element 1 in the list to element 2 in the list and so on), counting from 1 to n. When his count reaches n,
he removes that task from the list and starts counting from the next available task.
He repeats this procedure until one task remains. It is this last task that he chooses to execute.
*/
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int len = s.length();
		int n = sc.nextInt();
		ArrayList<Character> ar = new ArrayList<Character>();
		for(int i = 0; i < len; i++){
			ar.add(s.charAt(i));
		}
		
		int v = 0;
		while(ar.size() > 1){
			int v2 = (v+n-1) % ar.size();
			ar.remove(v2);
			v = v2 % ar.size();
			System.out.println(v+" "+v2+" "+ar.size());
		}
		System.out.println(ar.get(0));
	}
}
