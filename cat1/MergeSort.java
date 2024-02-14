import java.util.Arrays;

/**
 * time complexity is O(n log(n))
 * space complexity is O(n)
 * this algo is best suited for in-place sorting of arrays, as it sorts the arrays without using extra space
 */
public class MergeSort{
    public static void mergeSort(int arr[], int low, int high)
    {
        // this is a recursive function so should have a termination condition
        if(low<high)
        {
            int mid=(low+high)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }

    public static void merge(int arr[], int low, int mid, int high)
    {
        int n1=mid-low+1;// we are including the mid here itself by adding 1 at the end
        int n2=high-mid;
        int left[]=new int[n1];
        int right[]=new int[n2];
        for(int i=0;i<n1;i++)
        left[i]=arr[low+i];

        for(int j=0;j<n2;j++)
        right[j]=arr[mid+1+j];

        int i=0,j=0,k=low;
        while(i<n1 && j<n2)
        {
            if(left[i]<=right[j])
            {
                arr[k]=left[i];
                i++;
            }
            else{
                arr[k]=right[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k]=left[i];
            k++;
            i++;
        }
        while(j<n2){
            arr[k]=right[j];
            j++;
            k++;
        }
    }
    public static void main(String args[])
    {
        int arr[]={7, 2, 1, 6, 8, 5};
        mergeSort(arr,0,arr.length-1);
        System.out.println("The sorted array is : "+Arrays.toString(arr));
    }
}