package model.services;

import java.util.List;

import model.domain.Dica;
import model.repositories.IDicasRepository;

public class DicasServices {
    private final IDicasRepository repository;

    public DicasServices(IDicasRepository repository) {
        this.repository = repository;
    }

    public void salvar(Dica dica) {
        repository.criar(dica);
    }

    public void excluir(Integer id) {
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
}
