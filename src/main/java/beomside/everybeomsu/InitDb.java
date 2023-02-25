package beomside.everybeomsu;

import beomside.everybeomsu.domain.Board;
import beomside.everybeomsu.domain.Member;
import beomside.everybeomsu.domain.Post;
import beomside.everybeomsu.dto.req.post.PostReqDto;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.init();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void init() {
            Member member = Member.builder()
                    .name("손범수")
                    .nickname("shon5544")
                    .loginId("sbs8239")
                    .loginPw("sbs32465169")
                    .build();
            Board free = Board.builder()
                    .name("free")
                    .build();
            Board neww = Board.builder()
                    .name("new")
                    .build();

            PostReqDto postReqDto = new PostReqDto();
            postReqDto.setTitle("테스트 제목: 자유");
            postReqDto.setContent("테스트테스트테스트테스트: 자유");
            postReqDto.setAnonymous(true);
            postReqDto.setQuestion(false);
            postReqDto.setPostedDate(LocalDateTime.now());

            PostReqDto postReqDto2 = new PostReqDto();
            postReqDto2.setTitle("테스트 제목2: 자유");
            postReqDto2.setContent("테스트테스트테스트테스트: 자유");
            postReqDto2.setAnonymous(true);
            postReqDto2.setQuestion(false);
            postReqDto2.setPostedDate(LocalDateTime.now());

            PostReqDto postReqDto3 = new PostReqDto();
            postReqDto3.setTitle("테스트 제목3: 자유");
            postReqDto3.setContent("테스트테스트테스트테스트: 자유");
            postReqDto3.setAnonymous(true);
            postReqDto3.setQuestion(false);
            postReqDto3.setPostedDate(LocalDateTime.now());

            PostReqDto postReqDto4 = new PostReqDto();
            postReqDto4.setTitle("테스트 제목4: 자유");
            postReqDto4.setContent("테스트테스트테스트테스트: 자유");
            postReqDto4.setAnonymous(true);
            postReqDto4.setQuestion(false);
            postReqDto4.setPostedDate(LocalDateTime.now());

            PostReqDto postReqDto5 = new PostReqDto();
            postReqDto5.setTitle("테스트 제목: 새내기");
            postReqDto5.setContent("테스트테스트테스트테스트: 새내기");
            postReqDto5.setAnonymous(true);
            postReqDto5.setQuestion(false);
            postReqDto5.setPostedDate(LocalDateTime.now());

            PostReqDto postReqDto6 = new PostReqDto();
            postReqDto6.setTitle("테스트 제목2: 새내기");
            postReqDto6.setContent("테스트테스트테스트테스트: 새내기");
            postReqDto6.setAnonymous(true);
            postReqDto6.setQuestion(false);
            postReqDto6.setPostedDate(LocalDateTime.now());

            PostReqDto postReqDto7 = new PostReqDto();
            postReqDto7.setTitle("테스트 제목3: 새내기");
            postReqDto7.setContent("테스트테스트테스트테스트: 새내기");
            postReqDto7.setAnonymous(true);
            postReqDto7.setQuestion(false);
            postReqDto7.setPostedDate(LocalDateTime.now());

            PostReqDto postReqDto8 = new PostReqDto();
            postReqDto8.setTitle("테스트 제목4: 새내기");
            postReqDto8.setContent("테스트테스트테스트테스트: 새내기");
            postReqDto8.setAnonymous(true);
            postReqDto8.setQuestion(false);
            postReqDto8.setPostedDate(LocalDateTime.now());

            Post post1 = Post.builder()
                    .title(postReqDto.getTitle())
                    .content(postReqDto.getContent())
                    .scrapsCnt(0L)
                    .likesCnt(0L)
                    .commentsCnt(0L)
                    .photosCnt(0L)
                    .postedDate(postReqDto.getPostedDate())
                    .isAnonymous(postReqDto.isAnonymous())
                    .isQuestion(postReqDto.isQuestion())
                    .member(member)
                    .board(free)
                    .build();

            Post post2 = Post.builder()
                    .title(postReqDto2.getTitle())
                    .content(postReqDto2.getContent())
                    .scrapsCnt(0L)
                    .likesCnt(0L)
                    .commentsCnt(0L)
                    .photosCnt(0L)
                    .postedDate(postReqDto2.getPostedDate())
                    .isAnonymous(postReqDto2.isAnonymous())
                    .isQuestion(postReqDto2.isQuestion())
                    .member(member)
                    .board(free)
                    .build();

            Post post3 = Post.builder()
                    .title(postReqDto3.getTitle())
                    .content(postReqDto3.getContent())
                    .scrapsCnt(0L)
                    .likesCnt(0L)
                    .commentsCnt(0L)
                    .photosCnt(0L)
                    .postedDate(postReqDto3.getPostedDate())
                    .isAnonymous(postReqDto3.isAnonymous())
                    .isQuestion(postReqDto3.isQuestion())
                    .member(member)
                    .board(free)
                    .build();

            Post post4 = Post.builder()
                    .title(postReqDto4.getTitle())
                    .content(postReqDto4.getContent())
                    .scrapsCnt(0L)
                    .likesCnt(0L)
                    .commentsCnt(0L)
                    .photosCnt(0L)
                    .postedDate(postReqDto4.getPostedDate())
                    .isAnonymous(postReqDto4.isAnonymous())
                    .isQuestion(postReqDto4.isQuestion())
                    .member(member)
                    .board(free)
                    .build();

            Post post5 = Post.builder()
                    .title(postReqDto5.getTitle())
                    .content(postReqDto5.getContent())
                    .scrapsCnt(0L)
                    .likesCnt(0L)
                    .commentsCnt(0L)
                    .photosCnt(0L)
                    .postedDate(postReqDto5.getPostedDate())
                    .isAnonymous(postReqDto5.isAnonymous())
                    .isQuestion(postReqDto5.isQuestion())
                    .member(member)
                    .board(neww)
                    .build();

            Post post6 = Post.builder()
                    .title(postReqDto6.getTitle())
                    .content(postReqDto6.getContent())
                    .scrapsCnt(0L)
                    .likesCnt(0L)
                    .commentsCnt(0L)
                    .photosCnt(0L)
                    .postedDate(postReqDto6.getPostedDate())
                    .isAnonymous(postReqDto6.isAnonymous())
                    .isQuestion(postReqDto6.isQuestion())
                    .member(member)
                    .board(neww)
                    .build();

            Post post7 = Post.builder()
                    .title(postReqDto7.getTitle())
                    .content(postReqDto7.getContent())
                    .scrapsCnt(0L)
                    .likesCnt(0L)
                    .commentsCnt(0L)
                    .photosCnt(0L)
                    .postedDate(postReqDto7.getPostedDate())
                    .isAnonymous(postReqDto7.isAnonymous())
                    .isQuestion(postReqDto7.isQuestion())
                    .member(member)
                    .board(neww)
                    .build();

            Post post8 = Post.builder()
                    .title(postReqDto8.getTitle())
                    .content(postReqDto8.getContent())
                    .scrapsCnt(0L)
                    .likesCnt(0L)
                    .commentsCnt(0L)
                    .photosCnt(0L)
                    .postedDate(postReqDto8.getPostedDate())
                    .isAnonymous(postReqDto8.isAnonymous())
                    .isQuestion(postReqDto8.isQuestion())
                    .member(member)
                    .board(neww)
                    .build();

            em.persist(member);
            em.persist(free);
            em.persist(neww);

            em.persist(post1);
            em.persist(post2);
            em.persist(post3);
            em.persist(post4);
            em.persist(post5);
            em.persist(post6);
            em.persist(post7);
            em.persist(post8);
        }
    }
}
