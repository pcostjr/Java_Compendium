// Main.java
// description: Tester file for HashDictionary
// author: pcostjr
// created: 5.11.2025
// last update: 5.11.2025
package com.example.HashDictionary;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // this list is alphabetical so we can check if we're doing the insertions correct
        List<String> fruits = Arrays.asList("apple", "banana", "blackberry", "cherry", "date", "elderberry", "fig", "grape",
                "honeydew", "kiwi","lemon","mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine",
                "ugli", "vanilla", "watermelon", "xigua", "yuzu", "zucchini");
        // random number generator for get testing
        Random rand = new Random();
        // sort this list alphabetically so we can check if we're doing the insertions correct
        Collections.sort(fruits);

        // initialize the dictionary
        HashDictionary fruitHD = new HashDictionary();

        // check if collection is empty
        System.out.println("Dictionary created. Populating...");

        // for each fruit in fruits. add it to the collection
        for(String fruit : fruits) {
            fruitHD.insert(fruit, fruit);
        }
        System.out.println("Populated. Performing search for a few known values");
        for(int i = 0; i < 5; i++) {
            String search = fruits.get(rand.nextInt(fruits.size()));
            String result = fruitHD.get(search);
            System.out.println("Result from searching for " + search + " is " + result);
        }

        System.out.println("Deleting some known values and then attemping to search for them.");
        for(int i = 0; i < 5; i++) {
            String search = fruits.get(rand.nextInt(fruits.size()));
            fruitHD.delete(search);
            String result = fruitHD.get(search);
            System.out.println("Result from searching for " + search + " is " + result);
        }
    }

}