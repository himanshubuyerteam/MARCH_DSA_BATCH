import java.lang.reflect.Array;
import java.util.Arrays;

class dp1
{
    public static int fib(int x)
    {
        // System.out.println("Calculation Fib of "+x);
        if(x<=1)
            return x;
        int ra1 = fib(x-1);
        int ra2 = fib(x-2);
        return ra1+ra2;
    }
    //Memorization Or Top Down Approach
    //O(n) TC o(n) SC
    public static int fib_memo(int x,int []notes)
    {
        if(x<=1)
            return x;
        if(notes[x]!=-1)
            return notes[x];
        // System.out.println("Calculation Fib of "+x);
        int ra1 = fib_memo(x-1,notes);
        int ra2 = fib_memo(x-2,notes);
        notes[x]=ra1+ra2;
        return ra1+ra2;
    }
    public static int fib_tab(int x)
    {
        int [] arr = new int[x+1];
        arr[0] = 0 ;
        arr[1] = 1 ;
        for(int i = 2;i<arr.length;i++)
        {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[x];
    }
    // SR- Source Row 
    // SC- Source Column
    // DR- Destination Row
    // DC- Destination Column
    public static int mazePath(int sr,int sc,int dr,int dc)
    {
        if(sr==dr && sc==dc)
            return 1;
        if(sr>dr || sc>dc)
            return 0;
        int ra1 = mazePath(sr+1, sc, dr, dc);
        int ra2 = mazePath(sr, sc+1, dr, dc);
        return ra1+ra2;
    }
    public static int mazePath_memo(int sr,int sc,int dr,int dc,int [][]notes)
    {
        if(sr==dr && sc==dc)
            return 1;
        if(sr>dr || sc>dc)
            return 0;
        if(notes[sr][sc]!=-1)
            return notes[sr][sc];
        int ra1 = mazePath(sr+1, sc, dr, dc);
        int ra2 = mazePath(sr, sc+1, dr, dc);
        return notes[sr][sc]=ra1+ra2;
    }
    public static int mazePath_tab(int dr,int dc)
    {
        int [][]dp = new int[dr+1][dc+1];
        int n=dp.length;
        for(int i=0;i<n;i++)
            dp[i][n-1]=1;
        for(int i=0;i<n;i++)
            dp[n-1][i]=1;

        for(int i=n-2;i>=0;i--)
        {
            for(int j=n-2;j>=0;j--)
            {
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }

    public static int minCost(int sr,int sc,int dr,int dc,int [][]arr)
    {
        if(sr==dr && sc==dc)
            return arr[sr][sc];
        if(sr>dr || sc>dc)
            return 0;
        int ra1 = minCost(sr+1, sc, dr, dc,arr);
        int ra2 = minCost(sr, sc+1, dr, dc,arr);
        int myans = Math.min(ra1,ra2)+arr[sr][sc];
        return myans;
    }
    public static int minCost_memo(int sr,int sc,int dr,int dc,
                                    int [][]arr,int [][]notes)
    {
        if(sr==dr && sc==dc)
            return arr[sr][sc];
        if(sr>dr || sc>dc)
            return 0;
        if(notes[sr][sc]!=-1)
            return notes[sr][sc];
        int ra1 = minCost_memo(sr+1, sc, dr, dc,arr,notes);
        int ra2 = minCost_memo(sr, sc+1, dr, dc,arr,notes);
        int myans = Math.min(ra1,ra2)+arr[sr][sc];
        notes[sr][sc]=myans;
        return myans;
    }

    public static int minCost_tab(int [][]arr,int dr,int dc)
    {
        int n = arr.length;
        int m = arr[0].length;
        int [][]dp = new int[n][m];
        for(int i=dp.length-1;i>=0;i--)
        {
            for(int j=dp[0].length-1;j>=0;j--)
            {
                if(i==dp.length-1 && j==dp[0].length-1)
                    dp[i][j]=arr[i][j];
                else if(i==dp.length-1)  //Last Row
                    dp[i][j]=arr[i][j]+dp[i][j+1];
                else if(j==dp[0].length-1) //last col
                    dp[i][j]=arr[i][j]+dp[i+1][j];
                else
                {
                    int op1 = dp[i+1][j];
                    int op2 = dp[i][j+1];

                    dp[i][j]=Math.min(op1,op2)+arr[i][j];
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        // int ans = fib(7);
        int input = 7;
        int []notes = new int[input+1];
        Arrays.fill(notes, -1);
        // System.out.println(ans);
        // System.out.println(fib_memo(7, notes));
        int a1 = fib(input);
        int a2 = fib_memo(input, notes);
        int a3 = fib_tab(input);

        // System.out.println("Input 1 "+ a1); 
        // System.out.println(" Input 2 "+ a2);
        // System.out.println(" Input 3 "+ a3);

        int sr=0;
        int sc=0;
        int dr=2;
        int dc = 2;
        int [][]arr = new int[dr+1][dc+1];
        for(int []a:arr)
                Arrays.fill(a, -1);
        int b1 = mazePath(sr, sc, dr, dc);
        int b2 = mazePath_memo(sr, sc, dr, dc, arr);

        System.out.println("Ans1 "+b1);
        System.out.println("Ans2 "+b2);



    }
}