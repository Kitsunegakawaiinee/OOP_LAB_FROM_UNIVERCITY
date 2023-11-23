//import java.util.*;
import java.util.Scanner;
import java.util.Arrays;
public class Program
{
    protected int[] arr;

    Program()
    {
        Scanner input = new Scanner(System.in);

        //get size of array
        System.out.print("Array size : ");
        int size = input.nextInt();
        arr = new int[size];

        for(int i = 0; i < arr.length; i++) arr[i] = input.nextInt();

        input.close();

        sort();
    }

    private void sort()
    {
        Arrays.sort(arr);
    }

    public int[] for_return_arr()
    {
        return arr;
    }
}
