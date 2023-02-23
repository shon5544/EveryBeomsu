package beomside.everybeomsu.domain;

import beomside.everybeomsu.dto.req.regist.MemberRegisterReqDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    //id
    @Id @GeneratedValue
    private Long member_id;

    //기본 필드
    private String name;
    private String nickname;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "loginPw")
    private String loginPw;

    //연관관계 매핑
    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();

    //생성자
    public Member() {}

    //테스트용 생성자
    public Member(String name,String nickname, String loginId, String loginPw) {
        this.name = name;
        this.nickname = nickname;
        this.loginId = loginId;
        this.loginPw = loginPw;
    }

    //회원가입용 생성자
    public Member(MemberRegisterReqDto dto) {
        name = dto.getName();
        nickname = dto.getNickname();
        loginId = dto.getLogin_id();
        loginPw = dto.getLogin_pw();
    }
}
