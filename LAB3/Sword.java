public class Sword 
{
    private String name = "Katana";
    private float base_atk;
    private int lv;

    private float dmg;  

    private void dmg_cal(double character_atk)
    {
       dmg = (float) ((character_atk+base_atk)*(1+0.1*lv));
    }

    //public:
    public Sword(String name, float base_atk, int lv)
    {
        this(base_atk,lv);
        if(name != null)this.name = name;
    }

    public Sword(float base_atk, int lv)
    {
        this.base_atk = base_atk;
        this.lv = lv;
    }

    public double speed_decrease(float speed)
    {
        return speed*(0.1+0.04*lv);
    }

    public void upgrade()
    {
        System.out.println("\nupgrade "+name);
        lv += 1;
        base_atk += 5;
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

    public float return_atk()
    {
        return base_atk;
    }

    public double for_return_dmg(double character_atk)
    {
        dmg_cal(character_atk);
        return dmg;
    }
}
