package day06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeImpl implements BinarySearchTree {

    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            node.left = insert(node.left, data);
        }

        return node;
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (data > node.data) {
            node.right = delete(node.right, data);
        } else if (data < node.data) {
            node.left = delete(node.left, data);
        } else {
            //0 child
            if (node.left == null && node.right == null) {
                node = null;
                return null;
            }

            //only left child
            if (node.left != null && node.right == null) {
                Node temp = node.left;
                node = null;
                return temp;
            }

            //only right child
            if (node.left == null && node.right != null) {
                Node temp = node.right;
                node = null;
                return temp;
            }

            //2 children
            if (node.left != null && node.right != null) {
                int max = max(node.left).data;
                node.data = max;
                node.left = delete(node.left, max);
                return node;
            }
        }

        return node;
    }

    public int min() {
        Node node = min(root);

        return node.data;
    }

    private Node min(Node node) {
        if (node == null) {
            return null;
        }

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    public int max() {
        Node node = max(root);

        return node.data;
    }

    private Node max(Node node) {
        if (node == null) {
            return null;
        }

        while (node.right != null) {
            node = node.right;
        }

        return node;
    }

    public void levelOrder() {
        levelOrder(this.root);
    }

    private void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp == null) {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                System.out.print(temp.data + " ");

                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }

    public void inOrder() {
        inOrderIterative(this.root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    private void inOrderIterative(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    public void preOrder() {
        preOrderIterative(this.root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private void preOrderIterative(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.data + " ");

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public void postOrder() {
        postOrderIterative(this.root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    private void postOrderIterative(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                Node temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    node = temp;
                }
            }
        }
    }

    public void print() {
        System.out.println("Tree: ");
        this.levelOrder();

        System.out.print("In order traversal: ");
        this.inOrder();

        System.out.println();
        System.out.print("Pre order traversal: ");
        this.preOrder();

        System.out.println();
        System.out.print("Post order traversal: ");
        this.postOrder();

        System.out.println();
        System.out.println("Minimum value: " + this.min());
        System.out.println("Maximum value: " + this.max());
    }
}
