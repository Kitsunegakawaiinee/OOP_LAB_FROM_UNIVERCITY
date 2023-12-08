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

        /**
         * getter name of this weapon
         * @return name of this weapon
         */
        public String return_name()
        {
            return name;
        }

        /**
         * getter atk
         * @return atk of this weapon
         */
        public float return_atk()
        {
            return atk;
        }

        //astract
        /**
         *choose and use weapon skill 
         * @param atk atk of charater
         * @return dmg output
         */
        abstract public float skill(float atk);
}