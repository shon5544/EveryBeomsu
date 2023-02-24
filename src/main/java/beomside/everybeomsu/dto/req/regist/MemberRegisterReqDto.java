package beomside.everybeomsu.dto.req.regist;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class MemberRegisterReqDto {
    @NotEmpty private String name;
    @NotEmpty private String nickname;
    @NotEmpty private String loginId;
    @NotEmpty private String loginPw;
}
