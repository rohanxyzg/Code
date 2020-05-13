
import java.util.Scanner;

public class models {
    static Integer[] dp;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] a = new int[n+1];
            for(int i=0;i<n;i++)
                a[i+1]=sc.nextInt();
            int max = 1;
            int count = 1;
            dp = new Integer[n+2];
            for(int i=1;i<=n/2;i++){
                count = Math.max(count,1+f(a,i,n));
            }
            System.out.println(count);
        }

    }
    public static int f(int[] a,int index,int n){
        if(index>n)
            return 0;
        if(dp[index]!=null)
            return dp[index];
        //c = Math.max(c,occ);
        //System.out.println(c);
        int count = 0;
        for(int i=2*index;i<=n;i+=index){
            if(a[i]>a[index])
                count = Math.max(count,1+f(a,i,n));
        }
        return dp[index]=count;
    }

}