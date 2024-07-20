package com.mari.bibliotecamari.Controller;

import java.util.List
import com.mari.bibliotecamari.Entity.Usuario_externo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*;
import com.mari.bibliotecamari.DTO.UsuarioExternoDTO
import com.mari.bibliotecamari.Service.UsuarioExternoService
import com.mari.bibliotecamari.Mapper.UsuarioexternoMapper

public class UsuarioexternoController {
    private final UsuarioexternoService UsuarioexternoService;

    @GetMapping(value = "/")
    public List<ReadUsuarioexternoDto> getAll(){
        List<Usuarioexterno> listUsuarioexterno =UsuarioexternoService.findAll();
        List<ReadUsuarioexternoDto> listUsuarioexternoDto = new ArrayList<>();

        for (Usuarioexterno usuarioexterno : listUsuarioexterno){
            listUsuarioexternoDto.add(new ReadUsuarioexternoDto(
                    usuarioexterno.getcod_usuario(),
                    usuarioexterno.getnome(),
                    usuarioexterno.getendereco(),
                    usuarioexterno.gettelefone(),
                    usuarioexterno.getdocumento(),
                    usuarioexterno.getvinculo(),
                    usuarioexterno.getcod_circulacao()

            ));
        }

        return listUsuarioexternoDto;
    }

    @PutMapping("/")
    public ReadUsuarioexternoDto createUsuarioexterno(@RequestBody CreateUsuarioexternoDto dto){
        try {
            Usuarioexterno usuarioexterno = UsuarioexternoService.create(dto);

            return new ReadUsuarioexternoDto(
                    usuarioexterno.getcod_usuario(),
                    usuarioexterno.getnome(),
                    usuarioexterno.getendereco(),
                    usuarioexterno.gettelefone(),
                    usuarioexterno.getdocumento(),
                    usuarioexterno.getvinculo(),
                    usuarioexterno.getcod_circulacao()

            );
        } catch(Exception ex) {
            System.out.print(ex);
            return null;
        }
    }
}
