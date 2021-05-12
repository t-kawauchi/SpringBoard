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
import com.example.service.ThreadService;
import com.example.validation.NameForm;
import com.example.validation.SearchForm;
import com.example.validation.ThreadForm;

@Controller

@SessionAttributes("name")
public class IndexController {
	@Autowired
	ThreadService ts;
	@Autowired
	CommentService cs;

	@ModelAttribute("name")
	String name() {
		return "名無し";
	}
	

	
	//indexの表示処理、過去のthreadデータを取得
	@RequestMapping(value = "/")
	public String moveIndex(Model model, ThreadForm tf, SearchForm sf) {
		model.addAttribute("data", ts.getAllThread());
		return "index";
	}

	//スレッド作成をおしたとき
	@RequestMapping(value = "/newThread", method = RequestMethod.POST)
	public String onClickNewThread(Model model, @Validated ThreadForm tf, BindingResult result, SearchForm sf,
			@ModelAttribute String name) {
		if (result.hasErrors()) {
			return moveIndex(model, tf, sf);
		}
		//スレッド管理テーブル(THREAD_DATA_ENTITY)にデータを登録する処理
		int threadNumber=ts.resisterAndGetThreadNumber(tf, name);
		cs.resister(threadNumber,tf.getMessage(),name);
		return "redirect:/";
	}

	//詳細閲覧を押したときの処理
		@RequestMapping(value = "/comment", method = RequestMethod.POST)
		public String onClickView(@RequestParam("threadNumber") String threadNumber, Model model) {
			//スレッド番号を取得しコメントDBからスレッド版番号が一致するものを取り出し、モデルに格納
			Integer num = Integer.parseInt(threadNumber);
			model.addAttribute("data",cs.getAllComment(num));
			return "comment";
		}
	//
	//	//書き込みボタンが押されたとき
	//	@RequestMapping(value = "/newComment", method = RequestMethod.POST)
	//	public String onClickNewComent(@RequestParam("threadNumber") String threadNumber,
	//			@ModelAttribute("name") String name,
	//			@RequestParam String message, Model model) {
	//		commentDataRepository.save(new CommentDataEntity(Integer.parseInt(threadNumber), name, message));
	//		commentDataRepository.flush();
	//
	//		Integer num = Integer.parseInt(threadNumber);
	//		List<CommentDataEntity> data = commentDataRepositoryCustom.searchThread(num);
	//		model.addAttribute("CommentData", data);
	//		return "view";
	//	}
	
	//	//index.htmlで名前変更を押したとき
	@RequestMapping(value = "/changeName", method = RequestMethod.GET)
	public String moveChangeName(NameForm nf) {
		return "changeName";
	}

	//	//nameChange.htmlで変更を押したとき
	//	@RequestMapping(value = "/nameChange", method = RequestMethod.POST)
	//	public String onClickNameChange(@RequestParam("newName") String newName, Model model) {
	//		model.addAttribute("name", newName);
	//		List<ThreadDataEntity> data = threadDataRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	//		model.addAttribute("threadData", data);
	//		return "index";
	//	}
	//
	//検索ボタンが押されたとき
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String onClickSearch(Model model, ThreadForm tf, @Validated SearchForm sf, BindingResult result) {
		if (result.hasErrors()) {
			return moveIndex(model, tf, sf);
		}
		model.addAttribute("data", ts.search(sf.getSearch()));
		return "index";
	}
}
