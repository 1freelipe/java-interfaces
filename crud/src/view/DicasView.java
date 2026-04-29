package view;

import controller.DicasController;

public class DicasView {
    private final DicasController controller;

    public DicasView(DicasController controller) {
        this.controller = controller;
    }

    public void exibirMenu() {
        // 
    }

}


/* Criar a view com:
    a - Menu de opções c/ operações do CRUD
    b - Aplicar SRP e DIP
    c - O menu deve ter opção de sair
    d - Criar funcionalidade de seleção de banco de dados por passagem de parâmetro na inicialização
*/