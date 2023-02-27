package beomside.everybeomsu.dto.res.ScrappedPost;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberScrappedPostResDto {

    private String nickname;

    @Builder
    public MemberScrappedPostResDto(String nickname) {
        this.nickname = nickname;
    }
}
