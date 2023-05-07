package com.classboard.view.classList.mapper;

import com.classboard.view.classList.vo.ClassVO;
import com.classboard.view.classList.vo.ContainVO;
import com.classboard.view.classList.vo.RelateClassVO;
import com.classboard.view.classList.vo.WordVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClassListMapper {

	/**
	 * 강의 목록보기
	 * @return
	 * @throws Exception
	 */
	public List<ClassVO> selectClassList() throws Exception;

	/**
	 * 강의 상세보기
	 * @param classVO
	 * @return
	 * @throws Exception
	 */
	public ClassVO selectClassDetail(ClassVO classVO) throws Exception;

	/**
	 * 관련된 강의 조회
	 * @param classVO
	 * @return
	 * @throws Exception
	 */
	public List<RelateClassVO> selectRelateClass(ClassVO classVO) throws Exception;

	/**
	 * 강의 등록
	 * @param classVO
	 * @return
	 * @throws Exception
	 */
	public int insertClass(ClassVO classVO) throws Exception;

	/**
	 * 예외로 할 단어 조회
	 * @return
	 * @throws Exception
	 */
	List<WordVO> selectExceptionWord() throws Exception;

	/**
	 * 기존에 등록된 단어 조회
	 * @return
	 * @throws Exception
	 */
	List<WordVO> selectWord() throws Exception;

	/**
	 * 단어 저장
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int insertWord(Map<String, Object> paramMap) throws Exception;

	/**
	 * 중복된 단어 저장
	 * @param containVO
	 * @return
	 * @throws Exception
	 */
	public int insertContain(ContainVO containVO) throws Exception;
}
