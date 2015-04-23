

/**
 * @author Helson Taveras
 */
public class BinaryNode implements Comparable, TreeNode {

    private Object left;
    private Object right;
    private Object data;

    public BinaryNode(Object left, Object data, Object right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Object getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public Object getRight() {
        return right;
    }

    @Override
    public String getVisualString() {
        return "-:" + data.toString();
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public int compareTo(Object o) {
//        if (o instanceof BinaryNode)
//            return (int) Math.signum((Integer) getData() -
//                    (Integer) ((BinaryNode) o).getData());
//        else if (o instanceof HuffmanEncoder.Entry) {
//            return (int) Math.signum((Integer) getData() -
//                    (Integer) ((HuffmanEncoder.Entry) o).freq);
//        }

        throw new IllegalArgumentException("Unexpected class:" + o.getClass());
    }

    @Override
    public String toString() {
        return "BTNode{" +
                "left=" + left +
                ", right=" + right +
                ", data=" + data +
                '}';
    }
}