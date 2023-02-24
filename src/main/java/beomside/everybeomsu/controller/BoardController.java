package beomside.everybeomsu.controller;

import beomside.everybeomsu.domain.Board;
import beomside.everybeomsu.domain.Post;
import beomside.everybeomsu.dto.res.board.PostBoardResDto;
import beomside.everybeomsu.service.BoardService;
import beomside.everybeomsu.service.PostService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final PostService postService;

    @GetMapping("/board/{boardName}/{page}")
    public List<PostBoardResDto> getPosts(
            @PathVariable("boardName") String boardName,
            @PathVariable("page") int page) {

        return postService.getPostPageByName(boardName, page);
    }


    @PostMapping("/createBoard/{boardName}")
    public void createBoard(@PathVariable("boardName") String boardName) {
        Board board = Board.builder()
                .name(boardName)
                .build();

        boardService.createBoard(board);
    }
}
