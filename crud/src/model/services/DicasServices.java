package model.services;

import java.util.List;
import java.util.Objects;

import model.domain.Dica;
import model.repositories.IDicasRepository;

public class DicasServices {
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
        repository.apagar(id);
    }

    public Dica buscarPorId(Integer id) {
        return repository.buscaPorId(id);
    }

    public Dica atualizar(Dica dica) {
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
            throw new IllegalArgumentException("A descrição da dica não pode ser nula ou vazio");
        }
    }

    // Criando um outro validador para o ID
    private validarId(Dica id)
}
