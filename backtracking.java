import java.util.ArrayList;

class backtracking
{
    public void helper(int sr,int sc,int dr,int dc,String path,ArrayList<String>ans,int [][]arr)
    {
        if(sr==dr && sc==dc)
        {
            ans.add(path);
            return;
        }
        if(sr>dr || sc>dc || sr<0 || sc<0 || arr[sr][sc]==0)
        {
            return;
        }
        //Step1 Mark Visited -Blocked
        arr[sr][sc]=0;
        //Step2 Explore all 4 Directions
        helper(sr-1, sc, dr, dc, path+"U", ans, arr);
        helper(sr, sc+1, dr, dc, path+"R", ans, arr);
        helper(sr+1, sc, dr, dc, path+"D", ans, arr);
        helper(sr, sc-1, dr, dc, path+"L", ans, arr);
        // Step3 Unmark Visited -UnBlocked
        arr[sr][sc]=1;
    }
    public ArrayList<String> ratInMaze(int [][]arr)
    {
        ArrayList<String>ans=new ArrayList<>();
        int n=arr.length;
        int sr=0;
        int sc=0;
        int dr=n-1;
        int dc=n-1;
        helper(sr,sc,dr,dc,"",ans,arr);
        return ans;
    }

    public void helper_per(StringBuilder sb,int idx,ArrayList<String>ans)
    {
        if(idx==sb.length())
        {
            ans.add(sb.toString());
            return;
        }
        for(int i=idx;i<sb.length();i++)
        {
            swap(sb,i,idx);
            helper_per(sb,idx+1,ans);
            swap(sb,i,idx);
        }
    }
    public ArrayList<String> permutation(String str)
    {
        ArrayList<String>ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder(str);
        helper_per(sb,0,ans);
        return ans;
    }
    public void swap(StringBuilder sb,int i,int j)
    {
        char temp=sb.charAt(i);
        sb.setCharAt(i,sb.charAt(j));
        sb.setCharAt(j,temp);
    }
    public static void main(String[] args) {
        String str="ABC";
        backtracking obj=new backtracking();
        System.out.println(obj.permutation(str));
    }
}