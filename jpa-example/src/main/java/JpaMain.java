import domain.Member;
import domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Team team = new Team("team");
        em.persist(team);

        Member member = new Member();
        member.setName("member1");
        member.setTeam(team);
        em.persist(member);

        tx.commit();

        tx.begin();
        Team team2 = new Team("team2");
        em.persist(team2);

        Member findMember = em.find(Member.class, 2L);
        findMember.setTeam(null);
        em.remove(team2);
        tx.commit();

        em.close();
        emf.close();
    }
}
