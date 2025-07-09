package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    //@Autowired Annotations para Injeção de dependência
    private MissoesRepository missaoRepository;

    //Injeção de dependência
    public MissoesService (MissoesRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    //Listar todos as missões
    public List<MissoesModel> listarMissoes () {
        return missaoRepository.findAll();
    }


}
