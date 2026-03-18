package domain.pokemon;

public class Blaziken extends Pokemon implements FireType{
    public Blaziken(String nick, Integer cp, Integer hp) {
        super(nick, cp, hp);
    }

    @Override
    public void attack() {
        ambar();
    }

    @Override
    public void ambar() {
        System.out.println("Blaziken usou ambar!");
    }
}
