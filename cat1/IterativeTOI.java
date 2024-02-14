import java.util.Scanner;
import java.util.Stack;
/*
* time complexity=O(2^n), here n is the number of disks
* space complexity=O(1), constant as the space doesn't vary with n

*/

public class IterativeTOI {
    public static void towerOfHanoi(int disks,char source,char auxiliary,char destination){
        //here disks means the number of total disks
        Stack<Integer>sourceStack=new Stack<>();
        Stack<Integer>auxiliaryStack=new Stack<>();
        Stack<Integer>destinationStack=new Stack<>();

        for(int i=disks;i>0;i--)
        {
            sourceStack.push(i);
        }

        int totalMoves=(int) Math.pow(2,disks)-1;

        char temp;
        if(disks%2==0)
        {
            temp=auxiliary;
            auxiliary=destination;
            destination=temp;
        }

        for(int moves=1;moves<=totalMoves;moves++)
        {
            if(moves%3==1)
            {
                moveDisk(sourceStack,destinationStack,source,destination);
            }
            else if(moves%3==2)
            {
                moveDisk(sourceStack,auxiliaryStack,source,auxiliary);
            }
            else{
                moveDisk(auxiliaryStack,destinationStack,auxiliary,destination);
            }
        }
    }
    public static void moveDisk(Stack<Integer>sourceStack,Stack<Integer>destinationStack,char source,char destination)
    {
        if(!sourceStack.isEmpty() && (destinationStack.isEmpty() || sourceStack.peek()<destinationStack.peek()))
        {
            destinationStack.push(sourceStack.pop());
            System.out.println("Move Disk "+destinationStack.peek()+" from "+source+" to "+destination);
        }
        else{
            sourceStack.push(destinationStack.pop());
            System.out.println("Move Disk "+sourceStack.peek()+" from "+destination+" to "+source);
        }
    }
    public static void main(String args[]){
        int numberOfDisks=3;
        char source='A';
        char auxiliary='B';
        char destination='C';

        towerOfHanoi(numberOfDisks,source,auxiliary,destination);
    }    
}
