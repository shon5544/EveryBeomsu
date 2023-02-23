package beomside.everybeomsu.dto.req.write;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BoardWriteReqDto {
    @NotEmpty private String board_name;
}
