package beomside.everybeomsu.dto.res.post;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class CommentPostResDto {
    private String content;
    private Long likes_cnt;
    private LocalDateTime commented_date;
    private MemberPostResDto memberPostResDto;

    private List<CommentPostResDto> commentPostResDtos;

    @Builder
    public CommentPostResDto(String content,
                             Long likes_cnt,
                             LocalDateTime commented_date,
                             MemberPostResDto memberPostResDto,
                             List<CommentPostResDto> commentPostResDtos) {
        this.content = content;
        this.likes_cnt = likes_cnt;
        this.commented_date = commented_date;
        this.memberPostResDto = memberPostResDto;
        this.commentPostResDtos = commentPostResDtos;
    }
}
