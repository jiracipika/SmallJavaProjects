/*
<COSC 2007>
<Rajin Santos Gajadhar>
<239479650> 
<Lab 4>
*/

class BST {
    class Node {
        int key;
        Node left, right;

        //inner class
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BST() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    //recursive to insert a new key
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    //inorder traversal
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) return root;
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
}

class Main {
    public static void main(String[] args) {
        BST tree = new BST();

        tree.insert(3);
        tree.insert(8);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(2);
        tree.insert(10);
        tree.insert(9);
        tree.insert(20);
        tree.insert(25);
        tree.insert(15);
        tree.insert(16);

        System.out.println("Inorder traversal of the given tree:");
        tree.inorder();

        System.out.println("\n\nDoes 4 exist in the tree? " + tree.search(4));

        System.out.println("\nDeleting node 2 (no children)");
        tree.deleteKey(2);
        tree.inorder();

        System.out.println("\n\nDeleting node 4 (one child)");
        tree.deleteKey(4);
        tree.inorder();

        System.out.println("\n\nDeleting node 10 (two children)");
        tree.deleteKey(10);
        tree.inorder();
    }
}
