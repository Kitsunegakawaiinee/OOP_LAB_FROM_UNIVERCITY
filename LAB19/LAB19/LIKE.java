package LAB19;

class LIKE extends Reaction
{
    public LIKE(Person me)
    {
        super(me);
    }

    @Override
    public void reaction() 
    {
        System.out.printf("%s : I like this.\n",person);
    }
}
