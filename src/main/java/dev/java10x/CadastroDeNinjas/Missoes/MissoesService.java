package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    //@Autowired Annotations para Injeção de dependência
    private MissoesRepository missaoRepository;
    private MissoesMapper missoesMapper;

    //Injeção de dependência
    public MissoesService (MissoesRepository missaoRepository, MissoesMapper missoesMapper) {
        this.missaoRepository = missaoRepository;
        this.missoesMapper = missoesMapper;
    }

    //Listar todos as missões
    public List<MissoesDTO> listarMissoes () {
        List<MissoesModel> missoes = missaoRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //Listar missão por id
    public MissoesDTO listarMissoesById (long id) {
        Optional<MissoesModel> missoesById = missaoRepository.findById(id);
        return missoesById.map(missoesMapper::map).orElse(null);
    }

    //Criar missão
    public MissoesDTO criarMissoes (MissoesDTO missoes) {
        MissoesModel missoesModel = missoesMapper.map(missoes);
        missoesModel = missaoRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);
    }

    //Atualizar o missao
    public MissoesDTO atualizarMissao(long id, MissoesDTO missaoDTO) {
        Optional<MissoesModel> missaoExistente = missaoRepository.findById(id);
        if (missaoExistente.isPresent()) {
            MissoesModel missaoAtualizada = missoesMapper.map(missaoDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missaoRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }

    //Deletar missão
    public void deletarMissoes (Long id) {
        missaoRepository.deleteById(id);
    }


}
