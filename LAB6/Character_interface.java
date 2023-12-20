/** 
 * this class for create character (mc or enemy) 
*/
public interface Character_interface 
{
    /**
     * this character attack target
     * @param target target of attacking
     */
    void attack(Character target);

    /**
     * choose and show skill the character have
     * @return dmg of skill that was choose
     */
    float skill();

    /**
     * cal normal skill dmg
     * @return normal skill dmg
     */
    float normal_attack();

    /**
     * sent dialog index to target
     * @param target character you talk with
     */
    void talk(Character target); 

    /**
     * Recieve the dialog index
     * @param input index of dialog
     * @param target character that you want to talk with
     */
    void listen(int input,Character target);

    /**
     * cal hop after you were attacked
     * @param dmg dmg of opponent character
     */
    void be_attack(float dmg); //change to void

    /**
     * fly if you can fly
     */
    void fly();

    /**
     * chang weapon of you can
     */
    void swap_weapon();

    /**
     * get Accessory and equip to character (can't equip during the battle)
     * @param equip Accessory that you want to equip
     */
    void equip_Accessory(Accessory equip); 

    /**
     * unequip character Accessory
     */
    void unequip_Accessory();

    /**
     * choose your item and use that item
     */
    void use_item();

    /**
     * print all item in your inventory
     */
    void check_inventory();
}
