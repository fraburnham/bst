package com.evolvingneuron;

/**
 * Created by Frank Burnham on 3/14/15. It's pi day.
 * Moving node into its own class to make the BST class more generic.
 * All BST has to do is manipulate the tree.
 * All Node<Value> has to do is know itself and its neighbors.
 */

public class Node<Value> {
    //key will be immutable;
    private final Comparable key;

    private Value value;
    private Node parent = null;
    private Node leftChild = null;
    private Node rightChild = null;


    public Node(Node parent, Comparable k, Value v) {
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
        child.setParent(this);
    }

    public void setParent(Node parent) {
        //TODO: see setLeftChild(...)
        this.parent = parent;
    }

    public void setRightChild(Node child) {
        //TODO: see setLeftChild(...)
        rightChild = child;
        child.setParent(this);
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
