package dev.java10x.CadastroDeNinjas.Ninjas;

import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public NinjaModel listarNinjaById (Long id) {
        if (!(ninjaRepository.existsById(id))) {
          return null;
        }
        return ninjaRepository.findById(Long id);
    }

}