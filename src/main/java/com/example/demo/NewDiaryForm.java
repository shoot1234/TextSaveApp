package com.example.demo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class NewDiaryForm {
  //新規投稿された投稿文章
  @NotNull
  @Size(min=3, max=150, message="文字数は３〜１５０文字です。")//message属性で検証エラー時に表示する文言を指定
  private String newdiary;
}