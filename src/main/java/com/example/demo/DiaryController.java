package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
}
