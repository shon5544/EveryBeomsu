package beomside.everybeomsu.domain;

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
        member.addComment(this);

        this.post = post;
        post.addComment(this);

        if(comment_parent != null){
            this.commentParent = comment_parent;
            comment_parent.addChild(this);
        }
    }

    //비즈니스 로직
    public void plusLike() {
        likes_cnt++;
    }
    public void deleteThis() {
        this.content = "삭제된 댓글입니다.";
        this.likes_cnt = 0L;
    }

    public void addChild(Comment childComment) {
        commentChild.add(childComment);
    }
}
