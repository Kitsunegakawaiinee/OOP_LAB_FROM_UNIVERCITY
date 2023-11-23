class Main
{
    public static void print_array()
    {
        Program open = new Program();

        int[] arr = open.for_return_arr();

        System.out.print("Result is : ");

        for(int i: arr) System.out.print(i+" ");
        System.out.println();
    }

    public static void main(String[] args)
    {
        print_array();
    }
}