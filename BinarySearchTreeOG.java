/*
<COSC 2007>
<Rajin Santos Gajadhar>
<239479650> 
<Assignment 2>
*/

import java.util.Scanner;

public class BinarySearchTreeOG {

    //Represents each node in the tree
    class Node {
        int value;
        Node left, right;

        public Node(int item) {
            value = item;
            left = right = null;
        }
    }

    //Root node of the BST
    Node root;

    //Constructor for BST: initial tree is empty
    BinarySearchTreeOG() {
        root = null;
    }

    //Method to insert a new key in BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    //Recursive function to insert a new key in BST
    Node insertRec(Node root, int key) {
        //If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        //Otherwise, recur down the tree and insert the node
        if (key < root.value)
            root.left = insertRec(root.left, key);
        else if (key > root.value)
            root.right = insertRec(root.right, key);

        //Return the unchanged node pointer
        return root;
    }

    //Method to delete a key from BST
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    //Recursive function to delete a key in BST
    Node deleteRec(Node root, int key) {
        //If the tree is empty
        if (root == null) return root;

        //Otherwise, find key to be deleted
        if (key < root.value)
            root.left = deleteRec(root.left, key);
        else if (key > root.value)
            root.right = deleteRec(root.right, key);
        else {
            //Node with one or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            //Node with two children: Get inorder successor
            root.value = minValue(root.right);

            //Delete the inorder successor
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    //Function to find the minimum value in the BST
    int minValue(Node root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    //Functions to perform inorder, preorder and postorder traversals
    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    void preorder() {
        preorderRec(root);
        System.out.println();
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder() {
        postorderRec(root);
        System.out.println();
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.value + " ");
        }
    }

    //Main
    public static void main(String[] args) {
        BinarySearchTreeOG tree = new BinarySearchTreeOG();
        Scanner scanner = new Scanner(System.in);

        //User interface loop
        while (true) {
            System.out.println("\nBinary Search Tree Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display (Inorder)");
            System.out.println("4. Display (Preorder)");
            System.out.println("5. Display (Postorder)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter integer element to insert: ");
                    tree.insert(scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Enter integer element to delete: ");
                    tree.deleteKey(scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Inorder traversal: ");
                    tree.inorder();
                    break;
                case 4:
                    System.out.println("Preorder traversal: ");
                    tree.preorder();
                    break;
                case 5:
                    System.out.println("Postorder traversal: ");
                    tree.postorder();
                    break;
                case 6:
                    scanner.close();
                    System.out.println("Exiting Program");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid number.");
                    break;
            }
        }
    }
}
