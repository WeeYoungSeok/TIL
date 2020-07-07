### 답글 남기기

> 게시판 이용시 답글달기를 할수있는 기능이다.
>
> 응용하면 댓글달기, 댓글의 댓글달기 등등 여러가지로 사용용도가 많다.



- 원리

  > 글번호,그룹번호,그룹번호(순서),공백 이렇게 4가지가 필요하다.
  >
  > 글을 새로 적을때 그룹번호도 증가를 시켜준다.
  >
  > 그룹번호(순서)는 가장 먼저 쓴 글이 1번이 된다.
  >
  > 그리고 SELECT 해줄때 순서를 그룹번호는 내림차순, 그룹번호(순서)는 오름차순으로 해주어야 한다.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FbK4SJQ%2FbtqFtwdTEm4%2FNBxkhRK4UdaPUyPgbWkr80%2Fimg.png)

> 