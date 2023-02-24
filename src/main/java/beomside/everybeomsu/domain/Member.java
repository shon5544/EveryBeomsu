package beomside.everybeomsu.domain;

import beomside.everybeomsu.dto.req.regist.MemberRegisterReqDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    //id
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long memberId;

    //기본 필드
    private String name;
    private String nickname;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "login_pw")
    private String loginPw;

    //연관관계 매핑
    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();

    //생성자

    //테스트용 생성자
    @Builder
    public Member(String name,String nickname, String loginId, String loginPw) {
        this.name = name;
        this.nickname = nickname;
        this.loginId = loginId;
        this.loginPw = loginPw;
    }
}
