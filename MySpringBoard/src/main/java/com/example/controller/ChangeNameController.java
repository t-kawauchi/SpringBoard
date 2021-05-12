package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.validation.NameForm;

@Controller
@SessionAttributes("name")
public class ChangeNameController {
	@RequestMapping(value = "/change", method = RequestMethod.POST)
	public String onClickChangeName(Model model,@Validated NameForm nf,BindingResult result,@ModelAttribute String name) {
		if(result.hasErrors()) {
			return "changeName";
		}
		model.addAttribute("name",nf.getName());
		return "redirect:/";
	}
	
}