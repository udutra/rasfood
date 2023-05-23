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

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

        Endereco endereco = new Endereco("91254789", "Rua A", "apto 206", "POA", "RS");

        Cliente felipe = new Cliente("14523685445", "Felipe");
        felipe.addEndereco(endereco);

        Ordem ordem = new Ordem(felipe);
        ordem.addOrdensCardapio(new OrdensCardapio(cardapioDao.consultarPorId(1),2));

        clienteDao.cadastrar(felipe);
        ordemDao.cadastrar(ordem);

        System.out.println(ordem);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
