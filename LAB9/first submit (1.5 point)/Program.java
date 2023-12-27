import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Program 
{
    // private:
        private void read_file(String file_name)
        {
            File open = null;
            Scanner read = null;
            try
            {
                open = new File(file_name);
                read = new Scanner(open);
                int line = 1;

                if(read.hasNextLine())
                {
                    while (read.hasNextLine())
                    {
                        System.out.println("Line "+line++);
                        analys(read.nextLine());
                    } 
                    System.out.println();
                }
                else System.out.println("\nEmpty file!!!\n");
            }
            catch(FileNotFoundException e)
            {
                System.out.println("\nFile not found!!!\n");
            }
            finally
            {
                if(read != null) read.close();
            }
        }

        private void analys(String input)
        {
            if(input.isBlank())
            {
                System.out.println("Empty string!!!\n");
                return ;
            }

            int size = input.length();

            double result;

            boolean find_int = false,
            operator_allow = false,
            first_find = true;

            // Stack<Integer> stack_int = new Stack<>();
            // Stack<Character> stack_char = new Stack<>();
            Queue<Double> data_int = new LinkedList<>();
            Queue<Character> data_ope = new LinkedList<>();

            LinkedList<Character> operator = new LinkedList<>();
            operator.add('+'); operator.add('/'); operator.add('*'); operator.add('%');

            LinkedList<Character> num = new LinkedList<>();
            for(int i = 48; i < 58; i++) num.add((char) i);

            String number = "";

            Exception e = new Exception("Invalid value");

            try 
            {
                for(int i = 0; i<size; i++)
                {
                    char temp = input.charAt(i);

                    if(first_find)
                    {
                        if(temp == ' ') continue;

                        if(first_find && temp == '-') 
                        {
                            first_find = false;
                            find_int = true;
                            number += '-';
                            continue;
                        }

                        if(operator.contains(temp) && first_find) throw e;

                        if(num.contains(temp))
                        {
                            first_find = false;
                            find_int = true;
                            operator_allow = true;
                        }
                        else throw e;
                    }

                    if(find_int)
                    {
                        if(temp == ' ')
                        {
                            if(!number.equals("") && number.equals("-"))
                            {
                                data_int.add(Double.parseDouble(number));
                                number = "";
                                find_int = false;
                                operator_allow = true;
                            }

                            continue;
                        }

                        if(operator.contains(temp))
                        {
                            if(operator_allow)
                            {
                                data_int.add(Double.parseDouble(number));
                                data_ope.add(temp);
                                number = "";
                                operator_allow = false;
                                continue;
                            }
                            else throw e;
                        }

                        if(temp == '-')
                        {
                            if(number.equals("-")) number = "";
                            else if(number.equals("")) number += '-';
                            else
                            {
                                data_int.add(Double.parseDouble(number));
                                number = "-";
                                data_ope.add('+');
                            }
                            continue;
                        }

                        if(num.contains(temp))
                        {
                            number += temp;
                            operator_allow = true;
                            continue;
                        }
                        else throw e;

                    }
                    else
                    {
                        if(operator.contains(temp))
                        {
                            data_ope.add(temp);
                            find_int = true;
                        }
                        else if(temp == '-')
                        {
                            number += temp;
                        }
                        else throw e;

                        operator_allow = false;
                    }
                }

                if(number != "")
                {
                    data_int.add(Double.parseDouble(number));
                    number = "";
                }

                System.out.printf("Your ans is %f\n",cal(data_ope, data_int));
            } 
            catch (Exception e_get) 
            {
                System.out.println(e_get);
            }
        }

        private double cal(Queue<Character> ope, Queue<Double> num)
        {
            Double ans = null;

            if(ope.isEmpty())
            {
                if(num.isEmpty()) return 0;
                else
                {
                    System.out.println("something worng");
                    return -404.000;
                }
            }
            else
            {
                ans = num.poll();

                while(!ope.isEmpty())
                {
                    char operator = ope.poll();
                    double temp = num.poll();

                    switch (operator) {
                        case '+' -> ans += temp;
                        case '*' -> ans *= temp;
                        case '/' ->
                        {
                            try 
                            {
                                if(temp == 0) throw new Exception("Something worng with this infinity (something/0)");
                                else
                                {
                                    ans /= temp;
                                }
                            }
                            catch (Exception e) 
                            {
                                System.out.println(e);
                                ans = -404.00; //not found
                                break;
                            }
                        }
                        case '%' -> ans %= temp;
                        default -> {}
                    }
                }

                return ans;
            }
        }
    
    private void start()
    {
        Scanner input = new Scanner(System.in);

        boolean running = true;

        while (running) 
        {
            System.out.println
            (
                "(1) Empty file\n"+
                "(2) not_blank\n"+
                "(3) with blank\n"+
                "(4) error\n"+
                "(5) case File not found\n"+
                "(6) exit\n"+
                "Yout input : "
            );
            int i = 0;
            if(input.hasNextInt()) i = input.nextInt();

            switch (i) {
                case 1 -> read_file("Empty_file.txt");
                case 2 -> read_file("not_blank.txt");
                case 3 -> read_file("with_blank.txt");
                case 4 -> read_file("Error.txt");
                case 5 -> read_file("nothing.txt");
                case 6 -> running = false;
                default -> System.out.println("\nInvalid Input\n");
            }
            input.nextLine();
        }
    }

    //public:
        public Program()
        {
            start();
        }    
}
