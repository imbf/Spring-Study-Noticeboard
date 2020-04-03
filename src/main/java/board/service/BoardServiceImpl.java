package board.service;

import board.domain.BoardDTO;
import board.domain.BoardDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Resource
    private BoardDao boardDao;

    public BoardDao getBoardDao() {
        return boardDao;
    }

    public void setBoardDao(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Override
    public List<BoardDTO> list() {
        return boardDao.list();
    }

    @Override
    public int delete(BoardDTO boardDTO) {
        return boardDao.delete(boardDTO);
    }

    @Override
    public int edit(BoardDTO boardDTO) {
        return boardDao.update(boardDTO);
    }

    @Override
    public void write(BoardDTO boardDTO) {
        boardDao.insert(boardDTO)
    }

    @Override
    public BoardDTO read(int seq) {
        return boardDao.select(seq);
    }
}
