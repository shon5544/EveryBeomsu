package beomside.everybeomsu.dto.req.post;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BoardPostReqDto {
    @NotEmpty private String board_name;
}
