package beomside.everybeomsu.domain;

import beomside.everybeomsu.dto.req.BoardReqDto;
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
public class Board {

    //id
    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long boardId;

    //기본 필드
    private String name;

    //연관관계 매핑
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    //생성자
    @Builder
    public Board(String name) {
        this.name = name;
    }

    //비즈니스 로직
    public void addPost(Post post) {
        posts.add(post);
    }
}
