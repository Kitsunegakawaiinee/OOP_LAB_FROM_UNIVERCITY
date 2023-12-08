abstract public class Weapon 
{
    private String name;
    private float atk;

    // public:
        public Weapon(String name, float atk)
        {
            this.name = name;
            this.atk = atk;
        }

        public String return_name()
        {
            return name;
        }

        public float return_atk()
        {
            return atk;
        }

        //astract
        abstract public float skill(float atk);
}