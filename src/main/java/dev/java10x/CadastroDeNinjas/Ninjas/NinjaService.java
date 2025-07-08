package dev.java10x.CadastroDeNinjas.Ninjas;

import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    //@Autowired Annotations para Injeção de dependência
    private NinjaRepository ninjaRepository;

    //Injeção de dependência
    public NinjaService (NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os ninjas
    public List<NinjaModel> listarNinjas () {
        return ninjaRepository.findAll();
    }

    //Listar um ninja por id
    public NinjaModel listarNinjaById (Long id) {
        Optional<NinjaModel> ninjaById = ninjaRepository.findById(id);
        return ninjaById.orElse(null);
    }

    //Criar um novo ninja
    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    //Deletar um ninja por id
    public void deletarNinjaById(Long id) {
        ninjaRepository.deleteById(id);
    }
}