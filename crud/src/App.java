import java.sql.Connection;
import java.sql.ResultSet;
// import java.util.List;

import controller.DicasController;
import model.dao.DicasDao;
import model.dao.impl.MySqlDAO;
import model.domain.Dica;
import model.factories.ConexaoFactory;
import model.repositories.IDicasRepository;
import model.repositories.impl.EmMemoriaRepository;
// import model.repositories.impl.EmMemoriaRepository;
import model.repositories.impl.MySqlDicasRepository;
import model.services.DicasServices;
import view.DicasView;

public class App {

    // Instanciando o controller
    private static DicasController controller;

    // Setup inicializador até a camada da View
    private static void setUpInitializer() {
        Connection conexao = ConexaoFactory.getConnection();
        DicasDao dao = new MySqlDAO(conexao);
        IDicasRepository repository = new EmMemoriaRepository();
        DicasServices service = new DicasServices(repository);
        controller = new DicasController(service);
    }

    public static void main(String[] args) throws Exception {

        // Instanciando a view passando o controller como parâmetro, última câmada do MVC
        DicasView view = new DicasView(controller);
        view.exibirMenu();





        System.out.println("Hello, World!");
        ResultSet rst = ConexaoFactory
                    .getConnection()
                    .createStatement()
                    .executeQuery("Select Version() AS versao");
        if (rst.next()) {
            System.out.printf("Versão MYSQL: %s\n", rst.getString("versao"));
        }

        // Instanciando a dica
        Dica novaDica = new Dica();
        novaDica.id = 1;
        novaDica.titulo = "Aprender JDBC";
        novaDica.descricao = "Estudar Prepared Statement";

        // Instanciando a dica 2
        Dica novaDica2 = new Dica();
        novaDica2.id = 2;
        novaDica2.titulo = "Nova dica";
        novaDica2.descricao = "Nova descrição";

        // Instanciando o repository - Na memoria
        // IDicasRepository repository = new EmMemoriaRepository();

        // Criar repository
        Connection connection = ConexaoFactory.getConnection();
        DicasDao dao = new MySqlDAO(connection);
        IDicasRepository repository2 = new MySqlDicasRepository(dao);

        // Criar dica no repository2 que está sendo utilizado o MYSQL
        // repository2.criar(novaDica);
        repository2.criar(novaDica2);
        // repository2.apagar(1);

        // Criando as dicas no repository - Na memoria
        // repository.criar(novaDica);
        // repository.criar(novaDica2);

        // Buscar todas as dicas - Na memoria
        // List<Dica> dicas = repository.buscarTodos();
        // System.out.println(dicas);

        // Alterar dica sem passar o método?? - Na memoria
        // novaDica.descricao = "Dica alterada";
        // Dica dicaAlterada = repository.buscaPorId(1);
        // System.out.println(dicaAlterada);

        // Apagar dica - Na memoria
        // repository.apagar(2);
        // dicas = repository.buscarTodos();
        // System.out.println(dicas);


    }
}
