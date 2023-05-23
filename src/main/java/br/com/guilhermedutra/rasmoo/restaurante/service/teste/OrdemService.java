package br.com.guilhermedutra.rasmoo.restaurante.service.teste;

import br.com.guilhermedutra.rasmoo.restaurante.dao.CardapioDao;
import br.com.guilhermedutra.rasmoo.restaurante.dao.ClienteDao;
import br.com.guilhermedutra.rasmoo.restaurante.dao.OrdemDao;
import br.com.guilhermedutra.rasmoo.restaurante.entity.Cliente;
import br.com.guilhermedutra.rasmoo.restaurante.entity.Endereco;
import br.com.guilhermedutra.rasmoo.restaurante.entity.Ordem;
import br.com.guilhermedutra.rasmoo.restaurante.entity.OrdensCardapio;
import br.com.guilhermedutra.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.com.guilhermedutra.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasfood();
        entityManager.getTransaction().begin();

        CargaDeDadosUtil.cadastrarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CargaDeDadosUtil.cadastrarClientes(entityManager);
        CargaDeDadosUtil.cadastrarOrdensClientes(entityManager);

        ClienteDao clienteDao = new ClienteDao(entityManager);

        System.out.println(clienteDao.consultarPorNome("Costa"));

        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
