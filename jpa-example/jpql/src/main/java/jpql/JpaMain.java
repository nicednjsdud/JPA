package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("Jeong");
            member.setAge(10);
            member.setTeam(team);
            member.setType(MemberType.ADMIN);
            em.persist(member);

            em.flush();
            em.clear();

//            String query = "select "+
//                                "case when m.age <=10 then '학생요금'" +
//                                "when m.age >= 60 then '경로요금' " +
//                                "else '일반요금' " +
//                                "end " +
//                        "from Member m";
//            String query = "select coalesce(m.username, '이름 없는 회원') from Member m";
            String query = "select nullif(m.username, '관리자')from Member m";
            List<String> result = em.createQuery(query, String.class).getResultList();
            for (String s : result) {
                System.out.println("s = " + s);
            }

//            String query = "select m.username, 'HELLO', true FROM Member m " +
//                           "where m.type = :userType";
//            List<Object[]> result = em.createQuery(query)
//                    .setParameter("userType", MemberType.ADMIN)
//                    .getResultList();

//            System.out.println("result.size() = " + result.size());
//            for (Member member1 : result) {
//                System.out.println("member1 = " + member1);
//            }


//            List<MemberDTO> result = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m",MemberDTO.class)
//                      .getResultList();
//            MemberDTO memberDTO = result.get(0);
//            System.out.println("memberDTO.getUsername() = " + memberDTO.getUsername());
//            System.out.println("memberDTO.getAge() = " + memberDTO.getAge());


//            List<Object[]> resultList = em.createQuery("select m.username, m.age from Member m")
//                    .getResultList();
//            Object[] result = resultList.get(0);
//            System.out.println("username = " + result[0]);  // member1
//            System.out.println("age = " + result[1]);       // 10


//            List resultList = em.createQuery("select m.username, m.age from Member m" )
//                    .getResultList();
//            Object o = resultList.get(0);
//            Object[] result = (Object[]) o;
//            System.out.println("username = " + result[0]);  // member1
//            System.out.println("age = " + result[1]);       // 10


//            TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
//            List<Member> resultList = query.getResultList();
//
//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }
//
//            Member result = em.createQuery("select m from Member m where m.username =:username", Member.class)
//                        .setParameter("username", "member1")
//                        .getSingleResult();
//            System.out.println("result = " + result);


            // Spring Data JPA -> 
//            System.out.println("resultList2 = " + resultList2);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }
}
