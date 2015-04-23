

/**
 * Created by Helson Taveras on 3/26/15.
 */
public interface BinaryTree<T> {

    /**
     * The root node of the tree.
     *
     * @return
     */
    public TreeNode getRoot();

    /**
     * This is a support system for different types of Binary Tree nodes. By
     * specifying the class that the user is expecting to a be node of the tree,
     * the visual component knows when the node it's trying to render is a leaf
     * node (probably a subclass of Integer, or Character, for example) or an
     * internal node (in which case, it could be a CalculatorNode,
     * AlwaysFullNode, etc.). It's flexible.
     *
     * @return
     */
    public Class expectingClass();
}
