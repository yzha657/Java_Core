package day4;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(3,5,1,4,100,-1);

        //map
        List<Integer> square = ls.stream().map(i -> i * i).toList();
        System.out.println(square);

        //filter
        List<Integer> greaterThan0 = ls.stream().filter(i -> i >= 0).toList();
        System.out.println(greaterThan0);

        //sorted
        List<Integer> sorted = ls.stream().sorted().toList();
        System.out.println(sorted);

        //forEach
        ls.stream().forEach(i -> System.out.print(i+" "));
        System.out.println();

        //flatmap
        List<List<Integer>> ls2d = Arrays.asList(ls, square);
        List<Integer> times3 = ls2d.stream().flatMap(Collection::stream).map(i -> i*3).toList();
        System.out.println(times3);

        //distinct
        List<Integer> unique = times3.stream().distinct().toList();
        System.out.println(unique);

        //limit
        List<Integer> lessThan3 = ls.stream().limit(3).toList();
        System.out.println(lessThan3);

        //count
        System.out.println(ls.stream().filter(i -> i < 100).count() + " elements less than 100.");

        //max
        System.out.println(ls.stream().max((a, b) -> a-b) + " is the largest element.");

        //reduce
        System.out.println(ls.stream().reduce(0, Integer::sum) + " is the sum.");
    }
}
