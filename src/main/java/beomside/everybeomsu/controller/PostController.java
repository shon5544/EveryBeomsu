package beomside.everybeomsu.controller;

import beomside.everybeomsu.domain.*;
import beomside.everybeomsu.dto.req.createPost.PostReqDto;
import beomside.everybeomsu.dto.res.post.CommentPostResDto;
import beomside.everybeomsu.dto.res.post.MemberPostResDto;
import beomside.everybeomsu.dto.res.post.PostResDto;
import beomside.everybeomsu.service.BoardService;
import beomside.everybeomsu.service.MemberService;
import beomside.everybeomsu.service.PostService;
import beomside.everybeomsu.service.ScrappedPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;
    private final MemberService memberService;
    private final BoardService boardService;

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
                //나중에 리팩토링. 코드가 너무 지저분함
                .comments(
                        post.getComments().stream()
                                .map(c -> CommentPostResDto.builder()
                                        .content(c.getContent())
                                        .likes_cnt(c.getLikes_cnt())
                                        .commented_date(c.getCommentedDate())
                                        .memberPostResDto(MemberPostResDto.builder()
                                                .nickname(c.getMember().getNickname())
                                                .build()
                                        )
                                        .commentPostResDtos(
                                                c.getCommentChild().stream()
                                                        .map(innerC -> CommentPostResDto.builder()
                                                                .content(innerC.getContent())
                                                                .likes_cnt(innerC.getLikes_cnt())
                                                                .commented_date(innerC.getCommentedDate())
                                                                .memberPostResDto(MemberPostResDto.builder()
                                                                        .nickname(innerC.getMember().getNickname())
                                                                        .build()
                                                                )
                                                                .build()
                                                        )
                                                        .collect(Collectors.toList())
                                        )
                                        .build()
                                )
                                .collect(Collectors.toList())
                )
                .build();

        return postResDto;
    }

    @PostMapping("/createPost")
    public void createPost(@RequestBody PostReqDto postReqDto) {
        Member member = memberService.getMemberById(postReqDto.getMember_id());
        Board board = boardService.getBoardById(postReqDto.getBoard_id());

        Post post = Post.builder()
                .title(postReqDto.getTitle())
                .content(postReqDto.getContent())
                .scrapsCnt(0L)
                .likesCnt(0L)
                .commentsCnt(0L)
                .photosCnt(0L)
                .postedDate(LocalDateTime.now())
                .isAnonymous(postReqDto.is_anonymous())
                .isQuestion(postReqDto.is_question())
                .member(member)
                .board(board)
                .build();

        postService.createPost(post);

        log.info("Success: the post is created successfully");
    }

    @PutMapping("/plus/p/{postId}/likes")
    public void plusPostLikes(@PathVariable(name = "postId") Long postId) {
        Post post = postService.getPostById(postId);
        postService.plusLikes(post);
        log.info("Success: plus like is completed successfully");
    }

    @PutMapping("/cancel/p/{postId}/likes")
    public void cancelPostLikes(@PathVariable(name = "postId") Long postId) {
        Post post = postService.getPostById(postId);
        postService.cancelLikes(post);
        log.info("Success: minus like is completed successfully");
    }
}
