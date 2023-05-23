package br.com.guilhermedutra.rasmoo.restaurante.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordens")
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao = LocalDateTime.now();

    @ManyToOne
    private Cliente cliente;

    /**
     * ALL = Realiza todas as operações em cascata
     * DETACH = Operação detach executada no pai e no filho
     * MERGE = Salva pai e filho, podendo já haver a entidade gerenciada
     * PERSIST = Cria pai e filho
     * REFRESH = Atualiza entidade com operações do banco
     * REMOVE = Propaga remoção entre pai e filho
     **/
    @OneToMany(mappedBy = "ordem", cascade = CascadeType.ALL)
    //@JoinTable(name = "ordens_cardapio", joinColumns = @JoinColumn(name = "ordens_id"), inverseJoinColumns = @JoinColumn(name = "cardapios_id"))
    private List<OrdensCardapio> ordensCardapioList = new ArrayList<>();

    public Ordem() {
    }

    public Ordem(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addOrdensCardapio(OrdensCardapio ordensCardapio){
        ordensCardapio.setOrdem(this);
        this.ordensCardapioList.add(ordensCardapio);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<OrdensCardapio> getOrdensCardapioList() {
        return ordensCardapioList;
    }

    public void setOrdensCardapioList(List<OrdensCardapio> ordensCardapioList) {
        this.ordensCardapioList = ordensCardapioList;
    }

    @Override
    public String toString() {
        return "Ordem{ id: " + getId() + ", valorTotal: " + getValorTotal() + ", Data de Criação: " + getDataDeCriacao() + ", cliente: " + cliente + ", ordens: " + getOrdensCardapioList() + "}";
    }
}