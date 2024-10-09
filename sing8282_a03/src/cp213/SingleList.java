package cp213;

/**
 * A single linked list structure of <code>Node T</code> objects. These data
 * objects must be Comparable - i.e. they must provide the compareTo method.
 * Only the <code>T</code> value contained in the priority queue is visible
 * through the standard priority queue methods. Extends the
 * <code>SingleLink</code> class.
 *
 * @author Jashandeep Singh, 169018282, sing8282@mylaurier.ca
 * @version 2023-09-06
 * @param <T> this SingleList data type.
 */
public class SingleList<T extends Comparable<T>> extends SingleLink<T> {

    /**
     * Searches for the first occurrence of key in this SingleList. Private helper
     * methods - used only by other ADT methods.
     *
     * @param key The value to look for.
     * @return A pointer to the node previous to the node containing key.
     */

    @SuppressWarnings("unused")
    private SingleNode<T> linearSearch(final T key) {

	SingleNode<T> curr = this.front;
	SingleNode<T> prev = null;
	SingleNode<T> prev_ = null;

	while (curr != null && prev == null) {
	    if (curr.getItem().equals(key)) {
		prev = prev_;
	    }
	    prev_ = curr;
	    curr = curr.getNext();
	}
	return prev;
    }

    /**
     * Appends data to the end of this SingleList.
     *
     * @param data The value to append.
     */
    public void append(final T data) {

	SingleNode<T> newNode = new SingleNode<T>(data, null);
	if (this.isEmpty()) {
	    this.front = newNode;
	    this.rear = newNode;
	} else {
	    this.rear.setNext(newNode);
	    this.rear = newNode;
	}

	++this.length;

	return;
    }

    /**
     * Removes duplicates from this SingleList. The list contains one and only one
     * of each value formerly present in this SingleList. The first occurrence of
     * each value is preserved.
     */
    public void clean() {

	SingleNode<T> curr = this.front;
	SingleNode<T> currPlusOne = null;

	while (curr != null) {
	    currPlusOne = curr.getNext();

	    while (currPlusOne != null) {
		if (curr.getItem().compareTo(currPlusOne.getItem()) == 0) {
		    curr.setNext(currPlusOne.getNext());
		}
		currPlusOne = currPlusOne.getNext();

	    }
	    curr = curr.getNext();
	}

	return;
    }

    /**
     * Combines contents of two lists into a third. Values are alternated from the
     * origin lists into this SingleList. The origin lists are empty when finished.
     * NOTE: data must not be moved, only nodes.
     *
     * @param left  The first list to combine with this SingleList.
     * @param right The second list to combine with this SingleList.
     */
    public void combine(final SingleList<T> left, final SingleList<T> right) {

	SingleNode<T> curr = null;
	while (!left.isEmpty() || !right.isEmpty()) {
	    if (!left.isEmpty()) {
		curr = left.front;
		left.front = curr.getNext();
		curr.setNext(null);
		if (this.front == null) {
		    this.front = curr;
		    this.rear = curr;
		} else {
		    this.rear.setNext(curr);
		    this.rear = curr;
		}
	    }

	    if (!right.isEmpty()) {
		curr = right.front;
		right.front = curr.getNext();
		curr.setNext(null);
		if (this.front == null) {
		    this.front = curr;
		    this.rear = curr;
		} else {
		    this.rear.setNext(curr);
		    this.rear = curr;
		}
	    }
	    ++this.length;
	}

	return;
    }

    /**
     * Determines if this SingleList contains key.
     *
     * @param key The key value to look for.
     * @return true if key is in this SingleList, false otherwise.
     */
    public boolean contains(final T key) {

	SingleNode<T> prev = this.linearSearch(key);
	boolean contains_ = false;
	if (prev != null) {
	    contains_ = true;
	}
	return contains_;
    }

    /**
     * Finds the number of times key appears in list.
     *
     * @param key The value to look for.
     * @return The number of times key appears in this SingleList.
     */
    public int count(final T key) {

	SingleNode<T> curr = this.front;
	int count = 0;
	while (curr != null) {
	    if (key.compareTo(curr.getItem()) == 0) {
		++count;
	    }
	    curr = curr.getNext();
	}

	return count;
    }

    /**
     * Finds and returns the value in list that matches key.
     *
     * @param key The value to search for.
     * @return The value that matches key, null otherwise.
     */
    public T find(final T key) {
	T value = null;
	SingleNode<T> node = this.linearSearch(key);
	if (node != null) {
	    value = node.getNext().getItem();
	}
	return value;
    }

