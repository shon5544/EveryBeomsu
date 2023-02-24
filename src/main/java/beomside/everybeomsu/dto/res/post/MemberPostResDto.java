package beomside.everybeomsu.dto.res.post;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberPostResDto {

    private String nickname;

    @Builder
    public MemberPostResDto(String nickname) {
        this.nickname = nickname;
    }
}
