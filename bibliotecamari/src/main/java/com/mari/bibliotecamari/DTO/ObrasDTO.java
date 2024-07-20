package projeto.Mari.Biblioteca.dto;

public record ObrasDTO(
        Long isbn,
        String titulo,
        String subtitulo,
        Integer volume,
        String autoria,
        String imprenta,
        Integer ano,
        String serie,
        String colecao,
        String categoria,
        String exemplar,
        String estante,
        Integer codCurso
) {
}
