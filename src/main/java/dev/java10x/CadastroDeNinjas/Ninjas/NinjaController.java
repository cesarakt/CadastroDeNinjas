package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    //Injeção de dependência do NinjaService
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

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
    public List<NinjaModel> mostrarTodosNinjas() {
        return ninjaService.listarNinjas();
    }

    //Mostrar todos os ninjas (READ)

    @GetMapping("/listarID")
    public NinjaModel mostrarNinjaPorId () {
        return ninjaService.listarNinjas();
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