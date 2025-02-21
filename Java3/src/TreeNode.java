public class TreeNode {

    private LargeDepositor item;
    private TreeNode left; 
    private TreeNode right;  
    private TreeNode parent;
    private int N;  

    public TreeNode(LargeDepositor item) {
        this.item = item;
    }

    public TreeNode() {
    }

    public LargeDepositor getItem() {
        return item;
    }

    public void setItem(LargeDepositor item) {
        this.item = item;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getN() {
        return N;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
