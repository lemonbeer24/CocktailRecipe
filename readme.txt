서버 실행 방법 :
실행전 첨부된 images 폴더를 c드라이브 루트에 위치시켜 주세요.
포트번호가 3312 인 mysql 서버에 먼저 cocktailrecipe_db 을 이름으로 하는 db 를 생성해 주세요
mysql -u 유저명 -p cocktailrecipe_db < cockdbdump.sql cmd 명령어로 사용할 db 생성한 db에 dump 해 주세요
cmd 에서 서버 실행파일이 있는 곳 에서 
java -jar -Dsqlpassword=페스워드 -Dsqlusername=유저이름 -Dsqlport=sql서버포트번호 -Dspring.profiles.active=prod Cocktail_Recipe-0.0.1-SNAPSHOT.jar
로 서버를 실행하시면 됩니다.