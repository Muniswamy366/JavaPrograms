package com.arya.advance;

import java.util.HashSet;
import java.util.Set;

public class RemoveDupsArrNode {
  public static void removeDupes(Node node) {
    Set<Integer> set = new HashSet<>();
    set.add(node.val);
    Node prev = node;
    Node temp = node.next;
    while (temp != null) {
      if (set.contains(temp.val)) {
        prev.next = temp.next;
      } else {
        set.add(temp.val);
        prev = temp;
      }
      temp = temp.next;
    }
  }

  public static void main(String[] args) {

    int[] arr = new int[]{2, 1, 3, 5, 2, 1, 3, 5, 6, 7, 5};

    Node[] node = new Node[arr.length];

    for (int i = 1; i <= arr.length; i++) {

      node[i - 1] = new Node(arr[i - 1]);
    }

    for (int i = 1; i < node.length; i++) {

      node[i - 1].next = node[i];

    }

    Node firstNode = node[0];

    System.out.println(firstNode);
    removeDupes(firstNode);
    String val = firstNode.toString();
    System.out.println(val);
  }

  public static class Node {
    Node next;
    int val;

    public Node(int val) {
      this.val = val;
    }

    public String toString() {
      StringBuilder sb = new StringBuilder();
      Node temp = this;
      while (temp != null) {
        sb.append(temp.val);
        temp = temp.next;
      }
      return sb.toString();
    }
  }
}
