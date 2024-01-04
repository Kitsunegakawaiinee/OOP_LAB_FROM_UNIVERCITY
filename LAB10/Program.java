import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Program 
{
    private static Exception e = new Exception("Invalid input");
    //private:
        private static String remove_space(String input)
        {
            String for_return;

            for_return = input.replaceAll("\\s", "");
            for_return = for_return.replaceAll("\\s", "--");

            return for_return;
        }

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
                
            } 
            catch (FileNotFoundException e) 
            {
                System.out.println("file not found");    
                return null;
            }
        }

        private static void analys (LinkedList<Character> ope, LinkedList<Integer> num,String input)
        {
            boolean digit_only = true;

            LinkedList<Character> numeric = new LinkedList<>();
            for(int i = 48; i<=57; i++) numeric.add((char) i);

            int size = input.length();

            Integer minus_count = 0;
            boolean found_minus = false;

            String number = "";

            for(int i = 0; i<size; i++)
            {
                char temp = input.charAt(i);

                if(temp == '-')
                {
                    if(digit_only)
                    {
                        found_minus = true;
                        minus_count++;
                    }         
                    else
                    {
                        found_minus = true;
                        digit_only = true;
                        ope.add('+');
                        num.add(Integer.parseInt(number));
                        number = "";
                        minus_count++;
                    }
                    continue;
                }

                if(numeric.contains(temp))
                {
                    number = number + temp;
                    if(found_minus)
                    {
                        number = (minus_count%2 == 0)? number: "-"+number;
                        minus_count = 0;
                        found_minus = false;
                    }
                    digit_only = false;
                    continue;
                }

                if(temp == '+')
                {
                    if(!digit_only)
                    {
                        digit_only = true;
                        
                        num.add(Integer.parseInt(number));
                        number = "";
                        ope.add(temp);
                    }
                    continue; //case digit_only
                }

                if(temp == '*' || temp == '/' || temp == '%')
                {
                    digit_only = true;
                    num.add(Integer.parseInt(number));
                    number = "";
                    ope.add(temp);
                }
            }

            num.add(Integer.parseInt(number));
        }
    //public:
        // wait
        public static int cal(Queue<Character> ope, Queue<Integer> num)
        {
            int result = num.poll();
            int temp;
            Character operator;

            try
            {
                while(!ope.isEmpty())
                {
                    temp = num.poll();
                    operator = ope.poll();

                    switch (operator) 
                    {
                        case '+': result += temp; break;
                        case '-': result -= temp; break;
                        case '*': result *= temp; break;
                        case '/': 
                            if(temp == 0) throw e;
                            result /= temp; 
                            break;
                        case '%': 
                            if(temp == 0) throw e;
                            result %= temp; 
                            break;
                        default: break;
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
                return -404;
            }
            return result;
        }    

        public static int cal(String input)
        {
            int for_return = 0;
            
            LinkedList<Character> ope = new LinkedList<>();
            LinkedList<Integer> num = new LinkedList<>();

            input = remove_space(input);

            analys(ope, num, input);

            for_return = cal(ope, num);
            return for_return;
        }

         public static void main(String[] args)
         {
             Program test = new Program();
             String[] text = test.read_file("..\\test_all.txt");

             int line = 1;
             for(String i: text)
             {
                 System.out.printf("Line %d\ntext is %s\nresult is %d\n\n",line++,i,test.cal(i));
             }
         }
}


