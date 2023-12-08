import java.util.Scanner;

public class Katana extends Weapon
{
    private Scanner get = new Scanner(System.in);

    private String[] skill_name = 
    {
        "Slat",
        "Fast as lightning",
        "Transform into a dragon"
    };

    Katana()
    {
        super("Katana from my Father? or Mama?",72200.0f);
    }

    @Override
    public float skill(float atk) 
    {
        float dmg = super.return_atk() + atk;
        int choose = -1;

        System.out.println("\nChoose your skill");
        
        int size = skill_name.length;

        for(int i = 0; i< size; i++) System.out.printf("%s (%d)\n",skill_name[i],i);
        System.out.println("Do nothing (else)\n");
        
        if(get.hasNextInt()) choose = get.nextInt();

        // switch (choose) {
        //     case 0 -> return atk * 0.5;
        //     case 1 -> return atk * 1.8;
        //     case 2 -> System.out.println("\nThis skill cannot be used now.\n");
        //     default -> System.out.println("\nDo nothing\n");
        // }
        if(choose == 0) return (float) (dmg * 0.5);
        else if(choose == 1) return (float) (dmg * 1.8);
        else if(choose == 2) System.out.println("\nThis skill cannot be used now.\n");
        else System.out.println("\nDo nothing\n");

        get.nextLine();

        return 0;
    }
}
