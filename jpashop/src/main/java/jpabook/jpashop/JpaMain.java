package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.Team;

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

        try {
            tx.begin();
//            testSave(em);
//            query(em);
//            update(em);
//            delete(em);
//            biDirection(em);
            tx.commit();
        } catch (Exception e) {
            System.out.println("message: " + e.getMessage());
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static void testSave(EntityManager em) {
        Team team1 = new Team("team1", "팀1");
        em.persist(team1);

        Member member1 = new Member(1L, "회원1", 33);
        member1.setTeam(team1);
        em.persist(member1);

        Member member2 = new Member(2L, "회원2", 33);
        member2.setTeam(team1);
        em.persist(member2);
    }

    private static void query(EntityManager em) {
        String jpql = "select m from Member m join m.team t where t.name = :teamName";
        List<Member> results = em.createQuery(jpql, Member.class)
                .setParameter("teamName", "팀1")
                .getResultList();

        for (Member member : results) {
            System.out.println(member.getUsername());
        }
    }

    private static void update(EntityManager em) {
        Team team2 = new Team("team2", "팀2");
        em.persist(team2);

        Member member = em.find(Member.class, 1L);
        member.setTeam(team2);
    }

    private static void delete(EntityManager em) {
        Member member = em.find(Member.class, 1L);
        member.setTeam(null);
    }

    private static void biDirection(EntityManager em) {
        Team team = em.find(Team.class, "team1");
        List<Member> members = team.getMembers();

        for (Member member : members) {
            System.out.println(member.getUsername());
        }
    }
}
