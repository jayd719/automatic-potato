package cp213;

/**
 * A single linked priority queue structure of <code>Node T</code> objects.
 * These data objects must be Comparable - i.e. they must provide the compareTo
 * method. Only the <code>T</code> data contained in the priority queue is
 * visible through the standard priority queue methods. Extends the
 * <code>SingleLink</code> class.
 *
 * @author your name, id, email here
 * @version 2023-09-06
 * @param <T> the SinglePriorityQueue data type.
 */
public class SinglePriorityQueue<T extends Comparable<T>> extends SingleLink<T> {

    /**
     * Combines the contents of the left and right SinglePriorityQueues into the
     * current SinglePriorityQueue. Moves nodes only - does not move value or call
     * the high-level methods insert or remove. left and right SinglePriorityQueues
     * are empty when done. Nodes are moved alternately from left and right to this
     * SinglePriorityQueue. When finished all nodes must be in priority order from
     * front to rear.
     *
     * Do not use the SinglePriorityQueue insert and remove methods.
     *
     * Do not assume that both right and left priority queues are of the same
     * length.
     *
     * @param left  The first SinglePriorityQueue to extract nodes from.
     * @param right The second SinglePriorityQueue to extract nodes from.
     */
    public void combine(final SinglePriorityQueue<T> left, final SinglePriorityQueue<T> right) {
	assert this.front == null : "May combine into an empty Priority Queue only";

	SingleNode<T> node = null;

	while (!left.isEmpty() || !right.isEmpty()) {

	    if (!left.isEmpty()) {
		node = left.front;
		left.front = node.getNext();
		--left.length;
	    } else if (!right.isEmpty()) {
		node = right.front;
		right.front = node.getNext();
		--right.length;

	    }

	    if (this.front == null) {
		node.setNext(null);
		this.front = node;
		this.rear = node;
		++this.length;
	    } else {
		SingleNode<T> curr = this.front;
		SingleNode<T> prev = null;
		while (curr != null && curr.getItem().compareTo(node.getItem()) <= 0) {
		    prev = curr;
		    curr = curr.getNext();
		}
		if (prev == null) {
		    node.setNext(this.front);
		    this.front = node;
		} else {

		    node.setNext(curr);
		    prev.setNext(node);
		}
	    }
	}

	return;
    }

    /**
     * Adds value to the SinglePriorityQueue. Data is stored in priority order, with
     * highest priority value at the front of the SinglePriorityQueue, and lowest at
     * the rear. Priority is determined by simple comparison - lower values have
     * higher priority. For example, 1 has a higher priority than 2 because 1 is a
     * lower value than 2. (Think of the phrase, "We're number one!" as an
     * indication of priority.)
     *
     * When inserting value to the priority queue, the queue must remain sorted.
     * Hence you need to find the proper location of inserting value. use the head
     * pointer to go through the queue. e.g., use SingleNode&lt;T&gt; current =
     * this.head;
     *
     * use current = current.getNext(); to traverse the queue.
     *
     * To get access to the value inside a node of queue use current.getValue().
     *
     * @param data value to insert in sorted order in priority queue.
     */
    public void insert(final T data) {
	SingleNode<T> curr = this.front;
	SingleNode<T> prev = null;

	SingleNode<T> newNode = new SingleNode<>(data, null);

	if (this.front == null) {
	    this.front = newNode;
	    this.rear = newNode;
	} else {
	    while ((curr != null) && (curr.getItem().compareTo(data) <= 0)) {
		prev = curr;
		curr = curr.getNext();
	    }
	    if (prev == null) {
		newNode.setNext(this.front);
		this.front = newNode;

	    } else {
		newNode.setNext(curr);
		prev.setNext(newNode);
	    }

	}
	++this.length;
	return;
    }

    /**
     * Returns the highest priority value in the SinglePriorityQueue. Decrements the
     * count.
     *
     * @return the highest priority value currently in the SinglePriorityQueue.
     */
    public T remove() {

	SingleNode<T> topElement = this.front;
	this.front = topElement.getNext();
	--this.length;

	return topElement.getItem();
    }

    /**
     * Splits the contents of this SinglePriorityQueue into the higher and lower
     * SinglePriorityQueue. Moves nodes only - does not move value or call the
     * high-level methods insert or remove. this SinglePriorityQueue is empty when
     * done. Nodes with priority value higher than key are moved to the
     * SinglePriorityQueue higher. Nodes with a priority value lower than or equal
     * to key are moved to the SinglePriorityQueue lower.
     *
     * Do not use the SinglePriorityQueue insert and remove methods.
     *
     * @param key    value to compare against node values in SinglePriorityQueue
     * @param higher an initially empty SinglePriorityQueue queue that ends up with
     *               all values with priority higher than key.
     * @param lower  an initially empty SinglePriorityQueue queue that ends up with
     *               all values with priority lower than or equal to key.
     */
    public void splitByKey(final T key, final SinglePriorityQueue<T> higher, final SinglePriorityQueue<T> lower) {

	SingleNode<T> curr = this.front;
	SingleNode<T> prev = null;

	while (curr.getItem().compareTo(key) < 0) {
	    prev = curr;
	    curr = curr.getNext();
	    ++higher.length;
	}
	prev.setNext(null);

	higher.front = this.front;
	higher.rear = prev;

	lower.front = curr;
	lower.rear = this.rear;
	lower.length = this.length - higher.length;

	this.length = 0;
	this.front = null;
	this.rear = null;

	return;
    }
}
