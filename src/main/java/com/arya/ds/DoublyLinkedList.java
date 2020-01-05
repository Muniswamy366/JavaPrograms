package com.arya.ds;

public class DoublyLinkedList<E> {

    private DNodes<E> head;
    private int size;

    public static void main(String[] args) {

        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>();

        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        doublyLinkedList.add(4);
        doublyLinkedList.add(5);
        doublyLinkedList.remove(4);

        System.out.println("size is: " + doublyLinkedList.getSize());
        doublyLinkedList.printForword();
        doublyLinkedList.printBackword();

    }

    public boolean add(E data) {
        DNodes<E> temp = new DNodes<E>(data);
        boolean result = false;
        DNodes<E> cursor = null;

        if (head == null) {
            head = temp;
            result = true;
        } else {
            cursor = head;
            while (cursor.nextNode != null) {
                cursor = cursor.nextNode;
            }

            cursor.nextNode = temp;
            temp.previousNode = cursor;

            result = true;
        }

        this.size++;
        return result;
    }

    public boolean add(int index, E data) {
        boolean result = false;
        DNodes<E> temp = new DNodes<E>(data);
        DNodes<E> cursor = null;

        if (index == 0) {
            temp.nextNode = head;
            head.previousNode = temp;
            head = temp;
        } else {
            cursor = head;
            for (int i = 1; i < index; i++) {
                cursor = cursor.nextNode;
            }

            if (cursor.nextNode != null) {
                cursor.nextNode.previousNode = temp;
                temp.nextNode = cursor.nextNode;
            }

            cursor.nextNode = temp;
            temp.previousNode = cursor;
        }

        return result;
    }

    public E remove(int index) {
        E tempEle = null;
        DNodes<E> cursor = null;

        if (index == 0) {
            head = head.nextNode;
            head.previousNode = null;
        } else {
            cursor = head;

            for (int i = 1; i < index; i++) {
                cursor = cursor.nextNode;
            }

            cursor.nextNode = cursor.nextNode.nextNode;
            if (cursor.nextNode != null)
                cursor.nextNode.previousNode = cursor;

        }

        return tempEle;
    }

    public void printForword() {

        DNodes<E> cursor = head;
        boolean arrow = true;

        do {

            System.out.print((arrow) ? "|" + cursor.data + "|" : " --> " + "|" + cursor.data + "|");

            arrow = false;
            cursor = cursor.nextNode;

        } while (cursor != null);

        System.out.println();
    }

    public void printBackword() {

        DNodes<E> cursor = head;

        while (cursor.nextNode != null) {

            cursor = cursor.nextNode;

        }

        boolean arrow = true;

        do {

            System.out.print((arrow) ? "|" + cursor.data + "|" : " --> " + "|" + cursor.data + "|");

            arrow = false;
            cursor = cursor.previousNode;

        } while (cursor != null);

        System.out.println();
    }

    public int getSize() {
        return this.size;
    }
}

class DNodes<E> {

    public E data;
    public DNodes<E> previousNode;
    public DNodes<E> nextNode;

    public DNodes() {

    }

    public DNodes(E data) {

        this.data = data;
        this.previousNode = null;
        this.nextNode = null;

    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public DNodes<E> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DNodes<E> previousNode) {
        this.previousNode = previousNode;
    }

    public DNodes<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(DNodes<E> nextNode) {
        this.nextNode = nextNode;
    }

}