import java.util.Stack;

// time and space complexity is O(n)

public class StackPermutation{
    public static boolean isPermutable(int original[], int sequence[])
    {
        int i=0;
        Stack<Integer>stack=new Stack<>();
        for(int m: original)
        {
            stack.push(m);
            while(!stack.isEmpty() && stack.peek()==sequence[i]){
                stack.pop();
                i++;
            }

        }

        return stack.isEmpty();
    }
    public static void main(String args[])
    {
        int original[]={1,2,3,4};
        int sequence[]={4,2,1,3};
        boolean result=isPermutable(original,sequence);
        if(result)
        System.out.println("Yes it is stack permutable");
        else
        System.out.println("No it is not stack permutable");
    }
}