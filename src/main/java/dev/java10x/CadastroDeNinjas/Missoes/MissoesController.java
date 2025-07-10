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

    @GetMapping("/listar/{id}")
    public MissoesModel getMissoesPorId (@PathVariable long id) {
        return missaoService.listarMissoesById(id);
    }

    @PostMapping("/criar")
    public MissoesModel criarMissao (@RequestBody MissoesModel missoes) {
        return missaoService.criarMissoes(missoes);
    }

    @PutMapping("/alterar/{id}")
    public MissoesModel alterarMissao (@PathVariable long id,@RequestBody MissoesModel missao) {
        return missaoService.atualizarMissao(id,missao);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId (@PathVariable long id) {
        missaoService.deletarMissoes(id);
    }

}
