package beomside.everybeomsu.domain;

import beomside.everybeomsu.dto.req.BoardReqDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Board {

    //id
    @Id @GeneratedValue
    private Long board_id;

    //기본 필드
    private String name;

    //연관관계 매핑
    @OneToMany(mappedBy = "board")
    private List<Post> posts = new ArrayList<>();

    //생성자
    public Board() {}
    public Board(String name) {
        this.name = name;
    }
}
