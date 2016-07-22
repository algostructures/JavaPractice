/*
author : saurabh_prajapati
Implimentation of Doubly Linked list using array
*/
public class DoublyLinkedListUsingArray {
	int[] next;
	int[] prev;
	public DoublyLinkedListUsingArray(int maxSize){
		next = new int[maxSize+1];
		prev = new int[maxSize+1];
	}
	
	public void insert(int x, int pos){
		prev[x] = pos;
		next[x] = next[pos];
		
		prev[next[x]] = x;
		next[prev[x]] = x;
	}
	
	public void remove(int x){
		next[prev[x]] = next[x];
		prev[next[x]] = prev[x];
	}
	
	public static void main(String arg[]){
		int n = 10;
		DoublyLinkedListUsingArray list = new DoublyLinkedListUsingArray(n);
		for(int i = 0; i < n; i++)
			list.insert(i, 0);
		
		list.remove(1);
		list.remove(10);
		list.remove(5);
	}
}
