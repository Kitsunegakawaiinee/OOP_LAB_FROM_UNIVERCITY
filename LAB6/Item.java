public class Item 
{
    //private:
        private String name;
        private int count = 1;
        private float[] effect;
        //0 hp
        //1 mana


    //public:
        public Item(String name, float[] effect)
        {
            this.name = name;
            this.effect = effect;
        }

        public String info()
        {
            return name;
        }

        public int return_count()
        {
            return count;
        } 

        public void have_the_same()
        {
            count++;
        }

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
