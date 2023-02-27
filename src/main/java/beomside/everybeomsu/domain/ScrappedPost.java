package beomside.everybeomsu.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScrappedPost {

    @Id @GeneratedValue
    @Column(name = "scrapped_post_id")
    private Long scrappedPostId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public ScrappedPost(Member member, Post post) {
        this.member = member;
        this.post = post;
    }
}
