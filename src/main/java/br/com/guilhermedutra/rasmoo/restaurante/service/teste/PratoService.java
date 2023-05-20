package br.com.guilhermedutra.rasmoo.restaurante.service.teste;

import br.com.guilhermedutra.rasmoo.restaurante.dao.PratoDao;
import br.com.guilhermedutra.rasmoo.restaurante.entity.Prato;
import br.com.guilhermedutra.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PratoService {

    public static void main(String[] args) {
        Prato risoto = new Prato();

        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        EntityManager entityManager = JPAUtil.getEntityManagerRasfood();

        PratoDao pratoDao = new PratoDao(entityManager);

        entityManager.getTransaction().begin();
        pratoDao.cadastrar(risoto);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}