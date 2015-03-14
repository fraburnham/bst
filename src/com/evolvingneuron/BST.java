package com.evolvingneuron;

import java.util.Stack;

/**
 * Simple Binary Search Tree implementation
 * Created by Frank Burnham on 2/23/15.
 */

public class BST {
    //binary search tree to use as a foundation for k-d tree
    private Node root = null; //default to null just like the children do

    private Node find(Node root, Comparable key) {
        //search through the BST looking for key
        if (root == null) {
            return null;
        }

        int comp = root.getKey().compareTo(key);

        if (comp < 0) {
            return find(root.getRightChild(), key);
        } else if (comp > 0) {
            return find(root.getLeftChild(), key);
        }

        return root;
    }

    private void insert(Node root, Node newNode) {
        int comp = root.getKey().compareTo(newNode.getKey());

        if (comp < 0) {
            Node n = root.getRightChild();
            if (n == null) {
                root.setRightChild(newNode);
                return;
            }
            insert(n, newNode);
        } else if (comp > 0) {
            Node n = root.getLeftChild();
            if (n == null) {
                root.setLeftChild(newNode);
                return;
            }
            insert(n, newNode);
        }
    }

    public void delete(Comparable key) {
        Node d = find(root, key);

        Node leftChild = d.getLeftChild();
        Node rightChild = d.getRightChild();
        Node parent = d.getParent();

        insert(parent, leftChild);
        insert(parent, rightChild);
    }

    public Node find(Comparable key) {
        return find(root, key);
    }

    public void insert(Node newNode) {
        if (root == null) {
            root = newNode;
            return;
        }
        insert(root, newNode);
    }

    public Stack<Node> pathToRoot(Node n) {
        Stack<Node> path = new Stack<Node>();
        while (n != null) {
            path.push(n);
            n = n.getParent();
        }

        return path;
    }
}
