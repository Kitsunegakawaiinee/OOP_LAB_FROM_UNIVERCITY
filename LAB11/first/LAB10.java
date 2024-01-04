import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class LAB10 
{
    private static String remove_space(String input)
    {
        return input.replaceAll("\\s","");
    }
    private static String[] text(String path)
    {
        LinkedList<String> temp = new LinkedList<>();
        Scanner reader = null;
        String[] for_return;

        try 
        {
            File open = new File(path);
            reader = new Scanner(open);

            while (reader.hasNextLine()) 
            {
                temp.add(reader.nextLine());
            }

            for_return = new String[temp.size()];

            for_return = temp.toArray(for_return);
            return for_return;
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("\n"+e+"\n");
            System.out.println("exit\n");
            System.exit(0);
        }
        finally
        {
            if(reader != null) reader.close();
        }

        return null;
    }

    private static void print_result(String text, Program test)
    {
        try 
        {
            System.out.println("Input is "+text);
            System.out.print("Result = ");
            System.out.println(test.working(text));
        } 
        catch (Exception e)//(SyntaxError e) 
        {
            System.out.println("Error, bro");
            System.out.println("Error : "+e.getMessage());
        }

        System.out.println();
    }
    public static void main(String[] args) 
    {
        Scanner get = new Scanner(System.in);
        Program test = new Program();

        String input = "",path = null;
        String[] test_case = null;

        System.out.println("Choose your test case");
        System.out.print("(1) one pare\n(2) pon\n(3) multiple operator\n(4) recursive\n(5) error\n");

        input = get.nextLine();

        //path inpend on the complier you choose
        if(input.equals("1")) path = "../test_case/one_pare.txt";
        else if(input.equals("2")) path = "../test_case/pon_case.txt";
        else if(input.equals("3")) path = "../test_case\\multiple_ope.txt";
        else if(input.equals("4")) path = "../test_case/zoom.txt";
        else if(input.equals("5")) path = "../test_case/error.txt";
        else
        {
            System.out.println("exit");
            get.close();
            return ;
        }

        if(path != null) test_case = text(path);

        System.out.println();
        if(test_case != null)
            for(String i: test_case) print_result(remove_space(i), test);
        else System.out.println("Empty file");
        System.out.println();

        get.close();
        
        // //debug
        // print_result("8*1-1-1", test);
        // get.close();
        
    }    
}