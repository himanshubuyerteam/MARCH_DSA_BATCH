import java.util.Arrays;

class dp2
{

    // nums = [10,9,2,5,3,7,101,18] -> 4
    // nums = [10,22,9,33,21,50,41,60,80,1]  -> 6
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int []dp = new int[n];
        int lis = 0;
        for(int i=0;i<n;i++)
        {
            int mx = 0;
            for(int j=0;j<i;j++)
            {
                if(arr[j]<arr[i])
                    mx = Math.max(mx,dp[j]);
            }
            dp[i]=mx+1;
            lis = Math.max(lis,dp[i]);
        }
        return lis;
    }
    public static boolean helper(int []arr,int idx,int tar)
    {
        if(idx<0)
            return false;
        if(tar==0)
            return true;
        boolean ra1 = false;
        if(tar-arr[idx]>=0)
            ra1 = helper(arr, idx-1, tar-arr[idx]);
        boolean ra2 = helper(arr, idx-1, tar);
        return ra1 || ra2;
    }
    public static boolean helper_memo(int []arr,int idx,int tar,int [][]dp)
    {
        if(idx<0)
            return false;
        if(tar==0)
            return true;
        if(dp[idx][tar]!=-1)
        {
            if(dp[idx][tar]==0)
                return false;
            else
                return true;
        }
        boolean ra1 = false;
        if(tar-arr[idx]>=0)
            ra1 = helper(arr, idx-1, tar-arr[idx]);
        boolean ra2 = helper(arr, idx-1, tar);
        boolean fans = ra1 || ra2;
        if(fans == true)
            dp[idx][tar]=1;
        else
            dp[idx][tar]=0;
        return fans;
    }
    public static boolean targetSumSubSet(int []arr,int tar)
    {
        // return helper(arr, arr.length-1, tar);
        int [][]dp = new int[arr.length+1][tar+1];
        for(int []d:dp)
            Arrays.fill(d, -1);
        return helper_memo(arr, arr.length-1, tar, dp);
    }

    public static int helper_01_knapsack(int []wt,int []val,int maxWt,int idx)
    {
        if(maxWt==0)
            return 0;
        if(idx<0)
            return 0;
        //dont pick
        int op1 = helper_01_knapsack(wt,val,maxWt,idx-1);
        //pick
        int op2=0;
        if(maxWt-wt[idx]>=0)
            op2 = helper_01_knapsack(wt, val, maxWt-wt[idx], idx-1)+val[idx];
        int fans = Math.max(op1,op2);
        return fans;
    }
    public static int helper_01_knapsack_memo(int []wt,int []val,int maxWt,int idx,int [][]dp)
    {
        if(maxWt==0)
            return 0;
        if(idx<0)
            return 0;
        if(dp[idx][maxWt]!=-1)
            return dp[idx][maxWt];
        //dont pick
        int op1 = helper_01_knapsack_memo(wt,val,maxWt,idx-1,dp);
        //pick
        int op2=0;
        if(maxWt-wt[idx]>=0)
            op2 = helper_01_knapsack_memo(wt, val, maxWt-wt[idx], idx-1,dp)+val[idx];
        int fans = Math.max(op1,op2);
        dp[idx][maxWt]= fans;
        return fans;
    }
    public static int helper_unbounded_knapsack_memo(int []wt,int []val,int maxWt,int idx,int [][]dp)
    {
        if(maxWt==0)
            return 0;
        if(idx<0)
            return 0;
        if(dp[idx][maxWt]!=-1)
            return dp[idx][maxWt];
        //dont pick
        int op1 = helper_01_knapsack_memo(wt,val,maxWt,idx-1,dp);
        //pick
        int op2=0;
        if(maxWt-wt[idx]>=0)
            op2 = helper_01_knapsack_memo(wt, val, maxWt-wt[idx], idx,dp)+val[idx];
        int fans = Math.max(op1,op2);
        dp[idx][maxWt]= fans;
        return fans;
    }
    public int knapsack(int W, int val[], int wt[]) {
        int n = wt.length;
        int [][]dp = new int[n+1][W+1];
        for(int []d:dp)
            Arrays.fill(d,-1);
        return helper_01_knapsack_memo(wt,val,W,wt.length-1,dp);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i:nums)
            sum+=i;
        if(sum%2!=0)
            return false;
        int tar = sum/2;
        int [][]dp = new int [nums.length+1][tar+1];
        for(int []d:dp)
            Arrays.fill(d,-1);
        return helper_memo(nums,nums.length-1,tar,dp);
    }

    
    
    public static void main(String[] args) {
        
    }
}