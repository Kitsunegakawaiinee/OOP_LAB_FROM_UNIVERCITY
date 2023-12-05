import java.util.Scanner;

public class Main_Character extends Character
{
    Main_Character(String[] info, int lv, boolean have_wing,  Accessory[] equipment, Weapon[] weapon_have, float[] stat, String[] word, Item[] inventory)
    {
        super(info, lv, have_wing, equipment, weapon_have, stat, word, inventory);
    }

    private int word_index = 0;

    @Override
    public void talk(Character target) 
    {
        if(word_index <= 10)
        {
            System.out.print("\nSelena : ");
            System.out.println(super.word[word_index]);
            target.listen(word_index++, this);
        }
    }

    @Override
    public void listen(int dialog_index, Character target) 
    {
        if(dialog_index == 1)
        {
            System.out.print("Selena : ");
            System.out.println(word[11]+"\n\n");
            Game.end();
        }
    }

    @Override
    public float normal_attack() 
    {
        System.out.println("\nI can't hit her, not this time\n");
        return 0;    
    }

    @Override
    public float skill() {
        float dmg = weapon.skill(stat2[2]);
        
        if(dmg != 0) System.out.println("\nSerena didn't want to attack Monika, so she did nothing.\n");

        return 0;
    }

    public void attack(Character target) 
    {
        Scanner get = new Scanner(System.in);
        
        int input = -1;

        System.out.println("\nChoose your skill\nnormal attack(0) \nskill(1)\ndo nothing(else)\n");
        
        if(get.hasNextInt()) input = get.nextInt();

        if(input == 0) target.be_attack(normal_attack());
        else target.be_attack(skill());
    }

    @Override
    public boolean is_lost() {
        return (stat2[0] < 0);
    }
}
