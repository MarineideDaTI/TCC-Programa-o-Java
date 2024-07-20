package com.mari.bibliotecamari.DTO;

public record AtrasoDTO(
        Integer cod_atraso;
        Integer cod_circulacao;
        Integer cod_usuario;
        Integer dias_atraso;
        Integer multa_dia;
        Integer valor_multa
){
}

