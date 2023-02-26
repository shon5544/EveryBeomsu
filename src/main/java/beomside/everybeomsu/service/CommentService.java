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

    public Comment getCommentById(Long comment_id) {
        return commentRepository.findById(comment_id)
                .orElseGet(() -> null);
    }
}
