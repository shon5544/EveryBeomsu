package beomside.everybeomsu.dto.req.createPost;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BoardPostReqDto {
    @NotEmpty private String board_name;
}
