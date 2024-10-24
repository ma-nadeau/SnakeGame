package src;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> extends MyLinkedList<E> { 

	private DNode head;
	private DNode tail;
	
	/*
	 * ADD YOUR CODE HERE
	 */

	public boolean add(E element) {
		if(element == null){
			return false;
		}

		DNode newNode = new DNode();
		newNode.element = element;
		newNode.next = null;
		newNode.prev = tail;

		if (head == null) {
			tail = newNode;
			head = tail;
		}

		else if (tail != null) {

			tail.next = newNode;
			tail = newNode;

		}
		//tail = newNode;
		size++;
		//need to implement an true/false verification
		return true;
		}



	public E remove(){
		if(size == 0 || isEmpty()){
			throw new NoSuchElementException();
		}
		DNode removedNode = tail;
		E elementRN = removedNode.element;
		if(size == 1){
			clear();
			removedNode.element =null;
			return elementRN;
		}
		//DNode removedNode = tail;
		tail = tail.prev;
		tail.next = null;
		removedNode.element =null;
		size--;
		return elementRN;
	}

	public boolean addFirst(E element){
		if(element == null){
			return false;
		}
		DNode newNode = new DNode();
		newNode.element = element;
		newNode.next = head;
		newNode.prev = null;


		if (head != null){
			head.prev = newNode;

			head = newNode;
			//tail = head;

			size++;
		return true;
		}

		else{
			head = newNode;
			tail = newNode;
			size++;
			return true;
		}
	}
	public boolean addLast(E element){
		return add(element);
	}

	public E removeFirst(){
		if(size == 0){
			throw new NoSuchElementException();
		}
		DNode removedNode = head;
		E elementRN = removedNode.element;


		if(size == 1){
			clear();
			removedNode.element = null;
			return elementRN;
		}
		else {
			head = removedNode.next;
			removedNode.next = null;
			removedNode.element = null;
			head.prev = null;


		}
		//if(head == null) {
			//head.prev = null;


		//}
		//else{
		//	tail = null;

		//}
		size--;
		return elementRN;
	}

	public E removeLast(){
		return remove();
	}

	public E peekFirst(){
		if(size == 0){
			throw new NoSuchElementException();
		}
		DNode first_element = head;
		return first_element.element;
	}
	public E peekLast(){
		if(size == 0){
			throw new NoSuchElementException();
		}
		DNode last_element = tail;
		return last_element.element;
	}

	public void clear(){
		DNode toremove = head;
		while(toremove != null) {
			DNode newhead = toremove.next;
			toremove.element = null;
			toremove.next = null;
			toremove.prev = null;
			toremove = newhead;
			size--;
		}
		head = null;
		tail = null;
		size = 0;
	}


	/*
		head = null;
		tail = null;
		size = 0;
	}

	*/
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(obj == this) {
			return true;
		}
		if(obj.getClass() != this.getClass()) {
			return false;
		}

		MyDoublyLinkedList<E> nl = (MyDoublyLinkedList<E>) obj;
		if(nl.getSize() == 0 && this.getSize() == 0 ){
			return true;
		}
		if(nl.getSize() != this.getSize()){
			return false;
		}

		if ((obj instanceof MyDoublyLinkedList)) {
			//MyDoublyLinkedList<E> nl = (MyDoublyLinkedList<E>) obj;
			Iterator<E> i1 = this.iterator();
			Iterator<E> i2 = nl.iterator();

			while(i1.hasNext() && i2.hasNext()){
				if(!(i1.next().equals(i2.next()))){
					return false;
				}
		}}

		return true;


	}


	private class DNode {
		private E element;
		private DNode next;
		private DNode prev;
	}
	
	public Iterator<E> iterator() {
		return new DLLIterator();
	}
	
	private class DLLIterator implements Iterator<E> {
		DNode curr;

		public DLLIterator() {
			this.curr = head;
		}

		public boolean hasNext() {
			return this.curr != null;
		}

		public E next() {
			if (!this.hasNext())
				throw new NoSuchElementException();

			E element = this.curr.element;
			this.curr = this.curr.next;
			return element;
		}
	}
}
