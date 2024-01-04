import java.util.Iterator;

public class Token //implements Iterator<Character>
{
    // private:
        private Character data;
        private String text;
        private int current, size;
       
        private void go_next()
        {
            if(!finished()) data = text.charAt(current++);
            else data = null;
        }
    //public:
        public Token(String input)
        {
            text = input;
            current = 0;
            size = text.length();
            if(!text.isEmpty()) data = text.charAt(current++);
        }

        public boolean has_next()
        {
            return !(data == null);
        }

        public Character peek()
        {
            return data;
        }

        public boolean peek(char input)
        {
            if(!has_next()) return false;
            else return data.equals(input);
        }

        public void consume(char input) throws SyntaxError
        {
            if(peek(input)) next();
            else throw new SyntaxError(input + " expected");
        }

        public boolean finished()
        {
            return current >= size;
        }

        public Character next()
        {
            Character for_return = data;

            go_next();

            return for_return;
        }

}
