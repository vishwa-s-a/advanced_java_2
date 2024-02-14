/*
 * here we are using the doubly linked list
 * this method divides the list into sublists until the sublist contains only one element
 * then sort them and merge them into bigger sublists
 * finally we get the list which is sorted
 * 
 * time complexity O(n * log(n))
 * space complexity O(log(n))
 */
class Node{
    int data;
    Node prev;
    Node next;
    public Node(int data){
        this.data=data;
        this.prev=null;
        this.next=null;
    }
}
class LinkedList{
    Node head=null;
    public void add(int data){
        Node temp=new Node(data);
        if(head==null){
            head=temp;
            return ;
        }
        Node current=head;
        while(current.next!=null)
        {
            current=current.next;
        }
        current.next=temp;
        temp.prev=current;
    }
    public void display(){
        System.out.println("The linked list is : ");
        Node current=head;
        while(current.next!=null){
            System.out.print(current.data+"->");
            current=current.next;
        }
        System.out.print(current.data);
        System.out.println("\n");
    }
    public Node findMind(Node ref){
        Node slow=ref;
        Node fast=ref.next;
        while(slow!=null && fast!=null)// here both the pointers should not be null
        {
            fast=fast.next;
            if(fast==null)
            break;
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    public Node merge(Node head1, Node head2){
        Node result=new Node(-1);
        Node temp=result;
        while(head1!=null && head2!=null)
        {
            if(head1.data<head2.data){
                temp.next=head1;
                if(temp.data!=-1){
                    head1.prev=temp;
                }
                head1=head1.next;
            }
            else{
                temp.next=head2;
                if(temp.data != -1)
                {
                    head2.prev=temp;
                }
                head2=head2.next;
            }
            temp=temp.next;
        }

        // there is a possibility that one list gets over before the other and the above loop breaks off
        // so we will add all elements of other list which did not end directly to the result list
        while(head1!=null)
        {
            temp.next=head1;
            head1.prev=temp;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null)
        {
            temp.next=head2;
            head2.prev=temp;
            head2=head2.next;
            temp=temp.next;
        }

        return result.next;// as the result node is null so we return the next node
    }
    public Node mergeSort(Node ref)
    {
        // this is a recursive function so we should give the initial conditions to be true to run in recursive call
        if(ref.next==null)
        return ref;
        Node mid=findMind(ref);
        Node head1=ref;
        Node head2=mid.next;
        mid.next=null;
        head2.prev=null;// by these above two statements we get 2 separated lists
        // now we have to call this recursive mergeSort function on these 2 separated lists
        head1=mergeSort(head1);
        head2=mergeSort(head2);
        return merge(head1,head2);// we have to return the list which is a merger of these 2 list 
    }
}
public class MergeSortDll {
    public static void main(String args[]){
        LinkedList l1=new LinkedList();
        l1.add(1);
        l1.add(3);
        l1.add(5);
        l1.add(2);
        l1.add(4);
        l1.add(6);
        l1.display();
        l1.head=l1.mergeSort(l1.head);
        l1.display();
    }
}
