/**
 *
 */
package com.bst;

/**
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println("HELLO WORLD!\n\n");

	BST<String> bst = new BST<String>();

	System.out.println("Count Intial: " + bst.getCount());

	bst.insert("Hello");
	System.out.println("After First Append:" + bst.getCount());
    }

}
