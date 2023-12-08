public interface Accessory_interface 
{
    String return_name();
    String return_type();
    int return_index(); //add after implement
    void equip(float[] stat1, float[] stat2); //not the same at lab4
    void unequip(float[] stat1, float[] stat2); //not the same at lab4
}