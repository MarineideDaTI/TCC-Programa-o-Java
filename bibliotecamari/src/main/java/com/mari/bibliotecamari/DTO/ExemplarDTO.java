package projeto.Mari.Biblioteca.dto;

public record ExemplarDTO(
        Long isbn,
        String tombo,
        String edicao,
        String paginas,
        String localizacao,
        Integer quantidade,
        Integer codCirculacao
) {
}


