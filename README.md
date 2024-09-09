# PBL project : Make AD management Server

## 💻프로젝트 소개
국민대학교에서 ( 2024/01/08 ~ 2024/01/19 ) 10일간 진행한, 광고 관리 서비스 제작 프로젝트입니다.

<br>

## 👨‍👩‍👧‍👦 팀원 소개
[김유빈](https://github.com/KimYooBin1) - 국민대학교 소프트웨어학과 3학년 

[김혜은](https://github.com/hyeesw) - 국민대학교 소프트웨어학과 3학년 

[박정빈](https://github.com/obb8923) - 국민대학교 나노전자물리학과 3학년 

[한초희](https://github.com/cherror) - 국민대학교 소프트웨어학과 2학년 

<br>
 
## 🗂️ 시스템 설계
### Sceinaro
<img src="https://github.com/PBL-AD-Management/Backend/assets/84231143/5142838f-e39b-4e7c-8255-ec46a007dc9a" width=50%>

### ERD
<img src="https://github.com/PBL-AD-Management/Backend/assets/84231143/e32899a8-3260-463f-a256-20822ac1c476" width=49%>
<img src="https://github.com/PBL-AD-Management/Backend/assets/84231143/b15054b1-933d-4e58-b12f-c5a98e6ccd57" width=49%>

### System Architecture
<img src="https://github.com/PBL-AD-Management/Backend/assets/84231143/6f64f100-5854-4c62-ac43-7718ca52aef1" width=70%>

<br><br>

## ⚙️ 시작 가이드
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


<br><br>

## 🛠️ 주요 기능
   1. 홈화면에서는 DB에서 광고를 가져와서 5개씩 Table로 보여준다.
   2. 홈화면을 가져올때 DB의 전체 광고 수를 가져와서 Pagination 버튼 5개의 넘버링을 하고 display 를 조절한다.
   3. Table 의 상세 버튼을 누르면 상세페이지로 넘어간다.
   4. ADD 버튼을 누르면 광고 정보를 입력할 수 있는 레이어 팝업이 나온다.
   5. ADD 버튼 레이어 팝업에서 확인을 누르면 DB에 광고 정보가 저장되며, 홈화면이 redirection 되어 Table의 정보가 바뀐다.
   6. 삭제 버튼 레이어 팝업에서 확인을 누르면 DB에 저장되어 있는 해당 광고의 isActive colum 이 false 로 변경된다. ui 에서 광고 만료 여부가 활성에서 만료로 변경되고 list 에서 조회는 되지만, 실제 adTest시에는 해당 광고가 출력되지 않는다
   7. 수정 버튼 레이어 팝업에서 수정 데이터를 입력하고 확인을 누르면 해당 광고 id를 통해 DB 에서 광고를 찾아와 입력데이터로 수정된 후 다시 저장된다
   8. 검색기능은 두가지로 select를 통해 활성 또는 비활성인 광고만을 조회할 수 있고, input 창을 통해서 찾는 광고 title 을 입력하면 해당 title을 가진 광고를 list에 보여준다
   9. ADTest 레이어에서 유저를 선택하면 해당 유저의 정보가 출력된다(age, gender). Web View버튼을 누르게 되면 해당 유저정보를 바탕으로 DB 의 targetInf table을 조회해 해당 유저의 target Id를 찾아낸다. 이후 contract table 에서 해당 id와 동일한 광고를 찾아온후 페이지에 보여준다
   
      
   * ### 홈화면
![image](https://github.com/PBL-AD-Management/Backend/assets/59199893/ed3e8d9a-bf37-4834-8416-987fcfe850e4)
   * ### Pagination 기능
![image](https://github.com/PBL-AD-Management/Backend/assets/59199893/47233664-06ab-4980-9c94-d583b1980514)
   * ### 상세
![image](https://github.com/PBL-AD-Management/Backend/assets/59199893/b808e872-a2a2-47a0-815e-8f25a06afbfc)
   * ### ADD 버튼을 눌렀을때 나오는 레이어 팝업
![image](https://github.com/PBL-AD-Management/Backend/assets/59199893/537d3028-4330-4bd0-8693-4087dbcacf35)
   * ### AD Test 버튼을 눌렀을때 나오는 레이어 팝업
   ## 이전 버전
![image](https://github.com/PBL-AD-Management/Backend/assets/59199893/415b8150-f9b9-43ca-b4e4-c7563d4bd234)
   ## 수정 버전
![image](https://github.com/PBL-AD-Management/Backend/assets/55120730/8e67dd53-2b61-4b4b-8170-300d2f609cbd)
   * ### adTest Page
![image](https://github.com/PBL-AD-Management/Backend/assets/55120730/5c9c1f07-5251-4827-b84c-6336392623a9)
   * ### 삭제 버튼을 눌렀을때 나오는 레이어 팝업(6번 광고)
![image](https://github.com/PBL-AD-Management/Backend/assets/55120730/5a98a539-96f3-4187-8970-d9dff76611a6)
   * ### 삭제 후 : 만료가 되면 조회는 되지만 실제 광고slot에 보여지지 않는다
![image](https://github.com/PBL-AD-Management/Backend/assets/55120730/028eba4e-c5ac-4182-99f6-282d9f679163)
   * ### 검색 기능(활성 여부, 광고 title)
![image](https://github.com/PBL-AD-Management/Backend/assets/55120730/8e3d18f5-2848-496b-8030-3e9a7ab5f068)
![image](https://github.com/PBL-AD-Management/Backend/assets/55120730/64764f27-e7cf-456a-a8b1-904e41f35bd2)
   * ### 수정 기능(7번 수정)
![image](https://github.com/PBL-AD-Management/Backend/assets/55120730/79e21039-6ed7-4e76-8a00-cd8c83ab0d6f)
![image](https://github.com/PBL-AD-Management/Backend/assets/55120730/aa89301d-30ca-4daa-bcc7-d511ed4f971f)







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

## 수료증
<img src="https://github.com/user-attachments/assets/30feb352-1d9e-48ed-8545-58c19b752df2" width="700"/>
  
