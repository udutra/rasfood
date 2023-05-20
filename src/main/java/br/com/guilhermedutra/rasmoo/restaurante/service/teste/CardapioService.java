package br.com.guilhermedutra.rasmoo.restaurante.service.teste;

import br.com.guilhermedutra.rasmoo.restaurante.dao.CardapioDao;
import br.com.guilhermedutra.rasmoo.restaurante.entity.Cardapio;
import br.com.guilhermedutra.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {

    public static void main(String[] args) {
        Cardapio risoto = new Cardapio();

        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Cardapio salmao = new Cardapio();

        salmao.setNome("Salmão ao molho de maracuja");
        salmao.setDescricao("Salmão grelhado ao molho de maracuja");
        salmao.setDisponivel(true);
        salmao.setValor(BigDecimal.valueOf(60));

        EntityManager entityManager = JPAUtil.getEntityManagerRasfood();

        CardapioDao pratoDao = new CardapioDao(entityManager);

        entityManager.getTransaction().begin();
        pratoDao.cadastrar(risoto);
        entityManager.flush();
        pratoDao.cadastrar(salmao);
        entityManager.flush();
        System.out.println("O prato consultado foi: " + pratoDao.consultar(2));
        pratoDao.excluir(salmao);
        System.out.println("O prato consultado foi: " + pratoDao.consultar(2));

        entityManager.clear();
        risoto.setValor(BigDecimal.valueOf(75.50));
        pratoDao.atualizar(risoto);
        System.out.println("O prato consultado foi: " + pratoDao.consultar(1));


    }
}