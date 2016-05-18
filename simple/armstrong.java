/* Program to check if a given number is armstrong*/
public class armstrong {
	public static void main(String arg[]){
		int count;
		for (count = 100; count < 1000; count++){
			if(count == arm(count)){
				System.out.println(count);
			}
		}
	}
	static int arm(int number){
		int temp,sum = 0 ;
		while (number != 0){
			temp = number % 10;
			sum = sum+(temp*temp*temp);
			number = number / 10;
		}
		return sum;
	}
}
