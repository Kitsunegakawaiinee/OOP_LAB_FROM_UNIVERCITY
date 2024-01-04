import java.util.LinkedList;

public class Program 
{
    //private:
        private Token data;

        private LinkedList<Character> number = new LinkedList<>();
        private LinkedList<Character> ope_t = new LinkedList<>();
        private LinkedList<Character> ope_e = new LinkedList<>();
        private LinkedList<Character> allow_char = new LinkedList<>();

        //E -> E+T|E-T|T
        private double parseE() throws SyntaxError
        {
            double value = parseT();

            while (ope_e.contains(data.peek())) 
            {
                while(data.peek('+'))
                {
                    data.next();
                    value += parseT();
                }

                while(data.peek('-'))
                {
                    data.next();
                    value -= parseT();
                }
            }

            return value;
        }

        // T -> T*F|T/F|T%F|F
        private double parseT() throws SyntaxError
        {
            double value = parseF();

            while (ope_t.contains(data.peek())) 
            {
                while(data.peek('*'))
                {
                    data.next();
                    value *= parseF();
                }

                while(data.peek('/')) //can /0?
                {
                    data.next();
                    double temp_f = parseF();
                    if(temp_f == 0) throw new SyntaxError("/ 0?");
                    else
                    {
                        value /= temp_f;
                    }

    //                data.next();
    //                value /= parseF();
                }

                while(data.peek('%')) //can %0?
                {
                    data.next();
                    double temp_f = parseF();
                    if(temp_f == 0) throw new SyntaxError("% 0?");
                    else 
                    {
                        value %= temp_f;
                    }
                }
            }

            return value;
        }

        //F -> n|(E)
        private double parseF() throws SyntaxError
        {
            StringBuilder num = new StringBuilder();

            if(!allow_char.contains(data.peek())) throw new SyntaxError(data.peek() + " is illegal, bro");

            if(number.contains(data.peek()))
            {
                while(number.contains(data.peek())) num.append(data.next());
                return Double.parseDouble(num.toString());
            }
            else
            {
                data.consume('(');
                double value = parseE();
                data.consume(')');
                return value;
            }
        }
    // public:
        public Program()
        {
            for(int i = 48; i < 58; i++) number.add((char) i);
            ope_e.add('+'); ope_e.add('-');

            ope_t.add('*'); ope_t.add('/'); ope_t.add('%');

            allow_char.addAll(number);
            allow_char.addAll(ope_e);
            allow_char.addAll(ope_t);
            allow_char.add('('); allow_char.add(')');
        }

        public double working(String input) throws SyntaxError
        {
            if(input.isEmpty())
            {
                System.out.println("Empty file");
                return 0;
            }

            data = new Token(input);

            double value = parseE();

            //manual debug
            // if(data.peek() != null) System.out.println("peek is = "+data.peek().toString());

            if(!data.finished()) throw new SyntaxError("Check your input again");

            return value;
        }
}
