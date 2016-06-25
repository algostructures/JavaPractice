import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class GFG{
	static Node root;
	public static Node sortedArrayToBST(int a[], int start, int end){
		if(start > end)
			return null;
		int mid = (start+end)/2;
		Node node = new Node(a[mid]);
		node.left = sortedArrayToBST(a, start, mid-1);
		node.right = sortedArrayToBST(a,mid+1,end);
		
		return node;
	}
	
	public static void preOrder(Node node){
		if(node == null)
			return;
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int test = sc.nextInt();
    	while(test > 0){
    		test -= 1;
    		int n = sc.nextInt();
    		int a[] = new int[n];
    		for(int i = 0; i < n; i++){
    			a[i] = sc.nextInt();
    		}
    		Arrays.sort(a);
    		preOrder(sortedArrayToBST(a,0,n-1));
    		System.out.println();
    	}
    }
}
class Node{
	int data;
	Node right, left;
	Node(int d){
		this.data = d;
		left = right = null;
	}
}

