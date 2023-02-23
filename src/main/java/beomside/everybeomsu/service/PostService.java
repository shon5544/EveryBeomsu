package beomside.everybeomsu.service;

import beomside.everybeomsu.domain.Post;
import beomside.everybeomsu.dto.res.home.PostHomeResDto;
import beomside.everybeomsu.repository.PostRepository;
import beomside.everybeomsu.repository.jpa.PostJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final PostJpaRepository postJpaRepository;

    @Transactional
    public void writePost(Post post) {
        postRepository.save(post);
    }

    public List<PostHomeResDto> getPostWithPaging(String boardName) {
        return postJpaRepository.findPostByPaging(boardName).stream()
                .map(p -> new PostHomeResDto(p.getTitle(), p.getPostedDate(), p.getBoard().getName()))
                .collect(Collectors.toList());
    }
}
