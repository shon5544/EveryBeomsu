package beomside.everybeomsu.dto.res.post;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CommentPostResDto {
    private String content;
    private Long likes_cnt;
    private LocalDateTime commented_date;
    private MemberPostResDto memberPostResDto;

    @Builder
    public CommentPostResDto(String content,
                             Long likes_cnt,
                             LocalDateTime commented_date,
                             MemberPostResDto memberPostResDto) {
        this.content = content;
        this.likes_cnt = likes_cnt;
        this.commented_date = commented_date;
        this.memberPostResDto = memberPostResDto;
    }
}
