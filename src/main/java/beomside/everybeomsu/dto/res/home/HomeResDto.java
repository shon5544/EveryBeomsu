package beomside.everybeomsu.dto.res.home;

import beomside.everybeomsu.domain.Member;
import beomside.everybeomsu.domain.Post;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class HomeResDto {
    @NotNull
    private MemberHomeResDto member;

    private List<List<PostHomeResDto>> posts;

    private List<BoardHomeResDto> boards;

    private List<Long> idList;

    public HomeResDto(MemberHomeResDto member, List<List<PostHomeResDto>> posts, List<BoardHomeResDto> boards, List<Long> idList) {
        this.member = member;
        this.posts = posts;
        this.boards = boards;
        this.idList = idList;
    }
}
