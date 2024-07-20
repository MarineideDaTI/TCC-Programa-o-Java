package projeto.Mari.Biblioteca.dto;

import javax.xml.crypto.Data;

public record CirculacaoDTO(
        Integer codCirculacao,
        Long codUsuario,
        String tombo,
        Data emprestimo,
        Data devolucao,
        Long codAtraso
) {
}

