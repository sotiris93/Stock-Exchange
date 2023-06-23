package com.sotiris.stockexchange.inheritance_exercise;

public class Employee extends Person {
    private double salary;

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public int calculateSomething() {
        return salary % 1 == 0 ? String.valueOf(salary).length() - 2 : String.valueOf(salary).length() - 1;
    }
}
