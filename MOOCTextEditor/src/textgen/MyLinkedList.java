package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E> (null);
		tail = new LLNode<E> (null);
		size = 0;
		head.next = tail;
		tail.next = head;
	}
	
	public LLNode<E> findPrevNode(int curr_index) {
		LLNode<E> prev_node = head;
		for (int i = 0; i < curr_index; i++) {
			prev_node = prev_node.next;
		}
		return prev_node;
	}
	
	public LLNode<E> findNextNode(int curr_index) {
		LLNode<E> curr_node = head;
		for (int i = 0; i <= curr_index; i++) {
			curr_node = curr_node.next;
		}
		return curr_node.next;
	}
	
	public LLNode<E> findCurrNode(int curr_index) {
		LLNode<E> curr_node = head;
		for (int i = 0; i <= curr_index; i++) {
			curr_node = curr_node.next;
		}
		return curr_node;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("object reference has null value.");
		}
		// Add an element to an empty list
		LLNode<E> new_node = new LLNode<E>(element);
		if (size == 0) {
			new_node.next = tail;
			head.next = new_node;
			new_node.prev = head;
			tail.prev = new_node;
			size += 1;
		} else {
			// Create a current_node to travel through each node in the list
			// If current_node.next is tail, it is last node
			// Append new_node to current_node
			LLNode<E> current_node = new LLNode<E>(null);
			current_node = head;
			while (current_node.next.data != null) {
				current_node = current_node.next;
			}
			new_node.next = tail;
			current_node.next = new_node;
			new_node.prev = current_node;
			tail.prev = new_node;
			size += 1;
		}
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index is out of range.");
		}
		LLNode<E> temp_node = head.next;
		for (int i = 0; i < index; i++) {
			temp_node = temp_node.next;
		}
		return temp_node.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("object reference has null value");
		}
		
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index is out of range");
		}
		// find current node
		LLNode<E> curr_node = findCurrNode(index);
		System.out.println("curr_node.data: " + curr_node.data);
		// find previous node
		LLNode<E> prev_node = findPrevNode(index);
		System.out.println("prev_node.data when adding " + element + " at index " + index + " : " + prev_node.data);
		// find next node
		LLNode<E> next_node = findNextNode(index);
		System.out.println("next_node.data when adding " + element + " at index " + index + " : " + next_node.data);
		// establish connections among new node, previous node & next node
		LLNode<E> new_node = new LLNode<E>(element);
		if (size == 0) {
			new_node.next = tail;
			head.next = new_node;
			new_node.prev = head;
			tail.prev = new_node;
			size += 1;
		}
		else if (index == 0) {
			new_node.next = curr_node;
			head.next = new_node;
			new_node.prev = head;
			curr_node.prev = new_node;
			size += 1;
		} else {
			LLNode<E> updated_nextNode = curr_node;
			System.out.println("updated_nextNode.data when adding " + element + " at index " + index + " : " + updated_nextNode.data);
			new_node.next = updated_nextNode;
			prev_node.next = new_node;
			new_node.prev = prev_node;
			updated_nextNode.prev = new_node;
			size += 1;
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		int counter = 0;
		LLNode<E> temp_node = head;
		while (temp_node.next.data != null) {
			temp_node = temp_node.next;
			counter += 1;
		}
		return counter;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		E removal_data = get(index);
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Check out of bounds");
		}
		LLNode<E> next_node = findNextNode(index);
		LLNode<E> prev_node = findPrevNode(index);
		if (index == 0) {
			head.next = next_node;
			next_node.prev = head;
			size -= 1;
		} else {
			prev_node.next = next_node;
			next_node.prev = prev_node;
			size -= 1;
		}
		return removal_data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Check out of bounds");
		}
		
		if (element == null || size == 0) {
			throw new NullPointerException("Check null value");
		}
		LLNode<E> existing_node = findCurrNode(index);
		LLNode<E> replacing_node = new LLNode<E>(element);
		LLNode<E> next_node = findNextNode(index);
		LLNode<E> prev_node = findPrevNode(index);
		if (index == 0) {
			replacing_node.next = next_node;
			head.next = replacing_node;
			replacing_node.prev = head;
			next_node.prev = replacing_node;
		} else {
			replacing_node.next = next_node;
			prev_node.next = replacing_node;
			replacing_node.prev = prev_node;
			next_node.prev = replacing_node;
		}
		return existing_node.data;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;
	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
}
