import From_LAB11.Program;

import From_LAB11.SyntaxError;
import MyTree.EvalError;
import MyTree.Node;
import MyTree.Tree_config;
import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    private Program test = new Program();

    @Test
    void test1_1()
    {
        try
        {
            StringBuilder input = new StringBuilder();

            Node temp = test.working("261200");
            Tree_config.prettyPrint(temp, input);
            assertEquals("261200.0",input.toString());
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Test
    void test1_2()
    {
        try
        {
            StringBuilder input = new StringBuilder();

            Node temp = test.working("261200");
            int result = (int) Tree_config.eval(null, temp);
            assertEquals(261200, result);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Test
    void test2_1()
    {
        Map<String, Integer> binding = new HashMap<>();
        binding.put("x",15);

        try
        {
            StringBuilder input = new StringBuilder();

            Node temp = test.working("2*x+6");
            Tree_config.prettyPrint(temp, input);
            assertEquals("((2.0*x)+6.0)", input.toString());
            double result = Tree_config.eval(binding, temp);
            assertEquals(result, 36.0);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Test
    void test2_2()
    {
        Map<String, Integer> binding = new HashMap<>();
        binding.put("x",15);

        try
        {
            StringBuilder input = new StringBuilder();

            Node temp = test.working("2+x*6");
            Tree_config.prettyPrint(temp, input);
            assertEquals("(2.0+(x*6.0))", input.toString());
            double result = Tree_config.eval(binding, temp);
            assertEquals(result, 92.0);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Test
    void test3_1()
    {
        Map<String, Integer> binding = new HashMap<>();
        binding.put("x",15);

        try
        {
            StringBuilder input = new StringBuilder();

            Node temp = test.working("x/3/2");
            Tree_config.prettyPrint(temp, input);
            assertEquals("((x/3.0)/2.0)", input.toString());
            double result = Tree_config.eval(binding, temp);
            assertEquals(2.5,result);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Test
    void test3_2()
    {
        Map<String, Integer> binding = new HashMap<>();
        binding.put("x",5);

        try
        {
            StringBuilder input = new StringBuilder();

            Node temp = test.working("1+2+3+4+x+6+7+8+9+10");
            Tree_config.prettyPrint(temp, input);
            assertEquals("(((((((((1.0+2.0)+3.0)+4.0)+x)+6.0)+7.0)+8.0)+9.0)+10.0)", input.toString());
            double result = Tree_config.eval(binding, temp);
            assertEquals(55.0,result);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Test
    void test3_3()
    {
        Map<String, Integer> binding = new HashMap<>();
        binding.put("x",5);

        try
        {
            StringBuilder input = new StringBuilder();

            Node temp = test.working("1*2*3*4*x*6*7*8*9*10");
            Tree_config.prettyPrint(temp, input);
            assertEquals("(((((((((1.0*2.0)*3.0)*4.0)*x)*6.0)*7.0)*8.0)*9.0)*10.0)", input.toString());
            double result = Tree_config.eval(binding, temp);
            assertEquals(3628800.0,result);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Test
    void test3_4()
    {
        Map<String, Integer> binding = new HashMap<>();
        binding.put("x",5);

        try
        {
            StringBuilder input = new StringBuilder();

            Node temp = test.working("367894%9000%100");
            Tree_config.prettyPrint(temp, input);
            assertEquals("((367894.0%9000.0)%100.0)", input.toString());
            double result = Tree_config.eval(binding, temp);
            assertEquals(94,result);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Test
    void test3_5() {
        Map<String, Integer> binding = new HashMap<>();
        binding.put("x", 5);

        try {
            StringBuilder input = new StringBuilder();

            Node temp = test.working("468521-584-7984-16-849");
            Tree_config.prettyPrint(temp, input);
            assertEquals("((((468521.0-584.0)-7984.0)-16.0)-849.0)", input.toString());
            double result = Tree_config.eval(binding, temp);
            assertEquals(459088, result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void test4_1() {
        Map<String, Integer> binding = new HashMap<>();
        binding.put("x", 5);

        try {
            StringBuilder input = new StringBuilder();

            Node temp = test.working("7    %2+(   1+5*\n2)-8");
            Tree_config.prettyPrint(temp, input);
            assertEquals("(((7.0%2.0)+(1.0+(5.0*2.0)))-8.0)", input.toString());
            double result = Tree_config.eval(binding, temp);
            assertEquals(4, result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void test4_2() {
        Map<String, Integer> binding = new HashMap<>();
        binding.put("x", 5);

        try {
            StringBuilder input = new StringBuilder();

            Node temp = test.working("4984649844-x*x/4949894+856%10");
            Tree_config.prettyPrint(temp, input);
            assertEquals("((4.984649844E9-((x*x)/4949894.0))+(856.0%10.0))", input.toString());
            double result = Tree_config.eval(binding, temp);
            assertEquals(4.984649849999995E9, result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void test4_3() {
        Map<String, Integer> binding = new HashMap<>();
        binding.put("x", 5);

        try {
            StringBuilder input = new StringBuilder();

            Node temp = test.working("x*x-x%x*x*x%x/2/(x-x-7)");
            Tree_config.prettyPrint(temp, input);
            assertEquals("((x*x)-((((((x%x)*x)*x)%x)/2.0)/((x-x)-7.0)))", input.toString());
            double result = Tree_config.eval(binding, temp);
            assertEquals(25.0, result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void test5_1()
    {
        Map<String, Integer> binding = new HashMap<>();
        binding.put("x", 5864);

        try {
            StringBuilder input = new StringBuilder();

            Node temp = test.working("(x)");
            Tree_config.prettyPrint(temp, input);
            assertEquals("x", input.toString());
            double result = Tree_config.eval(binding, temp);
            assertEquals(5864.0, result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void test5_2()
    {
        assertThrows
                (
                        SyntaxError.class, ()->
                        {
                            Node temp = test.working("(xxx)");
                        }
                );
    }

    @Test
    void test5_3()
    {
        assertThrows
                (
                        SyntaxError.class, ()->
                        {
                            Node temp = test.working("++");
                        }
                );
        assertThrows
                (
                        SyntaxError.class, ()->
                        {
                            Node temp = test.working("----");
                        }
                );
        assertThrows
                (
                        SyntaxError.class, ()->
                        {
                            Node temp = test.working("****");
                        }
                );
        assertThrows
                (
                        SyntaxError.class, ()->
                        {
                            Node temp = test.working("////");
                        }
                );
        assertThrows
                (
                        SyntaxError.class, ()->
                        {
                            Node temp = test.working("%%%%");
                        }
                );
        assertThrows
                (
                        SyntaxError.class, ()->
                        {
                            Node temp = test.working("1+f;askjk;f");
                        }
                );
        assertThrows
                (
                        SyntaxError.class, ()->
                        {
                            Node temp = test.working("(1+5+7+8+8)))");
                        }
                );
    }

    @Test
    void test5_4()
    {
        Map<String , Integer> binding = new HashMap<>();

        assertThrows
                (
                        EvalError.class, ()->
                        {
                            Node temp = test.working("(x)");
                            Tree_config.eval(binding, temp);
                        }
                );

        assertThrows
                (
                        EvalError.class, ()->
                        {
                            Node temp = test.working("(x/0)");
                            Tree_config.eval(binding, temp);
                        }
                );
        assertThrows
                (
                        EvalError.class, ()->
                        {
                            Node temp = test.working("(x/(849754*0))");
                            Tree_config.eval(binding, temp);
                        }
                );
    }
}