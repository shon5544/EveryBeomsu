package beomside.everybeomsu.dto.res.home;

import beomside.everybeomsu.domain.Member;
import beomside.everybeomsu.domain.Post;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HomeResDto {
    @NotNull
    private MemberHomeResDto member;

    private List<List<PostHomeResDto>> posts;

    private List<BoardHomeResDto> boards;

    private List<Long> idList;

    @Builder
    public HomeResDto(MemberHomeResDto member, List<List<PostHomeResDto>> posts, List<BoardHomeResDto> boards, List<Long> idList) {
        this.member = member;
        this.posts = posts;
        this.boards = boards;
        this.idList = idList;
    }
}
