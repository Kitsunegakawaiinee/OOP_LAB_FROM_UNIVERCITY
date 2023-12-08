public class Accessory implements Accessory_interface
{
    private String [] info;
    //0 name
    //1 type

    private float[] stat;
    //0 max hp
    //1 max mana
    //2 base_atk
    //3 def

    int type_index;


    // public:
    public Accessory(String[] info, float[] stat)
    {
        this.info = info;
        this.stat = stat;

        if(info[0].equals("armor")) type_index = 0;
        else if(info[0].equals("armor pants")) type_index = 1;
        else if(info[0].equals("veil")) type_index = 2;
        else if(info[0].equals("necklace")) type_index = 3;
        else if(info[0].equals("ring")) type_index = 4;
        else if(info[0].equals("bangle")) type_index = 5;
        else if(info[0].equals("shoe")) type_index = 6;
    }

    @Override
    public String return_name() 
    {
        return info[0];
    }

    @Override
    public String return_type() 
    {
        return info[1];
    }

    public int return_index()
    {
        return type_index;
    }

    @Override
    public void equip(float[] stat1, float[] stat2) 
    {
        if(stat != null)
        {
            stat1[0] += stat[0];
            stat1[1] += stat[1];
            stat1[2] += stat[2];
            stat2[3] += stat[3];
        }
    }

    @Override
    public void unequip(float[] stat1, float[] stat2) 
    {

        //call this function?
        //TO BE CONTINUE
        stat1[0] -= stat[0];
        stat2[0] = (stat2[0] > stat1[0])? stat2[0]: stat1[0];

        stat1[1] -= stat[1];
        stat2[1] = (stat2[1] > stat1[1])? stat2[1]: stat1[1];

        stat1[2] -= stat[2];

        stat2[3] -= stat[3];
    }
}
