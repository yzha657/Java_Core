package day2;

import java.util.*;

public class Assignment2 {

    public static void main(String[] args){
        PriorityQueue<Student> heap = new PriorityQueue<>();
        Deque<Student> stack = new ArrayDeque<>();
        TreeSet<Student> set = new TreeSet<>((a, b) -> b.score - a.score);
        Student s1 = new Student("Yuqing", 100);
        Student s2 = new Student();
        Student s3 = new Student("Xin", 60);

        heap.offer(s1);
        heap.offer(s2);
        heap.offer(s3);

        System.out.println("Lowest score is : " + heap.poll().score);

        stack.addFirst(s1);
        stack.addFirst(s2);
        stack.addFirst(s3);

        System.out.println("Last student is : " + stack.removeFirst().name);

        set.add(s1);
        set.add(s2);
        set.add(s3);

        System.out.println("Highest score is : " + set.first().score);
    }

}
// Output:
//        Lowest score is : 0
//        Last student is : Xin
//        Highest score is : 100