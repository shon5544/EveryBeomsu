package beomside.everybeomsu.dto.res;

import beomside.everybeomsu.domain.Post;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResDto {
    //일반 필드
    @NotEmpty
    private String title; // 게시글 제목

    @NotEmpty
    private String content; // 게시글 내용

    private Long scraps_cnt; // 스크랩 누적 수
    private Long likes_cnt; // 좋아요 누적 수
    private Long comments_cnt; // 댓글 누적 수
    private Long photos_cnt; // 사진 누적 수

    @NotNull
    private LocalDateTime posted_date; // 포스팅 날짜

    @NotNull private boolean isAnonymous; // 익명 글 여부
    @NotNull private boolean isQuestion; // 질문 글 여부

    public PostResDto(Post post) {
        title = post.getTitle();
        content = post.getContent();
        scraps_cnt = post.getScraps_cnt();
        likes_cnt = post.getLikes_cnt();
        comments_cnt = post.getComments_cnt();
        photos_cnt = post.getPhotos_cnt();
        posted_date = post.getPostedDate();
        isAnonymous = post.isAnonymous();
        isQuestion = post.isQuestion();
    }
}
