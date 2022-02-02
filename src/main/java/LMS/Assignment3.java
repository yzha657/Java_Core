package LMS;

import java.util.*;

public class Assignment3 {
    public static void main(String[] args) {
        //Create List and Map.
        //List A contains 1,2,3,4,10(integer).
        //Map B contains ("a":"1")("b":"2")("c":"10") (key=string, value=string)
        //Get a list which contains all the elements in list A, but not in map B
        List<Integer> a = Arrays.asList(1,2,3,4,10);
        Map<String, String> b = new HashMap<>();
        b.put("a","1");
        b.put("b","2");
        b.put("c","10");
        List<Integer> ans = q1(a, b);
        System.out.println(ans);

        //Implement a group of classes that have common behavior/state as Shape.
        //Create Circle, Rectangle, Square for now as later on we may need more shapes.
        //They should have the ability to calculate the area. They should be able to compare using area.
        List<Shape> ls = new ArrayList<>();
        Shape circle = new Circle(1);
        Shape rectangle = new Rectangle(1, 3);
        Shape square = new Square(2);

        ls.add(circle);
        ls.add(rectangle);
        ls.add(square);

        Collections.sort(ls);

        for(Shape s : ls){
            System.out.println(s.getClass().getName() + " have area " + s.area() + " and perimeter " + s.perimeter() );
        }
    }

    private static List<Integer> q1(List<Integer> a, Map<String, String> b){
        List<Integer> ans = new ArrayList<>();
        Collection<String> valueSet = b.values();
        for(Integer i : a){
            if(!valueSet.contains(""+i)) ans.add(i);
        }
        return ans;
    }
}

interface Shape extends Comparable<Shape>{
    double area();
    double perimeter();

    @Override
    default int compareTo(Shape o) {
        if(this.area() == o.area()) return 0;
        return this.area() > o.area() ? 2 : -3;
    }
}

class Circle implements Shape{
    int radius;
    final double pi = 3.14;

    public Circle(int radius){
        this.radius = radius;
    }

    @Override
    public double area() {
        return radius * radius * pi;
    }

    @Override
    public double perimeter() {
        return 2 * radius * pi;
    }

}

class Rectangle implements Shape{
    int length;
    int width;

    public Rectangle(int length, int width){
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }

}

class Square implements Shape{
    int side;

    public Square(int side){
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double perimeter() {
        return 4 * side;
    }
}