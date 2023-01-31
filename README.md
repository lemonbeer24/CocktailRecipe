# 칵테일 사이트
![image](https://user-images.githubusercontent.com/53043464/213490030-07f06632-0589-4873-b926-fe9d49477fdb.png)

## 프로젝트 개요
칵테일 레시피를 업로드 하고 다른 사람과 공유 할 수 있는 사이트 입니다.<br>
메인 페이지 에서 다른 사람이 업로드한 레시피를 보거나 레시피 이름을 클릭하여 레시피의 세부 사항을 볼 수 있습니다.<br>
업로드 페이지 에서 회원가입 없이 아이디와 비밀번호. 레시피 정보를 입력하여 레시피를 업로드 할 수 있습니다.<br>
업로드 에서 사용된 아이디와 비밀번호를 이용하여 수정, 삭제를 할 수 있습니다.<br>

## how to run
실행전 첨부된 images 폴더를 c드라이브 루트에 위치시켜 주세요.<br>
mysql 서버에 먼저 cocktailrecipe_db 을 이름으로 하는 db 를 생성해 주세요.<br>
cockdbdump.sql 파일로 mysql -u 유저명 -p cocktailrecipe_db < cockdbdump.sql<br>
cmd 명령어로 생성한 db에 dump 해 주세요.<br>

```
java -jar -Dsqlusername=유저이름 -Dsqlpassword=페스워드 -Dsqlport=sql서버포트번호 -Dserverport=스프링서버포트번호 -Dspring.profiles.active=prod Cocktail_Recipe-0.0.1-SNAPSHOT.jar
```

이 명령어로 cmd 에서 서버를 실행시키면 됩니다.

## 개발 사항
Java version : JavaSE - 18 <br>
Build Tool : gradle 7.5 <br>
RDBMS : MYsql 5.7 <br>
spring boot version : 2.7.2<br>
dependency management version : 1.0.12.RELEASE <br>

의존성 : <br>
spring-boot-starter-jdbc<br>
spring-boot-starter-web<br>
org.projectlombok:lombok<br>
spring-boot-starter-test<br>
mysql-connector-java<br>
gson:2.9.1<br>
spring-boot-devtools:2.7.3<br>
spring-boot-starter-data-jpa<br>

프론트 엔드 : html 5, css3, java script, thymeleaf.



