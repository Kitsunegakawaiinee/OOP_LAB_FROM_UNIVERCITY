public interface Character_interface 
{
    void attack(Character target);
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
