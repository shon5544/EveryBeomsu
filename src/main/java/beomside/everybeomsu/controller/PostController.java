package beomside.everybeomsu.controller;

import beomside.everybeomsu.domain.Post;
import beomside.everybeomsu.dto.res.post.CommentPostResDto;
import beomside.everybeomsu.dto.res.post.PostResDto;
import beomside.everybeomsu.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/post/{postId}")
    public PostResDto getPost(@PathVariable("postId") Long postId) {
        Post post = postService.getPostById(postId);
        PostResDto postResDto = PostResDto.builder()
                .user_name(post.getMember().getName())
                .title(post.getTitle())
                .content(post.getContent())
                .like_cnt(post.getLikesCnt())
                .comment_cnt(post.getCommentsCnt())
                .scraps_cnt(post.getScrapsCnt())
                .postedDate(post.getPostedDate())
                .isAnonymous(post.isAnonymous())
                .isQuestion(post.isQuestion())
                .comments(
                        post.getComments().stream()
                                .map(p -> CommentPostResDto.builder().build())
                                .collect(Collectors.toList())
                )
                .build();

        return postResDto;
    }
}
