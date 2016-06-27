/*
A JAVA program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
*/
public class Main  {
	public static int maxSubArraySum(int a[]){
		int n = a.length;
		int maxSoFar = a[0];
		int currMax = a[0];
		for(int i = 1; i < n; i++){
			currMax = Math.max(a[i], currMax+a[i]);
			maxSoFar = Math.max(currMax, maxSoFar);
		}
		return maxSoFar;
	}
	public static void main(String arg[]){
		int a[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(maxSubArraySum(a));
	}
}

