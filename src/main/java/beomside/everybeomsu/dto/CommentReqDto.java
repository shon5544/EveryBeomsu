package beomside.everybeomsu.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CommentReqDto {
    @NotEmpty private String content;
    private Long likes_cnt;
}
