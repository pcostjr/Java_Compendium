// intBinarySearchTree.java
// description: An example of a balancing binary search tree
// author: pcostjr
// created: 5.8.2025
// last update: 5.8.2025
package com.example.bstDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.max;

public class intBinarySearchTree {
    private class bstNode {

        private int key;
        private bstNode left, right;

        bstNode(int key) {
            this.key = key;
        }

    }

    private bstNode root;

    public intBinarySearchTree() {
        this.root = null;
    }

    public int get(int key) {
        return get(this.root, key);
    }

    private int get(bstNode node, int key) {
        if (node == null) {
            throw new IllegalArgumentException("[!] Error: get() called on empty node.");
        }
        if (key < node.key) {
            return get(node.left, key);
        }
        else if (node.key < key) {
            return get(node.right, key);
        }
        else {
            return node.key;
        }
    }

    public void set(int key) {
        this.root = set(this.root, key);
    }

    private bstNode set(bstNode node, int key) {
        if (node == null) {
            return new bstNode(key);
        }
        if(key < node.key) {
            node.left = set(node.left, key);
        }
        else {
            if(node.key < key) {
                node.right = set(node.right, key);
            }
            else {
                node.key = key;
            }
        }
        return node;
    }

    public int size() {
        return size(this.root);
    }

    private int size(bstNode node) {
        if (node == null) {
           return 0;
        }
        return size(node.left) + size(node.right) + 1;
    }

    public int height() {
        return height(this.root);
    }

    private int height(bstNode node) {
        if (node == null) {
            return 0;
        }
        return max(height(node.left), height(node.right)) + 1;
    }

    private void peek(bstNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.key);
        peek(node.left, list);
        peek(node.right, list);
    }

    private bstNode treeFromSortedList(List<Integer> sortedList) {
        if (sortedList.isEmpty()) {
            return null;
        }
        int s = sortedList.size();
        int m = s/2;
        int median = sortedList.get(m);
        bstNode newNode = new bstNode(median);
        List<Integer> leftList = sortedList.subList(0,m);
        newNode.left = treeFromSortedList(leftList);
        List<Integer> rightList = sortedList.subList(m+1, s);
        newNode.right = treeFromSortedList(rightList);
        return newNode;
    }

    public void rebalance () {
        if (this.root != null) {
            List<Integer> list = new ArrayList<>();
            peek(this.root, list);
            Collections.sort(list);
            this.root = treeFromSortedList(list);
        }
    }
}