package beomside.everybeomsu.dto.req.createComment;

import lombok.Data;

@Data
public class CommentReplyReqDto {
    private String content;
    private Long member_id;
    private Long post_id;
    private Long parent_id;
}
