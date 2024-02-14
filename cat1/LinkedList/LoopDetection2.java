import java.util.*;
/*
 * here we are using hashing method to detect the loop in the list
 * time complexity=O(n)
 * space complexity=O(n)
 */
class Node{
    int value;
    Node next;
    public Node(int value){
        this.value=value;
        next=null;
    }
}
public class LoopDetection2 {

    public static Node insert(Node head,int val){
        Node newNode=new Node(val);
        if(head==null){
            head=newNode;
            return head; 
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        return head;
        
    }

    public static void display(Node head){
        Node temp=head;
        while(temp.next!=null){
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.print(temp.value+"\n");
    }

    public static void createLoop(Node head,int a, int b){
        int pa=0;
        int pb=0;
        Node p1=head;
        Node p2=head;
        while(pa!=a || pb!=b)
        {
            if(pa!=a){
                p1=p1.next;
                ++pa;
            }
            if(pb!=b){
                p2=p2.next;
                ++pb;
            }
        }
        //once the pointers reach the destination then we set the loop
        p2.next=p1;
    }

    public static boolean loopDetection(Node head){
        HashSet<Node>s=new HashSet<>();
        Node temp=head;
        while(temp!=null){
            if(s.contains(temp))
            return true;
            s.add(temp);
            temp=temp.next;
        }
        return false;
        
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the number of elements present in the list: ");
        int n=sc.nextInt();
        Node head=null;
        for(int i=0;i<n;i++)
        {
            int number=sc.nextInt();
            head=insert(head, number);
        }
        System.out.println("Linked list is : ");
        display(head);
        createLoop(head, 1, 3);
        if(loopDetection(head)){
            System.out.println("loop does exist");
        }
        sc.close();
    }

}
