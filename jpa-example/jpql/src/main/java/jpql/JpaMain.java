package jpql;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team teamA = new Team();
            teamA.setName("팀A");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setTeam(teamB);
            em.persist(member3);

            em.flush();
            em.clear();

//            String query = "select m From Member m join fetch m.team";
//            String query = "select distinct t From Team t join fetch t.members m";
//            String query = "select t From Team t";
            String query = "select m From Member m where m.team.id = :teamId";
            List<Member> members = em.createQuery(query, Member.class)
                    .setParameter("teamId",teamA.getId())
                    .getResultList();

            for (Member member : members) {
                System.out.println("member = " + member);
            }
//            for (Team t : result) {
////                System.out.println("username = "+m.getUsername() +"," + "teamName = "+m.getTeam().getName());
//                System.out.println("team = " + t.getName() + "|members =" + t.getMembers().size());
//                for(Member member : t.getMembers()){
//                    System.out.println("member = " + member);
//                }
//            }
//            String query = "select "+
//                                "case when m.age <=10 then '학생요금'" +
//                                "when m.age >= 60 then '경로요금' " +
//                                "else '일반요금' " +
//                                "end " +
//                        "from Member m";
//            String query = "select coalesce(m.username, '이름 없는 회원') from Member m";
//            String query = "select nullif(m.username, '관리자')from Member m";
//            String query = "select 'A' || 'B' From Member m"; // concat
//            String query = "select function('group_concat',m.username) From Member m";
//            String query = "select m.team From Member m";


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
