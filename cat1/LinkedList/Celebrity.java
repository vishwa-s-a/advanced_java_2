import java.io.IOException;
import java.util.Scanner;

/*
 * space and time complexity is O(N)
 */
class Solution{
    public int findCelebrity(int num[][], int n)
    {
        int celebrity=0;
        for(int i=1;i<n;i++)
        {
            if(num[celebrity][i]==1)
            celebrity=i;
        }
        for(int i=0;i<n;i++)
        {
            if(i!=celebrity && (num[celebrity][i]==1 || num[i][celebrity]==0))
            return -1;
        }
        return celebrity;
    }
}
public class Celebrity {
    public static void main(String args[])
    throws IOException{
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int relationshipMatrix[][]=new int[N][N];// initializing a 2-d matrix
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                relationshipMatrix[i][j]=sc.nextInt();
            }
        }

        int celebrity=new Solution().findCelebrity(relationshipMatrix,N);
        if(celebrity!=-1)
        System.out.println("The celebrity is : "+celebrity);
        else
        System.out.println("No celebrity");
        sc.close();

    }
}
