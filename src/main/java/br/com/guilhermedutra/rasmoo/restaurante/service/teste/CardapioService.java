package br.com.guilhermedutra.rasmoo.restaurante.service.teste;

import br.com.guilhermedutra.rasmoo.restaurante.dao.CardapioDao;
import br.com.guilhermedutra.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.com.guilhermedutra.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasfood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        System.out.println("Lista de produtos por valor\n" + cardapioDao.consultarPorValor(BigDecimal.valueOf(59.00)));
        entityManager.close();
    }
}