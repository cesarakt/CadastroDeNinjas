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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);
    }

    //Procurar ninjas por ID (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> mostrarTodosNinjas() {
        return ninjaService.listarNinjas();
    }

    //Mostrar todos os ninjas (READ)
    //PathVariable para utilizar como parâmetros de requisições
    @GetMapping("/listar/{id}")
    public NinjaDTO mostrarNinjaPorId (@PathVariable long id) {
        return ninjaService.listarNinjaById(id);
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjaPorId (@PathVariable long id,@RequestBody NinjaDTO ninja) {
        return ninjaService.atualizarNinja(id,ninja);
    }

    //Deletar um ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorID (@PathVariable long id) {
        ninjaService.deletarNinjaById(id);
    }
}