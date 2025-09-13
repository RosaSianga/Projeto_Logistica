package br.com.senai.entregas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Getters e Setter do Lombok
@Getter
@Setter

//Construtor do Lombok
@NoArgsConstructor //Obrigatório ter o construtor para criar o objeto vazio e ser populado após o retorno do banco
@AllArgsConstructor //Não é obrigatório, porém ele informa tudo no construtor

//JPA
@Entity // Entity informa que a classe é uma tabela
@Table(name = "tipo_usuario") //Table permite que vc configure a tabela

public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_usuario_id", nullable = false)
    private Integer tipoUsuarioID;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

}
