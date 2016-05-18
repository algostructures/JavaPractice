/* Converting a Martix to sparce(method ope()) and doing transpose then fast Transpose*/
import java.util.*;
public class Mat {
	int a[][];
	static sparse sp[];
	int rows,columns;
	int NUM;
	
	void input(){
		Scanner Sc = new Scanner(System.in);
		rows = Sc.nextInt();
		columns = Sc.nextInt();
		a = new int[rows][columns];
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < columns; j++)
				a[i][j] = Sc.nextInt();
	}
	
	void ope(){
		int count = 0;
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < columns; j++)
				if(a[i][j] != 0)
					count++;
		sp = new sparse[count+1];
		for(int i = 0; i <= count; i++)
			sp[i] = new sparse();
		sp[0].row = rows;
		sp[0].col = columns;
		sp[0].value = count;
		int k = 1;//non zero entries in array
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < columns; j++){
				if (a[i][j] != 0){
					sp[k].row = i;
					sp[k].col = j;
					sp[k].value = a[i][j];
					k++;
				}
			}
				
	}
	
	sparse[] transpose(sparse[] tp){
		sparse[] tp1 = new sparse[tp[0].value+1];
		for(int i = 0; i <= tp[0].value ; i++){
			tp1[i] = new sparse();
		}
		int i,j,n,currentb;
		n = tp[0].value;
		tp1[0].row = tp[0].col;
		tp1[0].col = tp[0].row;
		tp1[0].value = n;
		
		if(n > 0){
			currentb = 1;
			for(i = 0; i < tp[0].col; i++){
				for(j = 1; j <= n; j++){
					if(tp[j].col == i){
						tp1[currentb].row = tp[j].col;
						tp1[currentb].col = tp[j].row;
						tp1[currentb].value = tp[j].value;
						currentb++;
					}
				}
			}
		}
		return tp1;
	}
	
	sparse[] fast_transepose(sparse[] tp){
		sparse[] tp1 = new sparse[tp[0].value+1];
		for(int i = 0; i <= tp[0].value; i++)
			tp1[i] = new sparse();
		int row_term[],starting_pos[],i,j,num_cols= tp[0].col,num_term = tp[0].value;
		row_term = new int[10];
		starting_pos = new int[10];
		tp1[0].row = num_cols;
		tp1[0].col= tp[0].row;
		tp1[0].value = num_term;
		
		if(num_term > 0){
			for(i = 0; i < num_cols; i++)
				row_term[i] = 0;
			for(i = 1; i <= num_term; i++)
				row_term[tp[i].col]++;
			starting_pos[0] =  1;
			
			for(i = 1; i < num_cols; i++)
				starting_pos[i] = starting_pos[i-1]+row_term[i-1];
			
			for(i = 1; i <= num_term; i++){
				j = starting_pos[tp[i].col]++;
				tp1[j].row = tp[i].col;
				tp1[j].col = tp[i].row;
				tp1[j].value = tp[i].value;
			}
		}
		return tp1;
	}
	
	
	public static void main(String arg[]){
		Mat M = new Mat();
		M.input();
	    M.ope();
		sparse[] trn = M.fast_transepose(sp);
		for(int i = 0 ; i <= M.sp[0].value ;i++){
			System.out.println(M.sp[i].row+" "+M.sp[i].col+" "+M.sp[i].value);
		}
		System.out.println();
		for(int i = 0 ; i <= M.sp[0].value ;i++){
			System.out.println(trn[i].row+" "+trn[i].col+" "+trn[i].value);
		}
	}
}
