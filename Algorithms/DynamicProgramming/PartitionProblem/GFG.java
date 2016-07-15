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
    		int n = sc.nextInt();
    		int a[] = new int[n];
    		for(int i = 0; i < n; i++){
    			a[i] = sc.nextInt();
    		}
    		if(findPartition(a)){
    			System.out.println("YES");
    		}
    		else{
    			System.out.println("NO");
    		}
    	}
    }
	public static boolean findPartition (int a[]){
		int sum = 0;
		for(int i = 0; i < a.length; i++)
			sum += a[i];
		
		if(sum % 2 != 0)
			return false;
		
		boolean part[][] = new boolean[a.length+1][(sum/2)+1];
		
		for(int i = 0; i < a.length+1; i++)
			part[i][0] = true;
		
		for(int i = 1; i < (sum/2)+1; i++)
			part[0][i] = false;
			
		for(int i = 1; i < a.length+1; i++){
			for(int j = 1; j < (sum/2)+1; j++){
				if( j >= a[i-1]){
					part[i][j] = part[i-1][j] || part[i-1][j-a[i-1]];
				}
			}
		}
		return part[a.length][sum/2];
	}
}
