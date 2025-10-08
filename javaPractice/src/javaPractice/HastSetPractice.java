package javaPractice;

import java.util.HashSet;

class Student2 {
    public int id;
    public String name;
    public Student2(String name, int id) {
        this.name = name; 
        this.id = id;
    }
    public int hashCode() {
        return this.id;
    }
    public String toString() {
        return "Student: " + this.name + "@" + Integer.toHexString(hashCode());
    }
    public boolean equals(Object o) {
        if (o instanceof Student2) {
           Student2 s = (Student2) o;
           return s.id == this.id ? true : false;
        }
        return false;
    }
 }
 public class HastSetPractice {
    public static void main(String[] args) {
    HashSet<Student2> studentList = new HashSet<>();
    Student2 st1 = new Student2("Nimit", 1);
    Student2 st2 = new Student2("Rahul", 3);
    Student2 st3 = new Student2("Nimit", 2);
    studentList.add(st1);
    studentList.add(st2);
    studentList.add(st3);
    System.out.println(studentList.size());
    st1.id = 2;
    System.out.println(studentList.size());
    
    Student2 st4 = new Student2("Nimit", 1);
    
    
    System.out.println(studentList);

    System.out.println(studentList.contains(st4));
   }
 }