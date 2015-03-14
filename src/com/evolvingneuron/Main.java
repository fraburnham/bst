package com.evolvingneuron;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        BST bst = new BST();
        String[] s = new String[] {"g", "b", "d", "c", "k", "f", "a", "h", "i", "j", "z", "x"};

        for (int i = 0; i < s.length; i++) {
            bst.insert(new Node<Integer>(null, s[i], i));
        }

        for (String key : s) {
            System.out.println("\npathToRoot (" + key + "):");
            Stack<Node> path = bst.pathToRoot(bst.find(key));
            for (Node n : path) {
                System.out.print("->" + n.getKey());
            }
        }
    }
}
