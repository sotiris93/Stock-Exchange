package com.sotiris.stockexchange.inheritance_exercise;

import java.util.List;
import java.util.Set;

public class Student extends Person {
    protected String schoolName;

    public Student(String name, int age, String schoolName) {
        super(name, age);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    @Override
    public int calculateSomething() {
        int counter = 0;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        for(Character  letter : schoolName.toLowerCase().toCharArray()) {
            if(vowels.contains(letter)) {
                counter++;
            }
        }

//        for (int i = 0; i < schoolName.length(); i++) {
//            if (
//                    schoolName.charAt(i) == 'a' ||
//                            schoolName.charAt(i) == 'e' ||
//                            schoolName.charAt(i) == 'i' ||
//                            schoolName.charAt(i) == 'o' ||
//                            schoolName.charAt(i) == 'u') {
//
//                counter++;
//            }
//        }
        return counter;
    }

}
