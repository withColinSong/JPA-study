
# 다양한 연관관계 매핑

## 1. 다대일

### 1.1. 다대일 단방향

![img_2.png](img_2.png)

- Member member.team으로 팀 엔티티를 참조할 수 있지만, 반대로 Team에는 Member를 참조하는 필드가 없다.
- 따라서, Member와 Team은 다대일 단방향 연관관계

```java
@ManyToOne
@JoinColumn 
// @JoinColumn(name = "TEAM_ID")
private Team team;
```
- `@JoinColumn` : name을 생략하면 TEAM_TEAM_ID`[객체명_객체컬럼]`이 default
- Member.team 필드로 회원 테이블의 TEAM_ID 외래 키와 매핑하여 관리

#### 1.1.1. 다대일 단방향 Test
![img_1.png](img_1.png)
1. em.flush(), clear()를 통해 INSERT 구문 실행 및 영속성 컨텍스트 캐시가 비워진 상황이다. 
2. em.find()를 통해  SELECT 구문이 실행
3. findMember.getTeam().getName()을 통해 SELECT 구문 실행 

### 1.2. 다대일 양방향
![img_3.png](img_3.png)

> 양방향은 외래 키가 있는 쪽이 연관관계의 주인
- 일대다와 다대일 연관관계는 항상 다(N)에 외래키 존재
- 다쪽인(N) Member 테이블이 외래 키를 가지고 있으므로 Member.team이 연관관계 주인
- JPA는 외래 키를 관리할 때 연관관계의 주인만 사용
- 주인이 아닌 Team.members는 조회를 위한 JPQL이나 객체 그래프를 탐색할 때 사용

> 양방향 연관관계는 항상 서로를 참조해야 한다.
- 어느 한 쪽만 참조하면 양방향 연관관계가 성립되지 않는다.
- 항상 서로 참조하게 하려면 연관관계 편의 메소드 작성이 필요하다

#### 1.2.1. 연관관계 편의메서드
- 객체의 양방향 연관관계는 양쪽 모두 관계를 맺어주어야 순수한 객체 상태에서도 정상적으로 동작한다.
- 양쪽 한 곳에만 작성하거나 양쪽 다 작성할 수 있지만 무한루프의 위험성으로 한 곳에만 작성하는 것이 좋다.
```java
public void addTeam(Team team) {
    this.team = team;
    if(!team.getMembers().contains(this)) {
        team.getMembers().add(this);
    }
}
```

#### 1.2.2. 테스트 코드
![img.png](img.png)
- 편의 메서드를 통해 객체 간의 연관관계를 맺어주는 작업이 필요.
- [1.1.1.] when, then은 동일하다.