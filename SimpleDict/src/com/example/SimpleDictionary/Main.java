// Main.java
// description: main method and testing for SimpleDictionary object class
// author: pcostjr
// created: 5.9.2025
// last update: 5.9.2025
package com.example.SimpleDictionary;

// Additional submission nodes


// import collections class from java library so we can create an array of shuffles fruits
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
        SimpleDictionary fruitSD = new SimpleDictionary();

        // check if collection is empty
        System.out.println("Dictionary created. Results from initial empty check: " + fruitSD.isEmpty());

        // for each fruit in fruits. add it to the collection
        for(String fruit : fruits) {
            fruitSD.add(fruit, fruit);
        }

        // check the size. Since we alphabetized the collection, the size should be 25 since every node is on the right
        // (creating basically a linked list.)
        System.out.println(fruits.size() + " Added to collection. Current Size: " + fruitSD.size());

        for(int i = 0; i < 5; i++) {
            // obtain the key that we know is inside the collection
            String fruit = fruitSD.get(fruits.get(rand.nextInt(fruits.size())));
            System.out.println("Result from contains() on key " + fruit + " : " + fruitSD.contains(fruit));
            System.out.println("Result from get on key " + fruit + " : " + fruitSD.get(fruit));
        }

        // manually check for a couple invalid items
        System.out.println("Result from contains() on key egg: " + fruitSD.contains("egg"));
        try {
            System.out.println("Result from get on key egg:" + fruitSD.get("egg"));
        }
        catch(Exception e) {
            System.out.println(e);
        }

        // reset on randomly shuffled list
        fruitSD = new SimpleDictionary();
        Collections.shuffle(fruits);
        System.out.println("Shufflings fruits list and re-inserting into collection.");
        // for each fruit in fruits. add it to the collection
        for(String fruit : fruits) {
            fruitSD.add(fruit, fruit);
        }

        // check the size. Since we alphabetized the collection, the size should be 25 since every node is on the right
        // (creating basically a linked list.)
        System.out.println(fruits.size() + " Added to collection. Current Size: " + fruitSD.size());

        for(int i = 0; i < 5; i++) {
            // obtain the key that we know is inside the collection
            String fruit = fruitSD.get(fruits.get(rand.nextInt(fruits.size())));
            System.out.println("Result from contains() on key " + fruit + " : " + fruitSD.contains(fruit));
            System.out.println("Result from get on key " + fruit + " : " + fruitSD.get(fruit));
        }

        // manually check for a couple invalid items
        System.out.println("Result from contains() on key egg: " + fruitSD.contains("egg"));
        try {
            System.out.println("Result from get on key egg:" + fruitSD.get("egg"));
        }
        catch(Exception e) {
            System.out.println(e);
        }

    }
}