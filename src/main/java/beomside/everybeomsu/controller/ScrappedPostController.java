package beomside.everybeomsu.controller;

import beomside.everybeomsu.domain.ScrappedPost;
import beomside.everybeomsu.dto.res.ScrappedPost.ScrappedPostResDto;
import beomside.everybeomsu.service.ScrappedPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScrappedPostController {

    private final ScrappedPostService scrappedPostService;

    @GetMapping("/scrappedPosts/{memberId}")
    public List<ScrappedPostResDto> getScrappedPosts(@PathVariable(name = "memberId") Long memberId) {
        return scrappedPostService.getScrappedPostByMemberId(memberId);
    }
}
