// import java.util.*;

/*
 * here we use singly linked list for segregating the even and odd numbers in list
 * time complexity=O(N), N is the number of elements in list
 * space complexity=O(1)
 * This solution is called in-place solution and it does not require additional data structures 
 */
class Node{
    public int data;
    public Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class SegregateEvenOdd {
    static Node segregate(Node head){
        Node current=head;
        Node evenHead=null,evenTail=null;
        Node oddHead=null,oddTail=null;
        if(head==null){
            System.out.println("The list is empty");
            return head;
        }
        while(current!=null){
            int value=current.data;
            // System.out.println(value);
            if(value%2==0){
                if(evenHead==null){
                    evenHead=evenTail=current;
                }
                else{
                    evenTail.next=current;
                    evenTail=current;
                }
            }
            else{
                //if the value is odd
                if(oddHead==null)
                {
                    oddHead=oddTail=current;
                }
                else{
                    oddTail.next=current;
                    oddTail=current;
                }
            }
            current=current.next;
        }
        if(evenHead==null || oddHead==null)
        {
            // it indicates that the list has only odd or even values 
            return head;
        }
        evenTail.next=oddHead;//tring to combine both odd and even list
        oddTail.next=null;
        return evenHead;
    }
    static void display(Node ref){
        Node temp=ref;
        System.out.print("The linked list is: ");
        while(temp.next!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print(temp.data);
        System.out.println("\n");
    }
    static Node append(int val,Node head){
        Node newNode=new Node(val);
        if(head==null){
            head=newNode;
            return head;
        }
        Node current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=newNode;
        return head;
    }

    public static void main(String args[]){
        Node head=null;
        head=append(1, head);// here it is must to return the reference to head or else head remains null
        head=append(2, head);
        head=append(3, head);
        head=append(4, head);
        head=append(5, head);
        display(head);
        head=segregate(head);
        display(head);
    }
    
}
