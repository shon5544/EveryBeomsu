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
            Member member = new Member("손범수", "shon5544", "sbs8239", "sbs32465169");
            Board free = new Board("free");
            Board neww = new Board("new");

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

            Post post1 = new Post(postWriteReqDto);
            post1.setMember(member);
            post1.setBoard(free);

            Post post2 = new Post(postWriteReqDto2);
            post2.setMember(member);
            post2.setBoard(free);

            Post post3 = new Post(postWriteReqDto3);
            post3.setMember(member);
            post3.setBoard(free);

            Post post4 = new Post(postWriteReqDto4);
            post4.setMember(member);
            post4.setBoard(free);

            Post post5 = new Post(postWriteReqDto5);
            post5.setMember(member);
            post5.setBoard(neww);

            Post post6 = new Post(postWriteReqDto6);
            post6.setMember(member);
            post6.setBoard(neww);

            Post post7 = new Post(postWriteReqDto7);
            post7.setMember(member);
            post7.setBoard(neww);

            Post post8 = new Post(postWriteReqDto8);
            post8.setMember(member);
            post8.setBoard(neww);

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
