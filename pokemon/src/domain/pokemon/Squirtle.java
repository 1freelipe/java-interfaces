package domain.pokemon;

public class Squirtle extends Pokemon implements WaterType{
    public Squirtle(String nick, Integer cp, Integer hp) {
        super(nick, cp, hp);
    }

    @Override 
    public void attack() {
        splash();
    }

    @Override
    public void splash() {
        System.out.println("Squirtle usou splash");
    }
}
