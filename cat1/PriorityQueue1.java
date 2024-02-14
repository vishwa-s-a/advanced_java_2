/**
 * this is implementation of priority queue using doubly linked list
 * time and space complexity is O(n)
 */
// creating a priority queue node 
class PNode<T> {
    T data;
    int priority;
    PNode<T> prev=null;
    PNode<T> next=null;
    public PNode(T data,int priority){
        this.priority=priority;
        this.data=data;
    }
}
class PriorityQueue<T> {
    PNode<T> head;
    PNode<T> tail;
    public PriorityQueue(){
        head=null;
        tail=null;
    }
    public void insert(T data,int priority)
    {
        PNode<T>newNode=new PNode<>(data,priority);
        if(head==null)
        {
            head=newNode;
            tail=newNode;
        }
        else if(priority<head.priority)
        {
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }
        else{
            PNode<T>current=head;
            while(current.next!=null && current.next.priority<=priority)
            {
                current=current.next;
            }
            newNode.prev=current;
            newNode.next=current.next;
            if(current.next!=null)
            {
                current.next.prev=newNode;
            }else{
                tail=newNode;
            }

            current.next=newNode;
        }
    }

    public T delete(){
        if(head==null){
            return null;
        }
        T temp=head.data;
        head=head.next;
        if(head!=null)
        {
            head.prev=null;
        }
        else{
            tail=null;

        }

        return temp;
    }

    public T peek()
    {
        if(head==null)
        return null;
        return head.data;
    }

    public boolean isEmpty()
    {
        return head==null;
    }
}
public class PriorityQueue1{
    public static void main(String args[]){
        PriorityQueue<String>priorityQueue=new PriorityQueue<>();
        priorityQueue.insert("Task A",3);
        priorityQueue.insert("Task B",1);
        priorityQueue.insert("Task C",2);

        System.out.println("highest priority task is "+priorityQueue.peek());
        while(!priorityQueue.isEmpty())
        {
            System.out.println("Executing "+priorityQueue.delete());
        }
    }
}