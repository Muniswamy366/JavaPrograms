package com.arya.ds;

public class LinkedListTest {

	public static void main(String[] args) {
		/*SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
		linkedList.add(2);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.add(9);
		//insert 7 in sorting order.
		linkedList.iterator();
		linkedList.addInSorted(1);
		linkedList.iterator();*/
		
		/*SinglyLinkedList<Character> first = new SinglyLinkedList<Character>();
		first.add('m');
		first.add('u');
		first.add('n');
		first.add('i');
		SinglyLinkedList<Character> second = new SinglyLinkedList<Character>();
		second.add('m');
		second.add('u');
		second.add('n');
		second.add('i');
		first.compare2Strings(first, second);*/
		
		/*SinglyLinkedList<Integer> first = new SinglyLinkedList<Integer>();
		first.add(1);
		first.add(3);
		first.add(5);
		first.add(7);
		SinglyLinkedList<Integer> second = new SinglyLinkedList<Integer>();
		second.add(2);
		second.add(4);
		second.add(6);
		second.add(8);
		second.add(9);
		second.add(10);
		first.merge2Lists(first, second);*/
		
		/*SinglyLinkedList<Integer> first = new SinglyLinkedList<Integer>();
		first.add(1);
		first.add(2);
		first.add(3);
		first.add(4);
		first.add(5);
		first.reverseNthNode(first, 4);*/

		SinglyLinkedList<Integer> first = new SinglyLinkedList<Integer>();
		first.head = new Nodes<Integer>(1);
		first.head.nextNode = new Nodes<Integer>(2);
		first.head.nextNode.nextNode = new Nodes<Integer>(3);
		first.head.nextNode.nextNode.nextNode = new Nodes<Integer>(4);
		first.head.nextNode.nextNode.nextNode.nextNode = new Nodes<Integer>(5);
		first.head.nextNode.nextNode.nextNode.nextNode.nextNode = first.head;

		System.out.println(first.isCyclic());


	}

}
