package com.example.HashDictionary;

import java.lang.reflect.Constructor;

// HashDictionary.java
// description: A simple dictionary interface that uses a hash table
// and SLLs to store key/value pairs like the Python one in lecture 13-1
// author: pcostjr
// created: 5.11.2025
// last update: 5.11.2025
public class HashDictionary {

    // private node structure for SLL
    private class Node {
        // instance variables

        private String key;
        private String value;
        private Node next;

        private Node(String key,String value) {
            // assign key value and a null pointer for next
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // private SLL for HashTable
    private class SinglyLinkedList {

        // the first node in the SLL
        private Node first;

        // CONSTRUCTOR
        // make an empty pointer for the list
        private SinglyLinkedList() {
            this.first = null;
        }

        // MUTATORS
        // insert a new key value pair into the list
        private void insert(String key, String value) {
            Node node = new Node(key, value);
            // prepend the node to the root if it is empty
            if(this.first == null) {
                this.first = node;
            }
            else {
                // else, prepend the node as the root and connect the rest of the chain
                node.next = this.first;
                this.first = node;
            }
        }

        // remove a key value pair from the list
        private void delete(String key) {
            if(this.first != null) {
                if (this.first.key.equals(key)) {
                    if(this.first.next != null) {
                        // if our key is first in the list, reassign the pointer
                        // to the next item, garbage collect the old first
                        this.first = this.first.next;
                    }
                    else {
                        // or simply erase the value if there's only one item here
                        this.first = null;
                    }
                }
                else {
                    Node node = this.first;
                    // iterate through the chain until we find the target link
                    while(node != null && node.next != null) {
                        // if we meet all the conditions to remove an element
                        // surrounded by other elements
                        // change the pointers to not include the target and let
                        // it get collected
                        if (node.next.key.equals(key)) {
                                if(node.next.next != null) {
                                    node.next = node.next.next;
                                }
                                else {
                                    node.next = null;
                                }
                        }
                        node = node.next;
                    }
                }
            }
        }

        // ACCESSORS
        // primary function for getting an item from the list
        public String get(String key) {
            Node node = this.first;
            while(node != null) {
                if (node.key.equals(key)) {
                    // if we find the key, return it
                    return node.value;
                }
                else {
                    node = node.next;
                }
            }
            // if we iterate through the entire get function without finding
            // a value, return null
            return null;
        }
    }

    // since for this implementation the max is a static
    // arbitary value we use to populate the hashtable
    // we can make it static among all HashDictionaries
    // and final since it never changes. We can also
    // permanently assign the value outside the constructor
    private static final int max = 701;
    // SLL table array we will use
    private SinglyLinkedList[] table;

    // CONSTRUCTOR
    // create a new HashDictionary
    public HashDictionary() {
        // generate a new array of SLLs in table
        // and populate it with SLLs
        table = new SinglyLinkedList[max];
        for(int i = 0; i < max; i++) {
            this.table[i] = new SinglyLinkedList();
        }
    }

    // ACCESSORS
    // private function to generate a hash from a key
    private int keyToHash(String key) {
        // Java version of what we did in 13-1
        // we take the absolute value of a hashcode
        // and constrain it to our maximum size
        // using a modulo
        return Math.abs(key.hashCode()) % max;
    }

    // get value by key if it exists
    public String get(String key) {
        int index = keyToHash(key);
        return this.table[index].get(key);
    }

    // MUTATORS
    // insert a new key value pair into the hash table
    public void insert(String key, String value) {
        int index = keyToHash(key);
        this.table[index].insert(key, value);
    }

    // delete a target key value pair if it exists
    public void delete(String key) {
        int index = keyToHash(key);
        this.table[index].delete(key);
    }
}