    /**
     * Get the nth item in this SingleList.
     *
     * @param n The index of the item to return.
     * @return The nth item in this SingleList.
     * @throws ArrayIndexOutOfBoundsException if n is not a valid index.
     */
    public T get(final int n) throws ArrayIndexOutOfBoundsException {

	SingleNode<T> curr = this.front;
	T value = null;
	int i = 0;
	while (i++ < n) {
	    curr = curr.getNext();
	}
	value = curr.getItem();
	return value;
    }

    /**
     * Determines whether two lists are identical.
     *
     * @param source The list to compare against this SingleList.
     * @return true if this SingleList contains the same values in the same order as
     *         source, false otherwise.
     */
    public boolean identical(final SingleList<T> source) {

	boolean isIdentical = true;

	if (this.length == source.length) {
	    int i = 0;
	    while (isIdentical && i < this.length) {
		if (!this.get(i).equals(source.get(i))) {
		    isIdentical = false;
		}

		++i;
	    }

	} else {
	    isIdentical = false;
	}

	return isIdentical;
    }

    /**
     * Finds the first location of a value by key in this SingleList.
     *
     * @param key The value to search for.
     * @return The index of key in this SingleList, -1 otherwise.
     */
    public int index(final T key) {

	SingleNode<T> curr = this.front;

	int i = 0;
	while (curr != null && curr.getItem().compareTo(key) != 0) {
	    curr = curr.getNext();
	    i++;
	}
	if (curr == null) {
	    i = -1;
	}
	return i;
    }

    /**
     * Inserts value into this SingleList at index i. If i greater than the length
     * of this SingleList, append data to the end of this SingleList.
     *
     * @param i    The index to insert the new data at.
     * @param data The new value to insert into this SingleList.
     */

    public void insert(int i, final T data) {

	if (i > this.length) {
	    this.append(data);
	} else {
	    SingleNode<T> curr = this.front;
	    SingleNode<T> prev = null;

	    int k = 0;
	    while (k < i) {
		prev = curr;
		curr = curr.getNext();
		++k;
	    }
	    SingleNode<T> newNode = new SingleNode<T>(data, curr);
	    prev.setNext(newNode);
	    ++this.length;
	}

	return;
    }

    /**
     * Creates an intersection of two other SingleLists into this SingleList. Copies
     * data to this SingleList. left and right SingleLists are unchanged. Values
     * from left are copied in order first, then values from right are copied in
     * order.
     *
     * @param left  The first SingleList to create an intersection from.
     * @param right The second SingleList to create an intersection from.
     */
    public void intersection(final SingleList<T> left, final SingleList<T> right) {

	int i = 0;
	while (i < left.length) {
	    T value = left.get(i);

	    int j = 0;
	    while (j < right.length) {
		T checkVal = right.get(j);
		if (value.equals(checkVal)) {
		    this.append(value);
		}
		++j;
	    }

	    ++i;
	}

	return;
    }

    /**
     * Finds the maximum value in this SingleList.
     *
     * @return The maximum value.
     */
    public T max() {

	T max = null;

	if (!this.isEmpty()) {

	    SingleNode<T> curr = this.front;
	    max = curr.getItem();

	    while (curr != null) {
		if (max.compareTo(curr.getItem()) < 0) {
		    max = curr.getItem();
		}
		curr = curr.getNext();
	    }
	}

	return max;
    }

    /**
     * Finds the minimum value in this SingleList.
     *
     * @return The minimum value.
     */
    public T min() {

	T min_ = null;

	if (!this.isEmpty()) {

	    SingleNode<T> curr = this.front;
	    min_ = curr.getItem();

	    while (curr != null) {
		if (min_.compareTo(curr.getItem()) > 0) {
		    min_ = curr.getItem();
		}
		curr = curr.getNext();
	    }
	}
	return min_;
    }

    /**
     * Inserts value into the front of this SingleList.
     *
     * @param data The value to insert into the front of this SingleList.
     */
    public void prepend(final T data) {

	SingleNode<T> newNode = new SingleNode<T>(data, null);
	if (this.isEmpty()) {
	    this.front = newNode;
	    this.rear = newNode;
	} else {
	    newNode.setNext(this.front);
	    this.front = newNode;
	}
	++this.length;
	return;
    }

