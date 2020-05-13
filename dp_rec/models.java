/*
B. Orac and Models
time limit per test3 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
There are 𝑛 models in the shop numbered from 1 to 𝑛, with sizes 𝑠1,𝑠2,…,𝑠𝑛.

Orac will buy some of the models and will arrange them in the order of increasing numbers (i.e. indices, but not sizes).

Orac thinks that the obtained arrangement is beatiful, if for any two adjacent models with indices 𝑖𝑗 and 𝑖𝑗+1 (note that 𝑖𝑗<𝑖𝑗+1, because Orac arranged them properly), 𝑖𝑗+1 is divisible by 𝑖𝑗 and 𝑠𝑖𝑗<𝑠𝑖𝑗+1.

For example, for 6 models with sizes {3,6,7,7,7,7}, he can buy models with indices 1, 2, and 6, and the obtained arrangement will be beautiful. Also, note that the arrangement with exactly one model is also considered beautiful.

Orac wants to know the maximum number of models that he can buy, and he may ask you these queries many times.

Input
The first line contains one integer 𝑡 (1≤𝑡≤100): the number of queries.

Each query contains two lines. The first line contains one integer 𝑛 (1≤𝑛≤100000): the number of models in the shop, and the second line contains 𝑛 integers 𝑠1,…,𝑠𝑛 (1≤𝑠𝑖≤109): the sizes of models.

It is guaranteed that the total sum of 𝑛 is at most 100000.

Output
Print 𝑡 lines, the 𝑖-th of them should contain the maximum number of models that Orac can buy for the 𝑖-th query.

Example
inputCopy
4
4
5 3 4 6
7
1 4 2 3 6 4 9
5
5 4 3 2 1
1
9
outputCopy
2
3
1
1
Note
In the first query, for example, Orac can buy models with indices 2 and 4, the arrangement will be beautiful because 4 is divisible by 2 and 6 is more than 3. By enumerating, we can easily find that there are no beautiful arrangements with more than two models.

In the second query, Orac can buy models with indices 1, 3, and 6. By enumerating, we can easily find that there are no beautiful arrangements with more than three models.

In the third query, there are no beautiful arrangements with more than one model.


 */
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