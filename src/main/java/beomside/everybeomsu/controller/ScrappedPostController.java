package beomside.everybeomsu.controller;

import beomside.everybeomsu.domain.Member;
import beomside.everybeomsu.domain.Post;
import beomside.everybeomsu.domain.ScrappedPost;
import beomside.everybeomsu.dto.res.ScrappedPost.ScrappedPostAllResDto;
import beomside.everybeomsu.dto.res.ScrappedPost.ScrappedPostResDto;
import beomside.everybeomsu.service.MemberService;
import beomside.everybeomsu.service.PostService;
import beomside.everybeomsu.service.ScrappedPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ScrappedPostController {

    private final ScrappedPostService scrappedPostService;
    private final MemberService memberService;
    private final PostService postService;

    @GetMapping("/scrappedPosts/{memberId}")
    public ScrappedPostAllResDto getScrappedPosts(@PathVariable(name = "memberId") Long memberId) {
        List<ScrappedPostResDto> scraps = scrappedPostService.getScrappedPostByMemberId(memberId);

        return ScrappedPostAllResDto.builder()
                .scraps(scraps)
                .build();
    }

    @PutMapping("/plus/p/{postId}/m/{memberId}/scraps")
    public void plusScraps(@PathVariable(name = "postId") Long postId,
                           @PathVariable(name = "memberId") Long memberId) {

        Member member = memberService.getMemberById(memberId);
        Post post = postService.getPostById(postId);

        ScrappedPost scrappedPost = ScrappedPost.builder()
                .member(member)
                .post(post)
                .build();

        postService.plusScraps(post);
        scrappedPostService.save(scrappedPost);

        log.info("Success: scrappedPost is created successfully");
    }

    @DeleteMapping("/cancel/p/{scrapId}/scraps")
    public void cancelScraps(@PathVariable(name = "scrapId") Long scrapId) {
        ScrappedPost scrappedPost = scrappedPostService.getScrappedPostById(scrapId);
        scrappedPostService.cancelScrap(scrappedPost);
        log.info("Success: scrap is deleted");
    }
}
