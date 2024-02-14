

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinked {
    static Node head=null;
    static Node tail=null;

    public static void traverse() {
        Node current = head;
        while(current!=null)
        {
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.println("\n");
    }

    public static void reverseTravers(){
        Node current=tail;
        while(current!=null)
        {
            System.out.print(current.data+" ");
            current=current.prev;
        }
        System.out.println("\n");
    }

    public static void insertAtBeginning(int data)
    {
        Node temp=new Node(data);
        if(head==null)
        {
            head=temp;
            tail=temp;//i have doubt on the existence of this statement
        }
        else{
            temp.next=head;
            head.prev=temp;
            head=temp;
        }
    }

    public static void insertAtEnd(int data)
    {
        Node temp=new Node(data);
        if(tail==null)
        {
            head=tail=temp;
        }
        else{
            temp.prev=tail;
            tail.next=temp;
            tail=temp;
        }

    }
    public static void insertAtPosition(int data,int position)
    {
        Node temp=new Node(data);
        int currentPosition=1;
        // we are taking indexes from 1 not from 0 here
        if(position==1)
        {
            insertAtBeginning(data);
        }
        else{
            Node current=head;
            while (current !=null && currentPosition<position) {
                current=current.next;
                currentPosition++;
            }
            if(current==null)
            {
                //its the end of the list
                insertAtEnd(data);
            }
            else{
                temp.next=current;
                temp.prev=current.prev;
                current.prev.next=temp;
                current.prev=temp;

            }
        }
    }
    public static void deleteBeginning(){
        if(head==null){
            return ;
        }
        if(head==tail){
            head=null;
            tail=null;
            return;
        }

        Node temp=head;
        head=head.next;
        head.prev=null;
        temp.next=null;
    }


    public static void deleteEnd(){
        if(tail==null){
            return ;
        }
        if(head==tail)
        {
            head=null;
            tail=null;
            return;
        }
        Node temp=tail;
        tail=tail.prev;
        tail.next=null;
        temp.prev=null;
    }


    public static void deleteAtPosition(int position){
        if(head==null)
        return;
        if(position==1)
        deleteBeginning();
        int currentPosition=1;//here we are taking the position of starting point as 1
        Node current=head;
        while(current!=null && currentPosition<position)
        {
            current=current.next;
            currentPosition++;
        }
        if(current==null)
        {
            System.out.println("Entered position is wrong");

        }
        if(current==tail){
            deleteEnd();
        }

        current.prev.next=current.next;
        current.next.prev=current.prev;
        current.prev=null;
        current.next=null;
    }

    public static void main(String args[]) {
        System.out.println("Welcome to  Doubly linked list");

        insertAtEnd(1);
        insertAtEnd(2);
        System.out.print("The linked list created is: ");
        traverse();
        insertAtBeginning(0);
        
        System.out.print("The linked list in reverse order: ");
        reverseTravers();
        insertAtPosition(99, 2);
        System.out.print("The linked list created is: ");
        traverse();
        deleteAtPosition(2);
        System.out.print("The linked list created is: ");
        traverse();


    }
}

