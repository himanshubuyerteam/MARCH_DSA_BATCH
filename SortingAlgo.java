import java.util.Arrays;

class SortingAlgo
{
    public static void bubbleSort()
    {
        int arr[]= { 5,9,8,2,1};
        System.out.println("BEFORE SORTING-"+Arrays.toString(arr));
        int noOfElements = arr.length;
        boolean swapped;
        for(int itr=1;itr<=noOfElements-1;itr++)
        {
            swapped=false;
            for(int j=0;j<noOfElements-itr;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }
            }
            if(swapped==false)
                break;
        }

        System.out.println("AFTER SORTING-"+Arrays.toString(arr));

    }

    public static void selectionSort()
    {
        int arr[]= { 5,9,9,8,2,1};
        System.out.println("BEFORE SORTING-"+Arrays.toString(arr));
        int noOfElements = arr.length;
        for(int i=0;i<noOfElements-1;i++)
        {
            int mi=i;
            for(int j=i+1;j<noOfElements;j++)
            {
                if(arr[j]<arr[mi])
                    mi=j;
            }
            int temp=arr[i];
            arr[i]=arr[mi];
            arr[mi]=temp;
        }
        System.out.println("AFTER SORTING-"+Arrays.toString(arr));
    }
    public static void main(String[] args) {
        // bubbleSort();
        selectionSort();
    }
}


//
git init
git add .
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/himanshubuyerteam/MARCH_DSA_BATCH.git
git push -u origin main