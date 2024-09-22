package br.com.fiap.api.rede_social.repository;

import br.com.fiap.api.rede_social.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
