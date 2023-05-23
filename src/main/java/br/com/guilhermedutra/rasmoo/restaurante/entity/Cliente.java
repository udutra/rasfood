package br.com.guilhermedutra.rasmoo.restaurante.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private String cpf;
    private String nome;

    private String sobreNome;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecoList = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String cpf, String nome, String sobreNome) {
        this.cpf = cpf;
        this.nome = nome;
        this.sobreNome = sobreNome;
    }

    public void addEndereco(Endereco endereco){
        endereco.setCliente(this);
        this.enderecoList.add(endereco);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    @Override
    public String toString() {
        return "cpf: " + getCpf() + ", nome: " + getNome() + ", sobrenome: " + getSobreNome() + " , endereço: " + getEnderecoList();
    }
}