package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Team team = new Team();
        team.setName("teamA");
        entityManager.persist(team);

        Team team2 = new Team();
        team.setName("teamB");
        entityManager.persist(team2);

        Member member = new Member();
        member.setUsername("hello");
        member.setTeam(team);
        entityManager.persist(member);

        Member member2 = new Member();
        member2.setUsername("hello");
        member2.setTeam(team2);
        entityManager.persist(member2);


        entityManager.flush();
        entityManager.clear();

//        Member findMember = entityManager.find(Member.class, member.getId());
        List<Member> members = entityManager.createQuery("select m from Member m", Member.class).getResultList();
//        System.out.println("m = " + findMember.getTeam().getClass());


        tx.commit();
        entityManager.close();
        emf.close();
    }
}
