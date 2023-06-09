package com.classboard.view.classList.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClassVO {
  private String class_seq;
  private String class_name;
  private String class_content;
  private String word_seq;
  private String[] wordList;
  private String in_id;
  private String in_dtm;
  private String up_id;
  private String up_dtm;
}
