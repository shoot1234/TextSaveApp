package com.example.demo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	 public String summary(Model model, NewDiaryForm newDiaryForm) {
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

	//投稿文章の新規登録
	@PostMapping("add")
	public String add(Model model, @Valid NewDiaryForm newDiaryForm, BindingResult bindingResult) {
	    //バリデーションエラーがあるかどうかチェックして、エラーがあるなら新規登録処理をせずに、一覧表示メソッドを呼び出す
	    if (bindingResult.hasErrors()) {
	    	return summary(model, newDiaryForm);
	    }
	    //ChronoUnit.SECONDSで秒以下を切り捨て
	    Diary diary = new Diary(newDiaryForm.getNewdiary(), LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
	    diaryRepository.save(diary);
	    return "redirect:/diary/summary";
	  }

}
