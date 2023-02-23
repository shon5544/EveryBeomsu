package beomside.everybeomsu.service;

import beomside.everybeomsu.domain.Post;
import beomside.everybeomsu.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private PostRepository postRepository;

    @Transactional
    public void writePost(Post post) {
        postRepository.save(post);
    }
}
