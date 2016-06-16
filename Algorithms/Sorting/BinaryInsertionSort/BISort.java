public class BISort {
    public static void sort(int a[],int n){
        for (int i=0;i<n;++i){
            int temp=a[i];
            int left=0;
            int right=i;
            while (left<right){
                int middle=(left+right)/2;
                if (temp>=a[middle])
                    left=middle+1;
                else
                    right=middle;
            }
            for (int j=i;j>left;--j){
                swap(a,j-1,j);
            }
        }
    }

    public static void main(String[] args){
        int a[]=new int[]{12,10,34,23,9,7,8,5,6};
        sort(a,a.length);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public static void swap(int a[],int i,int j){
        int k=a[i];
        a[i]=a[j];
        a[j]=k;
    }
}
