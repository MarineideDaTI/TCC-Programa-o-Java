package projeto.Mari.Biblioteca.dto;

public record UsuarioExternoDTO(
        Long codUsuario,
        String nome,
        String endereco,
        String documento,
        String vinculo,
        Integer codCirculacao,
        String telefone
) {
}
