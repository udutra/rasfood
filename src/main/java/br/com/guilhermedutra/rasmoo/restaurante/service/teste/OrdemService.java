package br.com.guilhermedutra.rasmoo.restaurante.service.teste;

import br.com.guilhermedutra.rasmoo.restaurante.dao.ClienteDao;
import br.com.guilhermedutra.rasmoo.restaurante.dao.EnderecoDao;
import br.com.guilhermedutra.rasmoo.restaurante.entity.ClienteId;
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

        EnderecoDao enderecoDao = new EnderecoDao(entityManager);

        System.out.println(enderecoDao.consultarClientes(null,null,"Lapa"));
        System.out.println(enderecoDao.consultarClientesUsandoCriteria(null,null,"lapa"));

        ClienteDao clienteDao = new ClienteDao(entityManager);

        System.out.println(clienteDao.consultarPorId(new ClienteId("111111111123", "tayane@email.com")));


        System.out.println(clienteDao.consultarPorNome("Maria"));

        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
