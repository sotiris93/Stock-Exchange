package com.sotiris.stockexchange;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MyTest {

    @Test
    void myTest() {

        String text = "Java is a powerful powerful and popular programming language. Java is widely used in the industry. Java";

        Map<String, Integer> wordFrequencies = new HashMap<>();
//        BiFunction<String, Integer, String> mapper = (k, v) -> k.equals(v) ? counter++ : 1;
//        for(String word : text.split(" ")){
//            wordFrequencies.merge(word, 1, (currentFrequency, defaultValue) -> currentFrequency + 1);
//        }

        Arrays.stream(text.split(" "))
                .forEach(word ->  wordFrequencies.merge(word, 1, (currentFrequency, defaultValue) -> currentFrequency + 1));

        System.out.println(wordFrequencies);

        Map<Integer, List<String>> wordsPerFrequency = new HashMap<>();
        for(Map.Entry<String, Integer> mapEntry : wordFrequencies.entrySet()) {
            if(!wordsPerFrequency.containsKey(mapEntry.getValue())) {

                List<String> words = new ArrayList<>();
                words.add(mapEntry.getKey());
                wordsPerFrequency.put(mapEntry.getValue(),  words);

            } else{
                wordsPerFrequency.get(mapEntry.getValue()).add(mapEntry.getKey());
            }
        }
        System.out.println(wordsPerFrequency);

    }

//    @Test
//    void test2() {
//        String text = "Java is a powerful and popular programming language. Java is widely used in the industry. Java";
//        Map<Integer, List<String>> wordFrequencies = new HashMap<>();
//
//        String[] words = text.split(" ");
//
//        for(int i=0; i<words.length; i++) {
//            if(wordFrequencies)
//        }
//
//    }
}
