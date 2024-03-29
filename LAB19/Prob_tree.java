import java.util.Random;
import java.util.Stack;

interface Iterator<E> {
    boolean hasNext();
    E next();
}
interface Tree<E> {
    void add(E e);
    Iterator<E> iterator();
    
    //my code
    void set_mode();
}

public class Prob_tree<E extends Comparable<? super E>> implements Tree<E> {
    private static class TreeNode<E extends Comparable<? super E>> {
        E val;
        TreeNode<E> left, right;

        //my code
        TreeNode<E> parent;

        public TreeNode(E val) {
            this.val = val;
        }
        public TreeNode(E val, TreeNode<E> left, TreeNode<E> right) {
            this.val = val;
            this.left = left;
            this.right = right;

            //my code
            if(left != null) left.parent = this;
            if(right != null) right.parent = this;
        }

        public static int height(TreeNode<?> t) {
            if (t == null) return 0;
            int lh = height(t.left);
            int rh = height(t.right);
            return Math.max(lh, rh) + 1;
        }

        public TreeNode<E> insert(E e) {
            // insert recursively
            TreeNode<E> l = left, r = right;
            if (e.compareTo(val) < 0) {
                l = l == null ? new TreeNode<>(e) : l.insert(e);
            }
            else
                r = r == null ? new TreeNode<>(e) : r.insert(e);
            // rebalance if needed
            return rebalance(val, l ,r);
        }

        private TreeNode<E> rebalance(E val, TreeNode<E> l, TreeNode<E> r) {
            int lh = height(l);
            int rh = height(r);
            if (lh - rh > 1) { // heavy left
                TreeNode<E> ll = l.left, lr = l.right;
                int llh = height(ll), lrh = height(lr);
                if (llh - lrh >= 0) { // case 1
                    r = new TreeNode<>(val, lr, r);
                    val = l.val;
                    l = ll;
                }
                else { // case 2
                    TreeNode<E> lrl = lr.left, lrr = lr.right;
                    r = new TreeNode<>(val, lrr, r);
                    val = lr.val;
                    l = new TreeNode<>(l.val, ll, lrl);
                }
            }
            else if (rh - lh > 1) { // heavy right
                TreeNode<E> rl = r.left, rr = r.right;
                int rlh = height(rl), rrh = height(rr);
                if (rlh - rrh > 0) { // case 3
                    TreeNode<E> rll = rl.left, rlr = rl.right;
                    l = new TreeNode<>(val, l, rll);
                    val = rl.val;
                    r = new TreeNode<>(r.val, rlr, rr);
                }
                else { // case 4
                    l = new TreeNode<>(val, l, rl);
                    val = r.val;
                    r = rr;
                }
            }
            return new TreeNode<>(val, l, r);
        }
    }

    private TreeNode<E> root;

    @Override
    public void add(E e) {
        if (root == null)
            root = new TreeNode<>(e);
        else
            root = root.insert(e);
    }

    //my code
    // {
    private class Pre_order_interator implements Iterator<E>
    {
        TreeNode<E> data = null;
        Stack<TreeNode<E>> stack = new Stack<>();

        public Pre_order_interator() 
        {
            data = root;
            if(data != null)
            {
                TreeNode<E> temp = data.right;
                if(temp != null)stack.push(temp);
                temp = data.left;
                if(temp != null)stack.push(temp);
            }
        }

        private void cal_next()
        {
            if(stack.empty()) data = null;
            else 
            {
                data = stack.pop(); //pop next data
                if(data.right != null) stack.push(data.right);
                if(data.left != null) stack.push(data.left);
            }
        }

        @Override
        public boolean hasNext() 
        {
            return data != null;
        }

        @Override
        public E next() 
        {
            if(hasNext())
            {
                E for_return = data.val;
                cal_next();
                return for_return;
            }
            else return null;
        }
    }

    private class Post_order_interator implements Iterator<E>
    {
        private TreeNode<E> data = null;

        private TreeNode<E> cal_next(TreeNode<E> now)
        {
            TreeNode<E> parent = now.parent;

            if(parent == null) return null;

            if(parent.right == now) return parent;

            //case now is left
            if(parent.right == null) return parent;
            else return find_first(parent.right);
        }

        private TreeNode<E> find_first(TreeNode<E> curernt)
        {
            if(curernt != null)
            {
                TreeNode<E> temp = curernt.left;
                if(temp != null) return find_first(temp);
                temp = curernt.right;
                if(curernt.right != null) return find_first(temp);
    
                return curernt;
            }
            else return null;
        }

        public Post_order_interator()
        {
            data = find_first(root);
        }

        @Override
        public boolean hasNext() 
        {
            return data != null;
        }

        @Override
        public E next() 
        {
            if(hasNext())
            {
                E temp = data.val;
                data = cal_next(data);
                return temp;
            }
            
            return null;
        }
    }
    
    private boolean mode = false;

    public void set_mode()
    {
        mode = !mode;
    }
    // }

    @Override
    public Iterator<E> iterator() {
        
        //my code
        return mode? new Post_order_interator() : new Pre_order_interator();
    }

    public static void main(String[] args) {
        int N = 63;
        int seed = 2022;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = i;
        Random rand = new Random(seed);
        // create a random permutation
        for (int i = 0; i < N; i++) {
            int j = rand.nextInt(N-i)+i;
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        Tree<Integer> t = new Prob_tree<>();
        for (int i = 0; i < N; i++)
            t.add(a[i]);

        //my code 
        t.set_mode(); //for change to post order

        for (Iterator<Integer> itr = t.iterator(); itr.hasNext(); )
            System.out.print(itr.next() + " ");
        System.out.println();

        //Pre order I got
        // 32 19 9 5 2 1 0 3 4 7 6 8 16 13 11 10 12 15 14 17 18 27 23 21 20 22 25 24 26 30 29 28 31 
        // 47 40 36 34 33 35 38 37 39 44 42 41 43 45 46 55 50 48 49 52 51 54 53 59 57 56 58 61 60 62 

        // expected preorder:
        // 32 19 9 5 2 1 0 3 4 7 6 8 16 13 11 10 12 15 14 17 18 27 23 21 20 22 25 24 26 30 29 28 31
        // 47 40 36 34 33 35 38 37 39 44 42 41 43 45 46 55 50 48 49 52 51 54 53 59 57 56 58 61 60 62

        //Post order I got
        // 0 1 4 3 2 6 8 7 5 10 12 11 14 15 13 18 17 16 9 20 22 21 24 26 25 23 28 29 31 30 27 19 33 
        // 35 34 37 39 38 36 41 43 42 46 45 44 40 49 48 51 53 54 52 50 56 58 57 60 62 61 59 55 47 32 

        // expected postorder (challenge):
        // 0 1 4 3 2 6 8 7 5 10 12 11 14 15 13 18 17 16 9 20 22 21 24 26 25 23 28 29 31 30 27 19 33
        // 35 34 37 39 38 36 41 43 42 46 45 44 40 49 48 51 53 54 52 50 56 58 57 60 62 61 59 55 47 32
    }
}
