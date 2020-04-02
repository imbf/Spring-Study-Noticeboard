package board.domain;

import java.util.List;

public interface BoardDao {
    public abstract List<BoardDTO> list();

    public abstract int delete(BoardDTO boardDTO);

    public abstract int deleteAll();

    public abstract int update(BoardDTO boardDTO);

    public abstract int insert(BoardDTO boardDTO);

    public abstract BoardDTO select(int seq);

    public abstract int updateReadCount(int seq);
}
