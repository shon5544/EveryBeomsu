package beomside.everybeomsu.dto.req.regist;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class MemberRegisterReqDto {
    @NotEmpty private String name;
    @NotEmpty private String nickname;
    @NotEmpty private String login_id;
    @NotEmpty private String login_pw;
}
