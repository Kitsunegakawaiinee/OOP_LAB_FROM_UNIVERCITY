import java.util.ArrayList;
import java.util.Random;

import LAB19.Person;

public class My_Twitter
{    
    public static void main(String[] args) 
    {
        ArrayList<Person> users = new ArrayList<>();

        users.add(new Person("Ivy"));
        users.add(new Person("Serena"));
        users.add(new Person("Monika"));

        //followed
        int size = users.size();

        for(int i = 0; i<size; i++)
        {
            for(int j = 0; j< size; j++)
            {
                if(i==j) continue;

                users.get(j).get_followed(users.get(i));
            }
        }
        System.out.println();

        //tweet
        String[] message = {"I love you","I want to be with you all for ever", "I like you all"};

        for(int i = 0; i<size; i++)
        {
            for(int j = 0; j< 3; j++)
            {
                Random rand = new Random();
                int index = rand.nextInt(3);
                users.get(i).tweet(message[index]);
                System.out.println();
            }
        }
    }
}
