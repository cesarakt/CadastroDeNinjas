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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }

    //Procurar ninjas por ID (READ)
    @GetMapping("/listar")
    public List<NinjaModel> mostrarTodosNinjas() {
        return ninjaService.listarNinjas();
    }

    //Mostrar todos os ninjas (READ)
    //PathVariable para utilizar como parâmetros de requisições
    @GetMapping("/listar/{id}")
    public NinjaModel mostrarNinjaPorId (@PathVariable Long id) {
        return ninjaService.listarNinjaById(id);
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId () {
        return "Ninja atualizado";
    }

    //Deletar um ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorID (@PathVariable Long id) {
        ninjaService.deletarNinjaById(id);
    }
}