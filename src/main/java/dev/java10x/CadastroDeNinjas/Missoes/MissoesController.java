package dev.java10x.CadastroDeNinjas.Missoes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {
    //Injeção de dependência do NinjaService
    private final MissoesService missaoService;

    public MissoesController(MissoesService missaoService) {
        this.missaoService = missaoService;
    }

    @GetMapping("/listar")
    public List<MissoesDTO> getMissoes () {
        return missaoService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesDTO getMissoesPorId (@PathVariable long id) {
        return missaoService.listarMissoesById(id);
    }

    @PostMapping("/criar")
    public MissoesDTO criarMissao (@RequestBody MissoesDTO missoes) {
        return missaoService.criarMissoes(missoes);
    }

    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissao (@PathVariable long id,@RequestBody MissoesDTO missao) {
        return missaoService.atualizarMissao(id,missao);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId (@PathVariable long id) {
        missaoService.deletarMissoes(id);
    }

}
