/*
<COSC 2007>
<Rajin Santos Gajadhar>
<239479650> 
<Lab 3>
*/

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    // Function to insert nodes in level order
    Node insertLevelOrder(int[] arr, Node root, int i) {
        // Base case for recursion
        if (i < arr.length) {
            Node temp = new Node(arr[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    // Function to print preorder traversal of the tree
    void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Function to print inorder traversal of the tree
    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    // Function to print postorder traversal of the tree
    void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        tree.root = tree.insertLevelOrder(arr, tree.root, 0);
        System.out.println("Preorder traversal:");
        tree.preorder(tree.root);
        System.out.println("\nInorder traversal:");
        tree.inorder(tree.root);
        System.out.println("\nPostorder traversal:");
        tree.postorder(tree.root);
    }
}
