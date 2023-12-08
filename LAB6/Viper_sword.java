public class Viper_sword extends Weapon
{
    Viper_sword()
    {
        super("Nikki",48760.0f);
    }

    @Override
    public float skill(float atk) 
    {
        System.out.println("She swung her sword in a wide area and caused severe damage around me.\n");

        return (atk + super.return_atk()) * 60;
    }
}
