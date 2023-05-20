package br.com.guilhermedutra.rasmoo.restaurante.dao;

import br.com.guilhermedutra.rasmoo.restaurante.entity.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private final EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(final Categoria categoria){
        this.entityManager.persist(categoria);
        System.out.println("Entidade cadastrada: " + categoria);
    }

    public Categoria consultar(final Integer id){
        return entityManager.find(Categoria.class, id);
    }

    public void atualizar(final Categoria categoria){
        this.entityManager.merge(categoria);
    }

    public void excluir(final Categoria categoria){
        this.entityManager.remove(categoria);
    }
}