package domain.pokemon;

public class Pikachu extends Pokemon implements ElectricType {

    public Pikachu(String nick, Integer cp, Integer hp) {
        super(nick, cp, hp);
    }


   @Override
   public void thunderbolt() {
    System.out.println("Pikachu usou thunderbolt");
}

}