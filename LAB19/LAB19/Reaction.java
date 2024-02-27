package LAB19;

abstract class Reaction
{
    protected Person person;
    public Reaction(Person person)
    {
        this.person = person;
    }
    abstract void reaction();
}
