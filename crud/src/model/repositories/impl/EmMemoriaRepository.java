package model.repositories.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import model.domain.Dica;
import model.repositories.IDicasRepository;

public class EmMemoriaRepository implements IDicasRepository {

    private List<Dica> dicas = new ArrayList<>();

    @Override
    public Dica criar(Dica dica) {
        dicas.add(dica);
        return dica;
    }

    @Override
    public void apagar(Integer id) {
        Dica dica = dicas.stream().filter(d -> Objects.equals(d.id, id)).findFirst().orElseThrow(() -> new RuntimeException("Dica não encontrada"));
        dicas.remove(dica);
    }

    @Override
    public List<Dica> buscarTodos() {
        return dicas;
    }

    @Override
    public Dica buscaPorId(Integer id) {
        return dicas.stream().filter(d -> d.id.equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Dica não encontrada"));
    }

    @Override
    public Dica atualizar(Dica dica) {
        Dica dicaExistente = buscaPorId(dica.id);
        if(Objects.nonNull(dicaExistente)) {
            dicaExistente.titulo = dica.titulo;
            dicaExistente.descricao = dica.descricao;
        }
        return dicaExistente;
    }
    
}
