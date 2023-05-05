package com.classboard.view.classList.mapper;

import com.classboard.view.classList.vo.ClassVO;
import com.classboard.view.classList.vo.RelateClassVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ClassListMapper {

	public List<ClassVO> selectClassList() throws Exception;

	public ClassVO selectClassDetail(ClassVO classVO) throws Exception;

	public List<RelateClassVO> selectRelateClass(ClassVO classVO) throws Exception;

	public int insertClass(ClassVO classVO) throws Exception;



}
