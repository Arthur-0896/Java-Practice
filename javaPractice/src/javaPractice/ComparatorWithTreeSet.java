package javaPractice;
import java.util.Comparator;
import java.util.TreeSet;

class Student implements Comparable<Student> {

    Student(int id, String name, int age, int totalMarks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.totalMarks = totalMarks;
    }

    int id;
    String name;
    int age;
    int totalMarks;

    

    @Override
    public String toString() {
        return ("id:" + id + " name:" + name + " age:" + age + " total marks:" + totalMarks);
    }

    @Override
    public int compareTo(Student other) {
            return this.id - other.id;
    }

}

class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int maxLength = Math.abs(o1.name.length() - o2.name.length());
        for(int i = 0 ; i < o1.name.length();i++) {
            if(o1.name.charAt(i) < o2.name.charAt(i)) {
                return -1;
            } else if(o1.name.charAt(i) > o2.name.charAt(i)) {
                return 1;
            }
        }
        return 0;
    }
}

class MarksComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.totalMarks - o2.totalMarks;
    }
}

public class ComparatorWithTreeSet {
	public static void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet<>(new NameComparator());

        TreeSet<Student> treeSetSortedByMarks = new TreeSet<>(new MarksComparator());

        Student s1 = new Student(1,"Lina", 23, 230);
        Student s2 = new Student(2,"Arthur", 29, 200);
        Student s3 = new Student(2,"Zen", 30, 255);
        Student s4 = new Student(2,"Mitul", 30, 300);

        treeSet.add(s1);
        treeSet.add(s2);
        treeSet.add(s3);
        treeSet.add(s4);

        treeSetSortedByMarks.addAll(treeSet);

        System.out.println("Sorting by name: ");
        for(Student student : treeSet) {
            System.out.println(student.name);
        }
        System.out.println();

        System.out.println("Sorting by Marks: ");
        for(Student student : treeSetSortedByMarks) {
            System.out.println(student.name + " " + student.totalMarks);
        }
    }
}

