package beomside.everybeomsu.dto.req.post;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostReqDto {
    //일반 필드
    @NotEmpty private String title; // 게시글 제목

    @NotEmpty
    private String content; // 게시글 내용

//    private Long scraps_cnt; // 스크랩 누적 수
//    private Long likes_cnt; // 좋아요 누적 수
//    private Long comments_cnt; // 댓글 누적 수
//    private Long photos_cnt; // 사진 누적 수

    @NotNull private LocalDateTime postedDate; // 포스팅 날짜

//    private MemberPostReqDto member;
//    private BoardPostReqDto board;
    @NotNull private boolean isAnonymous; // 익명 글 여부
    @NotNull private boolean isQuestion; // 질문 글 여부
}
