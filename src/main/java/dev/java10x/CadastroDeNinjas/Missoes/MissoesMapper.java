package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {
    public MissoesModel map (MissoesDTO missaoDTO) {
        MissoesModel missaoModel = new MissoesModel();
        missaoModel.setId(missaoDTO.getId());
        missaoModel.setNome(missaoDTO.getNome());
        missaoModel.setDificuldade(missaoDTO.getDificuldade());
        missaoModel.setNinjas(missaoDTO.getNinjas());

        return missaoModel;
    }

    public MissoesDTO map (MissoesModel missoesModel) {
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());
        missoesDTO.setNinjas(missoesModel.getNinjas());

        return missoesDTO;
    }
}
