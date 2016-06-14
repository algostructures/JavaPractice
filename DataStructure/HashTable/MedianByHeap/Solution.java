/*
http://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
Given that integers are read from a data stream. Find median of elements read so for in efficient way. For simplicity assume there are no duplicates. For example, let us consider the stream 5, 15, 1, 3 …

After reading 1st element of stream - 5 -> median - 5
After reading 2nd element of stream - 5, 15 -> median - 10
After reading 3rd element of stream - 5, 15, 1 -> median - 5
After reading 4th element of stream - 5, 15, 1, 3 -> median - 4, so on...
Making it clear, when the input size is odd, we take the middle element of sorted data. If the input size is even, we pick average of middle two elements in sorted stream.
*/
import java.util.*;
public class Solution {
	public static void main(String arg[]){
		int a[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
		PriorityQueue<Integer> min = new PriorityQueue<Integer>();
		PriorityQueue<Integer> max = new PriorityQueue<Integer>(20, Collections.reverseOrder());
		double median = 0;
		for(int i = 0; i < a.length; i++){
			if(min.size() == max.size()){
				if(a[i] < median){
					max.add(a[i]);
					median = max.peek();
				}
				else{
					min.add(a[i]);
					median  = min.peek();
				}
			}
			else if(min.size() < max.size()){
				if(a[i] < median){
					min.add(max.poll());
					max.add(a[i]);
				}
				else{
					min.add(a[i]);
				}
				median = (max.peek() + min.peek())/2;
			}
			else{
				if(a[i] < median){
					max.add(a[i]);
				}
				else{
					max.add(min.poll());
					min.add(a[i]);
				}
				median = (max.peek() + min.peek())/2;
			}
			System.out.println(median);	
		}
	}
}
