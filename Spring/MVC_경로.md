- Request가 들어옴
- 리스너가 어떤 xml 호출해야하는지 확인
- 디스패처 서블릿으로 넘어감
- 핸들러 맵핑을 통해서 어떤 컨트롤러로 가는지 판단하고 
- 해당 컨트롤러에 요청을 보내줌
- 서비스 리포지토리를 통해서 dbcp를 통해서 db값을 가져옴
- 그러면 컨트롤러는 다시 그 값을 MAV형태로 디스패쳐 서블릿으로 보내줌
- 모델은 보내줄 값
- 뷰는 어떤 뷰로 보내줄지에대한 정보들
- 그걸 디스패쳐 서블릿이 받아서
- 뷰리졸버가 MAV의 값고 어디 뷰로 넘겨줄지를 판단하고 클라이언트에 응답해줌







##### 필터

> 클라이언트와 서버사이에서 리퀘스트와 리스판스 객체를 받아서 무언가를 처리하고
>
> 필터 체인을 통해서 작업한내용을 넘겨준다.



##### AOP

> Dao같은곳에 걸어줄수있음
>
> ccc와 cc를 나누어서 호출할 시점에 붙여줌



***필터와 AOP의 차이점***

> 특정 클래스 메소드에 적용되는게 AOP
>
> 필터는 요청과 응답에 관련된 처리 (Http) 여기서 특정 동작을 시행
>
> AOP는 타겟의 앞과 뒤에 공통적인 부분을 잘라서 붙여놓은것입니다 요청됐을때 특정 시점에 추가하는 개념

