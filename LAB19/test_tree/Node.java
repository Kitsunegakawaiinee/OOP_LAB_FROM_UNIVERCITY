package test_tree;
public class Node
{
    private int data;
    private Node parent;
    private Node left, right;

    public Node left_getter()
    {
        return left;
    }

    public Node right_getter()
    {
        return right;
    }

    public Node parent_getter()
    {
        return parent;
    }

    public Node(int data)
    {
        this.data = data;
    }

    /**
     * hang node
     * @param left Node
     * @param right Node
     */
    public void hang(Node left, Node right)
    {
        if(left != null) left.set_parent(this);
        this.left = left;
        if(right != null) right.set_parent(this);
        this.right = right;
    }

    public void set_parent(Node parent)
    {
        this.parent = parent;
    }

    @Override
    public String toString() 
    {
        return Integer.toString(data);
    }
}