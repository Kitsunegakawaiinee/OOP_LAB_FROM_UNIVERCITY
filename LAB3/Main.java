import java.util.Scanner;

class Main 
{
    static private Character mc;
    static private Scanner getString = new Scanner(System.in);

    private static String check()
    {
        String get = getString.nextLine();
        if(get.equals("y") || get.equals("Y")) return "y";
        else if (get.equals("n") || get.equals("N")) return "n";
        else
        {
            System.out.println("y/n only");
            return null;
        }
    }

    private static Sword crate_sword()
    {
        String input = null;

        while (input == null) 
        {
            System.out.println("\n\nDo you have sword? (y/n)");
            input = check();    
        }

        if(input.equals("y"))
        {
            float ATK = 5;
            String name;
            int lv = 1;

            System.out.println("You sword name : ");
            name = getString.nextLine();
            if(name.isEmpty() || name.isBlank()) name = null;

            System.out.println("How about LV? :");
            if(getString.hasNextInt()) lv = getString.nextInt();
            else System.out.println("I see LV 1");
            getString.nextLine();

            System.out.println("Base ATK : ");
            if(getString.hasNextFloat()) ATK = getString.nextFloat();
            else System.out.println("I change your ATK to 5\n");
            getString.nextLine();

            return new Sword(name, ATK, lv);
        }
        
        return null;
    }

    private static Shield create_shield()
    {
        String input = null;
        while (input == null) 
        {
            System.out.println("\n\nDo you have sheild? (y/n)");
            input = check();
        }

        if(input.equals("y"))
        {
            float defend = 10;
            String name;
            int lv = 1;

            System.out.println("You sheild name : ");
            name = getString.nextLine();

            if(name.isEmpty() || name.isBlank()) name = null;

            System.out.println("How about LV? :");
            if(getString.hasNextInt()) lv = getString.nextInt();
            else System.out.println("I see LV 1");
            getString.nextLine();

            System.out.println("Base defend : ");
            if(getString.hasNextFloat()) defend = getString.nextFloat();
            else System.out.println("I change your defend to 10\n");
            getString.nextLine();

            return new Shield(name, defend, lv);
        }
        
        return null;
    }

    private static void working()
    {
        System.out.println(mc);

        boolean running = true;



        while (running) 
        {
            int input = 0;
            System.out.println("\nWhat do you want to do?");
            System.out.println("Check status(1)\nTake off your equipment(2)\nChange your equipment(3)\nattack(4)\nUpgrade equipment(5)\nLV up!!(6)\nexit(7)\nDo nothing(else)");
            
            if(getString.hasNextInt()) input =getString.nextInt();
            getString.nextLine();

            switch (input) 
            {
                case 1 -> System.out.println(mc);
                case 2 -> 
                {
                    System.out.println("\nTake off\nSword(1)\nSheild(2)\ndo nothing(else)\n");

                    if(getString.hasNextInt()) mc.unequipment(getString.nextInt()); 
                }
                case 4 -> mc.attack();
                case 3 -> 
                {
                    int input2 = 0;
                    System.out.println("\nChange\nSword(1)\nSheild(2)\ndo nothing(else)\n");

                    if(getString.hasNextInt()) input2 = getString.nextInt();
                    getString.nextLine();

                    switch (input2) 
                    {
                        case 1 -> mc.change_equipment(crate_sword());
                        case 2 -> mc.change_equipment(create_shield());
                        default -> System.out.println("\ndo nothing\n");
                    }
                }
                case 5 ->
                {
                    int input2 = 0;
                    System.out.println("\nUpgrade\nSword(1)\nSheild(2)\ndo nothing(else)\n");

                    if(getString.hasNextInt()) input2 = getString.nextInt();
                    getString.nextLine();

                    switch (input2) 
                    {
                        case 1 -> mc.equipment_upgrade(input2);
                        case 2 -> mc.equipment_upgrade(input2);
                        default -> System.out.println("\ndo nothing\n");
                    }
                }
                case 6 -> mc.level_up();
                case 7 -> 
                {
                    System.out.println("\nExit\n");
                    running = false;
                }
                default -> System.out.println("\nDo nothing\n");
            }
        }
    }

    public static void main(String[] args) 
    {
        String name;
        Sword weapon;
        Shield armor;

        System.out.println("Name of your character : ");
        name = getString.nextLine();
        if(name.isEmpty() || name.isBlank()) name = null;

        weapon = crate_sword();
        armor = create_shield();
        mc = new Character(weapon, armor, name);

        working();
        getString.close();
    }    
}
