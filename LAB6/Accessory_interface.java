public interface Accessory_interface 
{
    /**
     * getter name of this Accessory 
     * @return name of this
     */
    String return_name();

    /**
     * getter type
     * @return type of this Accessory 
     */
    String return_type();

    /**
     * index of this Accessory 
     * @return index that use to access in character object
     */
    int return_index();

    /**
     * equip this Accessory 
     * @param stat1 stat of max stat
     * @param stat2 stat of current stat
     */
    void equip(float[] stat1, float[] stat2); 

    /**
     * unequip this Accessory 
     * @param stat1 stat of max stat
     * @param stat2 stat of current stat
     */
    void unequip(float[] stat1, float[] stat2); 
}