package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 삽입
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

            // 조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

            // 수정
//            findMember.setName("HelloJPA");
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

            // JPQL
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();
            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

            // 영속
//            System.out.println("=== Before ===");
//            em.persist(member);
            // detach
//            em.detach(member);
            // remove
//            em.remove(member);
//            System.out.println("=== After ===");
//            Member findMember = em.find(Member.class, 101L);
//
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

            // 영속
//            Member member1 = new Member(150L,"A");
//            Member member2 = new Member(160L,"B");

//            em.persist(member1);
//            em.persist(member2);

//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZ");
//            System.out.println("==============");

//            Member member = new Member(200L, "member200");
//            em.persist(member);
//            em.flush();
//            System.out.println("================");

//            Member member1 = new Member();
//            member1.setUsername("A");
//
//            Member member2 = new Member();
//            member2.setUsername("B");
//
//            Member member3 = new Member();
//            member3.setUsername("C");
//            System.out.println("============");
//            em.persist(member1);
//            em.persist(member2);
//            em.persist(member3);
//
//            System.out.println("member1 = " + member1.getId());
//            System.out.println("member2= "+member2.getId());
//            System.out.println("member3.getId() = " + member3.getId());
//            System.out.println("============");


//           Member member = new Member();
//           member.setUsername("member1");
//           em.persist(member);
//
//           Team team = new Team();
//           team.setName("teamA");
//           team.getMembers().add(member);
//            Movie movie = new Movie();
//            movie.setDirector("AAAA");
//            movie.setActor("BBBB");
//            movie.setName("바람과 함께 사라지다.");
//            movie.setPrice(10000);
//            em.persist(movie);
//            Member member = new Member();
//            member.setCreateBy("Jeong");
//            member.setUsername("user1");
//            member.setCreatedDate(LocalDateTime.now());
//            em.flush();
//            em.clear();

//            Member member = em.find(Member.class, 1L);
//            printMember(member);

//            Member member = new Member();
//            member.setUsername("hello");
//
//            em.persist(member);
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            member1.setTeam(team);
//            em.persist(member1);


//            Member member2 = new Member();
//            member2.setUsername("member2");
//            em.persist(member2);

//            em.flush();
//            em.clear();
//
//            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();

            // SQL : select * from member
            // SQL : select * from Team where TEAM_ID = xxx

//            Member m1 = em.getReference(Member.class, member1.getId());
//            System.out.println("m= " + m1.getTeam().getClass());
//
//            System.out.println("============");
//            m1.getTeam().getName();
//            System.out.println("============");
//            System.out.println("m1 = " +m1.getClass());     // proxy
//            em.detach(m1);
//            System.out.println("m1.getUsername() = " + m1.getUsername());
//            m1.getUsername();   // 강제초기화
//            Hibernate.initialize(m1);
//
//            System.out.println("isLoaded = "+ emf.getPersistenceUnitUtil().isLoaded(m1));

//            Member reference = em.find(Member.class, member1.getId());
//            System.out.println("reference = " + reference.getClass());
//
//            System.out.println("a==a : " + (m1 == reference));

//            logic(m1,m2);

            //
//            Member member1 = em.find(Member.class, member.getId());

//            Member findMember = em.getReference(Member.class, member.getId());
//            System.out.println("member1.getId() = " + findMember.getId());
//            System.out.println("member1.getUsername() = " + findMember.getUsername());


//            Movie findMovie = em.find(Movie.class, movie.getId());
//            System.out.println("findMovie = " + findMovie);
//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
//
//            em.flush();
//            em.clear();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//            findParent.getChildList().remove(0);

            Address address =new Address("city","street","100");

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setHomeAddress(address);
            em.persist(member1);

            Address newAddress =new Address("newCity",address.getStreet(),address.getZipCode());
            member1.setHomeAddress(newAddress);



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static void logic(Member m1, Member m2) {
        System.out.println("m1 == m2" + (m1 instanceof Member));
        System.out.println("m1 == m2" + (m2 instanceof Member));
    }

    private static void printMember(Member member) {
        System.out.println("member.getUsername() = " + member.getUsername());
    }

//    private static void printMemberAndTeam(Member member) {
//        String username = member.getUsername();
//        System.out.println("username = " + username);
//        Team team = member.getTeam();
//        System.out.println("team = " + team);
//    }
}
