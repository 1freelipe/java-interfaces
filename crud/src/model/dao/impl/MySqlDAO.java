package model.dao.impl;

import java.beans.Statement;
import java.sql.Connection;
import java.util.List;

import model.dao.DicasDao;
import model.domain.Dica;

public class MySqlDAO implements DicasDao {

    private final Connection connection;
    private static final logger logger = logger

    public MySqlDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Dica criar(Dica dica) {
        logger.info("Criando dica: " + dica);
        try(Statement stm = connection.createStatement()) {
            stm.execute("INSERT INTO dicas(titulo, descricao) VALUES ('%s', '%s')");
        } catch(Exception e) {
            logger.severe("Erro ao criar dica: " + e.getMessage());
            return null;
        }
        return null;
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
