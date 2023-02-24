package beomside.everybeomsu.domain;

import beomside.everybeomsu.dto.req.CommentReqDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    //id
    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long commentId;

    //기본 필드
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
    private Comment commentParent;

    @OneToMany(mappedBy = "commentParent")
    private final List<Comment> commentChild = new ArrayList<>();

    //생성자
    @Builder
    public Comment(String content,
                   Long likes_cnt,
                   LocalDateTime commentedDate,
                   Member member,
                   Post post,
                   Comment comment_parent) {
        this.content = content;
        this.likes_cnt = likes_cnt;
        this.commentedDate = commentedDate;
        this.member = member;
        this.post = post;
        this.commentParent = comment_parent;
    }

    //비즈니스 로직
    public void plusLike() {
        likes_cnt++;
    }
}
