package board.service;

import board.domain.BoardDTO;

import java.util.List;

public interface BoardService {
    public abstract List<BoardDTO> list();

    public abstract int delete(BoardDTO boardDTO);

    public abstract int edit(BoardDTO boardDTO);

    public abstract void write(BoardDTO boardDTO);

    public abstract BoardDTO read(int seq);
}
