 /*
<COSC 2007>
<Rajin Santos Gajadhar>
<239479650> 
<Assignment 3>
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
    
class TwoThreeTree {
    private TreeNode root;

    // Constructor
    public TwoThreeTree() {
        root = null;
    }

    // Preorder traversal
    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.title1 + ", ");
            preOrder(node.left);
            preOrder(node.middle);
            if (node.title2 != null) {
                System.out.print(node.title2 + ", ");
                preOrder(node.right);
            }
        }
    }

    // Inorder traversal
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.title1 + ", ");
            inOrder(node.middle);
            if (node.title2 != null) {
                System.out.print(node.title2 + ", ");
                inOrder(node.right);
            }
        }
    }

    // Postorder traversal
    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.middle);
            if (node.title2 != null) {
                postOrder(node.right);
                System.out.print(node.title2 + ", ");
            }
            System.out.print(node.title1 + ", ");
        }
    }

    // Retrieve an item by title
    public TreeNode retrieveItem(TreeNode node, String searchKey) {
        if (node == null) {
            return null;
        }

        if (searchKey.compareTo(node.title1) < 0) {
            return retrieveItem(node.left, searchKey);
        } else if (searchKey.compareTo(node.title1) == 0) {
            return node;
        } else if (node.title2 == null || searchKey.compareTo(node.title2) < 0) {
            return retrieveItem(node.middle, searchKey);
        } else {
            return retrieveItem(node.right, searchKey);
        }
    }

    // Insert an item into the 2-3 Tree
    public TreeNode insertItem(TreeNode node, String insertKey) {
        if (node == null) {
            return new TreeNode(insertKey);
        }

        if (node.title2 == null) {
            // Node has one title
            if (insertKey.compareTo(node.title1) < 0) {
                node.left = insertItem(node.left, insertKey);
            } else {
                node.middle = insertItem(node.middle, insertKey);
            }
        } else {
            // Node has two titles
            if (insertKey.compareTo(node.title1) < 0) {
                TreeNode newNode = insertItem(node.left, insertKey);
                TreeNode tempNode = new TreeNode(node.title1, node.title2);
                tempNode.left = newNode;
                tempNode.middle = node.middle;
                node.title1 = tempNode.title1;
                node.title2 = null;
                node.left = tempNode.left;
                node.middle = tempNode.middle;
            } else if (insertKey.compareTo(node.title2) < 0) {
                node.middle = insertItem(node.middle, insertKey);
            } else {
                TreeNode newNode = insertItem(node.right, insertKey);
                TreeNode tempNode = new TreeNode(node.title1, node.title2);
                tempNode.middle = node.middle;
                tempNode.right = newNode;
                node.title1 = node.title2;
                node.title2 = null;
                node.middle = tempNode.middle;
                node.right = tempNode.right;
            }
        }
        return node;
    }




public static void main(String[] args) {
    TwoThreeTree dvdTree = new TwoThreeTree();
    List<String> dvdDatabase = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    // Initialize the program with three DVD names
    dvdDatabase.add("Aliens");
    dvdDatabase.add("The Lord of the Rings");
    dvdDatabase.add("Kill Bill");
    
    for (String dvd : dvdDatabase) {
        dvdTree.root = dvdTree.insertItem(dvdTree.root, dvd);
    }

    while (true) {
        System.out.println("\nDVD Database Menu:");
        System.out.println("1. Insert DVD");
        System.out.println("2. Search for DVD");
        System.out.println("3. Print DVDs (Inorder)");
        System.out.println("4. Print DVDs (Preorder)");
        System.out.println("5. Print DVDs (Postorder)");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                System.out.print("Enter the DVD title to insert: ");
                String insertTitle = scanner.nextLine();
                dvdDatabase.add(insertTitle);
                dvdTree.root = dvdTree.insertItem(dvdTree.root, insertTitle);
                break;

            case 2:
                System.out.print("Enter the DVD title to search: ");
                String searchTitle = scanner.nextLine();
                TreeNode result = dvdTree.retrieveItem(dvdTree.root, searchTitle);
                if (result != null) {
                    System.out.println("Found DVD: " + result.title1);
                } else {
                    System.out.println("DVD not found.");
                }
                break;

            case 3:
                System.out.println("DVDs (Inorder):");
                dvdTree.inOrder(dvdTree.root);
                break;

            case 4:
                System.out.println("DVDs (Preorder):");
                dvdTree.preOrder(dvdTree.root);
                break;

            case 5:
                System.out.println("DVDs (Postorder):");
                dvdTree.postOrder(dvdTree.root);
                break;

            case 6:
                System.out.println("Exiting program.");
                scanner.close();
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice. Please enter a valid option.");
                break;
        }
    }
}
}


