package projeto.Mari.Biblioteca.dto;

public record AtrasoDTO(
        Long codAtraso,
        Integer codCirculacao,
        Long codUsuario,
        Integer diasAtraso,
        Integer multaDia,
        String valorMulta
){
}