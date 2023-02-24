package beomside.everybeomsu.dto.res.board;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostBoardResDto {
    private String title;
    private String summary;
    private LocalDateTime posted_date;

    private Long likes_cnt;
    private Long comment_cnt;

    @Builder
    public PostBoardResDto(String title, String summary, LocalDateTime posted_date, Long likes_cnt, Long comment_cnt) {
        this.title = title;
        this.summary = summary;
        this.posted_date = posted_date;
        this.likes_cnt = likes_cnt;
        this.comment_cnt = comment_cnt;
    }
}
