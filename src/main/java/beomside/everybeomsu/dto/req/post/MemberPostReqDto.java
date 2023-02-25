package beomside.everybeomsu.dto.req.post;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class MemberPostReqDto {
    @NotEmpty private String user_name;
    private String nickname;
    private String loginId;
    private String loginPw;
}
