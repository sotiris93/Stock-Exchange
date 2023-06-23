package com.sotiris.stockexchange.inheritance_exercise;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Person", 50),
                new Student("Student", 15, "School"),
                new HighSchoolStudent("HighSchoolStudent", 5, "HighSchool", 5),
                new Employee("Employee", 40, 100000));

        int sum = 0;
        for (Person person : people) {
            if(person instanceof Student){
                System.out.println("Student");
            }
            sum += person.calculateSomething();
        }
        Employee employee = new Employee("e", 4, 100.5);
        System.out.println("Employee salary length: " + employee.calculateSomething());
        System.out.println("Sum: " + sum);

        String a = "abc";
        String b = "abc";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());


    }
}
