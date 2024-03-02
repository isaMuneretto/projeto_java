package com.example.projeto_java.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cadastro")
public class Cadastro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "codigo", nullable = false, length = 50)
    private Integer codigo;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "preco", nullable = false, length = 50)
    private String preco;

    @Column(name = "categoria", nullable = false, length = 150)
    private String categoria;

    public Integer getCodigo(){
        return this.codigo;
    }

    public void setCodigo(Integer codigo){
        this.codigo = codigo;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getPreco(){
        return this.preco;
    }

    public void setPreco(String preco){
        this.preco = preco;
    }

    public String getCategoria(){
        return this.categoria;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

}
