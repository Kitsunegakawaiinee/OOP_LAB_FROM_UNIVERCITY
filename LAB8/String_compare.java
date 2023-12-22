    import java.util.Comparator;
    //edit from friend's code
    //compare string
    public class String_compare implements Comparator<String>
    {
        /**
         * compare String
         * @param obj1,obj2  string that you want to compare
         * @return -1 when obj1 come first
         * +1 if obj2 come first
         * 0 if the same
         */
        public int compare(String obj1, String obj2) 
        {
            if (obj1 == null) throw new NullPointerException("Your string 0 is null, bro!!!");
            if (obj2 == null) throw new NullPointerException("Your string 1 is null, bro!!!");

            int for_return;

            if(obj1.length() == obj2.length())
            {
                for_return = obj1.compareToIgnoreCase(obj2);// If lengths are equal
                return (for_return == 0)? 0: (for_return > 0)? 1: -1;
            } 

    //      obj1.length()-obj2.length() if  > 0 obj2 is Shorter if < 0 obj1 is Shorter
            for_return = Integer.compare(obj1.length(),obj2.length());
            
            return (for_return == 0)? 0: (for_return > 0)? 1: -1;
        }
    }