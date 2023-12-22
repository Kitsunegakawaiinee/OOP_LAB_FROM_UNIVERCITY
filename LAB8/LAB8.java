import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import javax.management.openmbean.InvalidOpenTypeException;

public class LAB8 
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

    private void print_set(String name, Collection set)
    {
        System.out.println(name);
        for(Object i: set) System.out.print(i + " ");
        System.out.println();
    }

    private void equal_test()
    {
        Scanner cin = new Scanner(System.in);

        int num;
        System.out.print("Your input : ");
        if(cin.hasNextInt()) num = cin.nextInt();
        else
        {
            throw new InvalidParameterException("Int only");
        }


        MySet<Integer> set1 = create_set(num);
        MySet<Integer> set2 = create_set(num);

        //random eqaul/not equal
        print_set("set 1", set1);
        print_set("set 2", set2);
        System.out.printf("set1 equal = %b and set2 equal = %b\n",set1.equals(set2), set2.equals(set1));
        System.out.println();

        //equal case
        System.out.println("equal case same adress");
        set2 = set1;
        print_set("set2", set2);
        System.out.printf("set1 equal = %b and set2 equal = %b\n",set1.equals(set2), set2.equals(set1));
        System.out.println();
        

        System.out.println("same element");
        set1 = create_set(num);
        set2 = new MySet<>();
        //add all already broken after edit
        for(int i: set1) set2.add(i);
        print_set("set 1", set1);
        print_set("set 2", set2);
        System.out.printf("set1 equal = %b and set2 equal = %b\n",set1.equals(set2), set2.equals(set1));
        System.out.println();

        int[] i1 = {1,3,5,7};
        int[] i2 = {7,1,5,3};
        set1 = new MySet<>();
        set2 = new MySet<>();

        for(int i = 0; i<4; i++) set1.add(i1[i]);
        for(int i = 0; i<4; i++) set2.add(i2[i]);
        print_set("set 1", set1);
        print_set("set 2", set2);
        System.out.printf("set1 equal = %b and set2 equal = %b\n",set1.equals(set2), set2.equals(set1));
        System.out.println();
    }

    public void test_hashcode(int num)
    {
        MySet<Integer> set1 = create_set(num);
        MySet<Integer> set2 = create_set(num);

        System.out.println("fisrt time");
        System.out.println("hash set 1 = "+set1.hashCode());
        System.out.println("hash set 2 = "+set2.hashCode());
        System.out.println();
    }

    private void string_compare()
    {
        String_compare compare = new String_compare();

        String[] string1 = {"Hello","World"};
        System.out.println("case 1");
        System.out.printf("string 0 is %s string 2 is %s\nstring compare is %d\n",string1[0],string1[1],compare.compare(string1[0], string1[1]));
        System.out.println();

        String[] string2 = {"World","Hello"};
        System.out.println("case 2");
        System.out.printf("string 0 is %s string 2 is %s\nstring compare is %d\n",string2[0],string2[1],compare.compare(string2[0], string2[1]));
        System.out.println();

        String[] string3 = {"Maneki","Neko"};
        System.out.println("case 3");
        System.out.printf("string 0 is %s string 2 is %s\nstring compare is %d\n",string3[0],string3[1],compare.compare(string3[0], string3[1]));
        System.out.println();

        String[] string4 = {"Neko","Maneki"};
        System.out.println("case 4");
        System.out.printf("string 0 is %s string 2 is %s\nstring compare is %d\n",string4[0],string4[1],compare.compare(string4[0], string4[1]));
        System.out.println();

        String[] string5 = {"HAHAHA", "hahaha"};
        System.out.println("case 5");
        System.out.printf("string 0 is %s string 2 is %s\nstring compare is %d\n",string5[0],string5[1],compare.compare(string5[0], string5[1]));
        System.out.println();

    }

    public static void main(String[] args) 
    {
        LAB8 test = new LAB8();

        //un comment before test
        //equal test
        // test.equal_test();

        //string
        // test.string_compare();
    }    
}
