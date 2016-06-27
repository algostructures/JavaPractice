/*
Java program to find longest increasing subsequence in a given array in O(n^2)
complexity.
*/

public class LIS {
	public static void main(String arg[]){
		 int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		 System.out.println(Lis(arr));
	}

	private static int Lis(int[] arr) {
		int n = arr.length;
		int lis[] = new int[n];
		int max = 0;
		
		for(int i = 0; i < n; i++)
			lis[i] = 1;
		
		for(int i = 1; i < n; i++)
			for(int j = 0; j < i; j++)
				if(arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
				
		for(int i = 0; i < n; i++)
			if(max < lis[i])
				max = lis[i];
		
		return max;
	}
}
