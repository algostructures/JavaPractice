/*Driver Method for linked list in java*/
public class LinkedList {
	public static void main(String arg[]){
		ListNode item1 = new ListNode();
		item1.setData(100);
		ListNode Head =  item1.InsertLinkedList(null, item1, 1);
		
		ListNode item2 = new ListNode();
		item2.setData(222);
		item1.InsertLinkedList(Head, item2, 2);
		
		ListNode item3 = new ListNode();
		item3.setData(333);
		item1.InsertLinkedList(Head, item3, 3);
		
		//item1.ListLength(Head);
	}
}
