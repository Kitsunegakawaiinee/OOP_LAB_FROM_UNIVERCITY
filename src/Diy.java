import java.util.Scanner;

public class Diy extends AirPurifier
{
    Diy(String model)
    {
        super(model, "not have serial number");
    }

    @Override
    protected void status()
    {
        clear_terminal();
        System.out.println("Status\nFan speed: HIGH\n");
    }

    @Override
    protected void working()
    {
        Scanner input_diy = new Scanner(System.in);
        boolean check_input = false;
        System.out.println("Now your Air Purifier is working");

        while (!check_input)
        {
            System.out.println("what should you do: \nUnplug(1), turn off (2), Do nothing (else)");
            int result = 0;
            if(input_diy.hasNextInt()) result = input_diy.nextInt();
            switch (result)
            {
                case 1 -> {close(); check_input = true; power_set(false);}
                case 2 -> {close(); check_input = true;}
                default -> doNothing();
            }

            input_diy.nextLine();
        }
    }
}
