package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");
//            em.persist(member);

//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.getName() = " + findMember.getName());
//            System.out.println("findMember = " + findMember.getId());
//            List<Member> findMembers = em.createQuery("select m from Member m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//            for (Member findMember : findMembers) {
//                System.out.println("findMember = " + findMember);
//            }
            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

            // 영속
//            System.out.println("BEFORE");
//            em.persist(member);
//            System.out.println("AFTER");
//
//            Member findMember = em.find(Member.class, 101L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//
//            System.out.println("result = "+(findMember2 == findMember1));

            // 영속
//            Member member1 = new Member(150L,"A");
//            Member member2 = new Member(160L,"B");
//
//            em.persist(member1);
//            em.persist(member2);
//            Member findMember = em.find(Member.class, 150L);
//            findMember.setName("ZZZZZ");
//
//            if(findMember.getName().equals("ZZZZZ")){
//                em.persist(findMember);
//            }

//            Member member = new Member(200L,"member200");
//            em.persist(member);
//
//            em.flush();
//            Member member = em.find(Member.class,150L);
//            member.setName("AAAAA");
//
//            em.detach(member);
//
//            System.out.println("================================");
//
//            Member findMember = em.find(Member.class, member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//
//            for (Member member1 : members) {
//                System.out.println("member1 = " + member1.getUsername());
//            }
//            Team team = new Team();
//            team.setName("TeamA");
////            team.getMembers().add(member);
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.changeTeam(team);
//            em.persist(member);

//            Movie movie = new Movie();
//            movie.setDirector("A");
//            movie.setActor("BBB");
//            movie.setName("바람과 함께 사라지다.");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//            Movie findMovie = em.find(Movie.class, movie.getId());
//            System.out.println("findMovie = " + findMovie);
//
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            em.persist(member2);
//
//            Member m1 = em.find(Member.class, member1.getId());
//            Member m2 = em.find(Member.class, member2.getId());
//
//            System.out.println("m1 == m2 : " + (m1.getClass() == m2.getClass()));
//
//
//            em.flush();
//            em.clear();
//


            //
//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getUsername() = " + findMember.getUsername());
//            Member findMember = em.getReference(Member.class, member1.getId());
//            System.out.println("findMember = " + findMember.getClass());

//            Parent parent = new Parent();
//
//
//            Child child1 = new Child();
//            Child child2 = new Child();
//            parent.addChild(child1);
//            parent.addChild(child2);
//            em.persist(parent);

//            Member member = new Member();
//            member.setUsername("hello");
//            member.setHomeAddress(new Address("city","street","zipcode"));
//            member.setWorkPeriod(new Period());

//            Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(new Address("city1","steet","zipcode"));
//
//            member.getFavoriteFoods().add("치킨");
//            member.getFavoriteFoods().add("피자");
//            member.getFavoriteFoods().add("족발");
//
//            member.getAddressHistory().add(new Address("city1","steet","zipcode"));
//            member.getAddressHistory().add(new Address("city1","steet","zipcode"));

            List<Member> result = em.createQuery("select m from Member m where m.usename like '%kim", Member.class)
                    .getResultList();




            tx.commit();


        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }

//    private static void printMemberAndTeam(Member findMember) {
//        String username = findMember.getUsername();
//        System.out.println("username = " + username);
//
//        Team team = findMember.getTeam();
//        System.out.println("team = " + team.getName());
//    }
}
