package board.controller;

import board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/board/list")
    public String list(Model model) { // 모델에 대한 참조변수를 인자로써 추가
        // 모델에 속성을 추가
        model.addAttribute("boardList", boardService.list());
        return "WEB-INF/board/list";   // DispatcherServlet이 뷰를 선정하는 힌트
    }
}

