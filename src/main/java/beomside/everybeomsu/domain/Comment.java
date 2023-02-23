package beomside.everybeomsu.domain;

import beomside.everybeomsu.dto.CommentReqDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Comment {

    //id
    @Id @GeneratedValue
    private Long comment_id;

    //기본 필드
    private String content;
    private Long likes_cnt;

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
    private List<Comment> comment_child;

    //생성자
    public Comment() {}
    public Comment(CommentReqDto commentReqDto) {
        content = commentReqDto.getContent();
        likes_cnt = commentReqDto.getLikes_cnt();
    }

    //비즈니스 로직
    public void plusLike() {
        likes_cnt++;
    }
}
