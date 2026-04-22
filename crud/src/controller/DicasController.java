package controller;

import java.util.List;

import model.domain.Dica;
import model.services.DicasServices;

public class DicasController {
    private final DicasServices service;

    public DicasController(DicasServices service) {
        this.service = service;
    }

    public void salvar(Dica dica) {
        service.salvar(dica);
    }

    public void excluir(Integer id) throws Exception {
        service.excluir(id);
    }

    public Dica buscarPorId(Integer id) {
        return service.buscarPorId(id);
    }

    public Dica atualizar(Dica dica) {
        return service.atualizar(dica);
    }

    public List<Dica> buscarTodas() {
        return service.buscarTodos();
    }
}
