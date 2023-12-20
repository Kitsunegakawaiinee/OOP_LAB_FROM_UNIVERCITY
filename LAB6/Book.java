import java.util.Scanner;

public class Book extends Weapon
{
    Scanner get = new Scanner(System.in);

    Book()
    {
        super("Mom's dark magic book", 54050.0f);
    }

    private String[] skill_name =
    {
        "Dark fire ball",
        "Voodoo doll",
        "Abyss monster fang",
        "Your power is nearby people's life"
    };

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
        //     case 0 -> return atk * 1.4;
        //     case 1 -> return atk * 2.6;
        //     case 2 -> return atk * 3.2;
        //     case 3 -> System.out.println("\nFollow the story, you can't be used this skill.\n");
        //     default -> System.out.println("\nDo nothing\n");
        // }

        if(choose == 0) return (float) (dmg * 1.4);
        else if(choose == 1) return (float) (dmg * 2.6);
        else if(choose == 2) return (float) (dmg * 3.2);
        else if(choose == 3) System.out.println("\nFollow the story, you can't be used this skill.\n");
        else System.out.println("\nDo nothing\n");

        get.nextLine();

        return 0;
    }
}
