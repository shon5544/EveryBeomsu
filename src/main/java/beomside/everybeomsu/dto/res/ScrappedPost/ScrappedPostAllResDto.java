package beomside.everybeomsu.dto.res.ScrappedPost;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScrappedPostAllResDto {
    private List<ScrappedPostResDto> scraps;

    @Builder
    public ScrappedPostAllResDto(List<ScrappedPostResDto> scraps) {
        this.scraps = scraps;
    }
}
