import javax.swing.tree.Node;
import javax.swing.tree.Node;

public class bst {
    public int sum(Node root)
    {
        if(root==null)
            return 0;
        int lsum = sum(root.left);
        int rsum = sum(root.right);
        return lsum+rsum+root.val;
    }
    public int size(Node root)
    {
        if(root==null)
            return 0;
        int lsum = size(root.left);
        int rsum = size(root.right);
        return lsum+rsum+1;
    }
    public int maximumOfTree(Node root)
    {
        Node temp = root;
        while(temp.right!=null)
        {
            temp=temp.right;
        }
        return temp.val;
    }
    public int minimumOfTree(Node root)
    {
        Node temp = root;
        while(temp.left!=null)
        {
            temp=temp.left;
        }
        return temp.val;
    }
    public boolean find(Node root,int key)
    {
        if(root==null)
            return false;
        if(root.val == key)
            return true;
        if(root.val>key)
            return find(root.left,key);
        else
            return find(root.right,key);
    }
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        
        if(root==null)
            return null;
        if(root.val>p.val && root.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        else if(root.val<p.val && root.val<q.val)
            return lowestCommonAncestor(root.right,p,q);
        else
            return root;
    }
    public Node LCA_BST(Node root,Node p,Node q)
    {
        if(root==null)
            return null;
        Node temp=root;
        while(temp!=null)
        {
            if(root.val>p.val && root.val>q.val)
                temp=root.left;
            else if(root.val<p.val && root.val<q.val)
                temp=root.right;
            else
                return root;
        }
        return null;
    }

    class helperObj
    {
        int min;
        int max;
        boolean isBst;
        helperObj(int min,int max,boolean isBst)
        {
            this.min=min;
            this.max=max;
            this.isBst=isBst;
        }
        helperObj(){}
    }
    public helperObj isBSTHelper(Node root)
    {
        if(root==null)
            return helperObj(Integer.MAX_VALUE,Integer.MIN_VALUE,true);
        helperObj lans = isBSTHelper(root.left);
        helperObj rans = isBSTHelper(root.right);

        boolean c1 = lans.max<root.val;
        boolean c2 = rans.min>root.val;
        boolean c3 = lans.isBst && rans.isBst;
        
        helperObj mans = new helperObj();
        mans.min = Math.min(lans.min,Math.min(rans.min,root.val));
        mans.max = Math.max(lans.max,Math.max(rans.max,root.val));
        mans.isBst = c1 && c2 && c3;
        return mans;
    }
    public boolean isBST(Node root)
    {
        helperObj rootAns = isBSTHelper(root);
        return rootAns.isBst;
    }
    public Node deleteNode(Node root, int key) {
        if(root==null)
            return null;
        if(root.val>key)
            root.left = deleteNode(root.left,key);
        else if(root.val<key)
            root.right = deleteNode(root.right,key);
        else // root.val == key
        {
            //c1 = RC LC Null
            //c2 = RC LC One is NOT NULL
            if(root.left==null || root.right==null)
            {
                // return root.left==null?root.right:root.left;
                if(root.left==null)
                    return root.right;
                else
                    return root.left;
            }
            //Both LC and RC are not NULL
            // Node replacement = getMax(root.left);
            Node replacement = getMin(root.right);
            root.val = replacement.val;
            // root.left = deleteNode(root.left,replacement.val);
            root.right = deleteNode(root.right,replacement.val);
        }
        return root;

    }

    public Node getMax(Node root)
    {
        while(root.right!=null)
            root=root.right;
        return root;
    }
    public Node getMin(Node root)
    {
        while(root.left!=null)
            root=root.left;
        return root;
    }
}
