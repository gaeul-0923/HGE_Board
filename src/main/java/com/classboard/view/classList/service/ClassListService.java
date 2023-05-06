package com.classboard.view.classList.service;

import com.classboard.view.classList.mapper.ClassListMapper;
import com.classboard.view.classList.vo.ClassVO;
import com.classboard.view.classList.vo.ContainVO;
import com.classboard.view.classList.vo.RelateClassVO;
import com.classboard.view.classList.vo.WordVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.classboard.common.CommUtill.*;

@Log4j2
@Service
@Transactional(rollbackFor = Exception.class)
public class ClassListService {

  @Autowired
  private ClassListMapper classBoardListMapper;

  /**
   * 강의 목록보기
   * @return
   * @throws Exception
   */
  public List<ClassVO> selectClassList() throws Exception
  {
    return classBoardListMapper.selectClassList();
  }

  /**
   * 강의 상세보기
   * @param classVO
   * @return
   * @throws Exception
   */
  public ClassVO selectClassDetail(ClassVO classVO) throws Exception
  {
    return classBoardListMapper.selectClassDetail(classVO);
  }

  /**
   * 연관된 강의 조회
   * @param classVO
   * @return
   * @throws Exception
   */
  public List<RelateClassVO> selectRelateClass(ClassVO classVO) throws Exception
  {
    return classBoardListMapper.selectRelateClass(classVO);
  }

  /**
   * 강의 저장
   * @param classVO
   * @return
   * @throws Exception
   */
  public int insertClass(ClassVO classVO) throws Exception {
    try {

      classVO.setUp_id(classVO.getIn_id());
      classBoardListMapper.insertClass(classVO);

      List<WordVO> existWordList = classBoardListMapper.selectWord();
      String[] existList = new String[existWordList.size()];
      for (int i = 0; i < existWordList.size(); i++) {
        existList[i] = existWordList.get(i).getWord_name();
      }

      Map<String, Integer> duplicateElements = new HashMap<>();
      Map<String, Integer> duplicateFrequencies = new HashMap<>();
      List<Integer> duplicateIndices = new ArrayList<>();


      for (int i = 0; i < existList.length; i++) {
        for (int j = 0; j < classVO.getWordList().length; j++) {
          if (existList[i].equals(classVO.getWordList()[j])) {
            duplicateElements.put(existList[i], i);
            duplicateFrequencies.put(existList[i], duplicateFrequencies.getOrDefault(existList[i], 0) + 1);
            duplicateIndices.add(i);
          }
        }
      }

      List<Integer> contain_cnt = new ArrayList<>();
      for (Map.Entry<String, Integer> entry : duplicateElements.entrySet()) {
        String element = entry.getKey();
        int frequency = duplicateFrequencies.get(element);
        contain_cnt.add(frequency);
        int index = entry.getValue();

      }

      List<String> wordseqList = new ArrayList<>();
      for (int i = 0; i < duplicateIndices.size(); i++) {
        wordseqList.add(existWordList.get(duplicateIndices.get(i)).getWord_seq());
      }

      for (int i = 0; i < wordseqList.size(); i++) {
        ContainVO containVO = new ContainVO();
        containVO.setClass_seq(classVO.getClass_seq());
        containVO.setWord_seq(wordseqList.get(i));
        containVO.setContain_cnt(contain_cnt.get(i));
        containVO.setIn_id(classVO.getIn_id());
        classBoardListMapper.insertContain(containVO);
      }

      return 1;

    } catch (Exception e) {
      log.debug(e);
      return 0;
    }
  }

  /**
   * 연관된 단어 저장
   * @param classVO
   * @return
   * @throws Exception
   */
  public int insertContainWord(ClassVO classVO) throws Exception{
    // 입력한 내용을 단어로 추출
    // 조사같은 예외 단어 조회
    try {

      List<WordVO> exceptionList = classBoardListMapper.selectExceptionWord();

      List<String> exceptionWordList = new ArrayList<>();
      for (int i = 0; i< exceptionList.size(); i++){
        exceptionWordList.add(exceptionList.get(i).getException_name());
      }

      // 조사가 붙은 단어 일 경우 조사를 잘라준다
      List<String> word = new ArrayList<>();
      String[] contentList = classVO.getWordList();
      for (int i = 0; i < contentList.length; i++) {
        String particle = separateParticle(contentList[i], exceptionWordList);
        String noun = contentList[i].substring(0, contentList[i].length() - particle.length());
        word.add(noun);
      }

      List<WordVO> wordList = classBoardListMapper.selectWord();
      List<String> existList = new ArrayList<>();
      for (int i = 0; i < wordList.size(); i++) {
        existList.add(wordList.get(i).getWord_name());
      }

      //기존 word 테이블에 있는 단어인지 조회
      for (int i = 0; i < word.size(); i++) {
        if (existList.contains(word.get(i))) {
          word.remove(i); // 중복된 단어가 있다면 배열에서 삭제해 준다
        }
      }

      // word 테이블에 저장
      Map<String, Object> paramMap = new HashMap<>();
      paramMap.put("wordList", word);
      paramMap.put("in_id", classVO.getIn_id());
      classBoardListMapper.insertWord(paramMap);

      return 1;
    } catch (Exception e) {
      log.debug(e);
      return 0;
    }
  }
}
