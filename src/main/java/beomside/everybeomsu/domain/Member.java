package beomside.everybeomsu.domain;

import beomside.everybeomsu.dto.MemberReqDto;
import jakarta.persistence.*;
import lombok.Getter;

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
    private List<Post> posts;

    @OneToMany(mappedBy = "member")
    private List<Comment> comments;

    //생성자
    public Member() {}
    public Member(MemberReqDto dto) {
        name = dto.getName();
        nickname = dto.getNickname();
        loginId = dto.getLogin_id();
        loginPw = dto.getLogin_pw();
    }
}
