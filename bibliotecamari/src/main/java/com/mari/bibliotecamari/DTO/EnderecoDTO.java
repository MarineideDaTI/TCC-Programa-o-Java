package projeto.Mari.Biblioteca.dto;

public record EnderecoDTO(
        Long codEndereco,
        Long codUsuario,
        String rua,
        String numero,
        String bairro,
        String cidade,
        String estado,
        String cep
) {
}


