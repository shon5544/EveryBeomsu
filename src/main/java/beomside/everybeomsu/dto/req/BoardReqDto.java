package beomside.everybeomsu.dto.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BoardReqDto {
    @NotEmpty private String name;
}
