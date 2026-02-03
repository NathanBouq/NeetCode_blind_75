
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
         this.left = left;
          this.right = right;
      }
}

public class Tree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }        
        // Swap left and right subtrees
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        // Recursively invert left and right subtrees
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(0);

        Tree tree = new Tree();
        TreeNode invertedRoot = tree.invertTree(root);
        // The invertedRoot now represents the root of the inverted binary tree.
        System.out.println("Inverted tree root value: " + invertedRoot.val);
    }
}