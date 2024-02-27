package LAB19;

class WOW extends Reaction
{
    public WOW(Person me)
    {
        super(me);
    }

    @Override
    public void reaction() 
    {
        System.out.printf("%s : WOW\n",person);
    }
}    
