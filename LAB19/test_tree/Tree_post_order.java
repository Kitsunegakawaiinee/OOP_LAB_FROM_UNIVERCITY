package test_tree;
import java.util.Iterator;

public class Tree_post_order implements Iterable<Node>
{
    private Node root;   
    
    private class Tree_iterator implements Iterator<Node>
    {
        private Node data = null;

        private Node cal_next(Node now)
        {
            Node parent = now.parent_getter();

            if(parent == null) return null;

            if(parent.right_getter() == now) return parent;

            //case now is left
            if(parent.right_getter() == null) return parent;
            else return find_first(parent.right_getter());
        }

        private Node find_first(Node curernt)
        {
            if(curernt != null)
            {
                Node temp = curernt.left_getter();
                if(temp != null) return find_first(temp);
                temp = curernt.right_getter();
                if(curernt.right_getter() != null) return find_first(temp);
    
                return curernt;
            }
            else return null;
        }

        public Tree_iterator()
        {
            data = find_first(root);
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
                Node temp = data;
                data = cal_next(data);
                return temp;
            }
            
            return null;
        }

    }

    public Tree_post_order(Node root)
    {
        this.root = root;
    }

    @Override
    public Iterator<Node> iterator() 
    {
        return new Tree_iterator();
    }
}
