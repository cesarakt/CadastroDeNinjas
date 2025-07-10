package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {
    //Injeção de dependência do NinjaService
    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    //Procurar ninjas (READ)
    @GetMapping("/listar")
    public String mostrarTodosNinjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas";
    }

    @GetMapping("/listar/{id}")
    public String mostrarNinjaPorId (@PathVariable long id, Model model) {
        NinjaDTO ninjaEncontrado = ninjaService.listarNinjaById(id);
        if (ninjaEncontrado != null) {
            model.addAttribute("ninja", ninjaEncontrado);
            return "detalhesNinja";
        } else {
            model.addAttribute("mensagem", "Ninja não encontrado");
            return "listarNinjas";
        }
    }

    //Deletar um ninja (DELETE)
    @GetMapping("/deletar/{id}")
    public String deletarNinjaPorID (@PathVariable long id) {
        ninjaService.deletarNinjaById(id);
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarNinja";
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.criarNinja(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado com sucesso!");
        return "redirect:/ninjas/ui/listar";
    }
}
