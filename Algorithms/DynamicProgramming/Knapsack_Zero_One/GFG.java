import java.util.Scanner;


class GFG{
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int test = sc.nextInt();
    	while(test > 0){
    		test -= 1;
    		int n = sc.nextInt();
    		int sum = sc.nextInt();
    		int w[] = new int[n];
    		int pr[] = new int[n];
    		int knp[][] = new int[n+1][sum+1];
    		for(int i = 0; i < n; i++){
    			pr[i] = sc.nextInt();
    		}
    		
    		for(int i = 0; i < n; i++){
    			w[i] = sc.nextInt();
    		}
    		
    		for(int i = 0; i < n+1;i++){
    			knp[i][0] = 0;
    		}
    		
    		for(int i = 0; i < sum+1;i++){
    			knp[0][i] = 0;
    		}
    		
    		for(int i = 1; i < n+1; i++){
    			for(int j = 0; j < sum+1; j++){
    				if(j - w[i-1] < 0){
    					knp[i][j] = knp[i-1][j];
    				}
    				else{
    					knp[i][j] = Math.max(knp[i-1][j], knp[i-1][j-w[i-1]]+pr[i-1]);
    				}
    			}
    		}
    		
    		
    		System.out.println(knp[n][sum]);
    	}
    }
	
}
