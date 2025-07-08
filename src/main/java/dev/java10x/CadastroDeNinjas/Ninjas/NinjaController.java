package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/helloworld")
    public String helloWorld () {
        return "Hello, World!";
    }

    //Adicionar ninjas (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja Criado.";
    }

    //Procurar ninjas por ID (READ)
    @GetMapping("/listar")
    public String mostrarTodosNinjas() {
        return "Todos Ninjas.";
    }

    //Mostrar todos os ninjas (READ)

    @GetMapping("/listarID")
    public String mostrarNinjaPorId () {
        return "Ninja por id";
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId () {
        return "Ninja atualizado";
    }

    //Deletar um ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorID () {
        return "Ninja deletado.";
    }
}