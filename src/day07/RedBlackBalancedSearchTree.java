package day07;

import static day07.Color.*;

public class RedBlackBalancedSearchTree {

    private class Node {
        int data;
        Color color;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.color = RED;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private Node nil;

    public RedBlackBalancedSearchTree() {
        this.nil = new Node(0);
        this.nil.color = BLACK;
        this.root = this.nil;
    }

    public void insert(int data) {
        this.root = insert(this.root, data);
        root.color = BLACK;
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }

        if  (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private Node rotateLeft(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        node.left = temp;
        temp.color = node.color;
        node.color = RED;
        return temp;
    }

    private Node rotateRight(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        temp.color = node.color;
        node.color = RED;
        return temp;
    }

    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    private boolean isRed(Node node) {
        return node != nil && node.color == Color.RED;
    }
}
