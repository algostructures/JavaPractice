/*Dynamic Stack in java by Array doubling*/
public class DynArrayStack {
	private int top;
	private int capacity;
	private int array[];
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isStackFull(){
		return (top == capacity -1);
	}
	
	public void push(int data){
		if(isStackFull())
			doubleStack();
		array[++top] = data;
	}
	
	private void doubleStack(){
		int newArray[] = new int[capacity * 2];
		System.arraycopy(array, 0, newArray, 0, capacity);
		capacity = capacity * 2;
		array = newArray;
	}
	
	public int pop(){
		if(isEmpty()){
			System.out.println("Stack OverFlow");
			return -1;
		}
		else
			return array[top--];
	}
	
	public void deleteStack(){
		top = -1;
	}
}
