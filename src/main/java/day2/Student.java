package day2;

class Student implements Comparable<Student>{
    String name;
    int score;

    public Student(){
        this.name = "";
        this.score = 0;
    }

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        if(this.score == o.score) return 0;
        return this.score < o.score ? -2 : 3;
    }

}