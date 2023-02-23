package beomside.everybeomsu.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class MemberReqDto {
    @NotEmpty private String name;
    @NotEmpty private String nickname;
    @NotEmpty private String login_id;
    @NotEmpty private String login_pw;
}
