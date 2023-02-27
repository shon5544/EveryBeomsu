package beomside.everybeomsu.dto.res.ScrappedPost;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostScrappedPostResDto {

    private String title;
    private String content;
    private Long postId;

    @Builder
    private PostScrappedPostResDto(String title, String content, Long postId) {
        this.title = title;
        this.content = content;
        this.postId = postId;
    }
}
