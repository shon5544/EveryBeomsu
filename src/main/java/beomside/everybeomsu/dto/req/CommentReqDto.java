package beomside.everybeomsu.dto.req;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentReqDto {
    @NotEmpty private String content;
    @NotNull private LocalDateTime commented_date;
    private Long likes_cnt;
}
