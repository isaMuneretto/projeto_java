package com.example.projeto_java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.projeto_java.Model.Cadastro;
import com.example.projeto_java.Repository.CadastroRepository;

@Controller
public class CadastroController {
    
    @Autowired
    private CadastroRepository pr;

    @GetMapping("/cadastro/criar")
    public String criar(){

        return "cadastro/criar";
    }

    @PostMapping("/cadastro/criar")
    public String criar(Cadastro cadastro){

        pr.save(cadastro);
        return "/cadastro/criar";
    }

   

}
    

