/*Max Heap Implementation_2 in java*/
import java.util.*;
public class MaxHeap {
	int heap[];
	int n;
	MaxHeap(int l){
		heap=new int[l];
		n=0;				// root node starts with index 1
	}
	
	void insert(int x){
		if(n==heap.length-1){
			System.out.println("Heap Full");
			return;
		}
		
		int pos=++n;
		while(pos!=1 && x>heap[pos/2]){
			heap[pos]=heap[pos/2];
			pos/=2;
		}
		heap[pos]=x;
	}
	
	int delete(){
		if(n==0)
			throw new NoSuchElementException("Underflow");
		int item=heap[1];
		int pos=heap[n--];
		int parent =1;
		int child=2;
		
		while(child<=n){
			if(child<n && heap[child]<heap[child+1]){
				child++;
			}
			
			if(pos>=heap[child])break;
			heap[parent]=heap[child];
			parent=child;
			child*=2;
		}
		
		heap[parent]=pos;
		return item;
	}
	void display(){
		for(int i=1;i<=n;i++)
			System.out.print(heap[i]+" ");
		System.out.println();
	}
}
