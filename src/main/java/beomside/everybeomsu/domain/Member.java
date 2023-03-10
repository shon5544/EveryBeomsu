package beomside.everybeomsu.domain;

import beomside.everybeomsu.dto.req.regist.MemberRegisterReqDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member implements UserDetails {

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
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private final List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private final List<CommentReply> commentReplies = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private final List<ScrappedPost> scrappedPosts = new ArrayList<>();

    //생성자
    @Builder
    public Member(String name,String nickname, String loginId, String loginPw) {
        this.name = name;
        this.nickname = nickname;
        this.loginId = loginId;
        this.loginPw = loginPw;
    }

    //비즈니스 로직
    @Override
    public String getPassword() {
        return this.loginPw;
    }

    @Override
    public String getUsername() {
        return this.loginId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(() -> "계정별 등록 권한");

        return collectors;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void addPost(Post post) {
        posts.add(post);
    }
    public void addComment(Comment comment) {
        comments.add(comment);
    }
    public void addCommentReply(CommentReply commentReply) {
        commentReplies.add(commentReply);
    }
}
