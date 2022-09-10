package com.dykim.hoiae.controller;

import com.dykim.hoiae.model.dto.MemoDTO;
import com.dykim.hoiae.model.dto.ReplyDTO;
import com.dykim.hoiae.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/memo")
public class MemoController {
    private final MemoService memoService;

    @Autowired
    public MemoController(MemoService memoService){
        this.memoService = memoService;
    }

    @GetMapping("/list")
    public ModelAndView selectAllMemo(ModelAndView mv){
        List<MemoDTO> memoList = memoService.selectAllMemo();
        memoList.forEach(System.out::println);

        mv.addObject("memoList",memoList);
        mv.setViewName("memo/list");

        return mv;
    }

    @GetMapping("{code}")
    public ModelAndView selectMemoByMemoCode(@PathVariable("code")  int memoCode, ModelAndView mv){

        System.out.println(memoCode);

        MemoDTO memo = memoService.selectMemoByCode(memoCode);
        List<ReplyDTO> replies = memoService.selectReplyByMemoCode(memoCode);

        mv.addObject("memo", memo);
        mv.addObject("replies", replies);
        mv.setViewName("memo/detail");

        return mv;
    }

    @GetMapping("/insert")
    public void insertMemoPage(){}

    @PostMapping("/insert")
    public ModelAndView insertMemo(ModelAndView mv, @RequestParam String title, @RequestParam String content, RedirectAttributes rttr) throws Exception {
        MemoDTO memo = new MemoDTO(0, title, content, new Date(), "Y");

        memoService.insertMemo(memo);
        mv.setViewName("redirect:/memo/list");
        rttr.addFlashAttribute("successMessage", "메모 추가에 성공했습니다.");

        return mv;
    }

    @GetMapping("/update")
    public ModelAndView updateMemoPage(ModelAndView mv, @RequestParam int code){
        MemoDTO memo = memoService.selectMemoByCode(code);
        mv.addObject("memo", memo);
        System.out.println(memo.getContent());
        mv.setViewName("/memo/update");

        return mv;
    }

    @PostMapping("/update")
    public ModelAndView updateMemo(ModelAndView mv, @RequestParam int code, @RequestParam String title, @RequestParam String content, RedirectAttributes rttr) throws Exception {
        MemoDTO memo = new MemoDTO(code, title, content, null, "Y");

        memoService.updateMemo(memo);
        mv.setViewName("redirect:/memo/"+code);
        rttr.addFlashAttribute("successMessage", "메모 수정에 성공했습니다.");

        return mv;
    }

    @PostMapping("/delete")
    public ModelAndView updateMemo(ModelAndView mv, @RequestParam int code, RedirectAttributes rttr) throws Exception {

        memoService.deleteMemo(code);
        mv.setViewName("redirect:/memo/list");
        rttr.addFlashAttribute("successMessage", "메모 삭제에 성공했습니다.");

        return mv;
    }


}
