package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome_ninja")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name= "idade_ninja")
    private int idade;

    @Column(name = "rank")
    private String rank;

    //Muitos ninjas para uma missão
    @ManyToOne
    @JoinColumn(name = "missao_id") // Chave estrangeira
    private MissoesModel missao;

}
