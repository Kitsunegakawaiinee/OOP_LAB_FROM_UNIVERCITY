import java.util.Random;

public class Enemy_class extends Character
{
    Enemy_class(String[] info, int lv, boolean have_wing,  Accessory[] equipment, Weapon[] weapon_have, float[] stat, String[] word, Item[] inventory)
    {
        super(info, lv, have_wing, equipment, weapon_have, stat, word,inventory);
    }

    private int current_dialog = 0;

    @Override
    public void listen(int dialog_index, Character target)
    {
        current_dialog  = dialog_index;
        talk(target);

    }

    @Override
    public void talk(Character target) 
    {
        System.out.print("Monika : ");

        if(current_dialog <= 9)
        {
            System.out.println(word[0]+'\n');
            target.listen(0, target);
        }
        else
        {
            System.out.println(word[1]+'\n');
            target.listen(1, target);
        }
    }

    private float love_effect(float dmg)
    {
        return (float) (dmg/1000000);
    }

    @Override
    public void attack(Character target) 
    {
        Random rand = new Random();
        
        int i = rand.nextInt(2);

        if(super.stat2[1] > 0)
        {
            if(i == 0)
            {
                target.be_attack(normal_attack());
                stat2[1] -= 14;
            } 
            else
            {
                target.be_attack(skill());
                stat2[1] -= 27;
            } 
        }
        else System.out.printf("\n%s out of mana\n\n", super.return_name());
    }

    @Override
    public float skill() 
    {
        float dmg = weapon.skill(stat2[2]);
        return love_effect(dmg);
    }

    public float normal_attack() 
    {
        float dmg = (weapon.return_atk() + stat2[2]);
        return  love_effect(dmg);
    }

    public boolean is_lost()
    {
        System.out.println("She can't lost in this game\n");
        
        return false;
    }
}
