package test_tree;

import java.util.Iterator;
import java.util.Stack;

public class Tree_pre_order implements Iterable<Node>
{
    Node root = null;

    private class Tree_iterator implements Iterator<Node>
    {
        Node data = null;
        Stack<Node> stack = new Stack<>();

        public Tree_iterator()
        {
            data = root;
            if(data != null)
            {
                Node temp = data.right_getter();
                if(temp != null)stack.push(temp);
                temp = data.left_getter();
                if(temp != null)stack.push(temp);
            }
        }

        private void cal_next()
        {
            if(stack.empty()) data = null;
            else 
            {
                data = stack.pop(); //pop next data
                if(data.right_getter() != null) stack.push(data.right_getter());
                if(data.left_getter() != null) stack.push(data.left_getter());
            }
        }

        @Override
        public boolean hasNext() 
        {
            return data != null;
        }

        @Override
        public Node next() 
        {
            if(hasNext())
            {
                Node for_return = data;
                cal_next();
                return for_return;
            }
            else return null;
        }
        
    }


    public Tree_pre_order(Node root) 
    {
        this.root = root;
    }

    @Override
    public Iterator<Node> iterator() 
    {
        return new Tree_iterator();
    }
    
}
