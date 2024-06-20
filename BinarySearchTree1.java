/*
<COSC 2007>
<Rajin Santos Gajadhar>
<239479650> 
<Assignment 2>
*/

public class BinarySearchTree1<T extends Comparable<T>> {
    private TreeNode<T> root;

    public BinarySearchTree1() {
        root = null;
    } // end default constructor

    public BinarySearchTree1(T rootItem) {
        root = new TreeNode<T>(rootItem, null, null);
    } // end constructor

    public void insert(T newItem) {
        root = insertItem(root, newItem);
    } // end insert

    public T retrieve(T searchKey) {
        return retrieveItem(root, searchKey);
    } // end retrieve

    public void delete(T searchKey) {
        root = deleteItem(root, searchKey);
    } // end delete

    // Method to get the root of the tree
    public TreeNode<T> getRoot() {
        return root;
    }

    // Recursive helper methods for insert, retrieve, and delete operations
    private TreeNode<T> insertItem(TreeNode<T> rootNode, T newItem) {
        if (rootNode == null) {
            rootNode = new TreeNode<T>(newItem);
            return rootNode;
        }

        int comparison = newItem.compareTo(rootNode.getItem());
        if (comparison < 0) {
            rootNode.setLeftChild(insertItem(rootNode.getLeftChild(), newItem));
        } else if (comparison > 0) {
            rootNode.setRightChild(insertItem(rootNode.getRightChild(), newItem));
        }

        return rootNode;
    }

    private T retrieveItem(TreeNode<T> rootNode, T searchKey) {
        if (rootNode == null) {
            return null;
        }

        int comparison = searchKey.compareTo(rootNode.getItem());
        if (comparison == 0) {
            return rootNode.getItem();
        } else if (comparison < 0) {
            return retrieveItem(rootNode.getLeftChild(), searchKey);
        } else {
            return retrieveItem(rootNode.getRightChild(), searchKey);
        }
    }

    private TreeNode<T> deleteItem(TreeNode<T> rootNode, T searchKey) {
        if (rootNode == null) {
            return null;
        }

        int comparison = searchKey.compareTo(rootNode.getItem());
        if (comparison < 0) {
            rootNode.setLeftChild(deleteItem(rootNode.getLeftChild(), searchKey));
        } else if (comparison > 0) {
            rootNode.setRightChild(deleteItem(rootNode.getRightChild(), searchKey));
        } else {
            // Node with one or no child
            if (rootNode.getLeftChild() == null) {
                return rootNode.getRightChild();
            } else if (rootNode.getRightChild() == null) {
                return rootNode.getLeftChild();
            }

            // Node with two children
            T minValue = minValue(rootNode.getRightChild());
            rootNode.setItem(minValue);
            rootNode.setRightChild(deleteItem(rootNode.getRightChild(), minValue));
        }

        return rootNode;
    }

    // Helper method to find the minimum value in a subtree
    private T minValue(TreeNode<T> rootNode) {
        T minValue = rootNode.getItem();
        while (rootNode.getLeftChild() != null) {
            rootNode = rootNode.getLeftChild();
            minValue = rootNode.getItem();
        }
        return minValue;
    }
}
