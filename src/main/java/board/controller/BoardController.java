package board.controller;

import board.domain.BoardDTO;
import board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@SessionAttributes("boardDTO")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/board/list")
    public String list(Model model) { // 모델에 대한 참조변수를 인자로써 추가
        // 모델에 속성을 추가
        model.addAttribute("boardList", boardService.list());
        return "/board/list";   // DispatcherServlet이 뷰를 선정하는 힌트
    }

    @RequestMapping(value = "/board/read/{seq}") // {seq}는 경로 변수라고 한다.
    public String read(Model model, @PathVariable int seq) {
        model.addAttribute("boardDTO", boardService.read(seq));
        return "/board/read";
    }

    @RequestMapping(value = "/board/write", method = RequestMethod.GET)
    public String write(Model model) {
        model.addAttribute("boardDTO", new BoardDTO());
        return "/board/write";
    }

    @RequestMapping(value = "/board/write", method = RequestMethod.POST)
    public String write(@Valid BoardDTO boardDTO, BindingResult bindingResult) { // 바인딩 결과 인자 : BindingResult 인스턴스
        if (bindingResult.hasErrors()) { // 바인딩 에러 처리 코드
            return "/board/write";
        } else {
            boardService.write(boardDTO);
            return "redirect:/board/list";
        }
    }

    @RequestMapping(value = "/board/edit/{seq}", method = RequestMethod.GET)
    public String edit(@PathVariable int seq, Model model) {
        BoardDTO boardDTO = boardService.read(seq);
        model.addAttribute("boardDTO", boardDTO);
        return "/board/edit";
    }

    @RequestMapping(value = "/board/edit/{seq}", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute BoardDTO boardDTO, BindingResult result, int pwd, SessionStatus sessionStatus, Model model) {
        if (result.hasErrors()) {
            return "/board/edit";
        } else {
            // 스프은 input 태그 가운데 pwd라는 이름을 가진 input 태그의 값을 자동으로 바인딩 해준다.
            if (boardDTO.getPassword() == pwd) {
                boardService.edit(boardDTO);
                sessionStatus.setComplete();
                return "redirect:/board/list";
            }
        }
        model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
        return "/board/edit";
    }

    @RequestMapping(value = "/board/delete/{seq}", method = RequestMethod.GET)
    public String delete(@PathVariable int seq, Model model) {
        model.addAttribute("seq", seq);
        return "/board/delete";
    }

    @RequestMapping(value = "/board/delete", method = RequestMethod.POST)
    public String delete(int seq, int pwd, Model model) {
        int rowCount;
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setSeq(seq);
        boardDTO.setPassword(pwd);

        rowCount = boardService.delete(boardDTO);

        if (rowCount == 0) {
            model.addAttribute("seq", seq);
            model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
            return "/board/delete";
        } else {
            return "redirect:/board/list";
        }
    }
}
