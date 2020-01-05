package com.arya.ds;

import java.util.LinkedList;

public class SinglyLinkedList<E> {

	public Nodes<E> head;

	public int size;

	public static void main(String[] args) {

		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();

		singlyLinkedList.add(1);
		singlyLinkedList.add(2);
		singlyLinkedList.add(3);
		singlyLinkedList.add(4);
		singlyLinkedList.add(5);
		// singlyLinkedList.add(singlyLinkedList.size, 4);
		singlyLinkedList.iterator();

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.remove(1);

		// removing based on index
		// singlyLinkedList.remove(3);
		// singlyLinkedList.iterator();
		// singlyLinkedList.findMidElement();
		// removing based on object
		// System.out.println(singlyLinkedList.remove(new Integer(1)));
		singlyLinkedList.reverseLinkedList();
		singlyLinkedList.iterator();
	}

	/*
	 * 1) Use two pointers fast and slow 2) Move fast two nodes and slow one node in
	 * each iteration 3) If fast and slow meet then linked list contains cycle 4) if
	 * fast points to null or fast.next points to null then linked list is not
	 * cyclic
	 */

	public boolean isCyclic() {

		Nodes<E> fast = head;
		Nodes<E> slow = head;
		Nodes<E> prev = head;

		while (fast != null && fast.nextNode != null) {
			fast = fast.nextNode.nextNode;
			slow = slow.nextNode;

			// if fast and slow pointers are meeting then LinkedList is cyclic
			if (fast == slow) {
				//prev.nextNode = null; //for remove loop
				return true;
			}
			//prev = slow; //for remove loop
		}
		return false;
	}

	// finding middle element with one pass

	public void findMidElement() {
		Nodes<E> current = head;
		Nodes<E> middle = head;
		int length = 0;

		while (current.nextNode != null) {
			length++;
			if (length % 2 == 0) {
				middle = middle.nextNode;
			}
			current = current.nextNode;
		}

		/*
		 * if(length%2 == 1){ middle = middle.getNextNode(); }
		 */

		System.out.println("length of LinkedList: " + ++length);
		System.out.println("middle element of LinkedList : " + middle.data);

	}

	// start slow node after n position then it will equal to total-n
	public E getNthNode(int n) {
		Nodes<E> fast = head;
		Nodes<E> slow = head;
		int start = 1;
		while (fast.nextNode != null) {
			fast = fast.nextNode;
			start++;
			if (start > n) {
				slow = slow.nextNode;
			}
		}
		return slow.data;
	}

	public void reverseLinkedList() {
		Nodes<E> current = head;
		// For first node, previousNode will be null
		Nodes<E> previousNode = null;
		Nodes<E> nextNode;
		while (current != null) {
			nextNode = current.nextNode;
			// reversing the link
			current.nextNode = previousNode;
			// moving currentNode and previousNode by 1 node
			previousNode = current;
			current = nextNode;
		}
		head = previousNode;
	}

	public boolean add(E data) {

		Nodes<E> temp = new Nodes<E>(data);
		Nodes<E> cur = head;

		if (head == null) {
			// head is null add temp node to head.
			head = temp;

			this.size++;
			return true;
		} else {

			// traversing to last node which is points next node as null.
			while (cur.nextNode != null)
				cur = cur.nextNode;

			// set last node to point temp node.
			cur.nextNode = temp;
			this.size++;
			return true;
		}
	}

	public boolean add(int index, E data) {

		Nodes<E> temp = new Nodes<E>(data);
		Nodes<E> cur = head;

		if (index == 0) {
			temp.nextNode = head;
			this.head = temp;// assign updated temp to head
			this.size++;
			return true;
		} else {

			for (int i = 1; i < index; i++) {
				cur = cur.nextNode;
			}

			temp.nextNode = cur.nextNode;
			cur.nextNode = temp;

			this.size++;
			return true;
		}

	}

	public E remove(int index) {
		Nodes<E> cur = head;
		E dElement = null;

		if (index == 0) {
			dElement = cur.data;
			cur = cur.nextNode;
		} else {
			for (int i = 1; i < index; i++) {
				cur = cur.nextNode;
			}

			dElement = cur.data;
			cur.nextNode = cur.nextNode.nextNode;
		}
		this.size--;
		return dElement;
	}

