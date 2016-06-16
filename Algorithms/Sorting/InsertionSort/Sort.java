import java.util.Scanner;
public class Sort {
	static Scanner Sc = new Scanner(System.in);
	public static void main (String arg[]){
		int a[];
		System.out.println("Enter the number of elements in array");
		int size = Sc.nextInt();
		a = new int[size];
		for (int i = 0; i < size; i++){
			a[i] = Sc.nextInt();
		}
		int b[] = Insertion_sort(a);
		for(int i = 0; i < size; i++){
			System.out.println(b[i]);
		}
	}
	
	public static int[] Insertion_sort(int[] list){
		int i, key;
		for(int j = 1; j < list.length; j++){
			key = list[j];
			i = j-1;
			while(i >= 0 && list[i] > key){
				list[i+1] = list[i];
				i = i-1;
			}
			list[i+1] = key;
		}
		return list;
	}
}
