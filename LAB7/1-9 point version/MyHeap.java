public class MyHeap
{
    //private:
        private int[] inventory;
        private int cap = 5;
        private int size = 1;

        private void check_priority(int choice)
        {
            if(choice == 0)
            {
                int here = 1;
                int left, right;
                
                inventory[1] = inventory[--size];

                if(size == 1) return;

                boolean go = true;

                while (go) 
                {
                    left = here*2;
                    right = here*2+1;

                    int min = here;

                    if(left < size)
                    {
                        if(inventory[left] < inventory[min]) min = left;
                    }

                    if(right < size)
                    {
                        if(inventory[right] < inventory[min]) min = right;
                    }

                    if(min != here)
                    {
                        swap(here, min);
                        here = min;
                        continue;
                    }

                    go = false;
                }
            }

            if(choice == 1)
            {
                int here = size-1;
                int parent = here/2;

                while(parent > 0)
                {
                    parent = here/2;


                    if(inventory[here] < inventory[parent])
                    {
                        swap(here, parent);
                        here = parent;
                        parent = here/2;
                        continue;
                    }

                    break;
                }
            }
        }

        private void resize()
        {
            cap *= 2;
            int[] new_data = new int[cap];
            
            for(int i = 0; i < size; i++)
            {
                new_data[i] = inventory[i];
            }

            inventory = new_data;
        }

        private void swap(int i, int j)
        {
            int temp = inventory[i];
            inventory[i] = inventory[j];
            inventory[j] = temp;
        }

    // public:
        public MyHeap()
        {
            inventory = new int[cap];
        }

        public void add(int input)
        {
            if(size >= cap)
            {
                resize();
            }

            inventory[size++] = input;
            check_priority(1);
        }

        public int pop()
        {
            if(size > 1)
            {
                int temp = inventory[1];
                check_priority(0);
                return temp;
            }
            else return -1;
        }

        public boolean empty()
        {
            return size == 1;
        }

        @Override
        public String toString() 
        {
            String for_return = "";

            for(int i = 1; i < size; i++)
            {
                for_return = for_return + inventory[i] + " ";
            }

            return for_return;
        }
}
