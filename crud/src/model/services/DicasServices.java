package model.services;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import model.domain.Dica;
import model.repositories.IDicasRepository;

public class DicasServices {

    private static final Logger logger = Logger.getLogger(DicasServices.class.getName());
    
    private final IDicasRepository repository;
    
    public DicasServices(IDicasRepository repository) {
        this.repository = repository;
    }

    public void salvar(Dica dica) {
        validarDica(dica);
        repository.criar(dica);
    }

    // Lançando exceção no método apagar
    public void excluir(Integer id) throws Exception{
        validarId(id);
        try {
            repository.apagar(id);
        } catch (Exception e) {
            logger.severe("Erro ao excluir dica: " + e.getMessage());
        }
    }

    public Dica buscarPorId(Integer id) {
        return repository.buscaPorId(id);
    }

    public Dica atualizar(Dica dica) {
        validarDica(dica);
        Dica dicaExistente = repository.buscaPorId(dica.id);

        if(Objects.isNull(dicaExistente)) {
            throw new IllegalArgumentException("Dica não encontrada.");
        }
        return repository.atualizar(dica);
    }

    public List<Dica> buscarTodos() {
        return repository.buscarTodos();
    }

    // Criando um validador de dados para a criação das dicas
    private void validarDica(Dica dica) {
        if (Objects.isNull(dica)) {
            throw new IllegalArgumentException("Dica não pode estar vazia");
        }
        if(Objects.isNull(dica.titulo) || dica.titulo.isEmpty()) {
            throw new IllegalArgumentException("O título não pode ser nulo ou vazio");
        }
        if(Objects.isNull(dica.descricao) || dica.descricao.isEmpty() || dica.descricao.length() > 500) {
            throw new IllegalArgumentException("A descrição da dica não pode ser nula ou vazio.");
        }
    }

    // Criando um outro validador para o ID
    private void validarId(Integer id) {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("ID da dica não encontrado");
        }
        if (id <=0 ) {
            throw new IllegalArgumentException("O ID deve ser maior que zero");
        }
    }
}
