package beomside.everybeomsu;

import beomside.everybeomsu.domain.Board;
import beomside.everybeomsu.domain.Member;
import beomside.everybeomsu.domain.Post;
import beomside.everybeomsu.dto.req.write.PostWriteReqDto;
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

            PostWriteReqDto postWriteReqDto = new PostWriteReqDto();
            postWriteReqDto.setTitle("테스트 제목: 자유");
            postWriteReqDto.setContent("테스트테스트테스트테스트: 자유");
            postWriteReqDto.setAnonymous(true);
            postWriteReqDto.setQuestion(false);
            postWriteReqDto.setPostedDate(LocalDateTime.now());

            PostWriteReqDto postWriteReqDto2 = new PostWriteReqDto();
            postWriteReqDto2.setTitle("테스트 제목2: 자유");
            postWriteReqDto2.setContent("테스트테스트테스트테스트: 자유");
            postWriteReqDto2.setAnonymous(true);
            postWriteReqDto2.setQuestion(false);
            postWriteReqDto2.setPostedDate(LocalDateTime.now());

            PostWriteReqDto postWriteReqDto3 = new PostWriteReqDto();
            postWriteReqDto3.setTitle("테스트 제목3: 자유");
            postWriteReqDto3.setContent("테스트테스트테스트테스트: 자유");
            postWriteReqDto3.setAnonymous(true);
            postWriteReqDto3.setQuestion(false);
            postWriteReqDto3.setPostedDate(LocalDateTime.now());

            PostWriteReqDto postWriteReqDto4 = new PostWriteReqDto();
            postWriteReqDto4.setTitle("테스트 제목4: 자유");
            postWriteReqDto4.setContent("테스트테스트테스트테스트: 자유");
            postWriteReqDto4.setAnonymous(true);
            postWriteReqDto4.setQuestion(false);
            postWriteReqDto4.setPostedDate(LocalDateTime.now());

            PostWriteReqDto postWriteReqDto5 = new PostWriteReqDto();
            postWriteReqDto5.setTitle("테스트 제목: 새내기");
            postWriteReqDto5.setContent("테스트테스트테스트테스트: 새내기");
            postWriteReqDto5.setAnonymous(true);
            postWriteReqDto5.setQuestion(false);
            postWriteReqDto5.setPostedDate(LocalDateTime.now());

            PostWriteReqDto postWriteReqDto6= new PostWriteReqDto();
            postWriteReqDto6.setTitle("테스트 제목2: 새내기");
            postWriteReqDto6.setContent("테스트테스트테스트테스트: 새내기");
            postWriteReqDto6.setAnonymous(true);
            postWriteReqDto6.setQuestion(false);
            postWriteReqDto6.setPostedDate(LocalDateTime.now());

            PostWriteReqDto postWriteReqDto7 = new PostWriteReqDto();
            postWriteReqDto7.setTitle("테스트 제목3: 새내기");
            postWriteReqDto7.setContent("테스트테스트테스트테스트: 새내기");
            postWriteReqDto7.setAnonymous(true);
            postWriteReqDto7.setQuestion(false);
            postWriteReqDto7.setPostedDate(LocalDateTime.now());

            PostWriteReqDto postWriteReqDto8 = new PostWriteReqDto();
            postWriteReqDto8.setTitle("테스트 제목4: 새내기");
            postWriteReqDto8.setContent("테스트테스트테스트테스트: 새내기");
            postWriteReqDto8.setAnonymous(true);
            postWriteReqDto8.setQuestion(false);
            postWriteReqDto8.setPostedDate(LocalDateTime.now());

            Post post1 = Post.builder()
                    .title(postWriteReqDto.getTitle())
                    .content(postWriteReqDto.getContent())
                    .scraps_cnt(0L)
                    .likes_cnt(0L)
                    .comments_cnt(0L)
                    .photos_cnt(0L)
                    .postedDate(postWriteReqDto.getPostedDate())
                    .isAnonymous(postWriteReqDto.isAnonymous())
                    .isQuestion(postWriteReqDto.isQuestion())
                    .member(member)
                    .board(free)
                    .build();

            Post post2 = Post.builder()
                    .title(postWriteReqDto2.getTitle())
                    .content(postWriteReqDto2.getContent())
                    .scraps_cnt(0L)
                    .likes_cnt(0L)
                    .comments_cnt(0L)
                    .photos_cnt(0L)
                    .postedDate(postWriteReqDto2.getPostedDate())
                    .isAnonymous(postWriteReqDto2.isAnonymous())
                    .isQuestion(postWriteReqDto2.isQuestion())
                    .member(member)
                    .board(free)
                    .build();

            Post post3 = Post.builder()
                    .title(postWriteReqDto3.getTitle())
                    .content(postWriteReqDto3.getContent())
                    .scraps_cnt(0L)
                    .likes_cnt(0L)
                    .comments_cnt(0L)
                    .photos_cnt(0L)
                    .postedDate(postWriteReqDto3.getPostedDate())
                    .isAnonymous(postWriteReqDto3.isAnonymous())
                    .isQuestion(postWriteReqDto3.isQuestion())
                    .member(member)
                    .board(free)
                    .build();

            Post post4 = Post.builder()
                    .title(postWriteReqDto4.getTitle())
                    .content(postWriteReqDto4.getContent())
                    .scraps_cnt(0L)
                    .likes_cnt(0L)
                    .comments_cnt(0L)
                    .photos_cnt(0L)
                    .postedDate(postWriteReqDto4.getPostedDate())
                    .isAnonymous(postWriteReqDto4.isAnonymous())
                    .isQuestion(postWriteReqDto4.isQuestion())
                    .member(member)
                    .board(free)
                    .build();

            Post post5 = Post.builder()
                    .title(postWriteReqDto5.getTitle())
                    .content(postWriteReqDto5.getContent())
                    .scraps_cnt(0L)
                    .likes_cnt(0L)
                    .comments_cnt(0L)
                    .photos_cnt(0L)
                    .postedDate(postWriteReqDto5.getPostedDate())
                    .isAnonymous(postWriteReqDto5.isAnonymous())
                    .isQuestion(postWriteReqDto5.isQuestion())
                    .member(member)
                    .board(neww)
                    .build();

            Post post6 = Post.builder()
                    .title(postWriteReqDto6.getTitle())
                    .content(postWriteReqDto6.getContent())
                    .scraps_cnt(0L)
                    .likes_cnt(0L)
                    .comments_cnt(0L)
                    .photos_cnt(0L)
                    .postedDate(postWriteReqDto6.getPostedDate())
                    .isAnonymous(postWriteReqDto6.isAnonymous())
                    .isQuestion(postWriteReqDto6.isQuestion())
                    .member(member)
                    .board(neww)
                    .build();

            Post post7 = Post.builder()
                    .title(postWriteReqDto7.getTitle())
                    .content(postWriteReqDto7.getContent())
                    .scraps_cnt(0L)
                    .likes_cnt(0L)
                    .comments_cnt(0L)
                    .photos_cnt(0L)
                    .postedDate(postWriteReqDto7.getPostedDate())
                    .isAnonymous(postWriteReqDto7.isAnonymous())
                    .isQuestion(postWriteReqDto7.isQuestion())
                    .member(member)
                    .board(neww)
                    .build();

            Post post8 = Post.builder()
                    .title(postWriteReqDto8.getTitle())
                    .content(postWriteReqDto8.getContent())
                    .scraps_cnt(0L)
                    .likes_cnt(0L)
                    .comments_cnt(0L)
                    .photos_cnt(0L)
                    .postedDate(postWriteReqDto8.getPostedDate())
                    .isAnonymous(postWriteReqDto8.isAnonymous())
                    .isQuestion(postWriteReqDto8.isQuestion())
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
