class Node
{
    int val;
    Node next;
    Node(int val,Node next)
    {
        this.val=val;
        this.next=next;
    }
}
public class LinkedList {
    static void printLL(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.println(temp.val);
            temp=temp.next;
        }
    }
    static int sizeOfLL(Node head)
    {
        int size=0;
        Node temp=head;
        while(temp!=null)
        {
            size++;
            temp=temp.next;
        }
        return size;
    }

    static Node reverseLL(Node head)
    {
        Node curr=head;
        Node prev=null;
        Node future=null;
        while(curr!=null)
        {
            future = curr.next;
            curr.next=prev;
            prev=curr;
            curr=future;
        }
        return prev;
    }
    static Node midLLSecondEven(Node head)
    {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static Node midLLFirstEven(Node head)
    {
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    boolean isPalindrome(Node head)
    {
        Node h1=head;
        //Find the Mid
        Node mid = midLLFirstEven(h1);
        //Make the LL2
        Node h2=mid.next;
        //Divide into 2 Halfs
        mid.next=null;
        //Reverse Second Half
        h2=reverseLL(h2);
        while(h1!=null && h2!=null)
        {
            if(h1.val!=h2.val)
                return false;
            h1=h1.next;
            h2=h2.next;
        }
        return true;
    }
    //Fold a LL / Compress A LinedList
    void reorder(Node head)
    {
        Node h1=head;
        //Find the Mid
        Node mid = midLLFirstEven(h1);
        //Make the LL2
        Node h2=mid.next;
        //Divide into 2 Halfs
        mid.next=null;
        h2=reverseLL(h2);

        Node f1=null;
        Node f2=null;
        while(h1!=null && h2!=null)
        {
            //save future
            f1=h1.next;
            f2=h2.next;
            //Build new Connection

            h1.next=h2;
            h2.next=f1;

            h1=f1;
            h2=f2;
        }
    }

    boolean isCycle(Node head)
    {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow)
                return true;
        }
        return false;
    }
    Node startingNodeOfCycle(Node head)
    {
        Node slow=head;
        Node fast=head;
        Node t1= null;
        Node t2=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow)
            {
                t1=slow;
                break;
            }
        }
        while(t1!=t2)
        {
            t1=t1.next;
            t2=t2.next;
        }
        return t1;
    }

    int lengthOfCycle(Node head)
    {
        Node t1= startingNodeOfCycle(head);
        Node t2=t1.next;
        int c=1;
        while(t2!=t1)
        {
            t2=t2.next;
            c++;
        }
        return c;
    }
    public static void main(String[] args) {
        Node n1=new Node(10,null);
        Node n2=new Node(20,null);
        Node n3=new Node(30,null);
        Node n4=new Node(40,null);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        printLL(n1);
        
    }
}
