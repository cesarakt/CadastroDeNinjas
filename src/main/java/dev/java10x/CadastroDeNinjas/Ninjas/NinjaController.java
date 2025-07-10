package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    //Injeção de dependência do NinjaService
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/helloworld")
    public String helloWorld () {
        return "Hello, World!";
    }

    //Adicionar ninjas (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {

        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: "+ novoNinja.getNome() + " (ID) : " + novoNinja.getId());
    }

    //Procurar ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> mostrarTodosNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Mostrar todos os ninjas (READ)
    //PathVariable para utilizar como parâmetros de requisições
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarNinjaPorId (@PathVariable long id) {
        NinjaDTO ninjaEncontrado = ninjaService.listarNinjaById(id);
        if (ninjaEncontrado != null) {
            return ResponseEntity.ok(ninjaEncontrado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O ninja com o ID "+id+" não foi encontrado.");
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId (@PathVariable long id,@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaAtualizado = ninjaService.atualizarNinja(id,ninja);

        if (ninjaAtualizado != null) {
            return ResponseEntity.ok(ninjaAtualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o ID "+id+" não foi encontrado.");
        }
    }

    //Deletar um ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorID (@PathVariable long id) {
        if (ninjaService.listarNinjaById(id) != null) {
            ninjaService.deletarNinjaById(id);
            return ResponseEntity.ok("Ninja com o ID "+id+" deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id "+ id+" não encontrado.");
        }

    }
}