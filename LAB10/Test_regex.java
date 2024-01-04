import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test_regex 
{
    // private static String regex = "\\s*-*\\d*\\s*(((\\+|\\*|-)\\s*\\-*\\d+\\s*))*\\s*$";
    private static String start = "(\\s*(-*|\\+*)\\d+\\s*)",
    allow_zoro = "((\\*|\\++|-+)\\s*(\\+*|-*)\\d+\\s*)",
    no_zero = "((/|%)\\s*(\\+*|-*)\\d+\\s*)";
    private static String regex = start + "(" + allow_zoro + "|" + no_zero +")*";

    private static boolean test_pattern(String input)
    {
        Pattern check = Pattern.compile(regex);
        Matcher for_return = check.matcher(input);
        return for_return.matches();
    }

    private static String[] read_file(String path)
    {
        try
        {
            File open = new File(path);
            Scanner input = new Scanner(open);
            ArrayList<String> array_temp = new ArrayList<>();

            while (input.hasNextLine()) array_temp.add(input.nextLine());

            String[] for_return = new String[array_temp.size()];
            int i = 0;
            for(String item: array_temp) for_return[i++] = item;
            return for_return;
            
        } catch (FileNotFoundException e) 
        {
            System.out.println("file not found");    
            return null;
        }
    }

    public static void main(String[] args) 
    {
        String[] file_name = {"..\\test_first.txt","..\\test_allow_zero.txt","..\\test_no_zero.txt","..\\test_all.txt"};
        // int index = File_name.TEST_FIRST.ordinal();
        int index = 0;
        // index = File_name.TEST_FIRST.ordinal();
        // index = File_name.TEST_ALLOW_ZERO.ordinal();
        // index = File_name.TEST_NO_ZERO.ordinal();
        index = File_name.TEST_ALL.ordinal();
        String[] test = read_file(file_name[index]);
        
        if(test!=null)
        {
            int line = 1;
            for(String i: test) System.out.printf("Line %d\nPattern is %b for \"%s\"\n",line++,test_pattern(i),i);
        }
    }

    public static enum File_name
    {
        TEST_FIRST,
        TEST_ALLOW_ZERO,
        TEST_NO_ZERO,
        TEST_ALL
    };
}
