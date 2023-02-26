package beomside.everybeomsu.dto.req.createComment;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentReqDto {
    private String content;
    private Long member_id;
    private Long post_id;
    private Long parent_id;
}
