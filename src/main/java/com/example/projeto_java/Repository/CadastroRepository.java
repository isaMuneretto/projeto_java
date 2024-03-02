package com.example.projeto_java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projeto_java.Model.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long>{
    
}
