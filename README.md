# 뉴스피드 복습 프로젝트
## 페이지 조회 기능 까지 구현 하였습니다.
### 서버 실행 중  에러가 발생 하였습니다.
![new-error](https://github.com/user-attachments/assets/af9c5818-26cc-455c-9071-8db2fcc27e56)
### 원인은 위 이미지에서 @PutMapping이 2개인데 서로 경로, 매개변수가 같아서 발생한 것이었습니다.
### 이후 서버 실행은 원활하게 작동하였으나 포스트맨 동작시 다음과 같은 에러가 발생하였습니다.
![image](https://github.com/user-attachments/assets/8d893bb8-2737-4c6b-9af1-484be7bd47e5)
### 인텔리제이로 돌아가 로그를 살펴보니 다음과 같았습니다.
![image](https://github.com/user-attachments/assets/dbf626b3-6dc6-4a21-9a76-213040879c53)
### 이 에러의 원인이 무엇인지 찾아보고 있던 중 과제 제출 기한이 다되어 일단 과제 제출하겠으나 
### 왜 이러한 포스트맨 에러가 발생하였는 지는 조금 더 공부해 보겠습니다.

## << error 해결>>
### 에러가 발생한 이유는 Filter 문제였다. 로그인을 해서 생성된 토큰을 보내주어야 제대로 된 응답이 이루어져야 하는 데
### 이 과정이 진행되지 않아 위와 같은 에러가 발생한 것이었다. 

## << profile CRUD>>
### 프로필 생성
![스크린샷 2025-03-22 152425](https://github.com/user-attachments/assets/c47b3016-c27f-4f87-b9bb-c7da234ff1ab)

### 프로필 다건 조회
![스크린샷 2025-03-22 152439](https://github.com/user-attachments/assets/fffddfea-4a28-49fe-8028-747e0030565e)

### 프로필 단건 조회
![스크린샷 2025-03-22 152453](https://github.com/user-attachments/assets/5a6f3d96-a066-4cd6-a360-a08404a3e92b)

### 프로필 수정
![스크린샷 2025-03-22 152625](https://github.com/user-attachments/assets/886604e9-9983-4677-91a5-9179ed8e4c0f)

### 프로필 비밀 번호 변경
![스크린샷 2025-03-22 152821](https://github.com/user-attachments/assets/01f2f2f0-808b-40d9-add8-ad6d428acba4)

### 프로필 삭제
![스크린샷 2025-03-22 152840](https://github.com/user-attachments/assets/e28861f4-6ca4-474c-8132-3c0e62be512a)







