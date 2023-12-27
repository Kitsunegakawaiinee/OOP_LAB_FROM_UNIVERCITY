public class Shield 
{
    private String name = "Holy Armor";
    private float defend;
    private int lv;

    //private:

    private double def_cal()
    {
        return defend * (1+0.1*lv);
    }

    //public:
    public Shield(String name,float defend, int lv)
    {
        this(defend,lv);
        if(name != null)this.name = name;
    }

    public Shield(float defend, int lv)
    {
        this.defend = defend;
        this.lv = lv;
    }

    public float reduce_speed(float speed)
    {
        return (float) (speed*(0.1+0.08*lv));
    }

    //getter
    public int for_return_lv()
    {
        return lv;
    }

    public String for_return_name()
    {
        return name;
    }

    public float for_return_defend()
    {
        return (float) def_cal();
    }

    public void upgrade()
    {
        System.out.println("\nupgrade "+name);
        lv += 1;
        defend += 1;
        def_cal();
    }
}