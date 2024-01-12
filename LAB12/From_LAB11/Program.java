package From_LAB11;

import java.util.LinkedList;

import MyTree.*;

public class Program 
{
    //private:
        private Token data;

        private LinkedList<Character> number = new LinkedList<>();
        private LinkedList<Character> ope_t = new LinkedList<>();
        private LinkedList<Character> ope_e = new LinkedList<>();
        private LinkedList<Character> allow_char = new LinkedList<>();

        //E -> E+T|E-T|T
        private Node parseE() throws SyntaxError
        {
            Node value = parseT();

            while (ope_e.contains(data.peek())) 
            {
                while(data.peek('+'))
                {
                    data.next();
                    // value += parseT();

                    Node right = parseT();
                    Node temp = value;
                    Ope_node ope = new Ope_node("ope", "+");
                    value = Tree_config.node_hang(temp, ope, right);
                }

                while(data.peek('-'))
                {
                    data.next();
                    // value -= parseT();

                    Node right = parseT();
                    Node temp = value;
                    Ope_node ope = new Ope_node("ope", "-");
                    value = Tree_config.node_hang(temp, ope, right);
                }
            }

            return value;
        }

        // T -> T*F|T/F|T%F|F
        private Node parseT() throws SyntaxError
        {
            Node value = parseF();

            while (ope_t.contains(data.peek())) 
            {
                while(data.peek('*'))
                {
                    data.next();
                    // value *= parseF();

                    Ope_node ope = new Ope_node("ope", "*");
                    Node right = parseF();
                    Node temp = value;
                    value = Tree_config.node_hang(temp, ope, right);
                }

                //wait
                // while(data.peek('/')) //can /0?
                // {
                //     data.next();
                //     double temp_f = parseF();
                //     if(temp_f == 0) throw new SyntaxError("/ 0?");
                //     else
                //     {
                //         value /= temp_f;
                //     }

    //                data.next();
    //                value /= parseF();
                // }

                while(data.peek('/'))
                {
                    data.next();
                    Ope_node ope = new Ope_node("ope", "/");
                    Node right = parseF();
                    Node temp = value;
                    value = Tree_config.node_hang(temp, ope, right);
                }

                // while(data.peek('%')) //can %0?
                // {
                //     data.next();
                //     double temp_f = parseF();
                //     if(temp_f == 0) throw new SyntaxError("% 0?");
                //     else 
                //     {
                //         value %= temp_f;
                //     }
                // }

                while(data.peek('%'))
                {
                    data.next();
                    Ope_node ope = new Ope_node("ope", "%");
                    Node right = parseF();
                    Node temp = value;
                    value = Tree_config.node_hang(temp, ope, right);
                }
            }

            return value;
        }

        //F -> n|(E)
        private Node parseF() throws SyntaxError
        {
            StringBuilder num = new StringBuilder();

            if(!allow_char.contains(data.peek())) throw new SyntaxError(data.peek() + " is illegal, bro");

            if(number.contains(data.peek()))
            {
                while(number.contains(data.peek())) num.append(data.next());
                return new IntLit("int", Double.parseDouble(num.toString()));
            }
            else if(data.peek().equals('x'))
            {
                Variable var = new Variable("var", "x");
                data.next();
                return var;
            }
            else
            {
                data.consume('(');
                Node value = parseE();
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
            allow_char.add('('); allow_char.add(')'); allow_char.add('x');
        }

        public Node working(String input) throws SyntaxError
        {
            if(input.isEmpty())
            {
                System.out.println("Empty file");
                return null;
            }

            data = new Token(input);

            Node value = parseE();

            //manual debug
            // if(data.peek() != null) System.out.println("peek is = "+data.peek().toString());

            if(!data.finished()) throw new SyntaxError("Check your input again");

            return value;
        }
}
