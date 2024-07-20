package com.mari.bibliotecamari.Entity;

import javax.persistence.*;

@Entity
@Table(name = "alunos")
public class Alunos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_usuario;
    private String nome;
    private String documento;
    private String endereco;
    private String telefone;
    private String cod_curso;
    private String turma;
    private String periodo;
    private String cod_circulacao

    // getters e setters
}