	public E remove(E data) {
		Nodes<E> cur = head;
		Nodes<E> pre = head;
		E dElement = null;

		for (int i = 0; i < this.size; i++) {
			if (i == 0) {
				if (data.toString().equals(cur.data.toString())) {
					dElement = cur.data;
					pre = cur.nextNode;
					head = pre;
					break;
				}
			} else {
				pre = cur;
				cur = cur.nextNode;

				if (data.toString().equals(cur.data.toString())) {
					dElement = cur.data;
					pre.nextNode = cur.nextNode;
					break;
				}

			}
		}

		this.size--;
		return dElement;

	}

	// https://www.geeksforgeeks.org/given-a-linked-list-which-is-sorted-how-will-you-insert-in-sorted-way/
	public boolean addInSorted(E data) {

		Nodes<E> temp = new Nodes<E>(data);
		Nodes<E> cur = head;

		if (head == null) {
			// head is null add temp node to head.
			head = temp;
			this.size++;
			return true;
		} else if (Integer.parseInt(head.data.toString()) > Integer.parseInt(temp.data.toString())) {
			temp.nextNode = head;
			head = temp;
			return true;
		} else {

			// traversing to last node which is points next node as null.
			while (cur.nextNode != null
					&& Integer.parseInt(cur.nextNode.data.toString()) < Integer.parseInt(temp.data.toString())) {
				cur = cur.nextNode;
			}

			// set last node to point temp node.
			temp.nextNode = cur.nextNode;
			cur.nextNode = temp;
			this.size++;
			return true;
		}

	}

	public int compare2Strings(SinglyLinkedList<E> s1, SinglyLinkedList<E> s2) {
		Nodes<E> first = s1.head;
		Nodes<E> second = s2.head;
		while (first != null && second != null && first.data.equals(second.data)) {
			first = first.nextNode;
			second = second.nextNode;
		}

		if (first != null && second != null) {
			return (first.data.toString().charAt(0) > second.data.toString().charAt(0)) ? 1 : -1;
		}

		if (first == null && second != null)
			return -1;

		if (first != null && second == null)
			return 1;

		return 0;
	}

	public void merge2Lists(SinglyLinkedList<E> s1, SinglyLinkedList<E> s2) {
		Nodes<E> first = s1.head;
		Nodes<E> second = s2.head;
		Nodes<E> temp = first; // it will be needed to get the head of the new list

		while (first != null && second != null) {
			Nodes<E> f_next = first.nextNode;
			Nodes<E> s_next = second.nextNode;
			first.nextNode = second;
			second.nextNode = f_next;
			first = f_next;
			second = s_next;
		}

		System.out.println("Mergred List");
		head = temp;
		iterator();
		System.out.println("\nRemaining Second List");
		head = second;
		iterator();
	}

	public void reverseNthNode(SinglyLinkedList<E> s1, int n) {
		Nodes<E> cur = s1.head;
		Nodes<E> prev = null;
		Nodes<E> next = null;
		int i = 1;

		while (cur != null && i <= n) {
			next = cur.nextNode;
			cur.nextNode = prev;
			prev = cur;
			cur = next;
			i++;
		}

		Nodes<E> temp = prev;

		while (prev != null && prev.nextNode != null)
			prev = prev.nextNode;
		prev.nextNode = cur;
		head = temp;

		iterator();
	}

	public void iterator() {
		Nodes<E> cur = head;
		StringBuilder sb = new StringBuilder();

		while (true) {
			sb.append(cur.data);
			sb.append(" -> ");

			if (cur.nextNode == null)
				break;
			cur = cur.nextNode;
		}

		System.out.println(sb.toString());
	}

	@Override
	public String toString() {
		return "" + head;
	}

}

class Nodes<E> {
	public E data;

	public Nodes<E> nextNode;

	Nodes() {

	}

	Nodes(E data) {
		this.data = data;
		this.nextNode = null;
	}

}
