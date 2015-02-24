package com.evolvingneuron;

/**
 * Simple Binary Search Tree implementation
 * Created by Frank Burnham on 2/23/15.
 */

public class BST<Value> {
    //binary search tree to use as a foundation for k-d tree
    public class Node {
        //key will be immutable;
        private final Comparable key;

        private Value value;
        private Node parent = null;
        private Node leftChild = null;
        private Node rightChild = null;


        public Node(Node parent, Comparable k, Value v) {
            //TODO: key cannot be null ever! raise BSTNullKeyException
            if (k == null) {
                throw new BSTNullKeyException();
            }
            key = k;
            value = v;
            this.parent = parent;
        }

        public Comparable getKey() {
            return key;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public Node getParent() {
            return parent;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public Value getValue() {
            return value;
        }

        public boolean isRoot() {
            return (null == parent);
        }

        public void setLeftChild(Node child) {
            //TODO: error checking
            //TODO: raise error when child already exists, or handle
            leftChild = child;
        }

        public void setParent(Node parent) {
            //TODO: see setLeftChild(...)
            this.parent = parent;
        }

        public void setRightChild(Node child) {
            //TODO: see setLeftChild(...)
            rightChild = child;
        }

        public void setValue(Value value) {
            this.value = value;
        }
    }

    Node root = null; //default to null just like the children do

    public void insert(Comparable key, Value value) {
        if (root == null) {
            root = new Node(null, key, value);
            return;
        }
        insert(root, key, value);
    }

    private void insert(Node root, Comparable key, Value value) {
        int comp = root.getKey().compareTo(key);

        if (comp < 0) {
            Node n = root.getRightChild();
            if (n == null) {
                root.setRightChild(new Node(root, key, value));
                return;
            }
            insert(n, key, value);
        } else if (comp > 0) {
            Node n = root.getLeftChild();
            if (n == null) {
                root.setLeftChild(new Node(root, key, value));
                return;
            }
            insert(n, key, value);
        } else {
            root.setValue(value);
        }
    }

    public Node find(Comparable key) {
        if (root == null) {
            //raise BSTNullTreeException ... maybe?
        }
        return find(root, key);
    }

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

    public void delete(Comparable key) {
        //TODO: implement

    }

    public void printTree() {

    }
}
