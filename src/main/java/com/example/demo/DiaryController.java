package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("diary")
public class DiaryController {
	@Autowired
	DiaryRepository diaryRepository;
	
	//投稿文章一覧情報の取得
	@GetMapping("summary")
	public String summary(Model model) {
		Iterable<Diary> diarys = diaryRepository.findAll();
		model.addAttribute("diarys", diarys);
		return "summary";
	}
	
	//指定されたidの投稿文章を削除する
	  @PostMapping("delete")
	  public String delete(@RequestParam Integer id) {
	    diaryRepository.deleteById(id);
	    return "redirect:/diary/summary";
	  }
	
	
}
