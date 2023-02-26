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
            postReqDto.set_anonymous(true);
            postReqDto.set_question(false);

            PostReqDto postReqDto2 = new PostReqDto();
            postReqDto2.setTitle("테스트 제목2: 자유");
            postReqDto2.setContent("테스트테스트테스트테스트: 자유");
            postReqDto2.set_anonymous(true);
            postReqDto2.set_question(false);

            PostReqDto postReqDto3 = new PostReqDto();
            postReqDto3.setTitle("테스트 제목3: 자유");
            postReqDto3.setContent("테스트테스트테스트테스트: 자유");
            postReqDto3.set_anonymous(true);
            postReqDto3.set_question(false);

            PostReqDto postReqDto4 = new PostReqDto();
            postReqDto4.setTitle("테스트 제목4: 자유");
            postReqDto4.setContent("테스트테스트테스트테스트: 자유");
            postReqDto4.set_anonymous(true);
            postReqDto4.set_question(false);

            PostReqDto postReqDto5 = new PostReqDto();
            postReqDto5.setTitle("테스트 제목: 새내기");
            postReqDto5.setContent("테스트테스트테스트테스트: 새내기");
            postReqDto5.set_anonymous(true);
            postReqDto5.set_question(false);

            PostReqDto postReqDto6 = new PostReqDto();
            postReqDto6.setTitle("테스트 제목2: 새내기");
            postReqDto6.setContent("테스트테스트테스트테스트: 새내기");
            postReqDto6.set_anonymous(true);
            postReqDto6.set_question(false);

            PostReqDto postReqDto7 = new PostReqDto();
            postReqDto7.setTitle("테스트 제목3: 새내기");
            postReqDto7.setContent("테스트테스트테스트테스트: 새내기");
            postReqDto7.set_anonymous(true);
            postReqDto7.set_question(false);

            PostReqDto postReqDto8 = new PostReqDto();
            postReqDto8.setTitle("테스트 제목4: 새내기");
            postReqDto8.setContent("테스트테스트테스트테스트: 새내기");
            postReqDto8.set_anonymous(true);
            postReqDto8.set_question(false);

            Post post1 = Post.builder()
                    .title(postReqDto.getTitle())
                    .content(postReqDto.getContent())
                    .scrapsCnt(0L)
                    .likesCnt(0L)
                    .commentsCnt(0L)
                    .photosCnt(0L)
                    .postedDate(LocalDateTime.now())
                    .isAnonymous(postReqDto.is_anonymous())
                    .isQuestion(postReqDto.is_question())
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
                    .postedDate(LocalDateTime.now())
                    .isAnonymous(postReqDto2.is_anonymous())
                    .isQuestion(postReqDto2.is_question())
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
                    .postedDate(LocalDateTime.now())
                    .isAnonymous(postReqDto3.is_anonymous())
                    .isQuestion(postReqDto3.is_question())
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
                    .postedDate(LocalDateTime.now())
                    .isAnonymous(postReqDto4.is_anonymous())
                    .isQuestion(postReqDto4.is_question())
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
                    .postedDate(LocalDateTime.now())
                    .isAnonymous(postReqDto5.is_anonymous())
                    .isQuestion(postReqDto5.is_question())
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
                    .postedDate(LocalDateTime.now())
                    .isAnonymous(postReqDto6.is_anonymous())
                    .isQuestion(postReqDto6.is_question())
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
                    .postedDate(LocalDateTime.now())
                    .isAnonymous(postReqDto7.is_anonymous())
                    .isQuestion(postReqDto7.is_question())
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
                    .postedDate(LocalDateTime.now())
                    .isAnonymous(postReqDto8.is_anonymous())
                    .isQuestion(postReqDto8.is_question())
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
