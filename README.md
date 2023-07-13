<!-- TOC -->
* [spec.](#spec)
* [1. 영속성 관리](#1--)
  * [1.1. 엔티티의 생명주기](#11--)
  * [1.2. 영속성 컨텍스트의 이점](#12---)
  * [1.3. Flush](#13-flush)
    * [1.3.1. 플러시 발생](#131--)
    * [1.3.2. 플러시 방법](#132--)
    * [1.3.3. 플러시 모드 옵션](#133---)
    * [1.3.4. 플러시 특징](#134--)
* [2. 엔티티 매핑](#2--)
<!-- TOC -->

# spec.
- boot 3.1.1
- gradle 8.1.1
- java 17

# 1. 영속성 관리
## 1.1. 엔티티의 생명주기
![](./asset/img.png)

**비영속 (new/transient)**
- 영속성 컨텍스트와 전혀 관계가 없는 새로운 상태

**영속 (managed)**
- 영속성 컨텍스트에 관리되는 상태

**준영속 (detached)** 
- 영속성 컨텍스트에 저장되었다가 분리된 상태
 
**삭제 (removed)**  
- 삭제된 상태

## 1.2. 영속성 컨텍스트의 이점
- 1차 캐시 동일성(identity) 보장
- 트랜잭션을 지원하는 쓰기 지연(transactional write-behind)
- 변경 감지(Dirty Checking) 
- 지연 로딩(Lazy Loading)

## 1.3. Flush
- 영속성 컨텍스트의 변경 내용을 DB에 반영

### 1.3.1. 플러시 발생
- 변경 감지
- 수정된 엔티티 쓰기 지연 SQL 저장소에 등록
- 쓰기 지연 SQL 저장소의 쿼리를 데이터 베이스에 전송

### 1.3.2. 플러시 방법 
- em.flush()
- 트랜잭션 커밋
- JPQL 쿼리 실행
```java
em.persist(member);
em.persist(member1);
em.persist(member2);

// 이때 데이터베이스에서 조회한 값이(위에 persist한 member 객체들)반영되어야 하기 때문에 flush가 된다.
query = em.createQuery("select m from Member m", Member.class);
List<Member> members = query.getResultList();
```

### 1.3.3. 플러시 모드 옵션
- FlushModeType.AUTO : 커밋이나, 쿼리를 실행할 때 플러시 (Default)
- FlushModeType.COMMIT : 커밋할 때만 플러시

### 1.3.4. 플러시 특징
- 영속성 컨텍스트를 비우지 않음
- 영속성 컨텍스트의 변경 내용을 데이터베이스에 동기화
- 트랜잭션이라는 작업 단위가 중요, 커밋 직전에만 동기화 하면 됨.

# 2. 엔티티 매핑
- 객체와 테이블 매핑 : @Entity, @Table
  - @Entity가 붙은 클래스는 JPA가 관리. 엔티티라고 한다.
  - JPA를 사용해서 테이블과 매핑할 클래스는 @Entity 필수
  - 기본 생성자 필수
  - final, enum, interface, inner 클래스 사용 x
  - @Entity는 클래스 이름을 기본으로 사용한다. 
- 필드와 컬럼 매핑 : @Column
- 기본 키 매핑 : @Id
- 연관관계 매핑 : @ManyToOne, @JoinColumn
