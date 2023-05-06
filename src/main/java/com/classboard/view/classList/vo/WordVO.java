package com.classboard.view.classList.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WordVO {
  private String exception_seq;
  private String exception_name;

  private String word_seq;
  private String word_name;
  private String in_id;
  private List<String> wordList;


}
