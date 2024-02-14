import java.util.Stack;
/*
 * time complexity and space complexity is O(1) for all stack operations, as it does not depend on the number of elements in the stack
 */
class StackClass{
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;// we have declared the variables later we will initialize them
    public StackClass()
    {
        mainStack=new Stack<>();
        minStack=new Stack<>();
    }
    public void push(int data)
    {
        mainStack.push(data);
        if(minStack.isEmpty() || data<=minStack.peek()){
            minStack.push(data);
        }
    }
    public void pop(){
        if(!mainStack.isEmpty()){
            if(mainStack.peek()==minStack.peek())
            {
                minStack.pop();
            }
            mainStack.pop();
        }
    }
    public int top(){
        if(!mainStack.isEmpty())
        return mainStack.peek();
        return -108;// if the mainStack is empty
    }
    public int getMin(){
        if(!minStack.isEmpty())
        return minStack.peek();
        return -108;//if the minStack is empty
    }
}
public class MinimumStack {
    public static void main(String args[]){
        StackClass stack=new StackClass();
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.push(4);
        stack.push(-1);
        System.out.println(stack.top());
        stack.push(6);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
    
}
