# 강의를 소개하기 위한 게시판입니다.


## 개발 기간
2023.05.04 ~ 2023.05.07


## 개발 환경

- 개발 언어 : Java11, Thymeleaf, JavaScript, jQuery
- Framework/ Library : SpringBoot2.5.5, mybatis, toast ui
- DBMS : mySQL
- OS : macOS
- etc : ErdCloud


## erd 구조

https://www.erdcloud.com/d/o2mmRcRWXPSREe8e4


## 역할

- 요구사항 분석
- 디비 설계
- 초기 환경 셋팅
- 게시판 api 비즈니스 로직 설계
- 뷰단 출력

## 게시판 요구 조건

- 목록보기, 상세보기, 글쓰기 기능이 동작할 것
- 각 게시물들은 연관 게시물이 있을 수도 없을 수도 있음
- 연관 게시물이 되는 조건은 중복되는 단어가 2개 이상 동시에 있을 경우
- 단, 전체 게시글에서 60% 이상 발견되는 단어는 고려하지 않음
