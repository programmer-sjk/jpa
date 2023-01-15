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

        em.close();
        emf.close();
    }
}
