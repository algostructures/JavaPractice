/*Driver method for max heap*/
public class Tset {

	public static void main(String[] args) {

		MaxHeap m=new MaxHeap(10);
		m.insert(20);
		m.display();
		m.insert(15);
		m.display();
		m.insert(2);
		m.display();
		m.insert(14);
		m.display();
		m.insert(10);
		m.display();
		m.insert(21);
		m.display();
		m.delete();
		m.display();
		m.delete();
		m.display();
		m.delete();
		m.display();
		
	}

}
