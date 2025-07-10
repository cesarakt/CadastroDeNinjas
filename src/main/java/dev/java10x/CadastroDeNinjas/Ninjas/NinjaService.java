package dev.java10x.CadastroDeNinjas.Ninjas;

import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    //@Autowired Annotations para Injeção de dependência
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    //Injeção de dependência
    public NinjaService (NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os ninjas
    public List<NinjaModel> listarNinjas () {
        return ninjaRepository.findAll();
    }

    //Listar um ninja por id
    public NinjaModel listarNinjaById (long id) {
        Optional<NinjaModel> ninjaById = ninjaRepository.findById(id);
        return ninjaById.orElse(null);
    }

    //Criar um novo ninja
    //Utiliza o DTO com o Mapper para realizar mais uma camada de proteção de dados
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    //Atualizar o ninja
    public NinjaModel atualizarNinja(long id, NinjaModel ninja) {
         if (ninjaRepository.existsById(id)) {
             ninja.setId(id);
             return ninjaRepository.save(ninja);
         }
         return ninja;
    }

    //Deletar um ninja por id
    public void deletarNinjaById(long id) {
        ninjaRepository.deleteById(id);
    }
}