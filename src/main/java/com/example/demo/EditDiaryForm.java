package com.example.demo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class EditDiaryForm {
  //編集する文章id
  @NotNull
  private int id;

  //編集投稿された文章
  @NotNull
  @Size(min=3, max=150)
  private String updateddiary;
}