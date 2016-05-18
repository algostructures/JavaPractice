/* Node data Structure for Linked list*/
public class ListNode {
	private int data;
	private ListNode next;
	
	ListNode(){}
	
	//public ListNode(int data){
	//	this.data = data;
	//}
	
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return data;
	}
	
	public void setNext(ListNode next){
		this.next = next;
	}
	
	public ListNode getNext(){
		return this.next;
	}
	
	int ListLength(ListNode headNode){
		int length = 0;
		ListNode currentNode = headNode;
		while(currentNode != null){
			length++;
			System.out.println(currentNode.data);
			currentNode = currentNode.getNext();
			
		}
		return length;
	}
	
	ListNode InsertLinkedList(ListNode headNode, ListNode nodeToInsert, int position){
		if(headNode == null)
			return nodeToInsert;
		int size = ListLength(headNode);
		
		if(position > size+1 || position < 1){
			System.out.println("Position of the node to be insert is invalid, The valid inputs are 1 to,"+(size+1));
			return headNode;
		}
		
		if(position == 1){
			nodeToInsert.setNext(headNode);
			return nodeToInsert;
		}
		
		else{
			ListNode previousNode = headNode;
			int count = 1;
			while (count < position-1){
				previousNode = previousNode.getNext();
				count++;
			}
			
			ListNode currentNode = previousNode.getNext();
			nodeToInsert.setNext(currentNode);
			previousNode.setNext(nodeToInsert);
		}
		
		return headNode;
	}
	
	ListNode DeleteNodeFromLinkedList(ListNode headNode, int position){
		int size = ListLength(headNode);
		if(position > size || position < 1){
			System.out.println("Position of the node to delete is invalid. The valid inputs are 1 to "+size);
			return headNode;
		}
		
		if(position == 1){
			ListNode currentNode = headNode.getNext();
			headNode = null;
			return currentNode;
		}
		
		else{
			ListNode previousNode = headNode;
			int count = 1;
			while(count < position){
				previousNode = previousNode.getNext();
				count++;
			}
			
			ListNode currentNode = previousNode.getNext();
			previousNode.setNext(currentNode.getNext());
			currentNode = null;
		}
		return headNode;
	}
	
	void DeleteLinkedList(ListNode head){
		ListNode auxilaryNode, iterator = head;
		while (iterator != null){
			auxilaryNode = iterator.getNext();
			iterator = null;
			iterator = auxilaryNode;
		}
	}
}
