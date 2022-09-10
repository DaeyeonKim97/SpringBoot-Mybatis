package com.dykim.hoiae.controller;

import com.dykim.hoiae.model.dto.ReplyDTO;
import com.dykim.hoiae.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping("/reply")
public class ReplyController {
    private final MemoService memoService;

    @Autowired
    public ReplyController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping
    public ModelAndView insertReply(ModelAndView mv, @RequestParam int memoCode,
                                    @RequestParam String author,
                                    @RequestParam String content,
                                    RedirectAttributes rttr) throws Exception {
        ReplyDTO reply = new ReplyDTO(0, author, content, new Date(), "Y", memoCode);
        memoService.insertReply(reply);
        mv.setViewName("redirect:/memo/"+memoCode);
        rttr.addFlashAttribute("successMessage", "댓글이 추가되었습니다.");

        return mv;
    }
}
