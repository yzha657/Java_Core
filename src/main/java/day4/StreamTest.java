package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(3,5,1,4,100,-1);

        //map
        List<Integer> square = ls.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println(square.toString());

        //filter
        List<Integer> greaterThan0 = ls.stream().filter(i -> i >= 0).collect(Collectors.toList());
        System.out.println(greaterThan0.toString());

        //sorted
        List<Integer> sorted = ls.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted.toString());

        //forEach
        ls.stream().forEach(i -> System.out.print(i+" "));
        System.out.println();

        //flatmap
        List<List<Integer>> ls2d = Arrays.asList(ls, square);
        List<Integer> times3 = ls2d.stream().flatMap(Collection::stream).map(i -> i*3).collect(Collectors.toList());
        System.out.println(times3.toString());

        //distinct
        List<Integer> unique = times3.stream().distinct().collect(Collectors.toList());
        System.out.println(unique.toString());

        //limit
        List<Integer> lessThan3 = ls.stream().limit(3).collect(Collectors.toList());
        System.out.println(lessThan3.toString());

        //count
        System.out.println(ls.stream().filter(i -> i < 100).count() + " elements less than 100.");

        //max
        System.out.println(ls.stream().max((a, b)-> a-b) + " is the largest element.");

        //reduce
        System.out.println(ls.stream().reduce(0, (subtotal, element) -> subtotal + element) + " is the sum.");
    }
}
