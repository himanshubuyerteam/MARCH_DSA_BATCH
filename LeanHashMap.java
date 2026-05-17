import java.util.*;
public class LeanHashMap {

    public boolean isZeroSumSubArray(int []arr)
    {
        HashMap<Integer,Boolean> hm = new HashMap<>();
        int sum =0;
        hm.put(sum,true);
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(hm.containsKey(sum))
                return true;
            hm.put(sum,true);
        }
        return false;
    }
    public boolean isKSumSubArray(int []arr,int k)
    {
        HashMap<Integer,Boolean> hm = new HashMap<>();
        int sum =0;
        hm.put(sum,true);
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(hm.containsKey(sum-k))
                return true;
            hm.put(sum,true);
        }
        return false;
    }
    public int countOfSubArraySumZero(int []arr)
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        int count = 0;
        hm.put(0,1);
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(hm.containsKey(sum))
            {
                count  = count + hm.get(sum);
                hm.put(sum,hm.get(sum)+1);
            }
            else
                hm.put(sum,1);
        }
        return count;
    }
    public int longestSubArraySumZero(int []arr)
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        int length = 0;
        hm.put(0,-1);
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(hm.containsKey(sum))
            {
                int olderIdx = hm.get(sum);
                int curr_len = i - olderIdx;
                length=Math.max(length,curr_len);
            }
            else
            {
                hm.put(sum,i);
            }
        }
        return length;
    }
    class pair
    {
        int length;
        int st_point;

    }
    public pair longestSubArraySumZero_pair(int []arr)
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        int length = 0;
        int stpoint = -1;
        hm.put(0,-1);
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(hm.containsKey(sum))
            {
                int olderIdx = hm.get(sum);
                int curr_len = i - olderIdx;
                if(curr_len>length)
                {
                    length = curr_len;
                    stpoint = olderIdx;
                }
            }
            else
            {
                hm.put(sum,i);
            }
        }
        pair p = new pair();
        p.length=length;
        p.st_point = stpoint;
        return p;
    }

    class keyFreqObj
    {
        int ele;
        int freq;
        keyFreqObj(int ele,int freq)
        {
            this.ele=ele;
            this.freq=freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<nums.length;i++)
        {
            int oldVal = hm.getOrDefault(nums[i],0);
            hm.put(nums[i],oldVal+1);
        }    
        for(int key:hm.keySet())
        {
            int [] obj = new int[2];
            obj[0]=key;
            obj[1]=hm.get(key);
            pq.add(obj);
        }
        ArrayList<Integer>al = new ArrayList<>();
        while(k>0)
        {
            int []removedObj = pq.remove();
            al.add(removedObj[0]);
            k--;
        }
        // return al;
        int []ans = new int[al.size()];
        for(int i=0;i<al.size();i++)
            ans[i]=al.get(i);
        return ans;
    }
    public static void main(String[] args) {
        // HashMap<String,Integer> hm = new HashMap<>();
        TreeMap<String,Integer>hm = new TreeMap<>();
        // hm.put("ABC",10);
        
        hm.put("BCD",10);
        hm.put("DEF",10);
        hm.put("IKL",2000);
        hm.put("AAA",0);
        System.out.println("BEFORE"+hm);
        hm.putIfAbsent("ABC", 100);
        System.out.println("AFTER"+hm);
        System.out.println(hm.size());
        System.out.println(hm.get("DEF"));

        // int ans = hm.get("XYZ");
        // System.out.println(ans);

        // if(hm.containsKey("BCD"))
        // {
        //     int ans = hm.get("BCD");
        //     System.out.println("VALUE IS ---"+ans);
        // }
        // else
        // {
        //     System.out.println("Key is Absent");
        // }
        int ans = hm.getOrDefault("bcd",0);
        System.out.println("VALUE IS ---"+ans);

        // for(String keys: hm.keySet())
        // {
        //     System.out.println("Key is ---"+keys);
        // }
        for(int val :hm.values())
        {
            System.out.println("Value is ---"+val);
        }

    }
}
