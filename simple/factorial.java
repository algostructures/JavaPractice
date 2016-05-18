/*factorial by recursion in java*/
public class factorial {
	public static void main(String arg[]){
		int i = 5;
		factorial f = new factorial();
		int b = f.fact(i);
		System.out.println(b);
	}
	int fact(int num){
		if(num == 1)
			return 1;
		return num * fact(num-1);
	}
	
}
