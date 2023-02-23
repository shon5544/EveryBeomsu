package beomside.everybeomsu.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BoardReqDto {
    @NotEmpty private String name;
}
