import java.sql.Array;
import java.util.Arrays;

class twopointer
{
    public static void reverse(int []arr)
    {
        int i=0;
        int j=arr.length-1;
        while(i<j)
        {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    public static void reverse_in_range(int []arr,int i,int j)
    {
        while(i<j)
        {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }

    public static void rotate(int []arr,int k)
    {
        int n=arr.length;
        k=k%n;
        if(k==0)
            return ;
        reverse_in_range(arr,0,n-1 );

        reverse_in_range(arr,0,k-1 );

        reverse_in_range(arr, k, n-1);

    }

    public static int maxWater(int []arr)
    {
        int i=0;
        int j=arr.length-1;
        int maxWater=0;
        while(i<j)
        {
            int min=Math.min(arr[i],arr[j]);
            int dist=j-i;
            int currwater=dist*min;
            maxWater=Math.max(maxWater,currwater);
            if(arr[i]>arr[j])
                j--;
            else   
                i++;
        }
        return maxWater;
    }
    public static int[] twoSum(int []arr,int tar)
    {
        int i=0;
        int j=arr.length-1;
        int []ans={-1,-1};
        int csum=0;
        while(i<j)
        {
            csum=arr[i]+arr[j];
            if(csum>tar)
                j--;
            else if(csum<tar)
                i++;
            else
            {
                ans[0]=i;
                ans[1]=j;
                return ans;
            }
        }
        return ans;
    }

    public static int maxSumSubArray(int []arr,int k)
    {
        int maxwin=0;
        int currwin=0;

        for(int i=0;i<k;i++)
            currwin+=arr[i];
        maxwin=currwin;

        for(int j=k;j<arr.length;j++)
        {
            int exclude=arr[j-k];
            int include=arr[j];
            currwin=currwin+include-exclude;
            maxwin=Math.max(maxwin,currwin);
        }        
        return maxwin;
    }

    public static void main(String[] args) {
        int []arr={1,2,3,4,5};
        System.out.println("BEFORE REVERSE-"+Arrays.toString(arr));
        // twopointer obj=new twopointer();
        // obj.reverse(arr);
        reverse(arr);
        System.out.println("AFTER REVERSE-"+Arrays.toString(arr));
    }
}