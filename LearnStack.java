import java.util.Stack;

class LearnStack
{
    public int longestValidParentheses(String s) {
        int oc=0;
        int cc=0;
        int score=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
                oc++;
            else
                cc++;
            if(oc==cc)
            {
                int curr_score=oc+cc;
                score=Math.max(score,curr_score);
            }
            if(cc>oc)
            {
                oc=0;
                cc=0;
            }
        }
        oc=0;
        cc=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            char ch=s.charAt(i);
            if(ch=='(')
                oc++;
            else
                cc++;
            if(oc==cc)
            {
                int curr_score=oc+cc;
                score=Math.max(score,curr_score);
            }
            if(cc<oc)
            {
                oc=0;
                cc=0;
            }
        }
        return score;
    }
    public boolean isValid(String s) {
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch= s.charAt(i);

            if(ch=='{' || ch=='[' || ch=='(')
                st.push(ch);
            else
            {
                if(st.size()==0)
                    return false;
                char topCh = st.peek();
                if(topCh=='[' && ch==']')
                    st.pop();
                else if(topCh=='{' && ch=='}')
                    st.pop();
                else if(topCh=='(' && ch==')')
                    st.pop();
                else
                    return false;
            }
        }
        if(st.size()==0)
            return true;
        else
            return false;
    }
    public int[] NGOR(int []arr)
    {
        Stack<Integer>st=new Stack<>();
        int []ans = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--)
        {
            while(st.size()>0 && st.peek()<arr[i])
                st.pop();
            if(st.size()==0)
                ans[i]=-1;
            else 
                ans[i]=st.peek();
            st.push(arr[i]);
        }
        return ans;
    }
    public int[] NSOR(int []arr)
    {
        Stack<Integer>st=new Stack<>();
        int []ans = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--)
        {
            while(st.size()>0 && st.peek()>arr[i])
                st.pop();
            if(st.size()==0)
                ans[i]=-1;
            else 
                ans[i]=st.peek();
            st.push(arr[i]);
        }
        return ans;
    }
    public int[] NGOL(int []arr)
    {
        Stack<Integer>st=new Stack<>();
        int []ans = new int[arr.length];
        // for(int i=arr.length-1;i>=0;i--)
        for(int i=0;i<arr.length;i++)
        {
            while(st.size()>0 && st.peek()<arr[i])
                st.pop();
            if(st.size()==0)
                ans[i]=-1;
            else 
                ans[i]=st.peek();
            st.push(arr[i]);
        }
        return ans;
    }
    public int[] NSOL(int []arr)
    {
        Stack<Integer>st=new Stack<>();
        int []ans = new int[arr.length];
        // for(int i=arr.length-1;i>=0;i--)
        int baseAns=-1;
        for(int i=0;i<arr.length;i++)
        {
            while(st.size()>0 && arr[st.peek()]<arr[i])
                st.pop();
            if(st.size()==0)
                ans[i]=baseAns;
            else 
                ans[i]=st.peek();
            // st.push(arr[i]);
            st.push(i);
        }
        return ans;
    }

    public int maxAreaOfReact(int []arr)
    {
        int []nsol=NSOL(arr);
        int []nsog=NSOR(arr);
        int n=arr.length;
        int maxArea=0;
        for(int i=0;i<n;i++)
        {
            int curr_width = nsog[i]-nsol[i]-1;
            int curr_area= arr[i]*curr_width;
            maxArea=Math.max(maxArea,curr_area);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        
    }
}