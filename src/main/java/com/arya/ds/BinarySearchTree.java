package com.arya.ds;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    public static BNode root;

    public BinarySearchTree() {
        BinarySearchTree.root = null;
    }

    public static void main(String[] arg) {

        // http://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/
        BinarySearchTree b = new BinarySearchTree();
        b.insert(3);
        b.insert(8);
        b.insert(1);
        b.insert(4);
        b.insert(6);
        b.insert(2);
        b.insert(10);
        b.insert(9);
        b.insert(20);
        b.insert(25);
        b.insert(15);
        b.insert(16);
        System.out.println("Original Tree : ");
        b.display(BinarySearchTree.root);
        System.out.println();
        System.out.println("Check whether BNode with value 4 exists : " + b.find(4));
        System.out.println("Delete BNode with no children (2) : " + b.delete(2));
        b.display(BinarySearchTree.root);
        System.out.println("\n Delete BNode with one child (4) : " + b.delete(4));
        b.display(BinarySearchTree.root);
        System.out.println("\n Delete BNode with Two children (10) : " + b.delete(10));
        b.display(BinarySearchTree.root);
    }

    public static void levelOrderTraversal(BNode startNode) {
        Queue<BNode> queue = new LinkedList<BNode>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            BNode tempNode = queue.poll();
            System.out.printf("%d ", tempNode.data);
            if (tempNode.left != null)
                queue.add(tempNode.left);
            if (tempNode.right != null)
                queue.add(tempNode.right);
        }
    }

    public void insert(int id) {
        BNode newBNode = new BNode(id);
        if (root == null) {
            root = newBNode;
            return;
        }
        BNode current = root;
        BNode parent = null;
        while (true) {
            parent = current;
            if (id < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newBNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newBNode;
                    return;
                }
            }
        }
    }

    public boolean delete(int id) {

        BNode parent = root;
        BNode current = root;
        boolean isLeftChild = false;

        while (current.data != id) {
            parent = current;
            if (current.data > id) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }

        // if i am here that means we have found the node
        // Case 1: if node to be deleted has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        // Case 2 : if node to be deleted has only one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.left != null && current.right != null) {

            // now we have found the minimum element in the right sub tree
            BNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public boolean find(int id) {
        BNode current = root;
        while (current != null) {
            if (current.data == id) {
                return true;
            } else if (current.data > id) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public BNode getSuccessor(BNode deleleBNode) {
        BNode successsor = null;
        BNode successsorParent = null;
        BNode current = deleleBNode.right;
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        /*
         * check if successor has the right child, it cannot have left child for sure if
         * it does have the right child, add it to the left of successorParent.
         */
        if (successsor != deleleBNode.right) {
            successsorParent.left = successsor.right;
            successsor.right = deleleBNode.right;
        }
        return successsor;
    }

    public void display(BNode root) {
        if (root != null) {
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }

    public int findMinimum() {
        if (root == null) {
            return 0;
        }
        BNode currNode = BinarySearchTree.root;
        while (currNode.left != null) {
            currNode = currNode.left;
        }
        return currNode.data;
    }

    public int findMaximum() {
        if (root == null) {
            return 0;
        }

        BNode currNode = root;
        while (currNode.right != null) {
            currNode = currNode.right;
        }
        return currNode.data;
    }

    public void printInorder() {
        printInOrderRec(root);
        System.out.println();
    }

    private void printInOrderRec(BNode currRoot) {
        if (currRoot == null) {
            return;
        }
        printInOrderRec(currRoot.left);
        System.out.print(currRoot.data + ", ");
        printInOrderRec(currRoot.right);
    }

    public void printPreorder() {
        printPreOrderRec(root);
        System.out.println();
    }

    private void printPreOrderRec(BNode currRoot) {
        if (currRoot == null) {
            return;
        }
        System.out.print(currRoot.data + ", ");
        printPreOrderRec(currRoot.left);
        printPreOrderRec(currRoot.right);
    }

    public void printPostorder() {
        printPostOrderRec(root);
        System.out.println();
    }

    private void printPostOrderRec(BNode currRoot) {
        if (currRoot == null) {
            return;
        }
        printPostOrderRec(currRoot.left);
        printPostOrderRec(currRoot.right);
        System.out.print(currRoot.data + ", ");

    }

}

class BNode {

    int data;
    BNode left;
    BNode right;

    public BNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}