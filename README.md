# JPA(Java Persistence API)

## 1장. JPA 소개
- JPA는 자바진영의 ORM 기술 표준이다.

### SQL을 직접 다룰 떄 발생하는 문제
- 객체를 DB에 CRUD 하려면 너무 많은 SQL과 JDBC API를 코드로 작성해야 하는 문제가 존재
- 요구사항 변경(컬럼 추가)에 따라 수정해야 할 요소가 너무 많다.

### 패러다임의 불 일치
- 객체와 RDBMS는 지향하는 목적이 서로 다르다. 이것을 객체와 RDBMS의 패러다임 불일치 문제라고 한다.
- 애플리케이션은 자바라는 객체지향 언어로 개발하고 데이터는 RDBMS에 저장해야 한다면 패러다임 불일치 문제를 중간에서 개발자가 해결해야 함.
- 패러다임의 불일치로는 상속, 연관관계(객체는 참조를, 테이블은 외래키), 객체 그래프 탐색 등이 있다.
- 정리하면 객체와 RDBMS는 지향하는 패러다임이 다르고, 이 패러다임을 극복하고자 개발자가 너무 많은 시간과 코드를 소비한다.
- JPA는 패러다임의 불일치 문제를 해결해주고 정교한 객체 모델링을 유지하게 도와준다.

### JPA란 무엇인가?
- Java Persistence API는 자바 진영의 ORM 기술 표준이다. 애플리케이션과 JDBC 사이에서 동작한다.
- ORM(Object-Relational Mapping)은 이름 그대로 객체와 관계형 데이터베이스를 매핑한다는 뜻이다.
- ORM 프레임워크는 객체와 테이블을 매핑해서 패러다임의 불일치 문제를 개발자 대신 해결해준다.
- 예를 들어 ORM을 사용하면 객체를 DB에 저장할 때 insert 쿼리를 사용하는 것이 아니라 객체를 저장하면 ORM 프레임워크가
적절한 insert SQL 쿼리를 생성해서 DB에 객체를 저장해준다.
- 성숙한 OOP 언어에는 대부분 ORM 프레임워크 들이 있는데 자바 진영에서는 하이버네이트 프레임워크가 가장 많이 사용된다.
- 하이버네이트를 기반으로 새로운 자바 ORM 기술 표준이 만들어 졌는데 이것이 바로 JPA다.

#### JPA 장점
- 생산성 (지루하고 반복적인 CRUD를 개발자가 직접 생성하지 않는다.)
- 유지보수 (필드를 추가, 삭제시 개발자가 작성해야 했던 코드를 JPA가 대신 처리해주니까 유지보수 해야 할 코드 수가 줄어듬)
- 패러다임 불 일치 문제 해결 (상속, 연관관계, 객체 그래프 탐색 등을 해결해준다.)
- 벤더 독립성 (JPA를 통해 추상화된 데이터 접근 계층을 제공해 특정 DB 기술에 종속되지 않도록 한다.)
