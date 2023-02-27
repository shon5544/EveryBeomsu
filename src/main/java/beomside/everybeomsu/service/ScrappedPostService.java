package beomside.everybeomsu.service;

import beomside.everybeomsu.domain.Post;
import beomside.everybeomsu.domain.ScrappedPost;
import beomside.everybeomsu.dto.res.ScrappedPost.MemberScrappedPostResDto;
import beomside.everybeomsu.dto.res.ScrappedPost.PostScrappedPostResDto;
import beomside.everybeomsu.dto.res.ScrappedPost.ScrappedPostResDto;
import beomside.everybeomsu.repository.ScrappedPostRepository;
import beomside.everybeomsu.repository.jpa.ScrappedPostJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScrappedPostService {

    private final ScrappedPostRepository scrappedPostRepository;
    private final ScrappedPostJpaRepository scrappedPostJpaRepository;

    @Transactional
    public void save(ScrappedPost scrappedPost) {
        scrappedPostRepository.save(scrappedPost);
    }

    public ScrappedPost getScrappedPostById(Long id) {
        return scrappedPostRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 프스트가 없습니다."));
    }

    public List<ScrappedPostResDto> getScrappedPostByMemberId(Long memberId) {

        return scrappedPostJpaRepository.findScrappedPostByMemberId(memberId).stream()
                .map(s -> ScrappedPostResDto.builder()
                        .scrappedPostId(s.getScrappedPostId())
                        .member(createMemberScrappedPostResDto(s.getMember().getNickname()))
                        .post(createPostScrappedPostResDto(s.getPost()))
                        .build())
                .collect(Collectors.toList());
    }

    private MemberScrappedPostResDto createMemberScrappedPostResDto(String nickname) {
        return MemberScrappedPostResDto.builder()
                .nickname(nickname)
                .build();
    }

    private PostScrappedPostResDto createPostScrappedPostResDto(Post post) {
        return PostScrappedPostResDto.builder()
                .title(post.getTitle())
                .content(post.getContent().length() > 50 ?
                        post.getContent().substring(0, 50) :
                        post.getContent())
                .postId(post.getPostId())
                .build();
    }
}
