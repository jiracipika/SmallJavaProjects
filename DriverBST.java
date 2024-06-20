/*
<COSC 2007>
<Rajin Santos Gajadhar>
<239479650> 
<Assignment 2>
*/

import java.util.Scanner;

public class DriverBST {

    public static void main(String[] args) {
        BinarySearchTree1<Integer> bst = new BinarySearchTree1<Integer>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBinary Search Tree Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display (Preorder, Inorder, Postorder)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter integer element to insert: ");
                    bst.insert(scanner.nextInt());
                    displayTree(bst);
                    break;
                case 2:
                    System.out.print("Enter integer element to delete: ");
                    bst.delete(scanner.nextInt());
                    displayTree(bst);
                    break;
                case 3:
                    displayTree(bst);
                    break;
                case 4:
                    scanner.close();
                    System.out.println("Exiting Program");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid number.");
                    break;
            }
        }
    }

    public static void displayTree(BinarySearchTree1<Integer> bst) {
        System.out.println("Preorder traversal: ");
        preorderTraversal(bst.getRoot());
        System.out.println("\nInorder traversal: ");
        inorderTraversal(bst.getRoot());
        System.out.println("\nPostorder traversal: ");
        postorderTraversal(bst.getRoot());
        System.out.println("\n=====================");
    }

    public static void inorderTraversal(TreeNode<Integer> node) {
        if (node != null) {
            inorderTraversal(node.getLeftChild());
            System.out.print(node.getItem() + " ");
            inorderTraversal(node.getRightChild());
        }
    }

    public static void preorderTraversal(TreeNode<Integer> node) {
        if (node != null) {
            System.out.print(node.getItem() + " ");
            preorderTraversal(node.getLeftChild());
            preorderTraversal(node.getRightChild());
        }
    }

    public static void postorderTraversal(TreeNode<Integer> node) {
        if (node != null) {
            postorderTraversal(node.getLeftChild());
            postorderTraversal(node.getRightChild());
            System.out.print(node.getItem() + " ");
        }
    }
}
