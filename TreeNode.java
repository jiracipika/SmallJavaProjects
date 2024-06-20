/*
<COSC 2007>
<Rajin Santos Gajadhar>
<239479650> 
<Assignment 3>
*/

class TreeNode {
    String title1; // First DVD title
    String title2; // Second DVD title (only used if the node has 3 children)
    TreeNode left;
    TreeNode middle;
    TreeNode right;
    
    // Constructor for nodes with one title
    public TreeNode(String title) {
        this.title1 = title;
        this.title2 = null;
        this.left = null;
        this.middle = null;
        this.right = null;
    }
    
    // Constructor for nodes with two titles
    public TreeNode(String title1, String title2) {
        this.title1 = title1;
        this.title2 = title2;
        this.left = null;
        this.middle = null;
        this.right = null;
    }
}
