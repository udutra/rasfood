package br.com.guilhermedutra.rasmoo.restaurante.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cardapio")
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String descricao;
    @ManyToOne
    private Categoria categoria;
    private boolean disponivel;
    private BigDecimal valor;

    @Column(name = "data_de_registro")
    private LocalDateTime dataDeRegistro = LocalDateTime.now();

    public Cardapio() {}

    public Cardapio(String nome, String descricao, boolean disponivel, BigDecimal valor, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.disponivel = disponivel;
        this.valor = valor;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(LocalDateTime dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "id: " + getId() + ", nome: " + getNome() + ", descricao: " + getDescricao() + ", disponivel: " + isDisponivel() +
                ", Categoria: " + getCategoria().getNome() + ", valor: " + getValor() + ", dataDeRegistro: " + getDataDeRegistro();
    }
}
