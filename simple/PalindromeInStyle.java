/*Checking Palindrome in java*/
import java.util.Scanner;

public class PalindromeInStyle {
	static Scanner  Sc = new Scanner(System.in);
	public static void main (String arg[]){
		System.out.println("Enter the Palindrome");
		String word = Sc.nextLine();
		
		if(isPalindrome(word))
			System.out.println("You Got Palindrome");
		else
			System.out.println("You are Dead");
	}
	
	static boolean isPalindrome(String inputStr){
		int i = 0, j =inputStr.length()-1;
		char[] ch = inputStr.toCharArray();
		
		while(i < j && ch[i] == ch[j]){
			i++;
			j--;
		}
		
		if(i < j)
			return false;
		else 
			return true;
	}
}
