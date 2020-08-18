##### @Autowired

> 의존관계를 자동으로 설정할 때 사용 (의존성 주입)
>
> 생성자 주입이나 세터주입을 자동으로 해주는 것
>
> 자동으로 묶어줄거야 class에 들어갈 값들을 자동으로 넣어줄거야



*<* (의존성 주입)

생성자 주입이나 세터주입을 자동으로 해주는 것

자동으로 묶어줄거야 class에 들어갈 값들을 자동으로 넣어줄거야

*<context:annotation-config/*>

> @Autowired



*<*context:component-scan base-package=""/*>*

> @Component, @Controller, @Service, @Repository



편의성을 위해 bean이나 autowire를 일일히 걸어주지않고

간단하게 어노테이션으로 해결가능!



*<*mvc:annotation-driven/*>*

> component보다 좀더 자세히 작동함
>
> mvc랑 component가 있으면 역할이 겹치기때문에 config는 안쓴다.!



Advisor = Advice + Pointcut

= cc +  ccc = -> Advisor (X) -> weaving된 결과(O)



### Proxy

> 내가 타겟이야라고 속이고 메소드를 가로챔