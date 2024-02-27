import java.util.ArrayList;
// import java.util.Iterator;

import test_tree.*;

public class Main_test_tree 
{
    private static Node tree1()
    {
        Node root = new Node(0);

        ArrayList<Node> list = new ArrayList<>();
        
        list.add(root);
        for(int  i = 1; i<=11; i++) list.add(new Node(i));

        list.get(4).hang(list.get(2), list.get(3));
        list.get(5).hang(list.get(1), list.get(4));
        Node left = list.get(5);

        list.get(7).hang(null, list.get(6));
        list.get(9).hang(list.get(7), list.get(8));
        list.get(11).hang(list.get(9), list.get(10));
        Node right = list.get(11);

        root.hang(left, right);
        return root;
    }

    private static Node tree2()
    {
        Node root = new Node(0);

        ArrayList<Node> list = new ArrayList<>();
        
        list.add(root);
        for(int  i = 1; i<=14; i++) list.add(new Node(i));

        list.get(3).hang(list.get(1), list.get(2));
        list.get(6).hang(list.get(4), list.get(5));
        list.get(10).hang(list.get(8), list.get(9));
        list.get(13).hang(list.get(11), list.get(12));

        list.get(7).hang(list.get(3), list.get(6));
        list.get(14).hang(list.get(10), list.get(13));

        list.get(0).hang(list.get(7), list.get(14));

        root = list.get(0);
        return root;
    }

    private static Node tree3(boolean i)
    {
        Node root = new Node(0);

        Node temp = new Node(1);

        if(i) root.hang(temp, null);
        else root.hang(null, temp);

        return root;
    }

    public static class Post_order_test
    {
        public static void main() 
        {
            Tree_post_order test = new Tree_post_order(tree1());
    
            // Iterator<Node> iter = test.iterator();
    
            // System.out.println(iter.next());
    
            // for(int i = 0; i<5; i++) System.out.print(iter.next()+" ");
    
            System.out.println("test case 1");
            for(Node i: test) System.out.print(i+" ");
            System.out.println('\n');
    
            test = new Tree_post_order(null);
            System.out.println("test case 2");
            for(Node i: test) System.out.print(i+" ");
            System.out.println('\n');
    
            test = new Tree_post_order(tree2());
            System.out.println("test case 3");
            for(Node i: test) System.out.print(i+" ");
            System.out.println('\n');
    
            test = new Tree_post_order(new Node(0));
            System.out.println("test case 4");
            for(Node i: test) System.out.print(i+" ");
            System.out.println('\n');
    
            test = new Tree_post_order(tree3(true));
            System.out.println("test case 5");
            for(Node i: test) System.out.print(i+" ");
            System.out.println('\n');
    
            test = new Tree_post_order(tree3(false));
            System.out.println("test case 6");
            for(Node i: test) System.out.print(i+" ");
            System.out.println('\n');
        }       
    }

    public static class Pre_order_test
    {
        public static void main() 
        {
            Tree_pre_order test = new Tree_pre_order(tree1());
            System.out.println("test case 1");
            for(Node i: test) 
                System.out.print(i+" ");
            // Iterator<Node> iter = test.iterator();
            // while(iter.hasNext())
            // {
            //     System.out.print(iter.next()+" ");
            //     System.out.println();
            // }
            System.out.println('\n');
    
            test = new Tree_pre_order(null);
            // Iterator<Node> iter = test.iterator();
            // System.out.println(iter.next());
            System.out.println("test case 2");
            for(Node i: test) 
                System.out.print(i+" ");
            System.out.println('\n');
    
            test = new Tree_pre_order(tree2());
            System.out.println("test case 3");
            for(Node i: test) System.out.print(i+" ");
            System.out.println('\n');
    
            test = new Tree_pre_order(new Node(0));
            System.out.println("test case 4");
            for(Node i: test) System.out.print(i+" ");
            System.out.println('\n');
    
            test = new Tree_pre_order(tree3(true));
            System.out.println("test case 5");
            for(Node i: test) System.out.print(i+" ");
            System.out.println('\n');
    
            test = new Tree_pre_order(tree3(false));
            System.out.println("test case 6");
            for(Node i: test) System.out.print(i+" ");
            System.out.println('\n');
        }       
    }

    public static void main(String[] args) 
    {
        System.out.println("test post order");
        Post_order_test.main();
        System.out.println("test preorder");
        Pre_order_test.main(); 
    }
}
