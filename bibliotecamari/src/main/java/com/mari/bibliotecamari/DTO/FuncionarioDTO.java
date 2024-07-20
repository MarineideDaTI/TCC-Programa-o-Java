package projeto.Mari.Biblioteca.dto;

public record FuncionarioDTO(
        Long codUsuario,
        String nome,
        String documento,
        String endereco,
        String telefone,
        Integer codSetor,
        Integer codCirculacao
){
}