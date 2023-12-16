package day06;

public interface BinarySearchTree {
    void insert(int data);

    void delete(int data);

    int min();

    int max();

    void levelOrder();

    void inOrder();

    void preOrder();

    void postOrder();

    void print();
}
