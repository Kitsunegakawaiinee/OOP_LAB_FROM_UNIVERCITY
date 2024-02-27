package MyTree;

abstract public class Node 
{
    private String type;
    public Node left;
    public Node right;

    public Node(String type)  
    {
        this.type = type;
    }
    
    public boolean type_check(String input)
    {
        return input.equals(type);
    }

    abstract public void prettyPrint(StringBuilder sb);
}
