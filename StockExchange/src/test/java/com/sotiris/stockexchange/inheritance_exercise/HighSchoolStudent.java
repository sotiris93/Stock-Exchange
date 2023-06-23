package com.sotiris.stockexchange.inheritance_exercise;

public class HighSchoolStudent extends Student {
    private int gradeLevel;

    public HighSchoolStudent(String name, int age, String schoolName, int gradeLevel) {
        super(name, age, schoolName);
        this.gradeLevel = gradeLevel;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    @Override
    public int calculateSomething() {
        return gradeLevel >= 5 ? 1 : 0;
    }
}
