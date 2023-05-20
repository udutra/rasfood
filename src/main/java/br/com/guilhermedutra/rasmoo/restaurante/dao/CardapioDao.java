package br.com.guilhermedutra.rasmoo.restaurante.dao;

import br.com.guilhermedutra.rasmoo.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;

public class CardapioDao {

    private final EntityManager entityManager;

    public CardapioDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(final Cardapio prato){
        this.entityManager.persist(prato);
        System.out.println("Entidade cadastrada: " + prato);
    }

    public Cardapio consultar(final Integer id){
        return entityManager.find(Cardapio.class, id);
    }

    public void atualizar(final Cardapio prato){
        this.entityManager.merge(prato);
    }

    public void excluir(final Cardapio prato){
        this.entityManager.remove(prato);
    }
}