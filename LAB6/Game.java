import java.io.File;
import java.io.IOException;

import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Game 
{
    private Scanner get  = new Scanner(System.in);
    //manage sound (form internet)
    private Clip clip;

    //game asset
    private Text text;

    private Character monika, serena;

    private static boolean game_running = true;

    public void start()
    {
        //story
        text = new Text();
        text.skip_or_not();

        play_sound();

        game_setup();
        start_playing();

        close_bgm();
    }

    /**
     * Create character and store data in instance var
     * @param who 0.MC 1.Enemy
     */
    private void create_character(int who)
    {
        String[] info = text.return_info_or_dialog(0, who);
        int lv = text.return_lv(who);
        boolean wing = text.return_wing(who);
        Accessory[] equipment = text.return_equipment(who);
        Weapon[] weapon_have = text.weapon_have(who);
        float[] stat = text.return_stat(who);
        String[] word = text.return_info_or_dialog(1, who);

        Item[] inventory = (who == 0)? text.return_inventory(): null;

        if(who == 0)serena = new Main_Character(info, lv, wing, equipment, weapon_have, stat, word, inventory);
        else monika = new Enemy_class(info, lv, wing, equipment, weapon_have, stat, word, inventory);
    }

    private void game_setup()
    {
        create_character(0);
        create_character(1);
    }

    private void monika_turn()
    {
        monika.attack(serena);
    }

    private String[] choice = 
    {
        "\nWhat should I do?",
        "Check my status (1)",
        "Check Monika statue (2)",
        "Swap you Weapon (3)",
        "Attack her(4)",
        "Talk to her(5)",
        "Use Item (6)",
        "Unquip your Accessory (7)",
        "Do nothing(else)\n"
    };

    private void start_playing()
    {
        boolean in_turn = true;

        while(game_running && !serena.is_lost())
        {
            while (in_turn) 
            {
                for(String i: choice) System.out.println(i);
                int input = 0;

                if(get.hasNextInt()) input = get.nextInt();

                switch (input) 
                {
                    case 1 -> System.out.println(serena);
                    case 2 -> System.out.println(monika);
                    case 3 -> serena.swap_weapon();
                    case 4 -> 
                    {
                        serena.attack(monika);
                        in_turn = false;
                    }
                    case 5 ->
                    {
                        serena.talk(monika);
                        in_turn = false;
                    } 
                    case 6 -> serena.use_item();
                    case 7 -> serena.unequip_Accessory();
                    default -> System.out.println("\nDo nothing\n");
                }

                get.nextLine();
            }

            if(game_running) monika_turn();
            if(game_running) in_turn = true;
        }

        close_bgm();

        String[] end_text = 
        {
            "\nSerena lost her, so Serena have to escape and wait until She found her again\n\n",
            "Serena pay everything she have to fly in the sky. She hug monika with her arm before free her.\n",
            "ENDING\n"
        };

        if(serena.is_lost()) Game.typping_effect(end_text[0]);
        else Game.typping_effect(end_text[1]);

        Game.typping_effect(end_text[2]);
        System.out.println();
    }

    //method in game
    private void play_sound()
    {
        try {
            File file = new File("Rolling cup.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            clip.loop(-1);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // Handle the exception here
            e.printStackTrace(); // Or handle it based on your application's logic
        }
    }

    private void close_bgm()
    {
        clip.stop();
    }

    static public void typping_effect(String input)
    {
        try
        {
            int size = input.length();
            for(int i = 0; i < size; i++)
            {
                System.out.print(input.charAt(i));
                Thread.sleep(5);
            } 
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }

    static public void end()
    {
        game_running = false;
    }
}
