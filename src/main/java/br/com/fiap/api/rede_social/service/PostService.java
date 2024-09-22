package br.com.fiap.api.rede_social.service;

import br.com.fiap.api.rede_social.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


}
