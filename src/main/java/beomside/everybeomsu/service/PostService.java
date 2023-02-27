package beomside.everybeomsu.service;

import beomside.everybeomsu.domain.Post;
import beomside.everybeomsu.dto.res.board.PostBoardResDto;
import beomside.everybeomsu.dto.res.home.PostHomeResDto;
import beomside.everybeomsu.repository.PostRepository;
import beomside.everybeomsu.repository.jpa.PostJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public void createPost(Post post) {
        postRepository.save(post);
    }

    @Transactional
    public void plusLikes(Post post) {
        post.plusLike();
    }

    @Transactional
    public void cancelLikes(Post post) {
        post.minusLike();
    }

    @Transactional
    public void plusScraps(Post post) {
        post.plusScrap();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 포스트가 없습니다."));
    }

    public List<PostHomeResDto> getFourPost(String boardName) {
        return postJpaRepository.findPostPageByName(boardName, 0, 4).stream()
                .map(p -> new PostHomeResDto(p.getTitle(), p.getPostedDate(), p.getBoard().getName()))
                .collect(Collectors.toList());
    }

    public List<PostBoardResDto> getPostPageByName(String boardName, int page) {
        return postJpaRepository.findPostPageByName(boardName, page, 20).stream()
                .map(p -> PostBoardResDto.builder()
                        .title(p.getTitle())
                        .summary(p.getContent().length() > 50 ?
                                p.getContent().substring(0, 50) + ".." :
                                p.getContent())
                        .posted_date(p.getPostedDate())
                        .likes_cnt(p.getLikesCnt())
                        .comment_cnt(p.getCommentsCnt())
                        .build())
                .collect(Collectors.toList());
    }

    public List<PostBoardResDto> getPostPageById(String boardName, int page) {
        return postJpaRepository.findPostPageByName(boardName, page, 20).stream()
                .map(p -> PostBoardResDto.builder()
                        .title(p.getTitle())
                        .summary(p.getContent().substring(0, 50) + "..")
                        .posted_date(p.getPostedDate())
                        .likes_cnt(p.getLikesCnt())
                        .comment_cnt(p.getCommentsCnt())
                        .build())
                .collect(Collectors.toList());
    }
}
