package MyTree;

import java.util.Map;

abstract public class Expr extends Node
{
    public Expr(String type)
    {
        super(type);
    }
    
    abstract public double eval(Map<String, Integer> bindings) throws EvalError;
}
