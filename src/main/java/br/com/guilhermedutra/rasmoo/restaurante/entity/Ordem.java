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

    @OneToMany(mappedBy = "ordem")
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

    @Override
    public String toString() {
        return "Ordem{ id: " + getId() + ", valorTotal: " + getValorTotal() + ", Data de Criação: " + getDataDeCriacao() + ", cliente: " + cliente + "}";
    }
}