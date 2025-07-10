package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Listar missão por id
    public MissoesModel listarMissoesById (Long id) {
        Optional<MissoesModel> missaoById = missaoRepository.findById(id);
        return missaoById.orElse(null);
    }

    //Criar missão
    public MissoesModel criarMissoes (MissoesModel missoes) {
        return missaoRepository.save(missoes);
    }

    //Atualizar o missao
    public MissoesModel atualizarMissao(Long id, MissoesModel missao) {
        if (missaoRepository.existsById(id)) {
            missao.setId(id);
            return missaoRepository.save(missao);
        }
        return missao;
    }

    //Deletar missão
    public void deletarMissoes (Long id) {
        missaoRepository.deleteById(id);
    }


}
