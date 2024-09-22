package br.com.fiap.api.rede_social.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "O nome não pode estar em branco.")
    String nome;

    @Email(message = "E-mail inválido.")
    String email;

    String telefone;
    String senha;

    @OneToMany(mappedBy = "usuario")
    private List<Post> postagens;

    public Usuario(Long id, String nome, String email, String telefone, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.postagens = postagens;
    }
    public Usuario() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "O nome não pode estar em branco.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome não pode estar em branco.") String nome) {
        this.nome = nome;
    }

    public @Email(message = "E-mail inválido.") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "E-mail inválido.") String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Post> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Post> postagens) {
        this.postagens = postagens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(telefone, usuario.telefone) && Objects.equals(senha, usuario.senha) && Objects.equals(postagens, usuario.postagens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, telefone, senha, postagens);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", senha='" + senha + '\'' +
                ", postagens=" + postagens +
                '}';
    }
}