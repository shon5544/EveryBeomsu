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

    @Column(name = "scraps_cnt")
    private Long scrapsCnt; // 스크랩 누적 수

    @Column(name = "likes_cnt")
    private Long likesCnt; // 좋아요 누적 수

    @Column(name = "comments_cnt")
    private Long commentsCnt; // 댓글 누적 수

    @Column(name = "photos_cnt")
    private Long photosCnt; // 사진 누적 수

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
                Long scrapsCnt,
                Long likesCnt,
                Long commentsCnt,
                Long photosCnt,
                boolean isAnonymous,
                boolean isQuestion,
                LocalDateTime postedDate,
                Member member,
                Board board) {
        this.title = title;
        this.content = content;
        this.scrapsCnt = scrapsCnt;
        this.likesCnt = likesCnt;
        this.commentsCnt = commentsCnt;
        this.photosCnt = photosCnt;
        this.isAnonymous = isAnonymous;
        this.isQuestion = isQuestion;
        this.postedDate = postedDate;
        this.member = member;
        this.board = board;
    }

    //비즈니스 로직
    public void plusScrap() {
        scrapsCnt++;
    }

    public void plusLike() {
        likesCnt++;
    }

    public void plusComment() {
        commentsCnt++;
    }

    public void plusPhoto() {
        photosCnt++;
    }

    public void minusScrap() {
        scrapsCnt--;
    }

    public void minusLike() {
        likesCnt--;
    }

    public void minusComment() {
        commentsCnt--;
    }

    public void minusPhoto() {
        photosCnt--;
    }
}
