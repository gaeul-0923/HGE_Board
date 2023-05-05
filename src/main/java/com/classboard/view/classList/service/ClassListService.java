package com.classboard.view.classList.service;

import com.classboard.view.classList.mapper.ClassListMapper;
import com.classboard.view.classList.vo.ClassVO;
import com.classboard.view.classList.vo.RelateClassVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@Transactional(rollbackFor = Exception.class)
public class ClassListService {

  @Autowired
  private ClassListMapper classBoardListMapper;

  public List<ClassVO> selectClassList() throws Exception
  {
    return classBoardListMapper.selectClassList();
  }

  public ClassVO selectClassDetail(ClassVO classVO) throws Exception
  {
    return classBoardListMapper.selectClassDetail(classVO);
  }

  public List<RelateClassVO> selectRelateClass(ClassVO classVO) throws Exception
  {
    return classBoardListMapper.selectRelateClass(classVO);
  }

  public int insertClass(ClassVO classVO) throws Exception
  {
    return classBoardListMapper.insertClass(classVO);
  }
}
