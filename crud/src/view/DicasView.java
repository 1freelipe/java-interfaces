package view;

import java.util.List;
import java.util.Scanner;

import controller.DicasController;
import model.domain.Dica;

public class DicasView {
    private final DicasController controller;

    public DicasView(DicasController controller) {
        this.controller = controller;
    }

    public void exibirMenu() {
        Integer opc;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("------------------");
            System.out.println("Seja bem vindo ao sistema! Escolha abaixo uma das opções para continuar:");
            System.out.println("1. Visualizar dicas");
            System.out.println("2. Cadastrar dica" );
            System.out.println("3. Buscar dica pelo ID");
            System.out.println("4. Deletar dica");
            System.out.println("0. Sair do sistema");
            System.out.println("------------------");

            opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Lista de todas as dicas criadas:");
                    index();
                    break;
                case 2:
                    // Limpando o buffer do scanner
                    scanner.nextLine();

                    System.out.println("Digite o título da dica:");
                    String title = scanner.nextLine();
                    System.out.println("Digite a descrição da dica:");
                    String description = scanner.nextLine();

                    create(title, description);
                    break;

                default:
                    break;
            }
            
        } while (opc != 0);

        System.out.println("Sistema finalizado!");
    }

    public void create(String title, String description) {
        // Instanciando a dica
        Dica novaDica = new Dica();

        // Atribuição direta aos campos já que sao publics
        novaDica.titulo = title;
        novaDica.descricao = description;

        // Passando 1 único argumento para o método que se comunica com o service
        controller.salvar(novaDica);
        System.out.println("Dica criada com sucesso.");
    }   

    public List<Dica> index() {
        List<Dica> dicas = controller.buscarTodas();

        if(dicas.isEmpty()) {
            System.out.println("Nenhuma dica cadastrada.");
        } else {
            for (Dica dica : dicas) {
                System.out.println("Título: " + dica.titulo);
                System.out.println("Descrição: " + dica.descricao);
                System.out.println("------------------------------");
            }
        }
        
        return dicas;
    }

}


/* Criar a view com:
    a - Menu de opções c/ operações do CRUD
    b - Aplicar SRP e DIP
    c - O menu deve ter opção de sair
    d - Criar funcionalidade de seleção de banco de dados por passagem de parâmetro na inicialização
*/