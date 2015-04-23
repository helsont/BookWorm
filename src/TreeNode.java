

/**
 * Created by Helson Taveras on 3/26/15.
 */
public interface TreeNode<T> {

    /**
     * Returns whatever data you have in the node.
     *
     * @return
     */
    public Object getData();

    /**
     * Can either be another node in the binary tree (of type
     * <code>BinaryTree.expectingClass()</code>) or a leaf node with data.
     *
     * @return
     */
    public Object getLeft();

    /**
     * Can either be another node in the binary tree (of type
     * <code>BinaryTree.expectingClass()</code>) or a leaf node with data.
     *
     * @return
     */
    public Object getRight();

    /**
     * String representation of an internal node. Can be blank if you don't
     * want to draw anything.
     *
     * @return
     */
    public String getVisualString();
}
