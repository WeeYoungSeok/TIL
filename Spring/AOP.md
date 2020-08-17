### AOP

관점을 분리시켜줄거야!

Aspect : 관심사

ccc와 cc를 나누어서 프로그래밍하자

### CC

> 주 관심사항 : CCC를 하고나서 나머지 부분들
>
> 해당 프로그램에 유니크한 부분

### CCC

> 공통 관심사들 끼리 자름(세미떄 SNS로그인, 결제 이런 공통된 것들을 짤라서 구분할것이다.)



CCC중에 호출할수 있는 부분이 Join Point

호출된 부분이 Pointcut



cc를 짜다가

ccc를 붙여줘야되는 상황이옴

cc에서 특정 부분에 붙여줘야하는데

호출할수 있는 부분부분들을 Join Point가 된다.(위치들(못들어가도)), ccc를 붙일수있는 모든 부분

근데 부분부분들중 맞는 곳에 들어가는걸 알려주는것이 Pointcut이다.(호출하는 부분부분들 중에 어디에다가 붙여줘야되는지 알려주는 애)



ccc코드들 (잘라놓은 코드들을 Advice라고 부름)



Advice랑 pointcut이 합쳐져있는걸 Aspect 또는 Advisor



ccc코드들이 pointcut해서 제대로 실행되는걸 Weaving이라고함

(프록시 객체가 타겟인척을해서 타겟 앞뒤에 ccc를 붙여줘서 제대로 실행이됨 이걸 통틀어 묶어준걸 위빙!)









1.Spring 특징 AOP <설정 구조> 

: pointcut 설정 

: aspect 설정 

: method 실행 전 

: method 정상 실행 후 

: method 예외 발생 시 

: method 실행 후 (예외 발생 여부 상관 없음) : 모든 시점 적용 가능



spring pdf에서 여기서 method는 타켓을 의미함

