package model.repositories.impl;

import java.util.List;

import model.dao.DicasDao;
import model.domain.Dica;
import model.repositories.IDicasRepository;

public class MySqlDicasRepository implements IDicasRepository{

    private DicasDao dao;

    public MySqlDicasRepository(DicasDao dao) {
        this.dao = dao;
    }

    @Override
    public Dica criar(Dica dica) {
        return dao.criar(dica);
    }

    @Override
    // Lançando exceção no método apagar do dao
    public void apagar(Integer id) throws Exception {
        dao.apagar(id);
    }

    @Override
    public List<Dica> buscarTodos() {
        return dao.buscarTodos();
    }

    @Override
    public Dica buscaPorId(Integer id) {
        return dao.buscaPorId(id);
    }

    @Override
    public Dica atualizar(Dica dica) {
        return dao.atualizar(dica);
    }
    
    


}

