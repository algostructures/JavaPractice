import java.util.Arrays;
import java.util.Scanner;

public class GFG{
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int test = sc.nextInt();
    	while(test > 0){
    		test -= 1;
    		int n = sc.nextInt();
    		fn f[] = new fn[n];
    		for(int i = 0; i < n; i++){
    			f[i] = new fn(sc.nextInt());
    		}
    		
    		for(int i = 0; i < n; i++){
    			f[i].set(sc.nextInt(), i);
    		}
    		ActivitySelector(f);
    	}
    }
	
	public static void ActivitySelector(fn f[]){
		Arrays.sort(f);    
		int k = 0;
		int n = f.length;
		System.out.print(1+f[0].i+" ");
		for(int i = 1; i < n; i++){
			if(f[i].s >= f[k].f){
				System.out.print(1+f[i].i+" ");
				k = i;
			}
		}
		System.out.println();
	}
}
class fn implements Comparable<fn>{
	int f;
	int i; 
	int s;
	fn(int s){
		this.s = s;
	}
	void set(int f, int i){
		this.f = f;
		this.i = i;
	}
	@Override
	public int compareTo(fn arg0) {
		return  this.f - arg0.f;
	}
}

