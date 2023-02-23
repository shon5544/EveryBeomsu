package beomside.everybeomsu.controller;

import beomside.everybeomsu.domain.Member;
import beomside.everybeomsu.dto.res.home.BoardHomeResDto;
import beomside.everybeomsu.dto.res.home.HomeResDto;
import beomside.everybeomsu.dto.res.home.MemberHomeResDto;
import beomside.everybeomsu.dto.res.home.PostHomeResDto;
import beomside.everybeomsu.service.BoardService;
import beomside.everybeomsu.service.MemberService;
import beomside.everybeomsu.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;
    private final PostService postService;
    private final BoardService boardService;

    @GetMapping("/home/{id}")
    public HomeResDto getHomeData(@PathVariable("id") @Valid Long id) {
        // MemberHomeResDto 제작
        Member findMember = memberService.search(id);
        MemberHomeResDto memberDto = new MemberHomeResDto(
                findMember.getNickname(),
                findMember.getName(),
                findMember.getLoginId());

        // BoardHomeResDto 를 이용해 PostHomeResDto 조립하기
        List<BoardHomeResDto> boards = boardService.getAll();
        List<List<PostHomeResDto>> posts = new ArrayList<>(); // boards 와 4개의 post dto List 들의 인덱스가 정확히 매칭된다.

        // boards 의 이름에 맞춰 Post 객체들을 4개씩 페이징하여 posts 로 넣는다. 
        boards.forEach(b -> {
            posts.add(postService.getPostWithPaging(b.getName()));
        });

        System.out.println(posts.toArray());

        // idList 만들기
        List<Long> idList = boardService.getAllId();

        HomeResDto result = new HomeResDto(memberDto, posts, boards, idList);
        return result;
    }
}
