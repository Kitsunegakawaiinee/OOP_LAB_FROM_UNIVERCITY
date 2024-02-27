package MyTree;

public class Ope_node extends Node
{
    private String value;

    public Ope_node(String type, String ope)
    {
        super(type);
        this.value = ope;
    }

    public String eval()
    {
        return value;
    }

    @Override
    public void prettyPrint(StringBuilder sb) 
    {
        sb.append(value);
    }

    public String getter()
    {
        return value;
    }
}
