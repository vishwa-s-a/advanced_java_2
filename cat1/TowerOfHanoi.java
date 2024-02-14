// this is the recursive version of the TOI
/*
* time complexity O(2^n)
* space complexity O(n)
*/
public class TowerOfHanoi{
    public static void tower(int disks,char source,char destination,char auxiliary)
    {
        //it will be a recursive function so we have to give it a termination condition
        if(disks==0)
        {
            return;
        }
        tower(disks-1,source,auxiliary,destination);
        System.out.println("Move disk "+disks+" from "+source+" to "+destination);
        tower(disks-1,auxiliary,destination,source);
    }
    public static void main(String args[]){
        int n=3;
        tower(n,'A','C','B');
    }
}