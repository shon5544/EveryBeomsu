package beomside.everybeomsu.service;

import beomside.everybeomsu.domain.Board;
import beomside.everybeomsu.dto.res.home.BoardHomeResDto;
import beomside.everybeomsu.repository.BoardRepository;
import beomside.everybeomsu.repository.jpa.BoardJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardJpaRepository boardJpaRepository;

    @Transactional
    public void createBoard(Board board) {
        boardRepository.save(board);
    }

    public List<BoardHomeResDto> getAll() {
        return boardRepository.findAll().stream()
                .map(b -> new BoardHomeResDto(b.getName()))
                .collect(Collectors.toList());
    }

    public List<Long> getAllId() {
        return boardJpaRepository.getIdList();
    }

    public Board getBoardById(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(() -> new EntityNotFoundException("해당 id의 게시판이 없습니다."));
    }
}
