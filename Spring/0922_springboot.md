> 이클립스 프로젝트만들기 
>
> spring stater project 여기서 Service URl(https://start.spring.io) 이것이 스프링 이니셜라이저임패키지명 원하는거로 바꾸기
>
> Developer Tools에 Lombok 한번 꼭 해보기 (정말정말 편함) - 회사에서 많이 씀
>
> Dto도 어노테이션으로 만들 수 있음
>
> Web으로와서 Spring Web 체크
>
> Web하나 체크했을뿐인데 엄청난 디펜던시 추가됨 컨트롤 클릭으로 추가해서 따라 올라가보면됨



> 스프링 부트는 체크하나만으로 엄청난 디펜던시들이 추가가되어있음
>
> 설정 저장파일 application.properties
>
> sever.port=8787
>
> # Whitelabel Error Page
>
> > 이게 404에러!



MVC



MVT

> Model - Dao (MVC에서의)
>
> View - (biz + cont...) (MVC에서의)
>
> Template - presentation layer (데이터를 표현)
>
> Template에서 뭘하냐? : 뷰에서 데이터를 전달해줌 그걸 받아서 화면에 출력해주는것을 의미





m.2역할

> 메이븐이 디펜던시를 읽어서 다운을해줌 (central repository에서 디펜던시 검색해서 가져옴)
>
> central repository에서 jar파일을 가져와서 다운로드해주는애가 메이븐이고
>
> 그게 m.2파일에 다운됨 (내 로컬에)