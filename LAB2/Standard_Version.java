import java.util.Scanner;

public class Standard_Version extends AirPurifier
{
    private int dust_value = 0;

    private String fan_speed(int dust_value)
    {
        if(dust_value >= 80) return "HIGH";
        else if(dust_value >= 40) return "MEDIUM";
        else return "LOW";
    }

    private void feel_lot_of_dust()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("How many dust do you think now?");
        if(input.hasNextInt())
        {
            int check = input.nextInt();
            if(check >= 0)
            {
                dust_value = check;
                System.out.println("Current fan speed is : "+fan_speed(dust_value));
            }
            else System.out.println("Negative value?");
        } 
        else System.out.println("Int only, please");
    }

    public Standard_Version(String Model, String Serial_Number)
    {
        super(Model, Serial_Number);
    }

    @Override
    protected void status()
    {
        clear_terminal();
        System.out.println("\nStatus");
        System.out.println(about_me());
        System.out.println("Fan speed : "+fan_speed(dust_value)+'\n');
    }

    @Override
    protected void working()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello, I am Standard version");

        boolean stop = false;

        while (!stop)
        {
            System.out.println("what should you do: \nUnplug(1), turn off (2), I think there are a lot of dust here(3), Check my status (4), Do nothing (else)");

            int result = 0;
            if(input.hasNextInt()) result = input.nextInt();

            switch (result)
            {
                case 1 -> {close(); stop = true; power_set(false);}
                case 2 -> {close(); stop = true;}
                case 3 -> feel_lot_of_dust();
                case 4 -> status();
                default -> doNothing();
            }

            input.nextLine();
        }
    }

}
