import domain.pokemon.*;


public class App {
    public static void main(String[] args) throws Exception {
        var Pikachu = new Pikachu("Pikachu", 100, 100);
        Pikachu.ComeBack();

        var Charmander = new Charmander("Charmander", 100, 100);
        Charmander.iChoseYou();
        Charmander.attack();
        Charmander.ComeBack();

        var Zapdos = new Zapdos("Zapdos", 2000, 2500);
        Zapdos.attack();
    }
}
