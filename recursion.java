//MUST WATCH------>
https://www.youtube.com/playlist?list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs
public class recursion {
    
    public static void f3(){
        System.out.println("INSIDE f3");
    }
    public static void f2(){
        System.err.println("hey");
        f3();
        System.out.println("see ya");
    }
    public static void f1(){
        System.err.println("hello");
        f2();
        System.out.println("BYE");
    }

    public static void pd(int n)
    {
        if(n==0)
        {
            return;
        }
        System.out.println(n);
        pd(n-1);
    }
    public static void pi(int n)
    {
        if(n==0)
        {
            return;
        }
        pi(n-1);
        System.out.println(n);
    }

    public static int  fact(int n)
    {
        if(n==0)
            return 1;
        int rans=fact(n-1);
        int mans=rans*n;
        return mans;
    }

    public static int product(int a,int b)
    {
        if(b>a)
            return product(b, a);
        if(b==1)
            return a;
        int rans=product(a,b-1);
        int mans=a + rans;
        return mans;
    }
        public static void main(String[] args) {
        // f1();
        // pd(5);
        pi(5);
    }

    public static int stairCase(int n)
    {
        if(n<=1)
            return 1;
        int rans1=stairCase(n-1);
        int rans2=stairCase(n-2);
        int mans=rans1+rans2;
        return mans;
    }
}
