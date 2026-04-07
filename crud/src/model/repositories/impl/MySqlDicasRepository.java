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
    public void apagar(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'apagar'");
    }

    @Override
    public List<Dica> buscarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodos'");
    }

    @Override
    public Dica buscaPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscaPorId'");
    }

    @Override
    public Dica atualizar(Dica dica) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }
    
    


}

