package beomside.everybeomsu.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    //id
    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long postId;

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
    @Builder
    public Post(String title,
                String content,
                Long scraps_cnt,
                Long likes_cnt,
                Long comments_cnt,
                Long photos_cnt,
                boolean isAnonymous,
                boolean isQuestion,
                LocalDateTime postedDate,
                Member member,
                Board board) {
        this.title = title;
        this.content = content;
        this.scraps_cnt = scraps_cnt;
        this.likes_cnt = likes_cnt;
        this.comments_cnt = comments_cnt;
        this.photos_cnt = photos_cnt;
        this.isAnonymous = isAnonymous;
        this.isQuestion = isQuestion;
        this.postedDate = postedDate;
        this.member = member;
        this.board = board;
    }

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
