// SimpleDictionary.java
// description: A simple dictionary using key value pairs
// author: pcostjr
// created: 5.7.2025
// last update: 5.9.2025
package com.example.SimpleDictionary;

public class SimpleDictionary {

    // simple Dictionary node inner class
    private class SDNode {

        // NOTE: Since Java is an OOP language, I only used the 'this'
        // keyword when applicable. The object will recognize when it is
        // referencing a class that it owns, or a variable

        // NOTE: There were no deletion or rebalancing methods included in the interface
        // from lecture 12-1, so I did not write them.

        // I originally wanted the key/value to be of Object type
        // but making comparisons would become beyond the scope of this
        // project, so they will be strings.
        private final String key;
        private String value;
        private SDNode left, right;

        public SDNode(String key, String value) {
            // assign instance variables and set left/right branches to null
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
        // root node for the dictionary
        private SDNode root;

        // create an empty SimpleDictionary instance
        public SimpleDictionary() {
            root = null;
        }

        // ACCESSOR METHODS
        // determine if the SD is empty.
        public boolean isEmpty() {
            return root == null;
        }

        // recursive helper method for get
        private String get(SDNode node, String key) {
            if(node == null) {
                throw new NullPointerException("[!]: Error. Collection is empty.");
            }
            // assign comparison value so we only have to call it once
            int compare = node.key.compareTo(key);
            // if node.key is greater than key
            if(compare > 0) {
                // recursive call on left node
                return get(node.left, key);
            }
            // if node.key is less than key
            else if(compare < 0){
                // recursive call of right node
                return get(node.right, key);
            }
            // if compareTo() returns 0, we must be at the key
            else {
                return node.value;
            }
        }

        // public get accessor method
        public String get(String key) {
            return get(root, key);
        }

        // recursive helper method to check if something exists
        private boolean exists(SDNode node, String key) {
            // if the key doesn't exist, we will eventually find a null value
            if (node == null) {
                return false;
            }
            // we nest this decision so we do not accidentally try to compare a null pointer
            // even though we probably won't
            else {
                // assign comparison value so we only have to call it once
                int compare = node.key.compareTo(key);
                // if node.key is greater than key
                if(compare > 0) {
                    // recursive call on left node
                    return exists(node.left, key);
                }
                // if node.key is less than key
                else if(compare < 0){
                    // recursive call of right node
                    return exists(node.right, key);
                }
                // if compareTo() returns 0, we must be at the key
                else {
                    return true;
                }
            }
        }

        // public find accessor method
        public boolean contains(String key) {
            return exists(root, key);
        }

        // recursive helper method for size
        private int size(SDNode node) {
            // if there is no node here, count it as 0
            if (node == null) {
                return 0;
            }
            // if there is no left
            if(node.left == null) {
                // check if there is no right
                if (node.right == null) {
                    // and count this as a leaf
                    return 1;
                }
                else {
                    // else, delegate to the right
                    return size(node.right) + 1;
                }
            }
            // if the right node is null (but we have a left)
            else if (node.right == null) {
                // delegate the left, and count for this node
                return size(node.left) + 1;
            }
            else {
                // delegate left and right, and account for this node
                return size(node.left) + size(node.right) + 1;
            }
        }

        // public size accessor method
        public int size() {
            return size(root);
        }

        // MUTATOR METHODS

        // private recursive helper for setting nodes
        private SDNode insert(SDNode node, String key, String value) {
            // if we have no node here, make one with the key value pair
            if(node == null) {
                return new SDNode(key, value);
            }
            // assign comparison value so we only have to call it once
            int compare = node.key.compareTo(key);
            // if node.key is greater than key
            if(compare > 0) {
                node.left = insert(node.left, key, value);
            }
            // if node.key is less than key
            else if(compare < 0){
                // recursive call of right node
                node.right = insert(node.right, key, value);
            }
            // if compareTo() returns 0, we must be at the key
            else {
                node.value = value;
            }
            // we have to return the additional node here so
            // we can correctly propagate back up the tree
            return node;
        }

        // public method for setting data nodes
        public void add(String key, String value) {
            root = insert(root, key, value);
        }

}

