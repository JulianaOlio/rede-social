package br.com.fiap.api.rede_social.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String conteudo;

    @ElementCollection
    private List<String> tags;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Post(Long id, String titulo, String conteudo, List<String> tags, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.tags = tags;
        this.usuario = usuario;
    }
    public Post() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(titulo, post.titulo) && Objects.equals(conteudo, post.conteudo) && Objects.equals(tags, post.tags) && Objects.equals(usuario, post.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, conteudo, tags, usuario);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", tags=" + tags +
                ", usuario=" + usuario +
                '}';
    }
}
