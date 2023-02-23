package beomside.everybeomsu.domain;

import beomside.everybeomsu.dto.req.CommentReqDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Comment {

    //id
    @Id @GeneratedValue
    private Long comment_id;

    //기본 필드
    @Lob
    private String content;
    private Long likes_cnt;

    @Column(name = "commented_date")
    private LocalDateTime commentedDate;

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_parent_id")
    private Comment comment_parent;

    @OneToMany(mappedBy = "comment_parent")
    private List<Comment> comment_child = new ArrayList<>();

    //생성자
    public Comment() {}
    public Comment(CommentReqDto commentReqDto) {
        content = commentReqDto.getContent();
        likes_cnt = commentReqDto.getLikes_cnt();
        commentedDate = commentReqDto.getCommented_date();
    }

    //비즈니스 로직
    public void plusLike() {
        likes_cnt++;
    }
}
