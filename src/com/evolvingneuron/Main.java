package com.evolvingneuron;

public class Main {

    public static void main(String[] args) {
        BST bst = new BST<Integer>();
        String[] s = new String[] {"a", "b", "w", "z", "q", "a", "c", "j", "m", "s"};

        for (int i = 0; i < s.length; i++) {
            bst.insert(s[i], i);
        }

        for (String key : s) {
            System.out.println("Key: " + key + " Value: " + bst.find(key).getValue());
        }
    }
}
