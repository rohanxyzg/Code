/*
C. Orac and LCM
time limit per test3 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
For the multiset of positive integers 𝑠={𝑠1,𝑠2,…,𝑠𝑘}, define the Greatest Common Divisor (GCD) and Least Common Multiple (LCM) of 𝑠 as follow:

gcd(𝑠) is the maximum positive integer 𝑥, such that all integers in 𝑠 are divisible on 𝑥.
lcm(𝑠) is the minimum positive integer 𝑥, that divisible on all integers from 𝑠.
For example, gcd({8,12})=4,gcd({12,18,6})=6 and lcm({4,6})=12. Note that for any positive integer 𝑥, gcd({𝑥})=lcm({𝑥})=𝑥.

Orac has a sequence 𝑎 with length 𝑛. He come up with the multiset 𝑡={lcm({𝑎𝑖,𝑎𝑗}) | 𝑖<𝑗}, and asked you to find the value of gcd(𝑡) for him. In other words, you need to calculate the GCD of LCMs of all pairs of elements in the given sequence.

Input
The first line contains one integer 𝑛 (2≤𝑛≤100000).

The second line contains 𝑛 integers, 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤200000).

Output
Print one integer: gcd({lcm({𝑎𝑖,𝑎𝑗}) | 𝑖<𝑗}).

Examples
inputCopy
2
1 1
outputCopy
1
inputCopy
4
10 24 40 80
outputCopy
40
inputCopy
10
540 648 810 648 720 540 594 864 972 648
outputCopy
54
Note
For the first example, 𝑡={lcm({1,1})}={1}, so gcd(𝑡)=1.

For the second example, 𝑡={120,40,80,120,240,80}, and it's not hard to see that gcd(𝑡)=40.


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class suffixGCD
{
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    static long gcd(long a, long b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args)
    {
        FastReader sc=new FastReader();
        int n = sc.nextInt();
        long[] a = new long[n];
        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();
        long[] suffixGcd = new long[n];
        suffixGcd[n-1] = a[n-1];
        for(int i=n-1;i>=1;i--){
            suffixGcd[i-1] = gcd(a[i-1],suffixGcd[i]);
        }

        //System.out.println();
        long num = a[0];
        long suff_gcd_num = suffixGcd[1];
        long ans = (num*(suff_gcd_num))/(gcd(num,suff_gcd_num));

        long g_ith = 0;
        for(int i=1;i<a.length-1;i++){
            num = a[i];
            suff_gcd_num = suffixGcd[i+1];
            g_ith = (num*(suff_gcd_num))/(gcd(num,suff_gcd_num));

            ans = gcd(g_ith,ans);

        }
        System.out.println(ans);
    }
}