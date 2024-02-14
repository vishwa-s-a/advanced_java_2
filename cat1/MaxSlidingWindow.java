import java.util.*;
public class MaxSlidingWindow{
    public static int[] maxSlidingWindow(int nums[], int k)
    {
        if(nums==null || nums.length==0)
        return new int[0];

        int n=nums.length;
        int results[]=new int[n-k+1];
        Deque<Integer>deque=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            while(!deque.isEmpty() && deque.peek()<i-k+1)
            deque.poll();

            while(!deque.isEmpty() && nums[i]>=nums[deque.peekLast()])
            deque.pollLast();

            deque.offer(i);
            if(i>=k-1){
                results[i - k + 1] = nums[deque.peek()];
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        } 
    }
}