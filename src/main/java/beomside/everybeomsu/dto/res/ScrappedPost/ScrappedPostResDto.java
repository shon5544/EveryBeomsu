package beomside.everybeomsu.dto.res.ScrappedPost;

import beomside.everybeomsu.domain.ScrappedPost;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScrappedPostResDto {

    private Long scrappedPostId;
    private MemberScrappedPostResDto member;
    private PostScrappedPostResDto post;

    @Builder
    public ScrappedPostResDto(Long scrappedPostId, MemberScrappedPostResDto member, PostScrappedPostResDto post) {
        this.scrappedPostId = scrappedPostId;
        this.member = member;
        this.post = post;
    }
}
