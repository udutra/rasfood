package br.com.guilhermedutra.rasmoo.restaurante.dao;

import br.com.guilhermedutra.rasmoo.restaurante.entity.Cardapio;
import br.com.guilhermedutra.rasmoo.restaurante.entity.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {

    private final EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public String cadastrar(final Categoria categoria){
        this.entityManager.persist(categoria);
        return "Entidade cadastrada: " + categoria;
    }

    public Categoria consultarPorId(final Integer id){
        return entityManager.find(Categoria.class, id);
    }

    public List<Categoria> consultarTodos(){
        String sql = "SELECT c FROM Categoria c";
        return this.entityManager.createQuery(sql, Categoria.class).getResultList();
    }

    public void atualizar(final Categoria categoria){
        this.entityManager.merge(categoria);
    }

    public void excluir(final Categoria categoria){
        this.entityManager.remove(categoria);
    }
}