package domain.pokemon;

public class Zapdos extends Pokemon implements ElectricType, FlyingType {
    public Zapdos(String nick, Integer cp, Integer hp) {
        super(nick, cp, hp);
    }

    @Override
    public void attack() {
        thunderbolt();
        wingAttack();
    }

    @Override
    public void thunderbolt() {
        System.out.println("Zapdos usou thunderbolt!");
    }

    @Override
    public void wingAttack() {
        System.out.println("Zapdos usou Wing Attack!");
    }
}
