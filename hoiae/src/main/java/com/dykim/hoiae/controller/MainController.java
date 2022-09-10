package com.dykim.hoiae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public ModelAndView redirectList(ModelAndView mv, RedirectAttributes rttr){
        mv.setViewName("redirect:/memo/list");
        rttr.addFlashAttribute("successMessage", "Welcome to Hoiae memo");

        return mv;
    }
}
