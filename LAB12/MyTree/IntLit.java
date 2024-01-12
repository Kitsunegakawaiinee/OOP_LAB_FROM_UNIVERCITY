package MyTree;

import java.util.Map;

public class IntLit extends Expr
{
    private double val;

    public IntLit(String type, double val)
    {
        super(type);
        this.val = val;
    }

    @Override
    public double eval(Map<String, Integer> bindings) 
    {
        return val;
    }

    @Override
    public void prettyPrint(StringBuilder sb) 
    {
        sb.append(val);
    }
}
