package board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class BoardController {
    @Autowired
    private BoardService boardService;

    @RequestMapping(value="/board/list")
    @ResponseBody
    public String list() {
        return boardService.list().toString();
    }
}
