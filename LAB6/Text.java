import java.util.Scanner;

/**
 * Class for store data od enemy and main character
 */
public class Text
{
    //character
    private String[] mc_info = 
    {
        "Serena",
        "Archer Hero",
        "Human?",
        "Despite being one of the four heroes in this world, she was one of \nthe evil leaders in the world she originated from."
    };

    private String[] mc_dialog =
    {
        "Mo... Monika",
        "Monika, can you hear me?",
        "Monika, I know you there.",
        "Monika, hypnosis magic is once your best magic, isn't it",
        "If it were you, I believe you would definitely hear me. So I'll call you until you hear me.",
        "I know, it is not you. I know you are controlled by the Devil King.",
        "My princess, I know you are sleeping there. Please wake up. Please come back. Please, Don't leave me like this.",
        "Monika, You are still fighting, right?\n"+
        "Want to break free from bondage but you can't, right?\n"+
        "You are suffering, right?",
        "The necklace on your neck is controlling you, right?"+
        "Just tell me you want some help, and I will hold everything on my own.",
        "If it were you who knew me best Killing me wouldn't be difficult for you.",
        "I will forgive you for everything, so please wake up.",
        //0-11
        "Yes, Nika-chan."
    };

    private int mc_lv = 67; 

    private boolean mc_wing = false;

    private float[] mc_stat = {124758.0f, 760.0f, 450.0f, 0.0f};

    private Weapon[] mc_have = new Weapon[]{new Katana(), new Book()}; 

    private Accessory[] mc_eq = 
    {
        new Accessory(new String[]{"Shirt", "armor"}, new float[]{360.0f,0.0f,0.0f,4587.7f}),
        new Accessory(new String[]{"Short", "armor pants"}, new float[] {0.0f, 0.0f, 0.0f, 0.0f}),
        null,
        null,
        new Accessory(new String[]{"Wedding ring", "ring"}, new float[] {0.0f, 0.0f, 0.0f, 0.0f}),
        null,
        new Accessory(new String[]{"Normal shoe", "shoe"}, new float[] {0.0f, 0.0f, 0.0f, 0.0f})    
    };

    //enemy
    private String[] enemy_info = 
    {
        "Monika",
        "The evil leader from another world?",
        "Succubus",
        "She has lived with Selena since she was a child.\nAlthough she is stubborn with Serena, she loves Serena more than anyone else in her world.\nbut now she was controlled by the evil king in this world."
    };

    private String[] enemy_word = 
    {
        "...",
        "Serena Onee-chan, please help me."

    };

    private boolean enemy_wing = true;

    private int enemy_lv = 765;

    private float[] enemy_stat = {1700000.0f, 80000.0f, 387500.0f, 0.0f};

    private Weapon[] enemy_have = {new Viper_sword()};

    private Accessory[] enemy_eq = 
    {
        new Accessory(new String[]{"Strapless", "armor"}, new float[]{360.0f,0.0f,0.0f,4587.7f}),
        new Accessory(new String[]{"Short", "armor pants"}, new float[] {0.0f, 0.0f, 0.0f, 0.0f}),
        null,
        new Accessory(new String[]{"Curse Necklace", "necklace"}, new float[] {0.0f, 0.0f, 0.0f, 0.0f}),
        new Accessory(new String[]{"Wedding ring", "ring"}, new float[] {0.0f, 0.0f, 0.0f, 0.0f}),
        null,
        new Accessory(new String[]{"Normal shoe", "shoe"}, new float[] {0.0f, 0.0f, 0.0f, 0.0f})    
    };

    Item mana_potion = new Item("Mana Potion", new float[]{0.0f, 120.0f});
    Item healing_potion = new Item("Healing Potion", new float[]{20000.0f,0.0f});


    //story
    private String[] story =
        { 
            "\nThis story is based on my Yuri Fiction that I wish I could publish to the world wild on somedays.\n\n",
            "Monika appeared on the battlefield of 4 Hero and Devil King's army.",
            "I already knew that, so I prepared for today, prepared to bring her back with me.\n\n",
            "Now, I am standing on the ground in front of her flying in the sky.\n\n"
        };

    /**
     * For print the story that store in Text class
     */
    private void print_story()
    {
        for(String i: story)
        {
            try
            {
                Game.typping_effect(i);
                Thread.sleep(700);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * check if user skip the story?
     */
    public void skip_or_not()
    {
        String input = null;
        Scanner get = new Scanner(System.in);

        System.out.println("\nDo you want to skip story? (y/n)\n");

        while(true)
        {
            input = get.nextLine();

            if(input.equals("n") || input.equals("N"))
            {
                print_story();
                break;
            }
            else if (input.equals("y") || input.equals("Y"))
            {
                System.out.println("\nOK\n");
                break;
            }
            else System.out.println("\n(y/n) only\n");
        }
    }

    // getter
    
    //0 MC
    //1 Enemy

    /**
     * getter of character info and dialog
     * @param choose 0 info 1 dialog
     * @param who 0 mc 1 enemy
     * @return info or dialog of character
     */
    public String[] return_info_or_dialog(int choose, int who)
    {
        return (choose == 0)? ((who == 0)? mc_info: enemy_info): ((who == 0)? mc_dialog: enemy_word);
    }

    /**
     * getter of chacter lv
     * @param who 0 lv of mc 1 level 
     * @return lv of character (depend of character you choose)
     */
    public int return_lv(int who)
    {
        if(who != 0) return enemy_lv;
        else return mc_lv;
    }

    /**
     * check if character have wing?
     * @param who 0 mc 1 enemy
     * @return have_wing?
     */
    public boolean return_wing(int who)
    {
        if(who == 0) return mc_wing;
        else return enemy_wing;
    }

    /**
     * getter stat of character you choose
     * @param who 0 mc 1 enemy
     * @return stat that depend on character you choose
     */
    public float[] return_stat(int who)
    {
        if(who == 0) return mc_stat;
        else return enemy_stat;
    }

    /**
     * getter equipment the character you have
     * @param who 0 mc 1 enemy
     * @return equipment that the character have
     */
    public Accessory[] return_equipment(int who)
    {
        return (who == 0)? mc_eq: enemy_eq;
    }

    /**
     * getter weapon list the character have
     * @param who 0 mc 1 enemy
     * @return Array of weapon the character have
     */
    public Weapon[] weapon_have (int who)
    {
        return (who == 0)? mc_have: enemy_have;
    }

    /**
     * getter list of Item the character have
     * @return array of Item that the character have
     */
    public Item[] return_inventory()
    {
        for(int i = 0; i < 4; i++) mana_potion.have_the_same();
        for(int i = 0; i < 4; i++) healing_potion.have_the_same();
        Item[] inventory = new Item[]{mana_potion, healing_potion};
        
        return inventory;
    }
}

