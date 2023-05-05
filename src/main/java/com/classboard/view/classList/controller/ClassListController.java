package com.classboard.view.classList.controller;

import com.classboard.view.classList.service.ClassListService;
import com.classboard.view.classList.vo.ClassVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Log4j2
@Controller
@RequestMapping("classBoard")
public class ClassListController {
  @Autowired
  private ClassListService classBoardListService;

  @GetMapping("/classList")
  public String classList(Model model, @RequestParam HashMap<String, String> searchMap) throws Exception{

    model.addAttribute("searchMap", searchMap);
    return "classBoard/classBoardList";
  }

  @GetMapping("/classAdd")
  public String classAdd(Model model, @RequestParam HashMap<String, String> searchMap) throws Exception{


    return "classBoard/classBoardAdd";
  }

  @GetMapping("/classDetail")
  public String classDetail(Model model, @RequestParam HashMap<String, String> searchMap) throws Exception{


    ClassVO classVO = new ClassVO();
    classVO.setClass_seq(searchMap.get("class_seq"));
    ClassVO classDetail = classBoardListService.selectClassDetail(classVO);

    model.addAttribute("searchMap", searchMap);
    model.addAttribute("classDetail", classDetail);
    return "classBoard/classBoardDetail";
  }
}
