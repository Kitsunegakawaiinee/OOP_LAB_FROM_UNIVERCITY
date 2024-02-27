package MyTree;

import java.util.LinkedList;
import java.util.Map;

public class Tree_config 
{
    public static Node node_hang(Node left, Node root, Node right)
    {
        root.left = left;
        root.right = right;
        return root;
    }    

    private static void print_helper(Node node, StringBuilder sd)
    {       
        if(node.type_check("int"))
        {
            if(node instanceof IntLit i) i.prettyPrint(sd);
        }
        else if(node.type_check("ope"))
        {
            if(node instanceof Ope_node i) i.prettyPrint(sd);
        }
        else if(node.type_check("var"))
        {
            if(node instanceof Variable i) i.prettyPrint(sd);
        }
    }

    public static void prettyPrint(Node root, StringBuilder sd) throws EvalError
    {
        if(root == null)
        {
            System.out.println("Empty tree");
            return ;
        }

        if(root.left == null && root.right == null)
        {
            print_helper(root, sd);
            return;
        }

        sd.append('(');
        if(root.left != null) prettyPrint(root.left, sd);
        print_helper(root, sd);
        if(root.right != null) prettyPrint(root.right, sd);  
        sd.append(')');  
    }

    public static double eval(Map<String, Integer> bindings, Node root) throws EvalError
    {

        if(root.left == null && root.right == null)
        {
            if(root instanceof IntLit i) return i.eval(bindings);
            else if(root instanceof Variable i) return i.eval(bindings);
        }

        double result = -1;

        if(root.type_check("ope"))
        {
            if(root instanceof Ope_node i)
            {
                result = eval(bindings, root.left);
                String ope = i.getter();

                if(ope.equals("+")) result+= eval(bindings, root.right);
                else if(ope.equals("-")) result-= eval(bindings, root.right);
                else if(ope.equals("*")) result*= eval(bindings, root.right);
                else if(ope.equals("/"))
                {
                    double temp = eval(bindings, root.right);

                    if(temp == 0) throw new EvalError("/ 0, bro");
                    
                    result /= temp;
                }
                else if(ope.equals("%")) 
                {
                    double temp = eval(bindings, root.right);

                    if(temp == 0) throw new EvalError("% 0, bro");

                    result %= temp;
                }
            }
        }

        return result;
    }
}
