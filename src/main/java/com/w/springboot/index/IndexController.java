package com.w.springboot.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

	@RequestMapping("hello")
	public String first(Model model) {
	    model.addAttribute("hello", "hello world");
	    return "index";
	}
}
