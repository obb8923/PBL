# PBL project : Make AD management Server

## 💻프로젝트 소개
국민대학교 에서 ( 2024/01/08 ~ 2024/01/19 ) 10일간 진행한, 광고 관리 서비스 제작 프로젝트입니다.

## 🙋‍♂️팀원 소개
[김유빈](github.com/KimYooBin1) - 국민대학교 소프트웨어학과 3학년 

[김혜은](github.com/hyeesw) - 국민대학교 소프트웨어학과 2학년 

[박정빈](github.com/obb8923) - 국민대학교 나노전자물리학과 3학년 

[한초희](github.com/cherror) - 국민대학교 소프트웨어학과 2학년 



## ⚙️시작 가이드
   ### 요구사항
   `java 17+`
   `springframework.boot 3.2.1`
   `JPA`
   `mySQL`
   
   ### 환경설정
1. Intellij 설치
     - [Intall Intellij link](https://www.jetbrains.com/idea/)
     - 무료로 community version 이용이 가능하며, 만약 학생용 메일이 있다면 유료 버전인 ultimate 이용이 가능하다.
2. `git clone`을 통해 repository 내용 복제
3. clone이 완료된 후 프로젝트가 있는 파일을 열고, build가 되기를 기다린다.
4. application.properties 에서 ( 위치: 프로젝트 파일\PBL_AD_Manager\src\main\resources )
   ```
   spring.datasource.url=
   spring.datasource.username=
   spring.datasource.password=
   ```
   database를 현재 사용가능한 것으로 설정한 후, url,name,password  적어준다.
5.   class PblAdManagerApplication 를 실행시킨다. ( 위치 :프로젝트 폴더\PBL_AD_Manager\src\main\java\team2\PBL_AD_Manager )

## 🛠️주요 기능
   1. 홈화면에서는 DB에서 광고를 가져와서 5개씩 Table로 보여준다.
   2. 홈화면을 가져올때 DB의 전체 광고 수를 가져와서 Pagination 버튼 5개의 넘버링을 하고 display 를 조절한다.
   3. Table 의 상세 버튼을 누르면 상세페이지로 넘어간다.
   4. ADD 버튼을 누르면 광고 정보를 입력할 수 있는 레이어 팝업이 나온다.
   5. ADD 버튼 레이어 팝업에서 확인을 누르면 DB에 광고 정보가 저장되며, 홈화면이 redirection 되어 Table의 정보가 바뀐다.
   6. ADTest , 수정, 삭제 기능은 미완성이다.
      
   * ### 홈화면
![image](https://github.com/PBL-AD-Management/Backend/assets/59199893/ed3e8d9a-bf37-4834-8416-987fcfe850e4)
   * ### Pagination 기능
![image](https://github.com/PBL-AD-Management/Backend/assets/59199893/47233664-06ab-4980-9c94-d583b1980514)
   * ### 상세
![image](https://github.com/PBL-AD-Management/Backend/assets/59199893/b808e872-a2a2-47a0-815e-8f25a06afbfc)
   * ### ADD 버튼을 눌렀을때 나오는 레이어 팝업
![image](https://github.com/PBL-AD-Management/Backend/assets/59199893/537d3028-4330-4bd0-8693-4087dbcacf35)
   * ### AD Test 버튼을 눌렀을때 나오는 레이어 팝업
![image](https://github.com/PBL-AD-Management/Backend/assets/59199893/415b8150-f9b9-43ca-b4e4-c7563d4bd234)


## 🔗사용한 기술
* ### IDE
  <img src="https://img.shields.io/badge/Intellij-000000?style=for-the-badge&logo=Intellij&logoColor=white">
* ### LANGUAGE
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
* ### FRAMEWORK
  <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
* ### DATABASE
  <img src="https://img.shields.io/badge/mySQL-4479A1?style=for-the-badge&logo=mySQL&logoColor=white">
* ### COMMUNICATION
  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"> <img src="https://img.shields.io/badge/notion-000000?style=for-the-badge&logo=notion&logoColor=white"> <img src="https://img.shields.io/badge/Trello-0052CC?style=for-the-badge&logo=Trello&logoColor=white">
