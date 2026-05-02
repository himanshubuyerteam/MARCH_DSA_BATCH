import java.util.*;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;
class Node{
    int val;
    Node left;
    Node right;
}
public class Tree {

    public int size(Node root)
    {
        if(root==null)
            return 0;
        int left_count = size(root.left);
        int right_count = size(root.right);
        return left_count+right_count+1;
    }
    public int sum(Node root)
    {
        if(root==null)
            return 0;
        int left_sum = sum(root.left);
        int right_sum = sum(root.right);
        return left_sum+right_sum+root.val;
    }

    public int max(Node root)
    {
        if(root==null)
            return Integer.MIN_VALUE;
        int left_max = max(root.left);
        int right_max = max(root.right);
        return Math.max(left_max,
               Math.max(root.val,right_max));
    }

    public int min(Node root)
    {
        if(root==null)
            return Integer.MAX_VALUE;
        int left_min = min(root.left);
        int right_min = min(root.right);
        return Math.min(left_min,
               Math.min(root.val,right_min));
    }

    public boolean isPresent(Node root,int key)
    {
        if(root==null)
            return false;
        if(root.val==key)
            return true;
        boolean left_present = isPresent(root.left, key);
        boolean right_present = isPresent(root.right, key);
        boolean final_ans = left_present || right_present;
        return final_ans;
    }
    public boolean RootToNodePath(Node root,int key,ArrayList<Integer>path)
    {
        if(root==null)
            return false;
        if(root.val==key)
        {
            path.add(root.val);
            return true;
        }
        boolean left_present = RootToNodePath(root.left, key,path);
        boolean right_present = RootToNodePath(root.right, key,path);
        boolean final_ans = left_present || right_present;
        if(final_ans==true)
            path.add(root.val);
        return final_ans;
    }

    //InterviewBit Solution
    // ArrayList<Integer>al;
    // public boolean helper(TreeNode root,int key)
    // {
    //     if(root==null)
    //         return false;
    //     boolean ra1=helper(root.left, key);
    //     boolean ra2=helper(root.right, key);
    //     if(ra1 || ra2 || root.val==key)
    //     {
    //         al.add(root.val);
    //         return true;
    //     }
    //     else
    //         return false;
    // }
    // public ArrayList<Integer> solve(TreeNode A, int B) {
    //     al=new ArrayList<>();
    //     helper(A,B);
    //     Collections.reverse(al);
    //     return al;
    // }

    void printPreorder(Node root)
    {
        if(root==null)
            return;
        System.out.println(root.val);
        printPreorder(root.left);
        printPreorder(root.right);
    }
    void printInorder(Node root)
    {
        if(root==null)
            return;
        printInorder(root.left);
        System.out.println(root.val);
        printInorder(root.right);
    }
    void printPostorder(Node root)
    {
        if(root==null)
            return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.println(root.val);
    }

    public ArrayList<Node> levelOrder(Node root)
    {
        Queue<Node>q = new LinkedList<>();
        q.add(root);
        ArrayList<Node>levelOrder= new ArrayList<>();
        while(q.isEmpty())
        {
            Node fnt = q.remove();
            levelOrder.add(fnt);
            if(fnt.left!=null)
                q.add(fnt.left);
            if(fnt.right!=null)
                q.add(fnt.right);
        }
        return levelOrder;
    }
    public ArrayList<ArrayList<Node>> levelWiseLevelOrder(Node root)
    {
        Queue<Node>q = new LinkedList<>();
        q.add(root);
        // ArrayList<Node>levelOrder= new ArrayList<>();
        ArrayList<ArrayList<Node>>levelOrder = new ArrayList<>();
        while(q.isEmpty())
        {
            int size = q.size();
            ArrayList<Node>levelAns = new ArrayList<>();
            while(size-->0)
            {
                Node fnt = q.remove();
                levelAns.add(fnt);
                if(fnt.left!=null)
                    q.add(fnt.left);
                if(fnt.right!=null)
                    q.add(fnt.right);
            }
            levelOrder.add(new ArrayList<>(levelAns));
            //levelOrder.add(levelAns);
        }
        return levelOrder;
    }
    public static void main(String[] args) {
        
    }
}
