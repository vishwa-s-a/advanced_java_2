// this is the brute force method of stock span problem
// time complexity is O(n^2)
// space complexity is O(n)

import java.util.Arrays;
public class StockSpan{
    public static int[] calculateSpan(int prices[])
    {
        // this function will return a array of span values
        int n=prices.length;
        int span[]=new int[n];
        span[0]=1;
        for( int i=1;i<n;i++)
        {
            span[i]=1;// initially we make 
            int j=i-1;
            while(j>=0 && prices[i]>prices[j])//we will get the max number of consecutive days 
            {
                span[i]+=1;
                j--;
            }
        }

        return span;
    }
    public static void main(String args[]){
        int prices[]={100,80,60,70,60,75,85};
        int span[]=calculateSpan(prices);
        System.out.println("The stock prices and span are as follows");
        System.out.println(Arrays.toString(prices));
        System.out.println(Arrays.toString(span));
    }
}