package LAB19;

import java.util.LinkedList;
import java.util.Random;

public class Person
{
    private String name;
    private LinkedList<Person> followed = new LinkedList<>();

    public Person(String name)
    {
        this.name = name;
    }

    public void followed_notfify(Person person)
    {
        System.out.println(person +" follow " + this);
    }

    public void get_notify(String message)
    {
        Random rand = new Random();

        int value = rand.nextInt(3);

        Reaction react = null;
        switch (value) 
        {
            case 0:
                react = new WOW(this);
                break;
            case 1:
                react = new LOVE(this);
                break;
            default:
                react = new LIKE(this);
                break;
        }

        react.reaction();
    }

    public void notify_followed(String message)
    {
        for(Person i: followed) i.get_notify(message);
    }

    public void tweet(String message)
    {
        System.out.printf("%s tweet %s\n",this,message);
        notify_followed(message);
    }

    public void get_followed(Person from)
    {
        if(!followed.contains(from))
        {
            followed.add(from);
            followed_notfify(from);
        }
    }

    @Override
    public String toString() 
    {
        return name;    
    }
}
