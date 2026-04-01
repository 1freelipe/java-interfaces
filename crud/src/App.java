import java.sql.ResultSet;
import java.util.List;

import model.domain.Dica;
import model.factories.ConexaoFactory;
import model.repositories.IDicasRepository;
import model.repositories.impl.EmMemoriaRepository;

public class App {
    public static void main(String[] args) throws Exception {
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

        // Instanciando o repository
        IDicasRepository repository = new EmMemoriaRepository();

        // Criando as dicas no repository
        repository.criar(novaDica);
        repository.criar(novaDica2);

        // Buscar todas as dicas
        List<Dica> dicas = repository.buscarTodos();
        System.out.println(dicas);

        // Alterar dica sem passar o método??
        novaDica.descricao = "Dica alterada";
        Dica dicaAlterada = repository.buscaPorId(1);
        System.out.println(dicaAlterada);

        // Apagar dica
        repository.apagar(2);
        dicas = repository.buscarTodos();
        System.out.println(dicas);


    }
}
