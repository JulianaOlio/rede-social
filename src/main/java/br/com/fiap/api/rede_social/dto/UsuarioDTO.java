package br.com.fiap.api.rede_social.dto;

public record UsuarioDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        String senha
) {
}
