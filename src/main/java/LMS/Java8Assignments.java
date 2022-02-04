package LMS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java8Assignments {

    //output:
    //[avi, ako]
    //Uppercase: [AVI, AKO]
    //Original List: [1, 2, 3, 55, -3]
    //o1,e2,o3,o55,o-3,
    //Average value is 11.6

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Person p1 = new Person("avi",10,"m");
        Person p2 = new Person("yu", 25, "m");
        Person p3 = new Person("ako", 33, "f");
        list.add(p1);
        list.add(p2);
        list.add(p3);
        List<String> res = search(list);
        System.out.println(res);
        System.out.println("Uppercase: " + upperCase(res));

        List<Integer> l2 = Arrays.asList(1,2,3,55,-3);
        System.out.println("Original List: " + l2);
        System.out.println(getString(l2));

        System.out.println("Average value is " + average(l2));


    }

    //Given a list of Objects, write a method that returns a list of all strings taht start with the letter 'a' and have exactly 3 letters.
    private static List<String> search(List<Person> list){
        List<String> res = new ArrayList<>();
        return list.stream().map(a->a.name).filter(a->{
            return a.startsWith("a") && a.length()==3;
        }).toList();
    }

    //Each element should be preceded by the letter 'e' if the number is even, preceded by the letter 'o' if the number is odd.
    private static String getString(List<Integer> list){
        return list.stream().reduce("", (sum, i) -> {
            if((i%2) == 0) {
                sum += "e"+i+",";
            }else{
                sum += "o"+i+",";
            }
            return sum;
        }, String::concat);
    }

    //Returns the average of a list of integers.
    private static Double average(List<Integer> list){
        return list.stream().mapToDouble(a -> a.intValue()).average().getAsDouble();
    }

    //Converts all strings in a list to their upper case.
    private static List<String> upperCase(List<String> list){
        return list.stream().map(String::toUpperCase).toList();
    }
}

class Person{
    String name;
    int age;
    String sex;

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
