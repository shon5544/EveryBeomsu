package beomside.everybeomsu.domain;

import beomside.everybeomsu.dto.req.write.PostWriteReqDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Post {

    //id
    @Id @GeneratedValue
    private Long post_id;

    //기본 필드
    private String title; // 게시글 제목

    private String content; // 게시글 내용

    private Long scraps_cnt; // 스크랩 누적 수
    private Long likes_cnt; // 좋아요 누적 수
    private Long comments_cnt; // 댓글 누적 수
    private Long photos_cnt; // 사진 누적 수

    @Column(name = "posted_date")
    private LocalDateTime postedDate; // 포스팅 날짜

    private boolean isAnonymous; // 익명 글 여부
    private boolean isQuestion; // 질문 글 여부

    //연관관게 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    //생성자
    public Post() {}
    public Post(PostWriteReqDto dto) {
        title = dto.getTitle();
        content = dto.getContent();
        scraps_cnt = 0L;
        likes_cnt = 0L;
        comments_cnt = 0L;
        photos_cnt = 0L;
        isAnonymous = dto.isAnonymous();
        isQuestion = dto.isQuestion();
        postedDate = dto.getPostedDate();
    }

    // 추가 예정
//    public Post(PostResDto dto){
//        title = dto.getTitle();
//        content = dto.getContent();
//        scraps_cnt = dto.getScraps_cnt();
//        likes_cnt = dto.getLikes_cnt();
//        comments_cnt = dto.getComments_cnt();
//        photos_cnt = dto.getPhotos_cnt();
//        isAnonymous = dto.isAnonymous();
//        isQuestion = dto.isQuestion();
//        postedDate = dto.getPosted_date();
//    }

    //비즈니스 로직
    public void plusScrap() {
        scraps_cnt++;
    }

    public void plusLike() {
        likes_cnt++;
    }

    public void plusComment() {
        comments_cnt++;
    }

    public void plusPhoto() {
        photos_cnt++;
    }

    public void minusScrap() {
        scraps_cnt--;
    }

    public void minusLike() {
        likes_cnt--;
    }

    public void minusComment() {
        comments_cnt--;
    }

    public void minusPhoto() {
        photos_cnt--;
    }
}
