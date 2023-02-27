package beomside.everybeomsu.service;

import beomside.everybeomsu.domain.Comment;
import beomside.everybeomsu.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public void createComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Transactional
    public void plusCommentLikes(Comment comment) {
        comment.plusLike();
    }

    @Transactional
    public void cancelCommentLikes(Comment comment) {
        comment.minusLike();
    }

    @Transactional
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Transactional
    public void deleteCommentByChanging(Comment comment) {
        comment.deleteThis();
    }

    public Comment getCommentById(Long comment_id) {
        return commentRepository.findById(comment_id)
                .orElseGet(() -> null);
    }
}
