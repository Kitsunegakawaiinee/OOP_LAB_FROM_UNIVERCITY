import MyTree.*;
import From_LAB11.*;

import java.util.HashMap;
import java.util.Map;

class Dont_have_to_care_this 
{
    public static void main(String[] args) 
    {
        // myTest1(); 
        // myTest2();
        // myTest3();
        // myTest4();
        // myTest5();
        // myTest6();
        // myTest7();
        myTest8();
    } 

    private static void myTest1()
    {
        StringBuilder equation = new StringBuilder();

        IntLit int1 = new IntLit("int", 45);
        IntLit int2 = new IntLit("int", 48);
        Ope_node ope1 = new Ope_node("ope", "+");

        Map<String, Integer> var_inventory = new HashMap<>();

        Node root = Tree_config.node_hang(int1,ope1,int2);

        try 
        {
            Tree_config.prettyPrint(root, equation);
        }
        catch (EvalError e) 
        {
            System.out.println(e.getMessage());
        }
        
        System.out.println(equation);
        System.out.println();
        equation = new StringBuilder();

        IntLit int3 = new IntLit("int", 456);
        Variable var1 = new Variable("var", "x");
        root = Tree_config.node_hang(int3, root, var1);
        var_inventory.put("x", 456);

        try 
        {
            Tree_config.prettyPrint(root, equation);
        }
        catch (EvalError e) 
        {
            System.out.println(e.getMessage());
        }
        System.out.println(equation);
    }
    
    private static void myTest2()
    {
        //2*x+6
        StringBuilder equation = new StringBuilder();

        IntLit int1 = new IntLit("int", 2);
        IntLit int2 = new IntLit("int", 6);
        Ope_node ope1 = new Ope_node("ope", "*");
        Variable var1 = new Variable("var","x");
        Ope_node ope2 = new Ope_node("ope", "+");
        IntLit int3 = new IntLit("int", 6);

        // Map<String, Integer> var_inventory = new HashMap<>();

        Node root = Tree_config.node_hang(int1,ope1,var1);
        root = Tree_config.node_hang(root, ope2, int3);

        try 
        {
            Tree_config.prettyPrint(root, equation);
        }
        catch (EvalError e) 
        {
            System.out.println(e.getMessage());
        }

        System.out.println(equation);
    }  

    private static void myTest3()
    {
        //2+x*6
        StringBuilder equation = new StringBuilder();

        IntLit int1 = new IntLit("int", 2);
        IntLit int2 = new IntLit("int", 6);
        Ope_node ope1 = new Ope_node("ope", "*");
        Variable var1 = new Variable("var","x");
        Ope_node ope2 = new Ope_node("ope", "+");

        // Map<String, Integer> var_inventory = new HashMap<>();

        Node root = Tree_config.node_hang(var1,ope1,int2);
        root = Tree_config.node_hang(int1,ope2,root);

        try 
        {
            Tree_config.prettyPrint(root, equation);
        }
        catch (EvalError e) 
        {
            System.out.println(e.getMessage());
        }

        System.out.println(equation); 
    }

    private static void myTest4()
    {
        StringBuilder equation = new StringBuilder();

        IntLit int1 = new IntLit("int", 2);
        IntLit int2 = new IntLit("int", 6);
        Ope_node ope1 = new Ope_node("ope", "*");
        Variable var1 = new Variable("var","x");
        Ope_node ope2 = new Ope_node("ope", "+");

        Map<String, Integer> var_inventory = new HashMap<>();
        var_inventory.put("x", 5);

        Node root = Tree_config.node_hang(var1,ope1,int2);
        root = Tree_config.node_hang(int1,ope2,root);

        try 
        {
            Tree_config.prettyPrint(root, equation);
        }
        catch (EvalError e) 
        {
            System.out.println(e.getMessage());
        }

        System.out.println(equation); 

        try 
        {
            System.out.println(Tree_config.eval(var_inventory, root));
        } 
        catch (EvalError e) 
        {
            System.out.println(e);
        }
    }

    private static void myTest5()
    {
        StringBuilder equation = new StringBuilder();

        IntLit int1 = new IntLit("int", 2);
        IntLit int2 = new IntLit("int", 6);
        Ope_node ope1 = new Ope_node("ope", "*");
        Variable var1 = new Variable("var","x");
        Ope_node ope2 = new Ope_node("ope", "+");

        Map<String, Integer> var_inventory = new HashMap<>();
        var_inventory.put("x", 5);

        Node root = Tree_config.node_hang(int1,ope1,var1);
        root = Tree_config.node_hang(root, ope2, int2);

        try 
        {
            Tree_config.prettyPrint(root, equation);
        }
        catch (EvalError e) 
        {
            System.out.println(e.getMessage());
        }

        System.out.println(equation); 

        try 
        {
            System.out.println(Tree_config.eval(var_inventory, root));
        } 
        catch (EvalError e) 
        {
            System.out.println(e);
        }
    }

    private static void myTest6()
    {
        StringBuilder equation = new StringBuilder();

        IntLit int1 = new IntLit("int", 261200);

        Map<String, Integer> var_inventory = new HashMap<>();
        var_inventory.put("x", 5);

        Node root = Tree_config.node_hang(null, int1, null);

        try 
        {
            Tree_config.prettyPrint(root, equation);
        }
        catch (EvalError e) 
        {
            System.out.println(e.getMessage());
        }

        System.out.println(equation); 

        try 
        {
            System.out.println(Tree_config.eval(var_inventory, root));
        } 
        catch (EvalError e) 
        {
            System.out.println(e);
        }
    }

    private static void myTest7()
    {
        Program test = new Program();
    }

    private static void myTest8()
    {
        Program test = new Program();
        StringBuilder sd = new StringBuilder();

        Map<String, Integer> var = new HashMap<>();

        Node ast = null;

        try 
        {
            // ast = test.working("1+2+3+4+5+6+7+8+9+10");
            // ast = test.working("261200");
            // ast = test.working("2*(x+6)");
            // ast = test.working("2*x+6");
            // var.put("x", 5);
            // ast = test.working("1+(5)");
            // ast = test.working("7%2+(1+5*2)");
//             ast = test.working("7    %2+(   1+5*\n2)");
            // ast = test.working("15%0");
            // ast = test.working("156/(1-1)");
//            ast = test.working("x/x");
//            var.put("x", 0);
//            ast = test.working("");
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }

        try 
        {
            Tree_config.prettyPrint(ast, sd);
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }

        System.out.println("print is");
        System.out.println(sd);

        try 
        {
            System.out.println("eval is ");
            System.out.println(Tree_config.eval(var, ast));
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
}
