package com.classboard.view.classList.controller;

import com.classboard.common.response.ResponseCode;
import com.classboard.common.response.ResponseVO;
import com.classboard.view.classList.service.ClassListService;
import com.classboard.view.classList.vo.ClassVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("api/classBoard")
public class ApiClassListController {

  @Autowired
  private ClassListService classBoardListService;


  @PostMapping("/selectClassBoardList")
  public ResponseVO selectClassBoardList(HttpServletRequest request) throws Exception{

    List<ClassVO> classList = classBoardListService.selectClassList();
    return new ResponseVO(ResponseCode.SUCCESS,classList);
  }

}
