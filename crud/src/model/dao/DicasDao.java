package model.dao;

import java.util.List;

import model.domain.Dica;

public interface DicasDao {
     Dica criar(Dica dica);
    void apagar(Integer id);
    List<Dica> buscarTodos();
    Dica buscaPorId(Integer id);
    Dica atualizar(Dica dica);
}
