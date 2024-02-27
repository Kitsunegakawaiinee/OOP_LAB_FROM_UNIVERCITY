package LAB19;

class LOVE extends Reaction
{
    public LOVE(Person me)
    {
        super(me);
    }

    @Override
    public void reaction() 
    {
        System.out.printf("%s : I love it.\n",person);
    }
}
