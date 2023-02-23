package beomside.everybeomsu.dto.res.home;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberHomeResDto {
    @NotEmpty private String user_name;
    @NotEmpty private String user_realname;
    @NotEmpty private String user_id;
}
