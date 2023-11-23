import java.util.Scanner;

class Main_in_use_class_var_and_method_ver
{
    static AirPurifier item;
    static Scanner input_all = new Scanner(System.in);

    public  static  String serial_number()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Give me a Serial number");
        String sn = input.nextLine();
        return sn;
    }
    public static boolean  choose()
    {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        int result = 0;

        System.out.println("choose your model\nStandard(1) Pro(2) DIY(3) Exit(else)");
        if(input.hasNextInt()) result = input.nextInt();

        switch (result)
        {
            case 1 -> {item = new Standard_Version("Standard Model",serial_number());}
            case 2 -> {item = new Pro_version("Pro Model",serial_number());}
            case 3 -> {item = new Diy("diy model");}
            default -> {System.out.println("Exit? Ok bye bye"); running = false;}
        }
        input.nextLine();

        return running;
    }

    static public void doing_something()
    {
        boolean working = true;
        while(working)
        {
            System.out.println("What do you want to do after got Air Purifier");

            boolean inputNotOk = true;
            while(inputNotOk)
            {
                System.out.println("plug it(1) kick(2) turn it on(3) leave it(4) do nothing(else)");
                Scanner input = new Scanner(System.in);
                int Result = 0;
                if(input.hasNextInt()) Result = input.nextInt();

                switch (Result)
                {
                    case 1 -> {item.check_plug(); inputNotOk = false;}
                    case 2 -> System.out.println("You doing this for what?");
                    case 3 -> {item.toggle_switch(); inputNotOk = false;}
                    case 4 -> {inputNotOk = false; working = false;}
                    default -> System.out.println("You do nothing");
                }

                input.nextLine();
            }
        }
    }

    public static void main(String[] args)
    {
        boolean running;

        do
        {
            running = choose();
            if(running) doing_something();
        }
        while(running);

        System.out.println("You choose AirPurifier "+AirPurifier.return_count()+" time");
        input_all.close();
    }
}