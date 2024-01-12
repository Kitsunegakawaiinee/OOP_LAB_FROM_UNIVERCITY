package MyTree;

import java.util.Map;

public class Variable extends Expr
{
    private String name;

    public Variable(String type, String name)
    {
        super(type);
        this.name = name;
    }

    @Override
    public double eval(Map<String, Integer> bindings) throws EvalError
    {
        if(bindings.containsKey(name)) return bindings.get(name);
        
        throw new EvalError("undefined variable: " + name);
    }

    @Override
    public void prettyPrint(StringBuilder sb) 
    {
        sb.append(name);
    }
}
