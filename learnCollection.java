import java.util.ArrayList;
import java.util.*;

public class learnCollection {
    public static void main(String[] args) {
        // // List<Integer> all = new ArrayList<>();
        // ArrayList<Integer> al = new ArrayList<>();
        // for(int i=0;i<9;i++)
        // {
        //     al.add(i);
        // }
        // System.out.println(al);
        // List<Integer> part = al.subList(2, 6);
        // System.out.println(part);

        // LinkedList<Integer>ll = new LinkedList<>();
        // ll.add(1);
        // ll.add(2);
        // ll.addLast(3);
        // ll.addFirst(0);
        // ll.add(2, 2000);
        // ll.get(2);
        // ll.removeLast();
        // ll.removeFirst();
        // ll.peekFirst();
        // ll.peekLast();
        // ll.remove(2);
        // ll.remove(2000);
        // System.out.println(ll);

        // Stack<Integer> st = new Stack<>();
        // st.push(10);
        // st.push(20);
        // st.push(30);

        // System.out.println(st.peek());
        // System.out.println(st.size());
        // System.out.println(st.pop());


    }
}


class MyHashMap {
    int num_of_buckets;
    LinkedList<int[]>[] buckets;  // Each node stores [key, value] pair

    public MyHashMap() {
        num_of_buckets = 15000;
        buckets = new LinkedList[num_of_buckets];
        for (int i = 0; i < num_of_buckets; i++)
            buckets[i] = new LinkedList<>();
    }

    public void put(int key, int value) {
        int bucketIdx = getHash(key);
        // If key exists, update its value
        for (int[] pair : buckets[bucketIdx]) {
            if (pair[0] == key) {
                pair[1] = value;
                return;
            }
        }
        // Key not found, add new pair
        buckets[bucketIdx].addLast(new int[]{key, value});
    }

    public int get(int key) {
        int bucketIdx = getHash(key);
        for (int[] pair : buckets[bucketIdx]) {
            if (pair[0] == key)
                return pair[1];
        }
        return -1; // Key not found
    }

    public void remove(int key) {
        int bucketIdx = getHash(key);
        buckets[bucketIdx].removeIf(pair -> pair[0] == key);
    }

    public int getHash(int key) {
        return key % num_of_buckets;
    }
}



class MyHashMap {
    private static final double LOAD_FACTOR = 0.75;
    private static final int INITIAL_CAPACITY = 10; // No need for power of 2 anymore

    private LinkedList<int[]>[] buckets;
    private int capacity;
    private int size;

    public MyHashMap() {
        capacity = INITIAL_CAPACITY;
        buckets = new LinkedList[capacity];
        size = 0;
        initBuckets();
    }

    private void initBuckets() {
        for (int i = 0; i < capacity; i++)
            buckets[i] = new LinkedList<>();
    }

    // Simple and clean hash — no bit tricks
    private int getHash(int key) {
        return Math.abs(key % capacity);
    }

    public void put(int key, int value) {
        int idx = getHash(key);
        for (int[] pair : buckets[idx]) {
            if (pair[0] == key) {
                pair[1] = value;
                return;
            }
        }
        buckets[idx].addLast(new int[]{key, value});
        size++;

        if ((double) size / capacity > LOAD_FACTOR)
            resize();
    }

    public int get(int key) {
        int idx = getHash(key);
        for (int[] pair : buckets[idx]) {
            if (pair[0] == key)
                return pair[1];
        }
        return -1;
    }

    public void remove(int key) {
        int idx = getHash(key);
        boolean removed = buckets[idx].removeIf(pair -> pair[0] == key);
        if (removed) size--;
    }

    private void resize() {
        capacity *= 2;
        LinkedList<int[]>[] oldBuckets = buckets;
        buckets = new LinkedList[capacity];
        initBuckets();
        size = 0;

        for (LinkedList<int[]> bucket : oldBuckets)
            for (int[] pair : bucket)
                put(pair[0], pair[1]);
    }
}