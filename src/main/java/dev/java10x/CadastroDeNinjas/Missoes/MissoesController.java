package dev.java10x.CadastroDeNinjas.Missoes;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @GetMapping("/missoes")
    public String getMissoes () {
        return "todas as missões";
    }

    @GetMapping("/missoesID")
    public String getMissoesPorId () {
        return "Missão por ID";
    }

    @PostMapping("/criar")
    public String criarMissao () {
        return "Missão criada com sucesso.";
    }

    @PutMapping("/alterar")
    public String alterarMissao () {
        return "Missão alterada com sucesso.";
    }

    @DeleteMapping("/deletar")
    public String deletarMissaoPorId () {
        return "missão deletada.";
    }

}
