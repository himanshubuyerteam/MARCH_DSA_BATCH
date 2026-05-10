import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
class student
    {
        int id;
        int marks;
        student(int id,int marks)
        {
            this.id=id;
            this.marks=marks;
        }
    }
public class PQ {
    
   public static void main(String[] args) {
        // PriorityQueue<Integer>pq = new PriorityQueue<>();
        // PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        // pq.add(10);
        // pq.add(20);
        // pq.add(30);
        // pq.add(7);
        // System.out.println(pq.peek());
        // System.out.println(pq.size());
        // pq.remove();
        // System.out.println(pq.peek());
        // PriorityQueue<student>pq = new PriorityQueue<>((a,b)->b.marks-a.marks);
        PriorityQueue<student>pq = new PriorityQueue<>(
            (a,b)->{
                if(a.marks == b.marks)
                    return b.id-a.id;
                return b.marks-a.marks;
            }
        );
        student s1 = new student(1,100);
        student s2 = new student(2,90);
        student s3 = new student(3,95);
        student s4 = new student(4,100);

        pq.add(s1);
        pq.add(s2);
        pq.add(s3);
        pq.add(s4);

        while(pq.size()>0)
        {
            student s = pq.remove();
            System.out.println("Student id is "+s.id);
        }




   } 
}
