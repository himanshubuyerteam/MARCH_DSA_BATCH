public class binarySearch {
    public boolean linearSearch(int []arr,int key)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==key)
                return true;
        }
        return false;
    }
    public boolean binarySearch(int []arr,int key)
    {
        int s=0;
        int e=arr.length-1;
        while(s<=e)
        {
            int midIdx=(s+e)/2;
            int midVal=arr[midIdx];

            if(key==midVal)
                return true;
            else if(key>midVal) // Go to Right
                s=midIdx+1;
            else// Go to Left
                e=midIdx-1;
        }
        return false;
    }

    public int firstOcc(int []arr,int key)
    {
        int s=0;//start
        int e=arr.length-1;//end
        int ans=-1;
        while(s<=e)
        {
            int midIdx=(s+e)/2;
            int midVal =arr[midIdx];
            
            if(midVal == key)
            {
                ans=midIdx;
                if(midIdx==0 || arr[midIdx-1]!=key)
                    return ans;
                else
                    e=midIdx-1;
            }
            else if(midVal>key)//
                e=midIdx-1;
            else
                s=midIdx+1;
        }
        return ans;
    }

    public int LastOcc(int []arr,int key)
    {
        int s=0;//start
        int e=arr.length-1;//end
        int ans=-1;
        while(s<=e)
        {
            int midIdx=(s+e)/2;
            int midVal =arr[midIdx];
            if(midVal == key)
            {
                ans=midIdx;
                if(midIdx==arr.length-1 || arr[midIdx+1]!=key)
                    return ans;
                else
                    s=midIdx+1;
            }
            else if(midVal>key)//
                e=midIdx-1;
            else
                s=midIdx+1;
        }
        return ans;
    }

    public int countOcc(int []arr,int key)
    {
        int fo=firstOcc(arr,key);
        if(fo==-1)
            return 0;
        int lo=LastOcc(arr,key);
        return lo-fo+1;
    }


    //Array - RSA
    public int minElementInRSA(int []arr)
    {
        int s=0;
        int e=arr.length-1;
        while(s<e)
        {
            int midIdx = (s+e)/2;
            int midVal = arr[midIdx];
            if(midVal>arr[e])
                s=midIdx+1;
            else //midVal<arr[e]
                e=midIdx;
        }
        return arr[s];
    }
    public int no_of_rotation(int []arr)
    {
        int s=0;
        int e=arr.length-1;
        while(s<e)
        {
            int midIdx = (s+e)/2;
            int midVal = arr[midIdx];
            if(midVal>arr[e])
                s=midIdx+1;
            else //midVal<arr[e]
                e=midIdx;
        }
        return s;
    }


    public boolean possible(int []arr,int hr,int speed)
    {
        int hrused=0;
        for(int x:arr)
        {
            hrused+=Math.ceil(x/speed*1.0);
        }
        if(hrused>hr)
            return false;
        else
            return true;
    }
    public int koko(int []arr,int hr)
    {
        int s=1;
        int e=arr[0];
        for(int x:arr)
            e=Math.max(x,e);
        int ans=-1;
        while(s<e)
        {
            int speed=(s+e)/2;

            if(possible(arr,hr,speed)==true)
            {
                ans=speed;
                e=speed-1;
            }
            else
                s=speed+1;
        }
        return ans;
    }
}


