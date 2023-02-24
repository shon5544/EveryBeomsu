package beomside.everybeomsu.dto.res.post;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostResDto {
    private String user_name;
    private String title;
    private String content;

    private Long like_cnt;
    private Long comment_cnt;
    private Long scraps_cnt;

    private LocalDateTime postedDate;

    private boolean isAnonymous;
    private boolean isQuestion;



    private List<CommentPostResDto> comments;

    @Builder
    public PostResDto(String user_name,
                      String title,
                      String content,
                      Long like_cnt,
                      Long comment_cnt,
                      Long scraps_cnt,
                      LocalDateTime postedDate,
                      boolean isAnonymous,
                      boolean isQuestion,
                      List<CommentPostResDto> comments) {
        this.user_name = user_name;
        this.title = title;
        this.content = content;
        this.like_cnt = like_cnt;
        this.comment_cnt = comment_cnt;
        this.scraps_cnt = scraps_cnt;
        this.postedDate = postedDate;
        this.isAnonymous = isAnonymous;
        this.isQuestion = isQuestion;
        this.comments = comments;
    }
}
