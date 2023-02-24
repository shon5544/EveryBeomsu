package beomside.everybeomsu.controller;

import beomside.everybeomsu.domain.Board;
import beomside.everybeomsu.dto.req.BoardReqDto;
import beomside.everybeomsu.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/createBoard/{boardName}")
    public void createBoard(@PathVariable("boardName") String boardName) {
        Board board = Board.builder()
                .name(boardName)
                .build();

        boardService.createBoard(board);
    }
}
