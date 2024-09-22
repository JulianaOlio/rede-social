package br.com.fiap.api.rede_social.controller;

import br.com.fiap.api.rede_social.dto.UsuarioDTO;
import br.com.fiap.api.rede_social.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioDTO>> findAll(
            @PageableDefault(size = 15,page = 0,  sort = "nome")
            Pageable pageable) {
        Page<UsuarioDTO> usuariosDTO = usuarioService.findAll(pageable);
        return ResponseEntity.ok(usuariosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        UsuarioDTO usuarioDTO = usuarioService.findById(id);
        return ResponseEntity.ok(usuarioDTO);
    }
    @GetMapping("/{Email}")
    public ResponseEntity<UsuarioDTO> findByEmail(@PathVariable String Email) {
        UsuarioDTO usuarioDTO = usuarioService.findByEmail(Email);
        return ResponseEntity.ok(usuarioDTO);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> save(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioDTOSaved = usuarioService.save(usuarioDTO);
        return new ResponseEntity<>(usuarioDTOSaved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioDTOUpdated = usuarioService.update(id, usuarioDTO);
        return ResponseEntity.ok(usuarioDTOUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDTO> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
