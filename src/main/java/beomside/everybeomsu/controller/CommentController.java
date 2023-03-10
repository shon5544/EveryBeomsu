package beomside.everybeomsu.controller;

import beomside.everybeomsu.domain.Comment;
import beomside.everybeomsu.domain.CommentReply;
import beomside.everybeomsu.domain.Member;
import beomside.everybeomsu.domain.Post;
import beomside.everybeomsu.dto.req.createComment.CommentReplyReqDto;
import beomside.everybeomsu.dto.req.createComment.CommentReqDto;
import beomside.everybeomsu.service.CommentReplyService;
import beomside.everybeomsu.service.CommentService;
import beomside.everybeomsu.service.MemberService;
import beomside.everybeomsu.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CommentController {

    private final MemberService memberService;
    private final PostService postService;
    private final CommentService commentService;
    private final CommentReplyService commentReplyService;

    @PostMapping("createComment")
    public void createComment(@RequestBody CommentReqDto commentReqDto) {
        Member member = memberService.getMemberById(commentReqDto.getMember_id());
        Post post = postService.getPostById(commentReqDto.getPost_id());

        Comment comment = Comment.builder()
                .content(commentReqDto.getContent())
                .likes_cnt(0L)
                .commentedDate(LocalDateTime.now())
                .member(member)
                .post(post)
                .build();

        commentService.createComment(comment);
        log.info("Success: comment is created successfully");
    }

    @PostMapping("/createComment/reply")
    public void createCommentReply(@RequestBody CommentReplyReqDto commentReplyReqDto) {
        Member member = memberService.getMemberById(commentReplyReqDto.getMember_id());
//        Post post = postService.getPostById(commentReplyReqDto.getPost_id());

        Comment parent = commentReplyReqDto.getParent_id() != null ?
                commentService.getCommentById(commentReplyReqDto.getParent_id()) :
                null;

        CommentReply commentReply = CommentReply.builder()
                .content(commentReplyReqDto.getContent())
                .likes_cnt(0L)
                .commentedDate(LocalDateTime.now())
                .member(member)
                .comment_parent(parent)
                .build();

        commentReplyService.createCommentReply(commentReply);
        log.info("Success: comment reply is created successfully");
    }

    @PutMapping("/plus/c/{commentId}/likes")
    public void plusCommentLikes(@PathVariable(name = "commentId") Long commentId) {
        Comment comment = commentService.getCommentById(commentId);
        commentService.plusCommentLikes(comment);
        log.info("Success: plus likes for comment is completed successfully");
    }

    @PutMapping("/cancel/c/{commentId}/likes")
    public void cancelCommentLikes(@PathVariable(name = "commentId") Long commentId) {
        Comment comment = commentService.getCommentById(commentId);
        commentService.cancelCommentLikes(comment);
        log.info("Success: cancel likes for comment is completed successfully");
    }

    @DeleteMapping("/delete/comment/{commentId}")
    public void deleteComment(@PathVariable(name = "commentId") Long commentId) {
        Comment comment = commentService.getCommentById(commentId);

        if(comment.getCommentChild().isEmpty()) {
            commentService.deleteComment(commentId);
        } else {
            commentService.deleteCommentByChanging(comment);
        }

        log.info("Success: comment is deleted successfully");
    }
}
