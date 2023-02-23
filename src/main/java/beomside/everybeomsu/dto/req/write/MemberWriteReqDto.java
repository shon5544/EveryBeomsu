package beomside.everybeomsu.dto.req.write;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberWriteReqDto {
    @NotEmpty private String user_name;
    private String nickname;
    private String loginId;
    private String loginPw;

}
