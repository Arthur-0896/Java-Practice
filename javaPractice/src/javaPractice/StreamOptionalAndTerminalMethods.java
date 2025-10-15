package javaPractice;


import java.util.*;
import java.util.stream.*;
public class StreamOptionalAndTerminalMethods {
  public static void main(String args[]) {
    List<Readings> Readingss = Arrays.asList(new Readings(2022,10,406.5), new Readings(2023,11,406.4), new Readings(2021,9,406.8));
   
    OptionalDouble max = Readingss.stream().mapToDouble(r -> r.getReadings()).reduce((v1 ,v2) -> Math.max(v1,v2));
   
    if(max.isPresent()) {
        System.out.println("Max is: " + max.getAsDouble());
    } else {
        System.out.println("List is empty.");
    }
   
    OptionalDouble min = Readingss.stream().mapToDouble(r -> r.getReadings()).reduce((v1,v2) -> Math.min(v1,v2));
   
    if(min.isPresent()) {
        System.out.println("Min is: " + min.getAsDouble());
    } else {
        System.out.println("List is empty.");
    }
   
    Stream<Double> doubleStream = Stream.of(1.0, 2.3, 4.4, 5.9);
   
    Optional<Double> doubleOptional = doubleStream.findFirst();
   
    if(doubleOptional.isPresent()) {
        System.out.println("First Double: " + doubleOptional.get());
    } else {
        System.out.println("Empty Optional");
    }
   
    Readings r = new Readings(2099,8,406.1);
   
    Optional<Readings> optionalReadings = Optional.ofNullable(r);
   
    Readings Readings = optionalReadings.orElse(new Readings(2017,4,407.0));
   
    System.out.println(Readings.getReadings());
   
   
    boolean yearIsPresent = Readingss.stream().mapToInt(read -> read.getYear()).anyMatch(y -> y == 2022);
   
    boolean yearIsNotPresent = Readingss.stream().mapToInt(read -> read.getYear()).noneMatch(y -> y == 2011);
   
    boolean allGreaterThan406 = Readingss.stream().mapToDouble(read -> read.getReadings()).allMatch(value -> value > 406);
   
    System.out.println("Readings for 2017 found? " + yearIsPresent);
   
        System.out.println("Readings for 2011 not found? " + yearIsNotPresent);
       
                System.out.println("All greater than 406? " + allGreaterThan406);


    //optionalReadings.ifPresent(Readings -> System.out.println("Readings is: " + Readings.getReadings()));
   
  }
}

class Readings {
    int year;
    int month;
    double Readings;
   
    Readings(int year, int month, double Readings) {
        this.year = year;
        this.month = month;
        this.Readings = Readings;
    }
   
    public double getReadings() {
        return Readings;
    }
     public int getYear() {
        return year;
    }
}
