package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.service.CommentService;
import com.example.validation.CommentForm;

@Controller
@SessionAttributes("name")
public class CommentController {
	@Autowired
	CommentService cs;
	
	@RequestMapping(value = "/newComment", method = RequestMethod.POST)
	public String newComment(Model model,@Validated CommentForm cf,BindingResult result,
			@RequestParam String threadNumber,@ModelAttribute("name")String name) {
		int num=Integer.parseInt(threadNumber);
		cs.resister(num, cf.getMessage(),name );
		model.addAttribute("data", cs.getAllComment(num));
		return "comment";
	}
}
