package LMS;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        q1();
        int[] a1 = {1,5,1,3,-2,9,13};
        int[] a2 = {-3, 7, 12, -11, 15, 8};
        int[] a3 = q2(a1, a2);
        System.out.println("Arrays before merging:" + Arrays.toString(a1) + Arrays.toString(a2));
        System.out.println("Array after merging: " + Arrays.toString(a3));

        System.out.println("Second largest number in a1 is : " + q3(a1));
        System.out.println("Second largest number in a2 is : " + q3(a2));
        System.out.println("Second largest number in a3 is : " + q3(a3));
    }

    //Write a program to implement the following activity diagram:
    //  1. Get keyboard input x
    //  2. If x > 0, loop x times call doSomething method and display result
    //      doSomething method could be one of the following:
    //          a. Sum of 1 to x
    //          b. Display the current timestamp (picked)
    //          c. Create file with name x.txt
    //          d. Use the parameter x to do something reasonable
    //  3. If x <= 0, show error message
    //  4. If x = 'q', show quit message and quit
    private static void q1(){
        Scanner in = new Scanner(System.in);
        while(true) {
            String s = in.next();
            if(s.equals("q")){
                System.out.println("Quiting...See you next time!");
                break;
            }
            try{
                int x = Integer.parseInt(s);
                if(x <= 0) System.out.println("Please type in a number greater than 0.");
                else{
                    for(int i = 0; i < x; i++){
                        doSomething(x);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Please type in a number.");
            }
        }
    }

    private static void doSomething(int x){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
    }

    //Merge two arrays of int
    private static int[] q2(int[] a1, int[] a2){
        int[] res = new int[a1.length + a2.length];
        int counter = 0;
        for(int i : a1){
            res[counter++] = i;
        }
        for(int i : a2){
            res[counter++] = i;
        }
        return res;
    }

    //Find the second largest number inside an array of int
    private static int q3(int[] a){
        if(a.length <= 1) return -1;
        int max = Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE;

        for(int i : a){
            if(i >= max){
                res = max;
                max = i;
            }else if(i > res){
                res = i;
            }
        }

        return res;
    }
}
