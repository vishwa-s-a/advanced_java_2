import java.util.*;
/*
 * already some notes has been made on onenote for this problem refer it
 * time complexity is O(n^2)
 * space complexity is O(1)
 */
class Node{
    public int data;
    Node prev;
    Node next;
    public Node(int data){
        this.data=data;
        prev=null;
        next=null;
    }
}
public class sortBitonicList {
    public static Node reverse(Node ref){
        Node temp=null;
        Node current=ref;
        while(current!=null){
            temp=current.prev;
            current.prev=current.next;
            current.next=temp;
            current=current.prev;
        }
        if(temp !=null)
        {
            ref=temp.prev;//here the temp.prev refers to the next node pointed by the temp node
        }
        return ref;
    }
    public static Node merge(Node first,Node second){
        if(first==null)
        return second;
        if(second==null)
        return first;
        if(first.data<second.data){
            first.next=merge(first.next,second);
            if(first.next!=null){
                first.next.prev=first;
            }
            first.prev=null;
            return first;
        }
        else{
            second.next=merge(first,second.next);
            if(second.next!=null){
                second.next.prev=second;
            }
            second.prev=null;
            return second;
        }
    }
    public static Node sort(Node ref)
    {
        Node temp=ref;
        if(temp==null || temp.next==null)
        return temp;
        while(temp.data<temp.next.data){
            temp=temp.next;
        }
        //when loops break then temp will be pointing to peak node
        Node first=ref;
        Node second=temp.next;
        temp.next=null;
        second.prev=null;
        second=reverse(second);
        return merge(first,second);

    }
    public static void display(Node ref){
        System.out.println("The linked list is: ");
        Node temp=ref;
        while(temp.next !=null)
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print(temp.data);
        System.out.println("\n");
    }
    public static Node push(int data,Node head_ref){
        Node temp=new Node(data);
        temp.next=head_ref;
        if(head_ref !=null){
            head_ref.prev=temp;
        }
        head_ref=temp;
        return head_ref;
    }
    public static void main(String args[]){
        Node head=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in list: ");
        int number=sc.nextInt();
        for(int i=0;i<number;i++){
            int value=sc.nextInt();
            head=push(value, head);
        }
        display(head);
        head=sort(head);
        display(head);
        sc.close();
    }
}
