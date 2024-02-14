import java.util.Arrays;
import java.util.Stack;
/**
 * this is stack based approach for the stock span problem
 * time complexity and space complexity is O(n), n is the number of stock prices
 */

public class StockSpan1{
    public static int[] calculateSpan(int prices[]){
        int n=prices.length;
        int span[]=new int[n];
        Stack<Integer>stack=new Stack<>();
        span[0]=1;
        stack.push(0);
        for(int i=1;i<n;i++)
        {
            while(!stack.isEmpty() && (prices[i]>=prices[stack.peek()]))
            {
                stack.pop();
            }

            span[i]=stack.isEmpty()?i+1:i-stack.peek();
            stack.push(i);
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