    /**
     * Finds, removes, and returns the value in this SingleList that matches key.
     *
     * @param key The value to search for.
     * @return The value matching key, null otherwise.
     */
    public T remove(final T key) {

//	SingleNode<T> prev = this.linearSearch(key);
//
//	if (prev != null) {
//
//	    if (prev.getNext().getNext() != null) {
//		prev.setNext(prev.getNext().getNext());
//
//	    } else {
//		prev.setNext(null);
//		this.rear = prev;
//	    }
//	    --this.length;
//	}

	return null;
    }

    /**
     * Removes the value at the front of this SingleList.
     *
     * @return The value at the front of this SingleList.
     */
    public T removeFront() {

	T value = this.front.getItem();
	this.front = this.front.getNext();
	--this.length;
	return value;
    }

    /**
     * Finds and removes all values in this SingleList that match key.
     *
     * @param key The value to search for.
     */
    public void removeMany(final T key) {

//	while (this.linearSearch(key) != null) {
//	    this.remove(key);
//	    System.out.println("rw");
//	}

	return;
    }

    /**
     * Reverses the order of the values in this SingleList.
     */
    public void reverse() {

	SingleNode<T> curr = this.front;
	SingleNode<T> next = null;
	SingleNode<T> prev = null;

	while (curr != null) {
	    next = curr.getNext();
	    curr.setNext(prev);
	    prev = curr;
	    curr = next;
	}
	this.front = prev;
	return;
    }

    /**
     * Splits the contents of this SingleList into the left and right SingleLists.
     * Moves nodes only - does not move value or call the high-level methods insert
     * or remove. this SingleList is empty when done. The first half of this
     * SingleList is moved to left, and the last half of this SingleList is moved to
     * right. If the resulting lengths are not the same, left should have one more
     * item than right. Order is preserved.
     *
     * @param left  The first SingleList to move nodes to.
     * @param right The second SingleList to move nodes to.
     */
    public void split(final SingleList<T> left, final SingleList<T> right) {

	int i = 1;
	int split = (int) Math.ceil(this.length / 2.0f);

	SingleNode<T> curr = this.front;

	while (i < split) {
	    curr = curr.getNext();
	    ++i;
	}
	left.front = this.front;
	right.front = curr.getNext();

	curr.setNext(null);
	left.rear = curr;
	left.length = split;

	right.rear = this.rear;
	right.length = this.length - split;

	this.front = null;
	this.rear = null;
	this.length = 0;

	return;
    }

    /**
     * Splits the contents of this SingleList into the left and right SingleLists.
     * Moves nodes only - does not move value or call the high-level methods insert
     * or remove. this SingleList is empty when done. Nodes are moved alternately
     * from this SingleList to left and right. Order is preserved.
     *
     * @param left  The first SingleList to move nodes to.
     * @param right The second SingleList to move nodes to.
     */
    public void splitAlternate(final SingleList<T> left, final SingleList<T> right) {

	SingleNode<T> curr = this.front;
	SingleNode<T> next = null;
	boolean left_ = true;
	while (curr != null) {
	    next = curr.getNext();
	    curr.setNext(null);
	    if (left_) {
		if (left.front == null) {
		    left.front = curr;
		    left.rear = curr;
		} else {

		    left.rear.setNext(curr);
		    left.rear = curr;
		}
		++left.length;

	    } else {
		if (right.front == null) {
		    right.front = curr;
		    right.rear = curr;
		} else {
		    right.rear.setNext(curr);
		    right.rear = curr;
		}
		++right.length;
	    }

	    left_ = !left_;
	    curr = next;
	}
	this.front = null;
	this.rear = null;
	this.length = 0;

	return;
    }

    /**
     * Creates a union of two other SingleLists into this SingleList. Copies value
     * to this list. left and right SingleLists are unchanged. Values from left are
     * copied in order first, then values from right are copied in order.
     *
     * @param left  The first SingleList to create a union from.
     * @param right The second SingleList to create a union from.
     */
    public void union(final SingleList<T> left, final SingleList<T> right) {

	SingleNode<T> curr = left.front;
	while (curr != null) {
	    if (!this.contains(curr.getItem())) {
		this.append(curr.getItem());
	    }
	    curr = curr.getNext();
	}
	curr = right.front;
	while (curr != null) {
	    if (!this.contains(curr.getItem())) {
		this.append(curr.getItem());
	    }
	    curr = curr.getNext();
	}

	return;
    }
}
