package beomside.everybeomsu.service;

import beomside.everybeomsu.domain.CommentReply;
import beomside.everybeomsu.repository.CommentReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentReplyService {

    private final CommentReplyRepository commentReplyRepository;

    public void createCommentReply(CommentReply commentReply) {
        commentReplyRepository.save(commentReply);
    }
}
