package br.com.fiap.api.rede_social.dto;

import br.com.fiap.api.rede_social.entity.Usuario;

import java.util.List;

public record PostDTO<Usuario>(
        Long id,
        String titulo,
        String conteudo,
        List<String> tags,
        Usuario usuario
) {
}
