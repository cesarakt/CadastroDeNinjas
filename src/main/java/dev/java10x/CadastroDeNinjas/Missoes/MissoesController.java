package dev.java10x.CadastroDeNinjas.Missoes;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {
    //Injeção de dependência do NinjaService
    private MissoesService missaoService;

    public MissoesController(MissoesService missaoService) {
        this.missaoService = missaoService;
    }

    @GetMapping("/listar")
    public List<MissoesModel> getMissoes () {
        return missaoService.listarMissoes();
    }

    @GetMapping("/listarID")
    public String getMissoesPorId () {
        return "Missão por ID";
    }

    @PostMapping("/criar")
    public MissoesModel criarMissao (@RequestBody MissoesModel missoes) {
        return missaoService.criarMissoes(missoes);
    }

    @PutMapping("/alterarID")
    public String alterarMissao () {
        return "Missão alterada com sucesso.";
    }

    @DeleteMapping("/deletarID")
    public String deletarMissaoPorId () {
        return "missão deletada.";
    }

}
