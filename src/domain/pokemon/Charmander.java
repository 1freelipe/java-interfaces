package domain.pokemon;

public class Charmander extends Pokemon implements FireType {

    public Charmander(String nick, Integer cp, Integer hp) {
        super(nick, cp, hp);
    }
    
    public void ambar() {
        System.out.println("Charmander usou ambar");
    }

    @Override
    public void attack() {
        ambar();
    }
}
