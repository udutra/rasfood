package br.com.guilhermedutra.rasmoo.restaurante.dao;

import br.com.guilhermedutra.rasmoo.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
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

    public List<Cardapio> consultarTodos() {
        try {
            String sql = "SELECT c FROM Cardapio c";
            return this.entityManager.createQuery(sql, Cardapio.class).getResultList();
        }
        catch (Exception e){
            return Collections.emptyList();
        }
    }

    public Cardapio consultarPorNome(final String filtro){
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE UPPER(c.nome) = UPPER(:valor)";
            return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("valor", filtro).getSingleResult();
        }
        catch (Exception e){
            return null;
        }
    }
    public List<Cardapio> consultarPorValor(final BigDecimal filtro){
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
            return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("valor", filtro).getResultList();
        }
        catch (Exception e){
            return Collections.emptyList();
        }
    }

    public void atualizar(final Cardapio cardapio){
        this.entityManager.merge(cardapio);
    }

    public void excluir(final Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }
}