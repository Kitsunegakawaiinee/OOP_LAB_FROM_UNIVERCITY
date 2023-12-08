import java.util.Scanner;

abstract public class Character implements Character_interface
{
    protected float[] stat1;
    //0 Max_HP
    //1 Max_mana
    //2 base_atk

    protected float[] stat2;
    //0 current hp
    //1 currrent mana
    //2 atk after cal
    //3 def

    private boolean have_wing; //not have in lab4
    private boolean now_flying; 

    private int lv;

    private String[] info;
    //0 name
    //1 job
    //2 species 
    //3 profile

    private Accessory[] equipment;
    // 0 armor
    // 1 armor pants
    // 2 Veil
    // 3 necklace
    // 4 ring
    // 5 bangle
    // 6 shoe

    private Item[] inventory;

    protected Weapon weapon;
    private Weapon[] weapon_inventory;

    protected String[] word;

    //private:

        /**
         * this medthod use with use_item
         */
        private void use_item2(int size, int input)
        {
            if(input < 0 || input > size-1) System.out.println("\nInvalid input\n");
            else
            {
                inventory[input].use_item(stat1, stat2);
                
                if(inventory[input].return_count() == 0)
                {
                    if(size > 0)
                    {
                        Item[] new_inventory = new Item[size-1];
                        int new_index = 0;
                        for(int i = 0; i < size; i++)
                        {
                            if(i == input) continue;

                            new_inventory[new_index++] = inventory[i];
                        }
                        inventory = new_inventory;
                    }
                    else inventory = null;
                }
                
            }
        }

    // public:
        //wait
        public Character(String[] info, int lv, boolean have_wing,  Accessory[] equipment, Weapon[] weapon_have, float[] stat, String[] word, Item[] inventory)
        {
            this.info = info;
            this.lv = lv;
            this.have_wing = have_wing;
            this.equipment = equipment;
            weapon_inventory = weapon_have;
            weapon = weapon_have[0];
            this.inventory = inventory;

            stat1 = stat;

            stat2 = new float[4];

            this.word = word;

            if(equipment != null) 
            {
                for(Accessory i: equipment)
                {
                    if(i != null)i.equip(stat1, stat2);
                } 
            }

            stat2[0] = stat1[0];
            stat2[1] = stat1[1];
            stat2[2] = stat1[2] * lv;
        }

        abstract public float normal_attack();

        @Override
        public void be_attack(float dmg)
        {
            float dmg_m_def = dmg;
            dmg_m_def -= stat2[3];
            if(dmg_m_def < 0) dmg_m_def = 0;
            stat2[0] -= dmg;
            System.out.println('\n'+info[0]+" be attacked with "+dmg+" dmg"+'\n');
        } 

        @Override
        abstract public void attack(Character target);

        // astract
        @Override
        abstract public float skill();

        @Override
        abstract public void talk(Character target);
        @Override
        abstract public void listen(int dialog_index, Character target);

        /**
         * check if this character lost or not?
         */
        abstract public boolean is_lost();

        @Override
        public void swap_weapon()
        {
            if(weapon_inventory.length > 1)
            {
                int input = -1;
                Scanner get = new Scanner(System.in);

                int size = weapon_inventory.length;
                System.out.println();
                for(int i = 0; i < size; i++)
                {
                    System.out.printf("(%d) %s\n",i,weapon_inventory[i].return_name());
                }

                System.out.println("\nChoose your weapon");

                if(get.hasNextInt()) input = get.nextInt();
                get.nextLine();

                if(input < 0 || input > size-1) System.out.println("\nCancel\n");
                else
                {
                    weapon = weapon_inventory[input];
                    System.out.printf("\nYour weapon change to %s\n",weapon.return_name());
                }

            }
            else System.out.println("\nYou can't change weapon");
        }

        @Override
        public void equip_Accessory(Accessory equip)
        {
            System.out.println("\nYou can't change your Accessory in the balle field\n");
        }

        @Override
        public void unequip_Accessory()
        {
            int size = 0;

            if(equipment != null) size = equipment.length;

            if(size > 0)
            {
                System.out.println();
                for(int i = 0; i < size; i++)
                {
                    if(equipment[i] != null) System.out.printf("(%d) %s (type) %s\n",i,equipment[i].return_name(),equipment[i].return_type());
                } 
                System.out.println();

                int input = -1;
                Scanner get = new Scanner(System.in);
                
                if(get.hasNextInt()) input = get.nextInt();
                get.nextLine();

                if(input > size || input < 0) System.out.println("\nNot have this weapon");
                else System.out.println("\nCan't unequip during the battle");
            }
            else System.out.println("You not have any equipment");
        }

        @Override
        public void check_inventory() 
        {
            if(inventory != null)
            {
                System.out.println();
                for(Item i: inventory) System.out.printf("%s x%d\n",i.info(),i.return_count());
                System.out.println();

            }
            else System.out.println("\nYour inventory is Empty\n");
        }

        @Override
        public void use_item() 
        {
            int size = 0;
            if(inventory != null) size = inventory.length;

            System.out.println();

            if(size != 0)
            {
                int input = -1;
                Scanner get = new Scanner(System.in);

                System.out.println();
                for(int i = 0; i<size; i++) System.out.printf("(%d) %s x%d\n",i,inventory[i].info(),inventory[i].return_count());
                System.out.println();

                System.out.println("Choose item : ");
                if(get.hasNextInt()) input = get.nextInt();
                get.nextLine();

                use_item2(size, input);
            }
            else System.out.println("\nYou have nothing in your inventory\n");
        }

        @Override
        public void fly()
        {
            if(!have_wing) System.out.println("\nYou can't fly\n");
            // else if(have_wing && !now_flying) now_flying = true;
            else if(have_wing && now_flying) System.out.println("\nyou are flying\n");
            else
            {
                now_flying = true;
                System.out.println("\nyou are flying into the sky\n");
            }
        }

        /**
         * getter name of this character
         * @return name of this character
         */
        public String return_name()
        {
            return info[0];
        }

        @Override
        public String toString() 
        {
            String for_return = "";

            String 
                name = "\nName: " + info[0] + '\n',
                job = "Job: " + info[1] + '\n',
                species = "Species: " + info[2] + '\n',
                //stat
                stat_string = 
                    "\nWeapon: " + weapon.return_name() + '\n' +
                    "LV: " + lv + '\n' +
                    "HP: " + stat2[0] + '/' + stat1[0] + '\n' +
                    "Mana: " + stat2[1] + '/' + stat1[1] + '\n' +
                    "ATK: " + stat2[2] + " + " +weapon.return_atk() + '\n' +
                    "DEF: " + stat2[3] + '\n',
                profile = "\nBackstory :\n"+ info[3] + "\n\n";

            for_return = name+job+species+stat_string+profile;

            return for_return;    
        }
}
