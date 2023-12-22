public interface Character_interface 
{
    /**
     * Method for attack
     * @param target target that this character want to attack
     */
    void attack(Character target);
    /**
     * skill method for choose and use skill
     * @return dmg of skill that used
     */
    float skill();
    float normal_attack();
    void talk(Character target); 
    void listen(int input,Character target);
    void be_attack(float dmg); //change to void
    void fly();
    void swap_weapon();
    void equip_Accessory(Accessory equip); //not the same at lab4
    void unequip_Accessory();//not the same at lab4
    void use_item();
    void check_inventory();
}
