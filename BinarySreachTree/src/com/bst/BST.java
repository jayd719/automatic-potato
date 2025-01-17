package com.bst;

class BST_NODE<T extends Comparable<T>> {
    private T data;
    private BST_NODE<T> left;
    private BST_NODE<T> right;

    public BST_NODE(T data) {
	this.data = data;
	this.left = null;
	this.right = null;
    }

    /**
     * @return the data
     */
    public T getData() {
	return this.data;
    }

    /**
     * @return the left
     */
    public BST_NODE<T> getLeft() {
	return this.left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(BST_NODE<T> left) {
	this.left = left;
    }

    /**
     * @return the right
     */
    public BST_NODE<T> getRight() {
	return this.right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(BST_NODE<T> right) {
	this.right = right;
    }

}

public class BST<T extends Comparable<T>> {
    private int count;
    private BST_NODE<T> root;

    public BST() {
	this.count = 0;
	this.root = null;

    }

    /**
     * @return the count
     */
    public int getCount() {
	return this.count;
    }

    /**
     * @return the root
     */
    public BST_NODE<T> getRoot() {
	return this.root;
    }

    public void insert(T data) {
	BST_NODE<T> node = new BST_NODE<T>(data);

	if (this.root == null) {
	    this.root = node;
	}

	this.count++;
    }

}
