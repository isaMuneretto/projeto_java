package com.example.projeto_java.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.projeto_java.Model.Cargo;
import com.example.projeto_java.Model.Pessoa;
import com.example.projeto_java.Repository.CargoRepository;
import com.example.projeto_java.Repository.PessoaRepository;

@Controller
public class PessoaController {

    @Autowired
    private PessoaRepository pr;

    @Autowired
    private CargoRepository cr;

    @GetMapping("/pessoa/criar")
    public String criar(){

        return "pessoa/criar";
    }

    @PostMapping("/pessoa/criar")
    public String criar(Pessoa pessoa){

        Cargo cargo = cr.getReferenceById(Long.parseLong("1"));
        Cargo cargo2 = cr.getReferenceById(Long.parseLong("2"));
        pessoa.addCargos(cargo); 
        pessoa.addCargos(cargo2); 

        pr.save(pessoa);
        return "redirect:/pessoa/listar";
    }

    //UPDATE pessoa SET ativo = 0 WHERE id=3  código manual SQL
    @GetMapping("/pessoa/listar")
    public ModelAndView listar(@RequestParam("visualizacao") Optional<String> visualizacao){
        ModelAndView view = new ModelAndView("pessoa/listar");
        
        String valor = visualizacao.orElse("ativo");
        List<Pessoa> pessoas = pr.findByAtivo(valor == "ativo"); //quando criamos métodos nós temos que colocar no repositorio 
        //List<Pessoa> pessoas = pr.findAll(); //armazena na lista Pessoa
        Long quantidadePessoas = pr.count();

        view.addObject("pessoas", pessoas);
        view.addObject("qtd", quantidadePessoas);
        return view;
    }

    @GetMapping("/pessoa/alterar/{id}")
    public ModelAndView alterar(@PathVariable Long id){  //a PathCariable vai conseguir pegar a variavel e alterar pegando o id
        ModelAndView view = new ModelAndView("pessoa/alterar");
        Optional<Pessoa> pessoa = pr.findById(id);

        view.addObject("pessoa", pessoa);
        view.addObject("id", id);

        return view;
    }

    @PostMapping("/pessoa/alterar/{id}")
    public String alterar(@PathVariable Long id, Pessoa pessoa){
        this.pr.save(pessoa);

        return "redirect:/pessoa/listar";
    }

    @GetMapping("/pessoa/deletar/{id}")
    public String deletar(@PathVariable Long id){
        Optional<Pessoa> pessoa = this.pr.findById(id); //optinal não da nenhum erro se ele não achar a pessoa
        Pessoa pessoaModel = pessoa.get();

        pessoaModel.setAtivo(false);

        pr.save(pessoaModel);

        return "redirect:/pessoa/listar";
    }

    @GetMapping("/pessoa/recuperar/{id}")
    public String recuperar(@PathVariable Long id){
        Optional<Pessoa> pessoa = this.pr.findById(id); //optinal não da nenhum erro se ele não achar a pessoa
        Pessoa pessoaModel = pessoa.get();

        pessoaModel.setAtivo(true);

        pr.save(pessoaModel);

        return "redirect:/pessoa/listar";
    }
}
