package br.com.guilhermedutra.rasmoo.restaurante.dao;

import br.com.guilhermedutra.rasmoo.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CardapioDao {

    private final EntityManager entityManager;

    public CardapioDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public String cadastrar(final Cardapio prato){
        this.entityManager.persist(prato);
        return "Entidade cadastrada: " + prato;
    }

    public Cardapio consultarPorId(final Integer id){
        return entityManager.find(Cardapio.class, id);
    }

    public List<Cardapio> consultarTodos(){
        String sql = "SELECT c FROM Cardapio c";
        return this.entityManager.createQuery(sql, Cardapio.class).getResultList();
    }

    public List<Cardapio> consultarPorValor(final BigDecimal filtro){
        String jpql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
        return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("valor",filtro).getResultList();
    }

    public void atualizar(final Cardapio prato){
        this.entityManager.merge(prato);
    }

    public void excluir(final Cardapio prato){
        this.entityManager.remove(prato);
    }
}