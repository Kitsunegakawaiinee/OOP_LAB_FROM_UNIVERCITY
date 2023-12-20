import java.util.HashMap;
import java.util.Set;

import java.util.Map.Entry;
import java.util.Collection;
import java.util.Iterator;

@SuppressWarnings("unchecked")

public class MySet<type> implements Set<type>
{
    // private:
        private int current_key = 0;
        private MyHeap temp_key = new MyHeap();
        private HashMap<Integer, type> inventory = new HashMap<Integer, type>();

        private class use_for_each implements Iterator<type>
        {
            //private:
                private int current = 0;
                private type data;

                private type until_not_null()
                {
                    if(data == null)
                    {
                        type for_return;
                        while(current < current_key)
                        {
                            for_return = inventory.get(current);

                            if(for_return != null) return for_return;
                            current++;
                        } 

                        return null;
                    }
                    else return data;
                }

            //public:
                use_for_each()
                {
                    data = inventory.get(current);

                    data = until_not_null();
                }

                @Override
                public boolean hasNext() 
                {
                    return data != null;
                }

                @Override
                public type next() 
                {
                    if(!hasNext()) return null;

                    type for_return = data;
                    data = inventory.get(++current);
                    data = until_not_null();
                    return for_return;
                }
        }

    //public:
        @Override
        public int size()
        {
            return inventory.size();
        }

        @Override
        public boolean isEmpty()
        {
            return inventory.isEmpty();
        }

        @Override
        public boolean contains(Object o)
        {
            return inventory.containsValue(o);
        }

        @Override
        public Iterator iterator() 
        {
            return new use_for_each();
        }

        @Override
        public boolean add(type input) 
        {
            if(inventory.containsValue(input))
            {
                return false;
            }
            else
            {
                if(temp_key.empty()) inventory.put(current_key++, input);
                else inventory.put(temp_key.pop(), input);

                return true;
            }
        }

        @Override
        public boolean remove(Object o) 
        {
            int key = -1;
            if(inventory.containsValue(o))
            {
                for(Entry<Integer, type> find: inventory.entrySet())
                {
                    if(find.getValue().equals(o))
                    {
                        key = find.getKey();
                        break;
                    }
                }

                inventory.remove(key);

                temp_key.add(key);

                return true;
            }
            else return false;
        }

        @Override
        public boolean addAll(Collection c) 
        {
            try 
            {
                for(Object i: c) add((type) i);
                return true;
            } 
            catch (Exception e) 
            {
                return false;
            }
        }

        @Override
        public void clear() 
        {
            inventory.clear();
        }

        @Override
        public boolean removeAll(Collection c) 
        {
            for(Object i: c)
            {
                if(inventory.containsValue(i)) remove(i);
            }

            return true;
        }

        @Override
        public boolean retainAll(Collection c) 
        {
            for(Object i: this)
            {
                if(!c.contains(i))
                {
                    this.remove(i);
                }
            }
            return true;
        }

        @Override
        public boolean containsAll(Collection c)
        {
            boolean for_return = true;

            for(Object i: c)
            {
                for_return = (for_return && inventory.containsValue(i));

                if(!for_return) break;
            }

            return for_return;
        }

        @Override
        public Object[] toArray(Object[] a) 
        {
            System.out.println("\nERROR: I can do this\n");
            return null;
        }

        @Override
        public Object[] toArray() 
        {
            int size = inventory.size();
            Object[] for_return = new Object[size];
            
            int i = 0;

            for(type item: this)
            {
                for_return[i] = item;
                i++;
            }

            return for_return;
        }

        @Override
        public String toString() 
        {
            String for_return = "Please, don't do this.";
            return for_return;
        }
}