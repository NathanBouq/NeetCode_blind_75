public class BinaryTreeUtils {
    /**
     * Checks if the binary tree passed as argument is an AVL
     * @param tree the binary tree to check.
     * @return true if the binary tree in input is an AVL tree, false otherwise
     */

    public static <E extends Comparable<E>> int computeHeight(BinaryTree<E> tree){
        return computeHeightFromNode(tree.getRoot());
    }

    private static <E extends Comparable<E>> int computeHeightFromNode(BinaryTreeNode<E> treeNode) {
        if(treeNode==null){
            return 0;
        }else{
            return 1 + Math.max(computeHeightFromNode(treeNode.getLeftChild()),
                computeHeightFromNode(treeNode.getRightChild()));
        }
    }

    //the time complexity for this method is O(n) where n is the  number of nodes in the tree
    public static <E extends Comparable<E>> boolean isAVLTree(BinaryTree<E> tree){
        // implement your method here
        //If a binary search tree has a balance factor of one then it is an AVL tree
        if (tree.getRoot() == null || tree == null){
            return false;
        }
        return isAVLTreee(tree.getRoot());
    }

    //the time complexity for this method is O(n) where n is the  number of nodes in the tree
    public static <E extends Comparable<E>> boolean isAVLTreee(BinaryTreeNode<E> tree){

        if (tree == null){
            return true;
        }
        //balance factor between left and right node must not be greater than 1 to be an AVL tree
        if (Math.abs(computeHeightFromNode(tree.getLeftChild()) - computeHeightFromNode(tree.getRightChild())) > 1){
            return false;    
        }
        return isAVLTreee(tree.getLeftChild()) && isAVLTreee(tree.getRightChild()) && isBSTTree(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* This algorithm checks if a BT is a BST recursively by checking if the leftchild is smaller than the parent node 
     * and the right child is bigger than the parent node
     * the time complexity for this method is O(n) where n is the  number of nodes in the tree
    */
     public static <E extends Comparable<E>> boolean isBSTTree(BinaryTreeNode<E> tree, int min, int max){
        // implement your method here
        // if node is null return true
        if (tree == null){
            return true;
        }
        var valueNode = (Integer) tree.getElement();
        if(valueNode < min || valueNode > max){ 
            return false;
        }else{
            return isBSTTree(tree.getRightChild(), valueNode + 1, max) && isBSTTree(tree.getLeftChild(), min, valueNode - 1);
        }
     }
}




