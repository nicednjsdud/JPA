# JPA에서 가장 중요한 2가지

- 객체와 관계형 데이터베이스 매핑하기
- 영속성 컨텍스트

## 1. 영속성 컨텍스트

- JPA를 이해하는데 가장 중요한 용어
- **"엔티티를 영구 저장하는 환경"이라는 뜻**

```java
 EntityManager.persist(entity);
```

### 1) 엔티티 매니저? 영속성 컨텍스트?

- 영속성 컨텍스트는 논리적인 개념
- 눈에 보이지 않는다.
- 엔티티 매니저를 통해서 영속성 컨텍스트에 접근

## 2. 엔티티의 생명주기

### 1) 비영속 (new/transient)

- 영속성 컨텍스트와 전혀 관계가 없는 새로운 상태

```java
    // 객체를 생성한 상태 (비영속)
    Member memeber = new Member();
    member.setId("member1");
    member.setUsername("회원1");
```

### 2) 영속 (managed)

- 영속성 컨텍스트에 관리되는 상태

```java
     // 영속
    em.persist(member);
```

### 3) 준영속 (detached)

- 영속성 컨텍스트에 저장되었다가 분리된 상태

```java
    // 회원 엔티티를 영속성 컨텍스트에서 분리, 준영속 상태
    em.detach(member);
```

### 4) 삭제 (removed)

- 삭제된 상태

```java
    // 객체를 삭제한 상태 (삭제)
    em.remove(memeber);
```

## 3. 영속성 컨텍스트의 이점

- 1차 캐시
- 동일성 (identity) 보장
- 트랜잭션을 지원하는 쓰기 지연 (transactional write-behind)
- 변경 감지 (Dirty Checking)
- 지연 로딩 (Lazy Loading)

### 1) 앤티티 조회, 1차 캐시

```java
    // 엔티티 생성한 상태(비영속)
    Member member = new Member();
    member.setId("member1");
    member.setUsername("회원1");

    // 1차 캐시에 저장됨
    em.persist(member);

    // 1차 캐시에서 조회
    Member findMember = em.find(Member.class,"member1");

    // 1차 캐시에서 없으니 데이터베이스에서 조회
    Member findMember2 = em.find(Member.class,"member2");
```
