package beomside.everybeomsu.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PostsReqDto {
    //일반 필드
    @NotEmpty private String title; // 게시글 제목
    @NotEmpty private String content; // 게시글 내용

    private Long scraps_cnt; // 스크랩 누적 수
    private Long likes_cnt; // 좋아요 누적 수
    private Long comments_cnt; // 댓글 누적 수
    private Long photos_cnt; // 사진 누적 수

    @NotEmpty private boolean isAnonymous; // 익명 글 여부
    @NotEmpty private boolean isQuestion; // 질문 글 여부
}
