import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    String[] read_file()
    {
        File file = new File("D:\\code\\my code\\java\\OOP_in_Univercity\\lab10-group42\\src\\test_all.txt"); //change this to your path to test
        try
        {
            Scanner input = new Scanner(file);
            ArrayList<String> temp = new ArrayList<>();
            while(input.hasNextLine()) temp.add(input.nextLine());

            int index = 0;
            String[] for_return = new String[temp.size()];
            for(String i: temp) for_return[index++] = i;
            return for_return;
        }
        catch(FileNotFoundException e)
        {
            System.out.println("file not found");
            return null;
        }
    }

    String[] test_case = read_file();

    @Test
    void test1()
    {
        assertEquals(55,Program.cal("1+2+3+4+5+6+7+8+9+10"));
    }

    @Test
    void test2()
    {
        assertEquals(-55, Program.cal("-10-9-8-7-6-5  -4-3 -2-1"));
    }

    @Test
    void test3()
    {
        assertEquals(3628800, Program.cal("10*9*8*7*6*5*4*3*2*1"));
    }

    @Test
    void test4()
    {
        assertEquals(1, Program.cal("1024/2/2/2/2/2/2/2/2/2/2"));
    }

    @Test
    void test5()
    {
        assertEquals(1, Program.cal("1987654321%100000000%100000000%1000000%100000%10000%1000%100%10"));
    }

    @Test
    void test6()
    {
        assertEquals(24,Program.cal(test_case[0]));
    }

    @Test
    void test7()
    {
        assertEquals(0,Program.cal(test_case[1]));
    }

    @Test
    void test8()
    {
        assertEquals(-50,Program.cal(test_case[2]));
    }

    @Test
    void test9()
    {
        assertEquals(0,Program.cal(test_case[3]));
    }

    @Test
    void test10()
    {
        assertEquals(-4,Program.cal(test_case[4]));
    }

    @Test
    void test11()
    {
        assertEquals(-21,Program.cal(test_case[5]));
    }

    @Test
    void test12()
    {
        assertEquals(5,Program.cal(test_case[6]));
    }

    @Test
    void test13()
    {
        assertEquals(0,Program.cal(test_case[7]));
    }

    @Test
    void test14()
    {
        assertEquals(0,Program.cal(test_case[8]));
    }

    @Test
    void test15()
    {
        assertEquals(-4662,Program.cal(test_case[9]));
    }

    @Test
    void test16()
    {
        assertEquals(-404,Program.cal(test_case[13]));
    }

    @Test
    void test17()
    {
        assertEquals(-404,Program.cal(test_case[14]));
    }
}