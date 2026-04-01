package domain.pokemon;

public class GreNinja extends Pokemon{

    public GreNinja(String nick, Integer cp, Integer hp) {
        super(nick, cp, hp);
    }
    
    public void shuriken() {
        System.out.println("Greninja usou shuriken.");
    }

    @Override
    public void attack() {
        shuriken();
    }
}
