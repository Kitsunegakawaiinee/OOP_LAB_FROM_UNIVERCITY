import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main 
{
    /**
     * create Myset<Integer> with random element
     * @param n number of element
     * @return Myset<Integer> with n element inside
     */
    MySet<Integer> create_set(int n)
    {
        MySet<Integer> for_return = new MySet<>();

        for(int i = 0; i < n; i++) for_return.add(new Random().nextInt(101));

        return for_return;
    }

    /**
     * create collection with random element
     * @param n number of element
     * @return Collection<Integer> with n element inside
     */
    private Collection<Integer> create_collection(int n)
    {
        Collection<Integer> for_return =  new LinkedList<>();

        for(int i = 0; i < n; i++) for_return.add(new Random().nextInt(101));

        return for_return;
    }

    /**
     * Test function size() isEmpty() clear() contains() and clear()
     * <p>effect: will print result to  console
     * @param num number of integer that will random and add to set
     */
    private void test_function(int num)
    {
        MySet<Integer> test = new MySet<Integer>();

        //check size and is empty before create set
        System.out.printf("size is %d and isEmpty = %b\n", test.size(), test.isEmpty());

        //check size after create set
        test = create_set(num);
        System.out.println("After call create set");
        System.out.printf("size is %d and isEmpty = %b\n", test.size(), test.isEmpty());
        for(int i: test) System.out.print(i + " ");
        System.out.println();

        //test contain function
        System.out.printf("contain 1 = %b\n", test.contains(1));
        System.out.printf("contain 196 = %b\n", test.contains(196));

        //test clear function
        System.out.println("After clear");
        test.clear();
        System.out.printf("size is %d and isEmpty = %b\n", test.size(), test.isEmpty());
        for(int i: test) System.out.print(i + " ");
    }

    /**
     * test add() function
     * <p>effect: will print result to  console
     * @param num number of integer that will random and add to set
     */
    private void test_add(int num)
    {
        MySet<Integer> test = new MySet<>();

       test = create_set(num);

        for(int i: test) System.out.print(i + " ");
        System.out.println();
    }

    /**
     * test add() with remove()
     * <p>effect: will print result to  console
     * @param num number of integer that will random and add to set
     */
    private void test_remove(int num)
    {
        MySet<Integer> test = new MySet<>();

        test = create_set(num);

        System.out.println("Before remove");
        for(int i: test) System.out.print(i + " ");
        System.out.println();

        int rm = new Random().nextInt(num);
        for(int i = 0; i < rm; i++)
        {
            int rm_value = new Random().nextInt(101);

            System.out.printf("remove %d status %b\n",rm_value, test.remove(rm_value));
        }
        System.out.println();

        System.out.println("After remove");
        for(int i: test) System.out.print(i + " ");
        System.out.println();

        for(int i = 0; i < 15; i++)
        {
            int value = new Random().nextInt(101);
            System.out.printf("add %d status %b\n", value, test.add(value));
        } 
        System.out.println("After add again");
        for(int i: test) System.out.print(i + " ");
    }

    /**
     * test containsAll() 
     * <p>effect: will print result to  console
     * @param num number of integer that will random and add to set
     */
    public void test_contain_all(int num)
    {
        Collection<Integer> inventory = create_collection(num);
        MySet<Integer> set = create_set(num);

        System.out.println("Collction");
        for(int i: inventory) System.out.print(i+" ");
        System.out.println();
        System.out.println("Myset");
        for(int i: set) System.out.print(i+" ");
        System.out.println();
        System.out.println("contain all = "+set.containsAll(inventory));
    }

    /**
     * test addAll() retainAll() removeAll() 
    * <p>effect: will print result to  console
     * @param num number of integer that will random and add to set and num/4 to collection
     */
    public void three_Function_with_all(int num)
    {
        MySet<Integer> set = create_set(num);
        Collection<Integer> collect = create_collection(num/4);

        System.out.println("Set");
        for(int i: set) System.out.print(i + " ");
        System.out.println();

        System.out.println("Collection");
        for(int i: collect) System.out.print(i + " ");
        System.out.println();

        System.out.println("Add all");
        set.addAll(collect);
        for(int i: set) System.out.print(i + " ");
        System.out.println();

        System.out.println("retain all");
        set.retainAll(collect);
        for(int i: set) System.out.print(i + " ");
        System.out.println();

        System.out.println("remove all");
        set.removeAll(collect);
        for(int i: set) System.out.print(i + " ");
        System.out.println();
    }


    public static void main_program() 
    {
        boolean not_ok = true;
        int num = 0;

        Scanner input = new Scanner(System.in);

        //loop until input is int
        while (not_ok) 
        {
            System.out.print("your input: ");

            if(input.hasNextInt()) 
            {
                num = input.nextInt();
                not_ok = false;
            }
            else System.out.println("Try again!!");
        }
        
        //remove comment when want to test

        //test 
        Main test = new Main();

        //test0
        // test.test_function(num);

        //test1
        // test.test_add(num);

        //test2
        // test.test_remove(num);

        // test3
        // test.test_contain_all(num);

        // test 4
        // test.three_Function_with_all(num);
    }
}