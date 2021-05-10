package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.validation.NameForm;

@Controller
@RequestMapping(value="/changeName")
public class ChangeNameController {
	@RequestMapping(value = "/change", method = RequestMethod.POST)
	public String onClickNameChange(Model model,@Validated NameForm nf,BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("valid失敗");
			return"changeName";
		}
		model.addAttribute("name",nf.getName());
		System.out.println("validセーフ");
		return "forward:/";
	}
}