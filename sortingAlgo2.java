
import java.util.Arrays;
public class sortingAlgo2 {
    // Give me 2 Sorted Arrays 
    //I will return you merged Sorted Array
    public static int[] merge2Sorted(int []a1,int []a2)
    {
        int n=a1.length;
        int m=a2.length;
        int []ans=new int[m+n];
        int i=0;
        int j=0;
        int k=0;
        while(i<n && j<m)
        {
            if(a1[i]>a2[j])
            {
                ans[k]=a2[j];
                j++;
            }
            else
            {
                ans[k]=a1[i];
                i++;
            }
            k++;
        }
        while(i<n)
        {
            ans[k]=a1[i];
            i++;
            k++;
        }
        while(j<m)
        {
            ans[k]=a2[j];
            k++;
            j++;
        }
        return ans;
    }
    //Give me a unsorted Array, and range of s and e
    // i will give you sorted Array
    public static int[] mergeSortHelper(int []arr,int startIdx,int endIdx)
    {
        if(startIdx==endIdx)
        {
            int []base_case=new int[1];
            base_case[0]=arr[startIdx];
            return base_case;
        }
        int midIdx=(startIdx+endIdx)/2;
        int []left_sorted_array = mergeSortHelper(arr,startIdx,midIdx);
        int []right_sorted_array = mergeSortHelper(arr,midIdx+1,endIdx);
        int []merged_sorted_array = merge2Sorted(left_sorted_array, right_sorted_array);
        return merged_sorted_array;
    }
    //Give me a unsorted Array, i return an sorted Array
    public static int[] mergeSort(int []arr)
    {
        return mergeSortHelper(arr, 0,arr.length-1);
    }
    public static void main(String[] args) {
        int []a1={1,4,7,9,19,22,25,29};
        int []a2={2,3};

        // System.out.println()
        int []ans=merge2Sorted(a1, a2);
        System.out.println(Arrays.toString(ans));
    }
}
