package com.classboard.view.classList.controller;

import com.classboard.common.response.ResponseCode;
import com.classboard.common.response.ResponseVO;
import com.classboard.view.classList.service.ClassListService;
import com.classboard.view.classList.vo.ClassVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Log4j2
@RestController
@RequestMapping("api/classBoard")
public class ApiClassListController {

  @Autowired
  private ClassListService classBoardListService;

  /**
   * 강의 목록 보기
   * @param request
   * @return
   * @throws Exception
   */
  @PostMapping("/selectClassBoardList")
  public ResponseVO selectClassBoardList(HttpServletRequest request) throws Exception{

    List<ClassVO> classList = classBoardListService.selectClassList();
    return new ResponseVO(ResponseCode.SUCCESS,classList);
  }

  /**
   * 강의 저장
   * @param request
   * @param classVO
   * @return
   * @throws Exception
   */
  @PostMapping("/insertClass")
  public ResponseVO insertClass(HttpServletRequest request, @ModelAttribute ClassVO classVO) throws Exception{
    int result = classBoardListService.insertClass(classVO);
    if (result > 0) {
      return new ResponseVO(ResponseCode.SUCCESS, 1);
    } else {
      return new ResponseVO(ResponseCode.SUCCESS, 0);
    }
  }

  /**
   * 연관된 단어 저장
   * @param request
   * @param classVO
   * @return
   * @throws Exception
   */
  @PostMapping("/insertContainWord")
  public ResponseVO insertContainWord(HttpServletRequest request, @RequestBody ClassVO classVO) throws Exception{

    int result = classBoardListService.insertContainWord(classVO);

    return new ResponseVO(ResponseCode.SUCCESS, result);
  }

}
