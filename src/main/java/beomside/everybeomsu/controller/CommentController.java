package beomside.everybeomsu.controller;

import beomside.everybeomsu.domain.Comment;
import beomside.everybeomsu.domain.Member;
import beomside.everybeomsu.domain.Post;
import beomside.everybeomsu.dto.req.createComment.CommentReqDto;
import beomside.everybeomsu.service.CommentService;
import beomside.everybeomsu.service.MemberService;
import beomside.everybeomsu.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CommentController {

    private final MemberService memberService;
    private final PostService postService;
    private final CommentService commentService;

    @PostMapping("createComment")
    public void createComment(@RequestBody CommentReqDto commentReqDto) {
        Member member = memberService.getMemberById(commentReqDto.getMember_id());
        Post post = postService.getPostById(commentReqDto.getPost_id());

        Comment parent = commentReqDto.getParent_id() != null ?
                commentService.getCommentById(commentReqDto.getParent_id()) :
                null;

        Comment comment = Comment.builder()
                .content(commentReqDto.getContent())
                .likes_cnt(0L)
                .commentedDate(LocalDateTime.now())
                .member(member)
                .post(post)
                .comment_parent(parent)
                .build();

        commentService.createComment(comment);
        log.info("Success: comment is created successfully");
    }
}
