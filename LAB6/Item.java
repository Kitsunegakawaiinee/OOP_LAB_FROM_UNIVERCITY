public class Item 
{
    //private:
        private String name;
        private int count = 1;
        private float[] effect;
        //0 hp
        //1 mana


    //public:
        /**
         * this class for Item
         * @param name name of this item
         * @param effect what ability that this item can do
         */
        public Item(String name, float[] effect)
        {
            this.name = name;
            this.effect = effect;
        }

        /**
         * getter name
         * @return name of this item
         */
        public String info()
        {
            return name;
        }

        /**
         * how many this item do you have
         * @return count of this item
         */
        public int return_count()
        {
            return count;
        } 

        /**
         * call when you have two+ of the same item
         */
        public void have_the_same()
        {
            count++;
        }

        /**
         * use item
         * @param stat1 stat of max stat
         * @param stat2 stat of current stat
         */
        public void use_item(float[] stat1, float[] stat2)
        {
            count--;
            System.out.printf("\n%s used!!!\n",name);
            
            stat2[0] += effect[0];
            stat2[0] = (stat2[0] > stat1[0])? stat1[0]: stat2[0];

            stat2[1] += effect[1];
            stat2[1] = (stat2[1] > stat1[1])? stat1[1]: stat2[1];

        }
}
