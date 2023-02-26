package beomside.everybeomsu.controller;

import beomside.everybeomsu.domain.Post;
import beomside.everybeomsu.dto.req.post.PostReqDto;
import beomside.everybeomsu.dto.res.post.CommentPostResDto;
import beomside.everybeomsu.dto.res.post.PostResDto;
import beomside.everybeomsu.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @PostMapping("/createPost")
    public void createPost(@RequestBody PostReqDto postReqDto) {
        Post post = Post.builder()
                .title(postReqDto.getTitle())
                .content(postReqDto.getContent())
                .scrapsCnt(0L)
                .likesCnt(0L)
                .commentsCnt(0L)
                .photosCnt(0L)
                .postedDate(LocalDateTime.now())
                .isAnonymous(postReqDto.isAnonymous())
                .isQuestion(postReqDto.isQuestion())
                .member(postReqDto.getMember())
                .board(postReqDto.getBoard())
                .build();

        postService.createPost(post);
    }
}
