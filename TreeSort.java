/*
<COSC 2007>
<Rajin Santos Gajadhar>
<239479650> 
<Lab 5>
*/

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.key + " ");
            inorderTraversal(root.right);
        }
    }
}

public class TreeSort {
    public static void main(String[] args) {
        int[] values = {45, 10, 7, 90, 12, 50, 13, 39, 57};
        BinarySearchTree bst = new BinarySearchTree();

        for (int value : values) {
            bst.insert(value);
        }

        System.out.println("Sorted order: ");
        bst.inorderTraversal(bst.root);
    }
}
