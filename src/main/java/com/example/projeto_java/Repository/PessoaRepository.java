package com.example.projeto_java.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projeto_java.Model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> { //long é o tipo da chave primaria

    List<Pessoa> findByAtivo(boolean ativo);  //adicionado método findByAtivo , faz a pesquisa das pessoas ativas
}
